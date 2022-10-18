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
                        <hr>
                    </div>
                </div>
            </div>
        </div>
    </header>
	<section class="page-section bg-light" id="전체">
		<div class="container">
		<h4>공지사항 수정</h4>
		<hr>
			<div class="row mb-4">
				<div class="col-sm-1 "></div>
				<div class="col-sm-10">
				<c:if test="${!empty notice}">
				<form method="post" action="${root}/notice/modify" name="notice-form"
						class="notice-form" id="notice-form">
						<input type="hidden" name="no" value="${notice.no}"> <label
							for="title" class="mt-3 form-label">제목</label> <input
							class="form-control" id="title" name="title" type="text" value="${notice.title}" /> <label
							for="content" class="mt-3 form-label">내용</label>
						<textarea rows="10" class="mt-1 form-control" id="content"
							name="content">${notice.content}</textarea>
						<div class="text-center mt-3">
							<input id="save" type="button" value="저장" class="btn btn-primary btn-block" />
						</div>
					</form>
					</c:if>
					<c:if test="${empty notice}">
					<div>잘못된 접근입니다.</div>
					</c:if>
				</div>
				<div class="col-sm-1"></div>
			</div>
		</div>
	</section>
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<script>
		$(document).ready(function() {
			$("#save").click(function() {
				if (!$("#title").val() || !$("#content").val()) {
					alert("제목, 내용 입력!!!");
					return;
				} else {
					$("#notice-form").submit();
				}
			});
		});
	</script>
</body>
</html>