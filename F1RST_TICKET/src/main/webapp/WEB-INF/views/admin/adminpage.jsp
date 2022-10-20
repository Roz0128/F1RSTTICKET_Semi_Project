<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


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

	
<form action="/adminpage" method="post" name="adminpage" id="adminpage" class="form-horizontal">

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
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-6">
					<h4 style="display: inline-block;">회원 관리</h4>
					<span><a href="/admin/user" style="color: #aaa;">더보기</a></span>
					<table class="table">
						<thead>
							<tr> 
								<th style="width: 15%">아이디</th>
								<th style="width: 30%">이메일</th>
								<th style="width: 20%">핸드폰</th>
								<th style="width: 10%">성별</th>
								<th style="width: 20%">생일</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>[DB작업]</td>
								<td>[DB작업]</td>
								<td>[DB작업]</td>
								<td>[DB작업]</td>
								<td>[DB작업]</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="col-md-6">
					<h4 style="display: inline-block;">공지사항 관리</h4>
					<span><a href="/admin/noticeList" style="color: #aaa;">더보기</a></span>
					<table class="table">
						<thead>
							<tr>
								<th>구분</th>
								<th>제목</th>
								<th>티켓 오픈 일시</th>
								<th>조회수</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>[DB작업]</td>
								<td>[DB작업]</td>
								<td>[DB작업]</td>
								<td>[DB작업]</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-6">
					<h4 style="display: inline-block;">예매 관리</h4>
					<span><a href="/admin/main" style="color: #aaa;">더보기</a></span>
					<table class="table">
						<thead>
							<tr>
								<th>아이디</th>
								<th>이메일</th>
								<th>핸드폰</th>
								<th>성별</th>
								<th>생일</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>[DB작업]</td>
								<td>[DB작업]</td>
								<td>[DB작업]</td>
								<td>[DB작업]</td>
								<td>[DB작업]</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="col-md-6">
					<h4 style="display: inline-block;">티켓 관리</h4>
					<span><a href="/admin/main" style="color: #aaa;">더보기</a></span>
					<table class="table">
						<thead>
							<tr>
								<th>아이디</th>
								<th>이메일</th>
								<th>핸드폰</th>
								<th>성별</th>
								<th>생일</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>[DB작업]</td>
								<td>[DB작업]</td>
								<td>[DB작업]</td>
								<td>[DB작업]</td>
								<td>[DB작업]</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-6">
					<h4 style="display: inline-block;">뮤지컬 관리</h4>
					<span><a href="/admin/mcDelete" style="color: #aaa;">더보기</a></span>
					<table class="table">
						<thead>
							<tr>
								<th>뮤지컬 번호</th>
								<th>뮤지컬 제목</th>
								<th>공연 시작일</th>
								<th>공연 종료일</th>
								<th>장소</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>[DB작업]</td>
								<td>[DB작업]</td>
								<td>[DB작업]</td>
								<td>[DB작업]</td>
								<td>[DB작업]</td>
							</tr>
						</tbody>
					</table>
				</div>
		</div>
	</div>
</div>
</div>
</form>