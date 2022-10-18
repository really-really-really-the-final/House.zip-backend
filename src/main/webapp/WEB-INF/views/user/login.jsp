<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headmeta.jsp"%>	
<title>happyhouse - login</title>
<%-- <c:if test="${cookie.loginid.value ne null}">
	<c:set var="svid" value="${cookie.loginid.value}" />
	<c:set var="ckid" value=" checked=\"checked\"" />
</c:if> --%>
<script type="text/javascript">
	$(document).ready(function() {
		$("#loginBtn").click(function() {
			if (!$("#userid").val()) {
				alert("아이디 입력!!!");
				return;
			} else if (!$("#userpwd").val()) {
				alert("비밀번호 입력!!!");
				return;
			} else {
				$("#loginform").attr("action", "${root}/user").submit();
			}
		});
	});
</script>
</head>
<body>

	<!-- Navigation-->
<%@ include file="/WEB-INF/views/include/nav.jsp"%>
	<!-- Page Header-->
	<header class="masthead"
		style="background-image: url('../assets/img/login-bg.jpg')">
		<div class="container position-relative px-4 px-lg-5">
			<div class="row gx-4 gx-lg-5 justify-content-center">
				<div class="col-md-10 col-lg-8 col-xl-7">
					<div class="page-heading">
						<h1>Welcome</h1>
						<hr>
						<span class="subheading">login page</span>
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
				<h1>Login</h1>
				<form id="loginform" method="post" action="${root}/user/login">
						<div class="form-floating">
							<input class="form-control mb-3" id="id" name="id"
								type="text" placeholder="아이디를 입력해주세요." value="ssafyssafy"/> <label for="id">ID</label>
						</div>
						<div class="form-floating">
							<input class="form-control mb-3" id="password" name="password"
								type="password" placeholder="비밀번호를 입력해주세요."value="1234" /> <label
								for="password">Password</label>
						</div>
						<!-- Login Button-->
						<div class="d-grid">
							<button class="btn" style="background-color: #ece6cc;"
								id="loginButton" type="submit">로그인</button>
						</div>
				</form>
			</div>
		</div>
		<div class="mt-1 text-end">
			<a href="${root}/user/findpwd"><h6 style="color:#FFBF00">비밀번호 찾기</h6></a>
		</div>
	</div>
	</main>	
	<%-- footer.jsp를 include해서 재사용하기 --%>
    <%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>