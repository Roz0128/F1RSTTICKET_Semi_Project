<%@page import="web.dto.Notice"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp" %>

<%	List<Notice> noticeList = (List) request.getAttribute("noticeList"); %>

<style type="text/css">

th, td {
	text-align: center;
}

td:nth-child(2) {
	text-align: justify;
}

</style>

<h1 class="text-center">공지사항</h1>
<hr>

<div class="container">

<table class="table table-hover table-condensed">
	<thead>
		<tr>
			<th style="width: 10%;">구분</th>
			<th style="width: 50%;">제목</th>
			<th style="width: 20%;">티켓 오픈 일시</th>
			<th style="width: 10%;">조회수</th>
		</tr>
	</thead>
	
	<tbody>
	<%	for( int i=0; i<noticeList.size(); i++) { %>
	<tr>
		<td><%=noticeList.get(i).getNotitype() %></td>
		<td>
			<a href="./view?notino=<%=noticeList.get(i).getNotino() %>">
				<%=noticeList.get(i).getNotititle() %>
			</a>
		</td>
		<td><%=noticeList.get(i).getOpendate() %></td>
		<td><%=noticeList.get(i).getNotihit() %></td>
			
	</tr>
	<%	} %>
	</tbody>
	
</table>

</div>

<div class="clearfix"></div>

<%@	include file="../layout/paging.jsp" %>

<%@	include file="../layout/footer.jsp" %>