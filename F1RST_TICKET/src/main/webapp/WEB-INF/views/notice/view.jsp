<%@page import="web.dto.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	Notice viewNotice = (Notice) request.getAttribute("viewNotice"); %>

<link rel="stylesheet" href="/resources/css/noticeView.css">

<%@ include file = "../layout/header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	$("#btnList").click(function() {
		$(location).attr('href', './list')
	})
})
</script>

<h1 class="text-center">공지사항</h1>

<div class="container">

<!-- 공지사항게시글 -->
<div class="container">

	<div class="row row-cols-auto">
		<div class="col page-header text-left">
			<span id="label" class="label label-info col"><%=viewNotice.getNotitype() %></span>
			<h3 id="title" class="text-left col"><strong><%=viewNotice.getNotititle() %></strong></h3>
		</div>
	
		<div class="row">
			<span class="col col-md-auto col-md-offset-9">등록일 : <%=viewNotice.getNotidate() %></span>
			<span class="col col-md-auto col-md-offset-9">조회수 : <%=viewNotice.getNotihit() %></span>
		</div>
		
		<!-- 공지사항게시글내용 -->
		<div class="row">
			<div id="content" class="col"><p><%=viewNotice.getNoticontent() %></p></div>
		</div>
	</div>

</div>

<!-- 목록버튼 -->
<div class="text-center">
	<button id="btnList" class="btn btn-outline">목록으로</button>
</div>

</div>

<%@ include file = "../layout/footer.jsp" %>