<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headmeta.jsp"%>
<title>SSAFY - 공지사항</title>
</head>
<!-- 전체-->
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
	<!-- Page Header-->
	<header class="masthead"
		style="background-image: url('../assets/img/notice.jpg')">
		<div class="container position-relative px-4 px-lg-5">
			<div class="row gx-4 gx-lg-5 justify-content-center">
				<div class="col-md-10 col-lg-8 col-xl-7">
					<div class="site-heading">
						<h1>공지사항</h1>
						<hr>
					</div>
				</div>
			</div>
		</div>
	</header>
	<section class="page-section bg-light" id="전체">
		<div class="container">
			<h4>상세내용</h4>
			<hr>
			<c:if test="${!empty notice}">
				<div class="text-end">
					<c:if test="${!empty ism && ism}">
						<a class="btn btn-outline-warning"
							href="${root}/notice/modify?no=${notice.no}&wrid=${notice.userId}">수정</a>
						<a class="btn btn-outline-warning"
							href="${root}/notice/delete?no=${notice.no}&wrid=${notice.userId}">삭제</a>
					</c:if>
				</div>
				<div class="text-center">

					<table class="mt-2 table table-bordered" style="min-height: 400px">
						<thead class="table-secondary">
							<tr>
								<th width=250px>제목</th>
								<th>${notice.title}</th>
							</tr>
						</thead>
						<tbody>
							<tr style="height:40px">
								<td width=250px>날짜</td>
								<td>${notice.regtime}</td>
							</tr>
							<tr style="height:40px">
								<td width=250px>작성자</td>
								<td>${notice.userId}</td>
							</tr>
							<tr>
								<td style="vertical-align : middle">내용</td>
								<td style="text-align: left">${notice.content}</td>
							</tr>
						</tbody>
					</table>

				</div>
			</c:if>
		</div>
	</section>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>