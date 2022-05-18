<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/headmeta.jsp"%>
<title>happyhouse - dong</title>
 <!-- 아파트 리스트 가져오기-->
    <script type="text/javascript" src="../js/aptList.js"></script>
</head>
<body>
<!-- Navigation-->
<%@ include file="/WEB-INF/views/include/nav.jsp"%>
<!-- Page Header-->
    <header class="masthead" style="background-image: url('../assets/img/home-bg.jpg')">
        <div class="container position-relative px-4 px-lg-5">
            <div class="row gx-4 gx-lg-5 justify-content-center">
                <div class="col-md-10 col-lg-8 col-xl-7">
                    <div class="site-heading">
                        <h1>동별 조회</h1>
                        <hr>
                        <span class="subheading">아파트 동별 조회</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Main Content-->
    <div class="container px-4 px-lg-5 mb-4">
        <div class="row gx-4 gx-lg-5 justify-content-center">
            <div class="col-md-10 col-lg-8 col-xl-7">
                <form action="${root}/house/dong" method="post">
                <div class="mb-3 row ">
                    <select class="col me-1 text-light form-control-lg bg-secondary" id="sido"> </select>
                    <select class="col me-1 text-light form-control-lg bg-secondary" id="gugun"> <option value="">구군선택</option>
                    </select>
                    <select class="col me-2 text-light form-control-lg bg-secondary" name="dong" id="dong">
                        <option value="">동선택</option>
                    </select>
                </div>
                <hr>
                <!-- apt preview-->
                <div class="row post-preview">
                    <input type="submit" class="btn btn-lg col mb-3" style="background-color: #eee6c4;" id="listBtn" value="조회">
                    </form>
                    <hr>
                    <div class="row">
                        <table class="col">
                        <c:if test="${!empty donglist}">
                            <tr>
                                <th>아파트</th>
                                <th>법정동</th>
                                <th>전용면적</th>
                                <th>거래금액</th>
                                <c:forEach var="house" items="${donglist}">
                                <tr>
                                	<td>${house.aptName}</td>
									<td>${house.dongName}</td>
									<td>${house.area}</td>
									<td>${house.dealAmount}</td>
								</tr>
                                </c:forEach>
                            </tr>
                        </c:if>
                        <c:if test="${empty donglist}">
                        <h5>거래 내역이 존재하지 않습니다. 다른 지역을 선택해주세요.</h5> 
                        </c:if>
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