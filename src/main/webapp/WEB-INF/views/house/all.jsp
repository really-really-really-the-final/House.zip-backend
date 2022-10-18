<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headmeta.jsp"%>
<title>happyhouse</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- 아파트 리스트 가져오기-->
<script type="text/javascript" src="../js/aptList.js"></script>
<!-- 지도 가져오기 -->
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7f40405e29341c1fa46226d9889e981a&libraries=services"></script>
<!-- 지도에 마커 찍기 -->
<script type="text/javascript">
var map;
$(function () {
  var container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
  var options = {
    //지도를 생성할 때 필요한 기본 옵션
    center: new kakao.maps.LatLng(37.574280624116845, 126.97059817098703), //지도의 중심좌표.
    level: 4, //지도의 레벨(확대, 축소 정도)
  };
  map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
  
  var positions = [

		 <c:forEach items="${houses}" var="house">
	    {
	        title: '${house.aptName}', 
	        latlng: new kakao.maps.LatLng(${house.lat},${house.lng})
	    },

	    </c:forEach> 
	/*     {
	        title: '롯데캐슬블루오션아파트',
	        latlng: new kakao.maps.LatLng(35.07284629, 129.073734)
	    } */

	];
  
  var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
  
  //지도를 재설정할 범위정보를 가지고 있을 LatLngBounds 객체를 생성합니다
  var bounds = new kakao.maps.LatLngBounds(); 
  for (var i = 0; i < positions.length; i ++) {
      
      // 마커 이미지의 이미지 크기 입니다
      var imageSize = new kakao.maps.Size(24, 35); 
      
      // 마커 이미지를 생성합니다    
      var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
      
      // 마커를 생성합니다
      var marker = new kakao.maps.Marker({
          map: map, // 마커를 표시할 지도
          position: positions[i].latlng, // 마커를 표시할 위치
          title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
          image : markerImage // 마커 이미지 
      });
      
      // 마커에 표시할 인포윈도우를 생성합니다 
      var infowindow = new kakao.maps.InfoWindow({
          content: positions[i].title // 인포윈도우에 표시할 내용
      });

      bounds.extend(positions[i].latlng);
      
      // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
      // 이벤트 리스너로는 클로저를 만들어 등록합니다 
      // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
      kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
      kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
  }

	//LatLngBounds 객체에 추가된 좌표들을 기준으로 지도의 범위를 재설정합니다
  // 이때 지도의 중심좌표와 레벨이 변경될 수 있습니다
  <c:if test="${!empty houses}">
  	map.setBounds(bounds);
  </c:if>

  // 인포윈도우를 표시하는 클로저를 만드는 함수입니다 
  function makeOverListener(map, marker, infowindow) {
      return function() {
          infowindow.open(map, marker);
      };
  }

  // 인포윈도우를 닫는 클로저를 만드는 함수입니다 
  function makeOutListener(infowindow) {
      return function() {
          infowindow.close();
      };
  }
  
});
</script>
</head>

<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
	<!-- Page Header-->
	<header class="masthead"
		style="background-image: url('../assets/img/home-bg.jpg')">
		<div class="container position-relative px-4 px-lg-5">
			<div class="row gx-4 gx-lg-5 justify-content-center">
				<div class="col-md-10 col-lg-8 col-xl-7">
					<div class="site-heading">
						<h1>Happy House</h1>
						<hr>
						<span class="subheading">welcome to house</span>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- Main Content-->
	<div class="container mb-4">
		<div class="row gx-4 gx-lg-5 justify-content-center">
			<div class="col-md-10 col-lg-8 col-xl-7">
				<form action="${root}/house/all" id="searchForm" method="post">
					<input type="hidden" name="currentPage" id="currentPage">
					<div class="mb-3 row ">
						<select class="col me-1 text-light s bg-secondary" id="sido"
							name="sido">
							<option value=""></option>
						</select> <select class="col me-1 text-light form-control-lg bg-secondary"
							id="gugun" name="gugun">
							<option value="">구군선택</option>
						</select>
					</div>
					<!-- 지도 -->
					<div class="mb-4" id="map" style="height: 500px;"></div>
					<!-- apt preview-->

					<input type="hidden" name="action" value="list"> <input
						type="button" class="w-100 btn mb-3"
						style="background-color: #eee6c4;" id="listBtn" value="아파트 정보 얻기">
				</form>
				<div class="row">
					<table class="col">
						<tr>
							<th>아파트</th>
							<th>법정동</th>
							<th>전용면적</th>
							<th>거래금액</th>
							<c:forEach var="house" items="${houses}">
								<tr>
									<td><a href="${root}/house/view?no=${house.no}">${house.aptName}</a></td>
									<td>${house.dongName}</td>
									<td>${house.area}</td>
									<td>${house.dealAmount}</td>
								</tr>
							</c:forEach>
						</tr>

						<tbody id="aptinfo"></tbody>
					</table>
				</div>
				<%@ include file="/WEB-INF/views/include/paging.jsp"%><br>
			</div>
		</div>
	</div>

	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<script>
	//전달받은 SearchCondition을 화면에 설정하는 함수를 만든다.
	function setSearchCondition(){
	
		if(document.querySelector("#sido").value=="시도선택" && 
				"${searchCondition.sido}"!="" ){
			selectOptionByValue("sido", "${searchCondition.sido}");
			sendRequest("gugun", document.querySelector("#sido").value.substr(0, 2) + "*00000");
		}
		
		if(document.querySelector("#sido").value=="${searchCondition.sido}" &&
				document.querySelector("#gugun").value=="구군선택" && 
				"${searchCondition.gugun}"!="" ){
			selectOptionByValue("gugun", "${searchCondition.gugun}");
		}
		document.querySelector("#currentPage").value = "${searchCondition.currentPage}"
	}
	
	// btnSearch가 클릭되면 currentPage를 1로 해서 검색 조건으로 검색한다.
	document.querySelector("#listBtn").addEventListener("click", function(){
		movePage(1);
	})
</script>
</body>
</html>