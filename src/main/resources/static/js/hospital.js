var map;
    $(function () {
      var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
      var options = { //지도를 생성할 때 필요한 기본 옵션
        center: new kakao.maps.LatLng(37.501298268200934, 127.03967042675127), //지도의 중심좌표.
        level: 5 //지도의 레벨(확대, 축소 정도)
      };

      map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

      // 마커가 표시될 위치입니다 
      var markerPosition = new kakao.maps.LatLng(37.501298268200934, 127.03967042675127);


      // HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
      if (navigator.geolocation) {

        // GeoLocation을 이용해서 접속 위치를 얻어옵니다
        navigator.geolocation.getCurrentPosition(function (position) {

          var lat = position.coords.latitude, // 위도
            lon = position.coords.longitude; // 경도

          var locPosition = new kakao.maps.LatLng(lat, lon), // 마커가 표시될 위치를 geolocation으로 얻어온 좌표로 생성합니다
            message = '현재위치';

          // 마커와 인포윈도우를 표시합니다
          displayMarker(locPosition, message);

        });

      } else { // HTML5의 GeoLocation을 사용할 수 없을때 마커 표시 위치와 인포윈도우 내용을 설정합니다

        var locPosition = new kakao.maps.LatLng(33.450701, 126.570667),
          message = 'geolocation을 사용할수 없어요..'

        displayMarker(locPosition, message);
      }

      // 지도에 마커와 인포윈도우를 표시하는 함수입니다
      function displayMarker(locPosition, message) {

        // 마커를 생성합니다
        var marker = new kakao.maps.Marker({
          map: map,
          position: locPosition
        });

        var iwContent = message, // 인포윈도우에 표시할 내용
          iwRemoveable = false;

        // 인포윈도우를 생성합니다
        var infowindow = new kakao.maps.InfoWindow({
          content: iwContent,
          removable: iwRemoveable
        });

        // 인포윈도우를 마커위에 표시합니다 
        infowindow.open(map, marker);

        // 지도 중심좌표를 접속위치로 변경합니다
        map.setCenter(locPosition);
      }
    });

    $(document).on("click", "#hospital-list", function () {
      // let serviceKey = "";
      // let pageNo = 1;
      // let numOfRows = 30;
      let requestData = {
        serviceKey: "bXQtg6w27MMbfTfUifok4Jq/8xtGezFvtRpm9TfkD/a13SLTn7EOs8FmfNL7AAO+JRYXTW5Nrrkq2qmcq+0abw==",
        pageNo: 1,
        numOfRows: 30,
      };
      $.ajax({
        url: "http://apis.data.go.kr/B551182/rprtHospService/getRprtHospService",
        type: "GET",
        data: requestData,
        dataType: "xml",
        success: function (response) {
          console.log(response);
          makeMarker(response);
          makeList(response);
        },
      });
    });

    function makeMarker(data) {

      // 마커를 표시할 위치와 title 객체 배열입니다 
      //   {
      //     title: '카카오', 
      //     latlng: new kakao.maps.LatLng(33.450705, 126.570677)
      // }
      var positions = [];
      $(data).find("item").each(function () {
        positions.push({
          title: `${$(this).find("yadmNm").text}`,
          content: `<div class="info"> 기관명 : ${$(this).find("yadmNm").text()} </div>`,
          latlng: new kakao.maps.LatLng(
            `${$(this).find("YPosWgs84").text()}`,
            `${$(this).find("XPosWgs84").text()}`
          )
        });
      });

      // 마커 이미지의 이미지 주소입니다
      var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";

      for (var i = 0; i < positions.length; i++) {

        // 마커 이미지의 이미지 크기 입니다 
        var imageSize = new kakao.maps.Size(24, 35);

        // 마커 이미지를 생성합니다    
        var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

        // 마커를 생성합니다
        var marker = new kakao.maps.Marker({
          map: map, // 마커를 표시할 지도
          position: positions[i].latlng, // 마커를 표시할 위치
          title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
          image: markerImage // 마커 이미지 
        });

        var infowindow = new kakao.maps.InfoWindow({
          content: positions[i].content,
        });

        // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
        // 이벤트 리스너로는 클로저를 만들어 등록합니다 
        // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
        kakao.maps.event.addListener(
          marker,
          "mouseover",
          makeOverListener(map, marker, infowindow)
        );
        kakao.maps.event.addListener(marker, "mouseout", makeOutListener(infowindow));

        kakao.maps.event.addListener(marker, "click", makeClickListener(map, marker, infowindow));

        var moveLocation = new kakao.maps.LatLng(positions[0].latlng.Ma, positions[0].latlng.La)
        map.setLevel(6);
        map.setCenter(moveLocation);
      }
    }

    function makeClickListener(map, marker, infowindow) {
      return function () {
        let pos = marker.getPosition();
        map.setLevel(5);
        map.panTo(marker);
      };
    }

    // 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
    function makeOverListener(map, marker, infowindow) {
      return function () {
        infowindow.open(map, marker);
      };
    }

    // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
    function makeOutListener(infowindow) {
      return function () {
        infowindow.close();
      };
    }

    function makeList(data) {
      let hospitalList = ``;
      $(data)
        .find("item")
        .each(function () {
          hospitalList += `
                  <tr>
                    <td>${$(this).find("yadmNm").text()}</td>
                    <td>${$(this).find("telno").text()}</td>
                    <td>${$(this).find("addr").text()}</td>
                    <td>${$(this).find("pcrPsblYn").text()}</td>
                    <td>${$(this).find("YPosWgs84").text()}</td>
                    <td>${$(this).find("XPosWgs84").text()}</td>
                  </tr>
                  `;
        });
      $("#hospitalList").empty().append(hospitalList);
    }