<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headmeta.jsp"%>
<title>happyhouse</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- 아파트 리스트 가져오기-->
<script type="text/javascript" src="../js/aptList.js"></script>
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
						<h1>아파트별 조회</h1>
						<hr>
						<span class="subheading">아파트 이름 조회</span>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Main Content-->
	<div class="container px-4 px-lg-5 mb-4">
		<div class="row gx-4 gx-lg-5 justify-content-center">
			<div class="col-md-10 col-lg-8 col-xl-7">
				<form action="${root}/house/apt" method="post">
					<!-- apt preview-->
					<div class="row post-preview">
						<input class="col mb-3 me-2" type="text" id="aptName"
							name="aptName" placeholder="검색할 아파트 명"> <input
							type="submit" class="btn btn-lg col mb-3"
							style="background-color: #eee6c4;" id="aptChekBtn" value="조회">
				</form>
				<hr>
				<div class="row">
					<table class="col" id="table-1">
						<tr>
							<th>아파트</th>
							<th>법정동</th>
							<th>전용면적</th>
							<th>거래금액</th>
							<c:forEach var="house" items="${aptlist}">
								<tr>
									<td>${house.aptName}</td>
									<td>${house.dongName}</td>
									<td>${house.area}</td>
									<td>${house.dealAmount}</td>
								</tr>
							</c:forEach>
						</tr>
						<tbody id="aptinfo"></tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	</div>
	<%-- footer.jsp를 include해서 재사용하기 --%>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>