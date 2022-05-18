<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%-- <%@ include file="/WEB-INF/views/include/headmeta.jsp"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<link rel="icon" type="image/x-icon" href="../assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js" crossorigin="anonymous"></script>
<!-- Google fonts-->
<link
	href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/styles.css" rel="stylesheet" />
<script src="js/scripts.js"></script>
<title>happyhouse</title>
</head>

<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
	<!-- Page Header-->
	<header class="masthead"
		style="background-image: url('assets/img/home-bg.jpg')">
		<div class="container position-relative px-4 px-lg-5">
			<div class="row gx-4 gx-lg-5 justify-content-center">
				<div class="col-md-10 col-lg-8 col-xl-7">
					<div class="site-heading">
						<h1>Happy House</h1>
						<hr>
						<span class="subheading">introduce</span>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- Main Content-->
	<div class="container mb-4">
		<div class="text-center">
			<h2 >행복한 나의 집을 찾아서...</h2>
			<hr>
			<li class="mb-2">아파트 위치, 실거래가, 거래 날짜 등 많은 매매 정보 확인 가능..!</li>
			<li class="mb-2">전국에 있는 아파트 매매정보 확인 가능!!</li>
			<li class="mb-2">자세한 매매 정보 검색 및 공지사항은 회원만 확인 가능!</li>
			<li class="mb-2">관심지역 동네 업종 정보 추가 예정 (많관부^_^)</li>
			<li class="mb-2">우리 홈페이지는 별이 다섯개~~★★★★★</li>
		</div>
	</div>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>