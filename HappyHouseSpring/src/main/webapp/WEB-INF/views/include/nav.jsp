<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-dark fixed-top" id="mainNav">
	<div class="container px-4 px-lg-5">
		<a class="navbar-brand" href="${root}">Happy House</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			Menu <i class="fas fa-bars"></i>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">

			<ul class="navbar-nav ms-auto py-4 py-lg-0"></ul>
			<div id="userinfo">
				<div id="header_nav">
					<ul class="navbar-nav ms-auto py-4 py-lg-0">
						<li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4"
							href="${root}/intro">intro</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle px-lg-3 py-3 py-lg-4" href="#"
							role="button" data-bs-toggle="dropdown">거래조회</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="${root}/house/all">전체조회</a></li>
								<li><a class="dropdown-item" href="${root}/house/dong">동별조회</a></li>
								<li><a class="dropdown-item" href="${root}/house/apt">아파트별조회</a></li>
							</ul></li>
							<li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4"
							href="${root}/qna">QnA</a></li>
					
						<c:if test="${empty loginUser}">
							<li class="nav-item"><a
								class="nav-link px-lg-3 py-3 py-lg-4" href="${root}/user/login">login</a></li>
							<li class="nav-item"><a
								class="nav-link px-lg-3 py-3 py-lg-4" href="${root}/user/regist">signup</a></li>
						</c:if>
						<c:if test="${!empty loginUser}">
						<li class="nav-item"><a class="nav-link px-lg-3 py-3 py-lg-4"
							href="${root}/notice/">공지사항</a></li>
							<%-- <li class="nav-item"><a
									class="nav-link px-lg-3 py-3 py-lg-4" href="${root}/main?action=hospital">의료정보</a></li>
									<li class="nav-item"><a
									class="nav-link px-lg-3 py-3 py-lg-4" href="${root}/main?action=storelist">상가정보</a></li> --%>
							<li class="nav-item"><a
								class="nav-link px-lg-3 py-3 py-lg-4" href="${root}/user/logout">logout</a></li>
							<li class="nav-item"><a
								class="nav-link px-lg-3 py-3 py-lg-4" href="${root}/user/mypage">mypage</a></li>
						</c:if>
					</ul>
				</div>
			</div>
		</div>
	</div>
</nav>

<script>
	let msg = "${msg}";
	if (msg) {
		alert(msg);
	}
</script>