<%@page import="web.dto.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	Notice viewNotice = (Notice) request.getAttribute("viewNotice"); %>

<!-- 스마트 에디터2 설치 -->
<script type="text/javascript" src="/resources/se2/js/service/HuskyEZCreator.js"></script>

<script type="text/javascript" src = "https://code.jquery.com/jquery-2.2.4.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>


<!-- adminpage.css -->
<style type="text/css">
#adminpageDiv div{
	vertical-align: middle;
	padding: 20px;
}

#adminpageDiv ul li a {
	text-decoration: none;
	color : #fff;
	font-size: 18px;
}

#adminpageDiv ul li a:hover{
	
border-bottom: 2px solid #D4DFE6;

}

#adminpageDiv{
	
	background-color: #8EC0E4;
	padding-top: 10%;
	padding-bottom: 20%;
}

#adminpageMain {
	padding-top: 5%;

}

tr th{
	font-size: 14px;
}

</style>

<script type="text/javascript">
$(document).ready(function() {
	
	//목록버튼
	$("#btnList").click(function() {
		$(location).attr('href', './noticeList')
	})
	
	//수정버튼 클릭
	$("#btnUpdate").click(function() {
		$(location).attr('href', './noticeUpdate?notino=<%=viewNotice.getNotino() %>')
	})

	//삭제버튼 클릭
	$("#btnDelete").click(function() {
		$(location).attr('href', './noticeDelete?notino=<%=viewNotice.getNotino() %>')
	})
	
	
})
</script>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-4 col-md-offset-1">
			<a href='/admin/main'><img alt="LOGO" src="/resources/img/logo.jpg" style="display: inline"></a>
		</div>
	</div>
	<div class="col-md-4 col-md-offset-1">
		<a href="/admin/main" style="text-decoration: none; color:black; font-size: 20px; font-weight: bold;">
			관리자 페이지
		</a>
	</div>
</div>

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
			<div id="content" class="col text-center"><p><%=viewNotice.getNoticontent() %></p></div>
		</div>
	</div>

</div>

<!-- 목록버튼 -->
<div class="text-center">
	<button id="btnList" class="btn btn-outline">목록으로</button>
	<button id="btnUpdate" class="btn btn-outline" style="background-color: #8EC0E4;">수정하기</button>
	<button id="btnDelete" class="btn btn-outline" style="background-color: #ea9999;">삭제하기</button>
</div>

</div>