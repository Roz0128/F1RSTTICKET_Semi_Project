<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>F1RST TICKET</title>

<script type="text/javascript" src = "https://code.jquery.com/jquery-2.2.4.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<style type="text/css">
 #header nav ul li {
 	font-size: 20px;
 }
 
 #dropdownMenu1 {
 	color:#6AAFE6;
 	background-color: transparent;
 	border:0;
 	outline: 0;
  	display: inline-block; 
  	font-size: 30px;
  	font-weight: bold;
  	padding: 9px 9px 20px 17px;
  
 }
 
 #menuMu {
 	font-size: 30px;
 	padding-right: 30px;
 	padding-top: 30px;
  	font-weight: bold;
  	display: inline-block;
 }
 
 .dropdown-menu{
 	border-color: #6AAFE6;
 	box-shadow: none;
 }

.img-responsive{
max-width: 100%;
 height: auto; 
  display: block;
}
  
</style>

<!-- layout.css -->
<link rel="stylesheet" href="/resources/css/layout.css">

</head>
<body>

<header id="header">

  <!-- navbar 위에 메뉴 만들기 -->
  <div class="topmenu">
	<ul style="list-style-type: none">
		<li style="display:inline"><a href="/user/login">로그인</a></li>
		<li style="display:inline"><a href="/">회원가입</a></li>
		<li style="display:inline"><a href="/">마이페이지</a></li>
		<li style="display:inline"><a href="/">고객센터</a></li>
	</ul>    
  </div>
    
<!-- <nav class="navbar navbar-default"> -->
<nav class="navbar navbar-expend-md">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">      
      	<img alt="logo" src ="/resources/img/logo.jpg" style="width: 100%; height: 100%; ">
      </a>
    </div>
    

	<!-- 각페이지 링크 지정. -->
    <div class="collapse navbar-collapse" id="midmenu">
      <ul class="nav navbar-nav">
        <li><a href="/musical/mc">뮤지컬</a></li>
        <li><a href="/">공지사항</a></li>
        <li><a href="/">이벤트</a></li>
        <li><a href="/">이용안내</a></li>
        <li><a href="/">My티켓</a></li>
      </ul>
      
      <!-- 검색창 -->
      <form class="navbar-form navbar-right" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="">
        </div>
        
        <!-- 검색 버튼 -->
        <button type="submit" class="btn">
         	<span class="glyphicon glyphicon-search" aria-hidden="true"></span> 
        </button>
      </form>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

</header>

<hr>
<div class="center-block">
<center>
		<span id="menuMu">뮤지컬</span>
		<span style="display:inline-block;" class="glyphicon glyphicon-menu-right" aria-hidden="true"></span>
	
	<!-- 뮤지컬 페이지 드롭다운 메뉴 -->
	<div class="dropdown" style="display:inline-block;">
  		<button class="btn btn-default.focus dropdown-toggle btn-lg" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
    	전체보기
   		 <span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
<!--     <span class="glyphicon glyphicon-chevron-up" aria-hidden="true"></span> -->
	  	</button>
	  <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
	    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">전체보기</a></li>
	    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">신규보기</a></li>
	    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">인기보기</a></li>
	    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">MD's PICK</a></li>
	  </ul>
	</div>
</center>
</div>
<hr>
<img src="/resources/img/mc/sam.jpg" alt="sam" class="img-thumbnail img-responsive">


<!-- footer에 사용할 부트스트랩 -->
<nav class="navbar navbar-default navbar-fixed-bottom">
<div class = "container">
<footer id="footer">

	<!-- <h1>TEST</h1> -->
	<div class="collapse navbar-collapse" id="botmenu">
		<ul class="nav navbar-nav"> <!-- 링크 걸어야함. -->
			<li><a href="/">회사소개</a></li>
			<li><a href="/">개인정보 처리방침</a></li>
			<li><a href="/">이용약관</a></li>
			<li><a href="/">고객센터</a></li>
			<li><a href="/">티켓판매안내</a></li>
			<li><a href="/">광고안내</a></li>
		</ul>
	</div>
	
	<br><br>
	<p class="navbar-text navbar-left">퍼스트티켓</p>
	<p class="navbar-text navbar-left">주소오오오</p>
	<p class="navbar-text navbar-left">대표자</p>
	<p class="navbar-text navbar-left">사업자정보</p>
	<p class="navbar-text navbar-left">통신판매업신고</p>
	
	


	<!-- logo -->
	<a class="navbar-brand navbar-right" href="/">
        <img alt="logo" src="<%=request.getContextPath()%>/resources/img/logo.jpg">
    </a>
	
</footer>
    </div><!-- .container end -->
</nav>

</body>
</html>