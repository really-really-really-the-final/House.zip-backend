<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/views/include/headmeta.jsp"%>
	<title>happyhouse - hospital</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <!-- 지도 가져오기 -->
  <script type="text/javascript"
    src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7f40405e29341c1fa46226d9889e981a&libraries=services"></script>
  <!-- 아파트 리스트 가져오기-->
  <script type="text/javascript" src="js/hospital.js"></script>
  
</head>
<body>
<!-- Navigation-->
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
<header class="masthead" style="background-image: url('assets/img/home-bg.jpg')">
    <div class="container position-relative px-4 px-lg-5">
      <div class="row gx-4 gx-lg-5 justify-content-center">
        <div class="col-md-10 col-lg-8 col-xl-7">
          <div class="site-heading">
            <h1>병원 정보</h1>
            <hr>
            <span class="subheading">welcome to hospital</span>
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
          <strong>건강보험 심사평가원</strong> 호흡기 진료 지정 의료기관 정보서비스.
        </div>
        <div class="row justify-content-end">
          <button type="button" class="btn btn-outline-danger mb-2" id="hospital-list">의료기관 검색</button>
        </div>
        <div id="map" class="mt-2" style="width: 100%; height: 500px"></div>
        <div class="mt-3">
          <table class="table table-striped">
            <thead>
              <tr>
                <th>요양기관명</th>
                <th>전화번호</th>
                <th>주소</th>
                <th>PCR검사여부</th>
                <th>위도</th>
                <th>경도</th>
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