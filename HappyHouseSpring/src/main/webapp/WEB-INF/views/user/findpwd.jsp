<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headmeta.jsp"%>
<title>SSAFY - 비밀번호찾기</title>
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> -->
<!--     <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=3e9a9ed52d8e8d23d706d0eccadb61ba"
    ></script> -->
</head>
<!-- 전체-->
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
	<!-- Page Header-->
	<header class="masthead"
		style="background-image: url('../assets/img/login-bg.jpg')">
		<div class="container position-relative px-4 px-lg-5">
			<div class="row gx-4 gx-lg-5 justify-content-center">
				<div class="col-md-10 col-lg-8 col-xl-7">
					<div class="page-heading">
						<h1>Login</h1>
						<hr>
						<span class="subheading">FIND PASSWORD</span>
					</div>
				</div>
			</div>
		</div>
	</header>
	<!-- Main Content-->
	<main class="mb-4">
		<div class="container px-4 px-lg-5">
			<div class="row gx-4 gx-lg-5 justify-content-center">
				<div class="col-md-10 col-lg-8 col-xl-7">
					<h1>비밀번호 찾기</h1>
					<form method="post" action="${root}/user/findpwd" name="info-form"
						class="info-form">
						<div class="form-floating">
							<input class="form-control mb-3" id="id" name="id" type="text"
								placeholder="아이디를 입력해주세요." /> <label for="id">ID</label>
						</div>
						<div class="form-floating">
							<input class="form-control mb-3" id="name" name="name"
								type="text" placeholder="이름을 입력해주세요." /> <label for="name">Name</label>
						</div>
						<div class="form-floating">
							<input class="form-control mb-3" id="tel" name="tel" type="text"
								placeholder="010********" /> <label for="tel">Tel</label>
						</div>
						<!-- Login Button-->
						<div class="d-grid">
							<button class="btn" style="background-color: #ece6cc;"
								id="findButton" type="submit">찾기</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>