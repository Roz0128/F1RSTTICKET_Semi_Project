<%@page import="web.dto.Musical"%>
<%@page import="java.util.List"%>
<%@page import="util.Paging"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 조회결과 반환 -->
<%	List<Musical> musicalList = (List) request.getAttribute("musicalList"); %>
<!-- paging 반환 -->
<%	Paging paging = (Paging) request.getAttribute("paging"); %>

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
	margin-left: 70px;

}

.table th{
	background-color: #CADBE9;
	text-align: center;
	height: 55px;
	font-size: large;
	font-weight: bold;
}
td {
	text-align: center;
	font-weight: 500;
	font-size: 15px;
}

.col-md-11 p{
	font-size: 30px;
	font-weight: bold;
	display: inline-block;
}

#del {
	color: white;
	text-decoration: none;
}

#mcDel {
	font-size: 10px;
}
</style>

<script>	
//뮤지컬 삭제 확인
$(document).ready(function(){
	
    if( ${isDel eq true} ) {
		alert('뮤지컬 삭제 성공');
    }
    else if( ${isDel eq false } ){
    	alert('뮤지컬 삭제 실패');
    }
});	
</script>
	
<form action="/admin/mcDelete" method="get" name="adminpage" id="adminpage" class="form-horizontal">

<div class="container-fluid">
	<div class="row">
		<div class="col-md-4 col-md-offset-1">
			<a href='/admin/main'><img alt="LOGO" src="/resources/img/logo.jpg" style="display: inline"></a>
		</div>
	</div>
	<div class="col-md-4 col-md-offset-1">
		<a href="/admin/main" style="text-decoration: none; color:black; font-size: 25px; font-weight: bold;">
			관리자 페이지
		</a>
	</div>
	<br><br>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-2 col-md-offset-1" id="adminpageDiv">
			<ul style="list-style-type: none;">
				<li><a href="/admin/user">회원 관리
				<span class="glyphicon glyphicon glyphicon-menu-right" aria-hidden="true"></span></a></li><br>
				<li><a href="/admin/noticeList" onclick="">공지사항 관리
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
					<p style="display: inline-block;">뮤지컬 관리</h3>
					
					<!-- 뮤지컬 조회 -->
					<table class="table  table-hover table-condensed" style="width:1000px;margin-top: 30px;">
						<tr>
							<th style="width:15%;padding-top:18px;">뮤지컬 번호</th>
							<th style="width:25%;padding-top:18px;">뮤지컬 제목</th>
							<th style="width:15%;padding-top:18px;">공연 시작일</th>
							<th style="width:15%;padding-top:18px;">공연 종료일</th>
							<th style="width:20%;padding-top:18px;">장소</th>
							<th style="width:10%;padding-top:18px;">삭제</th>
						</tr>
						
						<%for(int i=0; i<musicalList.size(); i++) { %>
							<tr>
								<td><%=musicalList.get(i).getMcno() %></td>
								<td style="text-align: left;">
								<a style="text-decoration: none;color:black;"
									 href="/musical/mcView?mcno=<%=musicalList.get(i).getMcno() %>">
								<%=musicalList.get(i).getMcname() %></a>
								</td>
								<td><%=musicalList.get(i).getMcstart() %></td>
								<td><%=musicalList.get(i).getMcend() %></td>
								<td><%=musicalList.get(i).getMcloc() %></td>
								<td>
									<button id="mcDel" class="btn btn-danger" >
									<a href="/admin/mcDelete?mcno=<%=musicalList.get(i).getMcno() %>" id="del">
									삭제</a>
									</button>
								</td>
							</tr>
						<% }  %>
						
					</table>
		</div>
		<div style="margin-left: 430px;display: inline-block;">
			<ul class="pagination">
			
				<%-- 첫 페이지로 이동 --%>
				<%	if(paging.getCurPage() != 1) { %>
				<li><a href="./mcDelete">&laquo;</a></li>
				<%	} %>
		
			
				<%-- 이전 페이지로 이동 --%>
				<%	if(paging.getCurPage() > 1) { %>
				<li><a href="./mcDelete?curPage=<%=paging.getCurPage()-1 %>">&lt;</a></li>
				<%	} %>
			
			
				<%-- 페이징 번호 리스트 --%>
				<%	for(int i=paging.getStartPage(); i<=paging.getEndPage(); i++) { %>
				<%		if(i == paging.getCurPage()) { %>
				<li class="active"><a href="./mcDelete?curPage=<%=i %>"><%=i %></a></li>
				<%		} else { %>
				<li><a href="./mcDelete?curPage=<%=i %>"><%=i %></a></li>
				<%		} %>
				<%	} %>
		
		
				<%-- 다음 페이지로 이동 --%>
				<%	if(paging.getCurPage() < paging.getTotalPage()) { %>
				<li><a href="./mcDelete?curPage=<%=paging.getCurPage()+1 %>">&gt;</a></li>
				<%	} %>
		
				
				
				<%-- 마지막 페이지 이동 --%>
				<%	if(paging.getCurPage() != paging.getTotalPage()) { %>
				<li><a href="./mcDelete?curPage=<%=paging.getTotalPage() %>">&raquo;</a></li>
				<%	} %>
				
			</ul>
		</div>
	</div>
</div>
		</div>
	</div>
</div>
</div>
</form>

