<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headmeta.jsp"%>
<title>happyhouse</title>
<!-- 아파트 리스트 가져오기-->
<!-- <script type="text/javascript" src="js/aptList.js"></script> -->
<!-- 지도 가져오기 -->
<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7f40405e29341c1fa46226d9889e981a&libraries=services"></script>
<!-- 지도에 마커 찍기 -->
<script type="text/javascript">
var map2;
$(function () {
	<c:if test="${!empty house}">
  var container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
  var options = {
    //지도를 생성할 때 필요한 기본 옵션
    center: new kakao.maps.LatLng(${house.lat},${house.lng}), //지도의 중심좌표.
    level: 4, //지도의 레벨(확대, 축소 정도)
  };
  map2 = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
      var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
      // 마커 이미지의 이미지 크기 입니다
      var imageSize = new kakao.maps.Size(24, 35); 
      var markerPosition  = new kakao.maps.LatLng(${house.lat},${house.lng}); 
      
      // 마커 이미지를 생성합니다    
      var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize); 
      
      // 마커를 생성합니다
      var marker = new kakao.maps.Marker({
          map: map2, // 마커를 표시할 지도
          position: markerPosition, // 마커를 표시할 위치
          image : markerImage // 마커 이미지 
      });
      marker.setMap(map2);
	</c:if>
      kakao.maps.event.addListener(marker, 'mouseover', makeOverListener(map2, marker, infowindow));
      kakao.maps.event.addListener(marker, 'mouseout', makeOutListener(infowindow));
});
</script>
</head>
<body>
	<!-- Navigation-->
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
	<!-- Page Header-->
	<header class="masthead"
		style="background-image: url('../assets/img/home-bg.jpg')">
		<div class="container position-relative px-4 px-lg-5">
			<div class="row gx-4 gx-lg-5 justify-content-center">
				<div class="col-md-10 col-lg-8 col-xl-7">
					<div class="site-heading">
						<h1>상세 조회</h1>
						<hr>
						<span class="subheading">아파트 상세 조회</span>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- Main Content-->
	<div class="container mb-4">
		<div class="row gx-4 gx-lg-5 justify-content-center">
			<div class="col-md-10 col-lg-8 col-xl-7">
				<!-- 지도 -->
				<div class="mb-4" id="map" style="width: 100%; height: 400px;"></div>

					<table class="table table-bordered table-dark">
						<c:if test="${!empty house}">
						<tr>
									<td>아파트</td>
									<td>${house.aptName}</td>
								</tr>
								<tr>
									<td>법정동</td>
									<td>${house.dongName}</td>
								</tr>
								<tr>
									<td>건축년도</td>
									<td>${house.buildYear}</td>
								</tr>
								<tr>
									<td>지번</td>
									<td>${house.jibun}</td>
								</tr>
								<tr>
									<td>거래금액</td>
									<td>${house.dealAmount}</td>
								</tr>
								<tr>
									<td>전용면적</td>
									<td>${house.area}</td>
								</tr>
								<tr>
									<td>층수</td>
									<td>${house.floor}</td>
								</tr>
						</c:if>
						<tbody id="aptinfo"></tbody>
					</table>
				</div>
		
		</div>
	</div>

	<%-- footer.jsp를 include해서 재사용하기 --%>
<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>