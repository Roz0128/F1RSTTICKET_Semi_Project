<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="web.dto.Musical"%>
<%@ page import="java.util.List"%>
<%@page import="util.Paging"%>
<!-- c:forEach 사용을 위한 jstl 선언 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- 조회결과 반환 -->
<% List<Musical> musicalList = (List) request.getAttribute("musicalList"); %>
<!-- paging 반환 -->
<%	Paging paging = (Paging) request.getAttribute("paging"); %>

<%@ include file="../layout/header_mu.jsp" %>

<script>
$(document).ready(function(){
	<!-- 뮤지컬 카테고리 메뉴 클릭 시 아이콘 변경 -->
	$(".dropdown").on("hide.bs.dropdown", function(){
		$("#dropdownMenu1").html('전체보기 <span class="glyphicon glyphicon-chevron-down"></span>');
	});
	$(".dropdown").on("show.bs.dropdown", function(){
		$("#dropdownMenu1").html('전체보기 <span class="glyphicon glyphicon-chevron-up"></span>');
	});
  
	<!-- 뮤지컬 카테고리 메뉴 트렌젝션 -->
	$('.dropdown').on('show.bs.dropdown', function() {
		$(this).find('.dropdown-menu').first().stop(true, true).slideDown();
	});
	$('.dropdown').on('hide.bs.dropdown', function() {
		$(this).find('.dropdown-menu').first().stop(true, true).slideUp();
	});
});
</script>

<hr>
<div class="text-center">
		<span id="menuMu">뮤지컬</span>
		<span style="display:inline-block;" class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
	
	<!-- 뮤지컬 페이지 드롭다운 메뉴 -->
	<div class="dropdown" style="display:inline-block;">
  		<button onclick="handleTitleClick()" class="btn btn-default.focus dropdown-toggle btn-lg" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
    		전체보기 <span id="icon" class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
	  	</button>
	  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
	    <li role="presentation"><a role="menuitem" tabindex="-1" href="/musical/mcList">전체보기</a></li>
	    <li role="presentation"><a role="menuitem" tabindex="-1" href="/musical/mcNew">신규보기</a></li>
	    <li role="presentation"><a role="menuitem" tabindex="-1" href="/musical/mcLike">인기보기</a></li>
	    <li role="presentation"><a role="menuitem" tabindex="-1" href="/musical/mcMd">MD's PICK</a></li>
	  </ul>
	</div>
</div>
<hr>

<!-- 뮤지컬 전체 목록 -->
<div>
	
<c:forEach var="musical" items="${musicalList}"> 
	<a href="./mcView?mcno=${musical.mcno}">
		<div class="col-md-3">
			<div id="imgWrapper">
				<img alt="포스터" src="${pageContext.request.contextPath}/resources/img/mc/${musical.mcimg}"
						onerror="this.src='${pageContext.request.contextPath}/resources/img/mc/noImg.jpg'">
			</div>
			<div id="textWrapper">
				<p class="title">뮤지컬 [${musical.mcname}]</p> 
				<p class="info">${musical.mcstart} ~ ${musical.mcend}</p> 
				<p class="info">${musical.mcloc}</p>
				<br><br>
			</div>
		</div> 
	</a>
</c:forEach>

</div>

<div class="text-center">
	<ul class="pagination">
	
		<%-- 첫 페이지로 이동 --%>
		<%	if(paging.getCurPage() != 1) { %>
		<li><a href="./mcList">&laquo;</a></li>
		<%	} %>

	
		<%-- 이전 페이지로 이동 --%>
		<%	if(paging.getCurPage() > 1) { %>
		<li><a href="./mcList?curPage=<%=paging.getCurPage()-1 %>">&lt;</a></li>
		<%	} %>
	
	
		<%-- 페이징 번호 리스트 --%>
		<%	for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { %>
		<%		if(i == paging.getCurPage()) { %>
		<li class="active"><a href="./mcList?curPage=<%=i %>"><%=i %></a></li>
		<%		} else { %>
		<li><a href="./mcList?curPage=<%=i %>"><%=i %></a></li>
		<%		} %>
		<%	} %>


		<%-- 다음 페이지로 이동 --%>
		<%	if(paging.getCurPage() < paging.getTotalPage()) { %>
		<li><a href="./mcList?curPage=<%=paging.getCurPage()+1 %>">&gt;</a></li>
		<%	} %>

		
		
		<%-- 마지막 페이지 이동 --%>
		<%	if(paging.getCurPage() != paging.getTotalPage()) { %>
		<li><a href="./mcList?curPage=<%=paging.getTotalPage() %>">&raquo;</a></li>
		<%	} %>
		
	</ul>
</div>
<%@ include file = "../layout/footer.jsp" %>

