<%@ page contentType="text/html; charset=UTF-8" %>
<%-- https://getbootstrap.com/docs/4.0/components/pagination/ --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<ul class="pagination justify-content-center">
	<li class="page-item">
		<a href="javascript:movePage(1);" class="page-link">최신</a>
	</li>
	<li class="page-item">
		<a href="javascript:movePage(${navigation.startRange? 1 : navigation.startPage-1})" class="page-link">이전</a>
	</li>
<c:forEach var="i" begin="${navigation.startPage}" end="${navigation.endPage}">
	<li class="${navigation.currentPage==i? 'page-item active' : 'page-item'}">
		<a href="javascript:movePage(${i})" class="page-link">${i}</a>
	</li>
</c:forEach>
	<li class="page-item">
		<a href="javascript:movePage(${navigation.endRange? navigation.endPage : navigation.endPage+1})" class="page-link">다음</a>
	</li>
	<li class="page-item">
		<a href="javascript:movePage(${navigation.totalPageCount})" class="page-link">마지막</a>
	</li>
</ul>
