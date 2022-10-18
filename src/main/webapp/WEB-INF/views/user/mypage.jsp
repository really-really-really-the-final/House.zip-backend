<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headmeta.jsp"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>happyhouse - mypage</title>
<script type="text/javascript">
	function modify() {
		document.querySelector("#password").disabled = false;
		document.querySelector("#name").disabled = false;
		document.querySelector("#email").disabled = false;
		document.querySelector("#phone").disabled = false;
		
		document.querySelector("#btnModify").style.display = "none";
		document.querySelector("#btnSave").style.display = "inline";
		document.querySelector("#btnNope").style.display = "inline";
		<c:if test="${!requestScope.user.isManager()}">
		document.querySelector("#btnQuit").style.display = "none";
		</c:if>
	}
</script>
</head>
<body>
	<!-- Navigation-->
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
	<!-- Page Header-->
	<header class="masthead" style="background-image: url('../assets/img/mypage-bg.jpg')">
		<div class="container position-relative post-heading">
			<h1 class="text-center">My page</h1>
		</div>
	</header>
	<!-- SIGNUP Content-->
	<article class="mb-5">
		<div class="container px-4 px-lg-5 center-block" style="width: 500px;">
			<div class="signup-page">
				<h2>회원 정보</h2>
				<hr>
				<form method="post" action="${root}/user/modify" class="info-form text-left mb-3" name="info-form" id="info-form">
					<!-- <input type="hidden" name="action" value="modify">  -->
					<input type="hidden" name="ism"value="${requestScope.user.isManager()}"> 
					<input type="hidden" name="id" value="${user.id}"> 
					
					<div class="row">
						<div class="col-3 mb-3 border-end border-1">아이디</div>
						<input class="col form-control mb-3" id="id" name="id" type="text" value="${user.id}" 
						disabled style="border:0;" />
					</div>
					
					<div class="row">
						<div class="col-3 mb-3 border-end border-1">비밀번호</div>
						<input class="col form-control mb-3" id="password" name="password" type="text" value="${user.password}" 
						disabled style="border:0;" />
					</div>
					
					<div class="row">
						<div class="col-3 mb-3 border-end border-1">이름</div>
						<input class="col mb-3  form-control" id="name" name="name" value="${user.name}" type="text" disabled style="border: 0;" />
					</div>
					
					<div class="row">
						<div class="col-3 mb-3 border-end border-1">이메일</div>
						<input class="col mb-3 form-control" id="email" name="email" type="email" value="${user.email}" disabled
							style="border: 0;" />
					</div>
					
					<div class="row">
						<div class="col-3 border-end border-1">전화번호</div>
						<input class="col mb-1 form-control" id="phone" name="tel" type="text" value="${user.tel}" disabled style="border: 0;" />
					</div>
					
					<hr>
					<div class="text-center mt-3">
						<input id="btnSave" type="submit" class="btn btn-info"	style="display: none" value="정보저장" />
						<a id="btnNope" class="btn" style="display: none; background-color: #eee6c4;" href="${root}/user/mypage">취소</a>
					</div>
				</form>
			</div>
			<div class="row">
				<button class="btn col me-2" style="background-color: #eee6c4;" id="btnModify" onclick="modify();">정보수정</button>
				<c:if test="${!requestScope.user.isManager()}">
					<a class="btn col" style="background-color: #eee6c4;"id="btnQuit" href="${root}/user/rmuser">탈퇴</a>
				</c:if>
			</div>
		</div>
	</article>
	<%-- footer.jsp를 include해서 재사용하기 --%>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>