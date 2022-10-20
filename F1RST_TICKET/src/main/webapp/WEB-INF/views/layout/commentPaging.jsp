<%@page import="util.Paging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	Paging paging = (Paging) request.getAttribute("paging"); %>

<div class="text-center">
	<ul class="pagination">
	
		<%-- 첫 페이지로 이동 --%>
<%-- 		<%	if(paging.getCurPage() != 1) { %> --%>
<%-- 		<li><a href="./view?reviewno=<%=request.getParameter("reviewno") %>">&larr; 처음</a> --%>
<%-- 		<%	} %> --%>
		
		<%-- 이전 페이징 리스트로 이동 --%>
<%-- 		<%	if(paging.getStartPage() != 1) { %> --%>
<%-- 		<li><a href="./view?reviewno=<%=request.getParameter("reviewno") %>&curPage=<%=paging.getStartPage() - paging.getPageCount() %>">&laquo;</a> --%>
<%-- 		<%	} %> --%>
		
		<%-- 이전 페이지로 이동 --%>
<%-- 		<%	if(paging.getCurPage() > 1) { %> --%>
<%-- 		<li><a href="./view?reviewno=<%=request.getParameter("reviewno") %>&curPage=<%=paging.getCurPage()-1 %>">&lt;</a> --%>
<%-- 		<%	} %> --%>
	
		<%	for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { %>
		<%		if(i == paging.getCurPage()) {%>
		<li class="active"><a href="./view?reviewno=<%=request.getParameter("reviewno") %>&curPage=<%=i %>"><%=i %></a></li>
		<%		} else { %>
		<li><a href="./view?reviewno=<%=request.getParameter("reviewno") %>&curPage=<%=i %>"><%=i %></a></li>
		<%		} %>
		<%	} %>
		
		<%-- 다음 페이지로 이동 --%>
<%-- 		<%	if(paging.getCurPage() < paging.getTotalPage()) { %> --%>
<%-- 		<li><a href="./view?reviewno=<%=request.getParameter("reviewno") %>&curPage=<%=paging.getCurPage()+1 %>">&gt;</a> --%>
<%-- 		<%	} %> --%>
		
		<%-- 다음 페이징 리스트로 이동 --%>
<%-- 		<%	if(paging.getStartPage() != paging.getTotalPage()) { %> --%>
<%-- 		<li><a href="./view?reviewno=<%=request.getParameter("reviewno") %>&curPage=<%=paging.getStartPage() + paging.getPageCount() %>">&raquo;</a> --%>
<%-- 		<%	} %> --%>
		
	 	<%-- 마지막 페이지 이동 --%>
<%-- 		<%	if(paging.getCurPage() != paging.getTotalPage()) { %> --%>
<%-- 		<li><a href="./view?reviewno=<%=request.getParameter("reviewno") %>&curPage=<%=paging.getTotalPage() %>">끝 &rarr;</a> --%>
<%-- 		<%	} %> --%>
		
	</ul>
</div>