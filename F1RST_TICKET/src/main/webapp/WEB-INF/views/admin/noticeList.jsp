<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="web.dto.Notice"%>
<%@page import="java.util.List"%>


<%	List<Notice> noticeList = (List) request.getAttribute("noticeList"); %>

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

th, td {
	text-align: center;
}

td:nth-child(2) {
	text-align: justify;
}

</style>

<script type="text/javascript">
$(document).ready(function() {
	$("#btnWrite").click(function() {
		location.href = "/admin/noticeWrite"
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
	<br><br>
	
<div class="container-fluid">
	<!-- 관리자메뉴바 -->
	<div class="row">
		<div class="col-md-2 col-md-offset-1" id="adminpageDiv">
			<ul style="list-style-type: none;">
			<li><a href="/admin/user">회원 관리
			<span class="glyphicon glyphicon glyphicon-menu-right" aria-hidden="true"></span></a></li><br>
			<li><a href="/admin/noticeList">공지사항 관리
			<span class="glyphicon glyphicon glyphicon-menu-right" aria-hidden="true"></span></a></li><br>
			<li><a href="/admin/main">예매 관리
			<span class="glyphicon glyphicon glyphicon-menu-right" aria-hidden="true"></span></a></li><br>
			<li><a href="/admin/main">티켓 관리
			<span class="glyphicon glyphicon glyphicon-menu-right" aria-hidden="true"></span></a></li><br>
			<li><a href="/admin/mcDelete">뮤지컬 관리
			<span class="glyphicon glyphicon glyphicon-menu-right" aria-hidden="true"></span></a></li><br>
			</ul>
		</div>
		
		<div class="col-md-8" id="adminpageMain">
			<div class="container-fluid">
			
			<div class="row">
				<div class="col-md-11">
				<h3 style="display: inline-block;">공지사항 관리</h3>
				
				<!-- 공지사항 조회 -->
				<table class="table  table-hover table-condensed" style="width:1000px;margin-top: 30px;">
					<tr>
					<th style="width:10%;padding-top:18px;">구분</th>
					<th style="width:50%;padding-top:18px;">제목</th>
					<th style="width:20%;padding-top:18px;">티켓 오픈 일시</th>
					<th style="width:10%;padding-top:18px;">조회수</th>
					</tr>
				
					<%	for( int i=0; i<noticeList.size(); i++) { %>
					<tr>
					<td><%=noticeList.get(i).getNotitype() %></td>
					<td>
					<a href="./noticeView?notino=<%=noticeList.get(i).getNotino() %>">
					<%=noticeList.get(i).getNotititle() %>
					</a>
					</td>
					<td><%=noticeList.get(i).getOpendate() %></td>
					<td><%=noticeList.get(i).getNotihit() %></td>
							
					</tr>
					<%	} %>
										
				</table>
				</div>
			</div>
			
			</div>
<!-- 글쓰기 버튼 -->
<div id="btnBox" class="text-center">
	<button id="btnWrite" class="btn btn-outline">글쓰기</button>
</div>
<%@	include file="../layout/paging_admin_notice.jsp" %>
</div>
		</div>
	</div>
</div>
<div class="clearfix"></div>

