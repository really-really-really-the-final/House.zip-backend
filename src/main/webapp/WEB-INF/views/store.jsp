<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/headmeta.jsp"%>
	<title>happyhouse - store</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
      <!-- 아파트 리스트 가져오기-->
    <script type="text/javascript" src="js/aptList.js"></script>
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
    center: new kakao.maps.LatLng(36.366843048120025, 127.31701328329802), //지도의 중심좌표.
    level: 4, //지도의 레벨(확대, 축소 정도)
  };
  map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
  
  var positions = [

		 <c:forEach items="${stores}" var="store">
	    {
	        title: '${store.name}', 
	        latlng: new kakao.maps.LatLng(${store.lat},${store.lng})
	    },

	    </c:forEach> 
	/*     {
	        title: '롯데캐슬블루오션아파트',
	        latlng: new kakao.maps.LatLng(35.07284629, 129.073734)
	    } */

	];
  
  var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
  
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

      // 마커에 mouseover 이벤트와 mouseout 이벤트를 등록합니다
      // 이벤트 리스너로는 클로저를 만들어 등록합니다 
      // for문에서 클로저를 만들어 주지 않으면 마지막 마커에만 이벤트가 등록됩니다
      kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map, marker, infowindow));
      kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
  }

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
<!-- Navigation-->
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
<header class="masthead" style="background-image: url('assets/img/home-bg.jpg')">
    <div class="container position-relative px-4 px-lg-5">
      <div class="row gx-4 gx-lg-5 justify-content-center">
        <div class="col-md-10 col-lg-8 col-xl-7">
          <div class="site-heading">
            <h1>상가 정보</h1>
            <hr>
            <span class="subheading">welcome to store</span>
          </div>
        </div>
      </div>
    </div>
  </header>
  <!-- Main Content-->
  <div class="container mb-4">
    <div class="row gx-4 gx-lg-5 justify-content-center">
      <div class="col-md-10 col-lg-8 col-xl-7">
        <div class="alert alert-success">
          <strong >관심지역 스토어</strong>
        </div>
        <div id="map" class="mt-2" style="width: 100%; height: 500px"></div>
        <div class="mt-3">
          <table class="table table-striped">
						<thead>
							<tr>
								<th>가게이름</th>
								<th>카테고리</th>
								<th>주소</th>
								<c:forEach var="store" items="${stores}">
									<tr>
										<td>${store.name}</td>
										<td>${store.category}</td>
										<td>${store.address}</td>
									</tr>
								</c:forEach>
							</tr>
						</thead>
						<tbody id="hospitalList"></tbody>
          </table>
        </div>
      </div>
    </div>
  </div>

<%-- footer.jsp를 include해서 재사용하기 --%>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>