<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headmeta.jsp"%>
<title>SSAFY - 공지사항</title>
</head>
<!-- 전체-->
<body>
	<%@ include file="/WEB-INF/views/include/nav.jsp"%>
	 <!-- Page Header-->
    <header class="masthead" style="background-image: url('../assets/img/notice.jpg')">
        <div class="container position-relative px-4 px-lg-5">
            <div class="row gx-4 gx-lg-5 justify-content-center">
                <div class="col-md-10 col-lg-8 col-xl-7">
                    <div class="site-heading">
                        <h1>공지사항</h1>
                    </div>
                </div>
            </div>
        </div>
    </header>
	
	<section class="page-section bg-light" id="전체">
		<div class="container">
			<div class="text-end">
				<c:if test="${!empty ism && ism}">
					<a class="btn btn-outline-warning"
						href="${root}/notice/write">글작성</a> 
				</c:if>
			</div>
			<div class="text-center">

				<table class="mt-2 table table-bordered">

						<thead class="table-secondary">
					<tr>
						<th class="col-md-8">제목</th>
						<th class="col-md-2">날짜</th>
						<th class="col-md-2">id</th>
					</tr>
					</thead>
					<c:if test="${!empty notices}">
						<c:forEach var="notice" items="${notices}">
							<tr>
								<td><a href="${root}/notice/detail?no=${notice.no}"
									style="text-decoration: none">${notice.title}</a></td>
								<td>${notice.regtime.substring(0,10)}</td>
								<td>${notice.userId}</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
			</div>
		</div>
	</section>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
</body>
</html>