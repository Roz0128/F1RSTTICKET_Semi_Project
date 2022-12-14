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

<!-- search.css -->
<link rel="stylesheet" href="/resources/css/search_mu.css">

<style type="text/css">
body {
	color : black;text-align:center; margin:0; padding:0;
}

.wrap{
	position: relative;
  	min-height: 100%;
  	
}

nav {
	position : fixed; width:100%; height:40px; background : #6AAFE6; 
	color : white; text-align : center;top:0;left:0;}
	
.all {
	display:flex; flex-flow : row wrap; min-width:280px; margin-top:50px;
}

header {
	flex:1 1 100%; height:85px; background:white;
}
	
main {
	flex: 1 1 100%;
	min-height: 100%;
	padding: 35px 0 35px 0;
}

footer{
	position : absolute; 
	width:100%;
	flex: 1 1 100%;
	padding: 35px 0 0 0;
}

.header1{
	display: inline-block;
}

.header2{
	display: inline-block;
	padding-top: 10px;
	font-size: 20px;
}

.header3{
	float: right;
	padding-top: 10px;
	font-size: 20px; */
}

.topmenu {
	float:right;
	padding: .4% 3% 0 0;
	z-index: 10;
}

.topmenu>ul>li{

	margin-left: 18px;
	font-size: 14px;
}

.topmenu a {
	text-decoration: none;
	color:#fff;
}

.topmenu a:hover{
	text-decoration: none;
	color: black;
} 

header li a {
	color : black;
	
}

header li a:hover{
	border-bottom: 2px solid black;
	color : black !important;
	background-color: #fff !important;
}

footer a:hover {
	text-decoration: none;
}

.topcon {
	padding-left: 20px;
}


html, body{
	height:100%;
}

.footer-wrap {
	background:#6AAFE6;
	width:100%;
	
	z-index: 2;
}

.empty {
	background:white;
	height:100px;
	width:100%;
	z-index: 1;
	position:relative;
	transform: translatY(-100%);
	
}
</style>

</head>
<body>
<nav class="topmenu">

<!--  ??? ?????????  --> 
<% if(session.getAttribute("login") == null )  { %>
  <div class="topmenu">
	<ul style="list-style-type: none">
		<li style="display:inline"><a href="/user/login">?????????</a></li> 
		<li style="display:inline"><a href="/join">????????????</a></li>  
	</ul>    
</div>
<% }  %>

<!--  ?????????  -->
<% if(session.getAttribute("login") != null  && (boolean)session.getAttribute("login"))  { %>
  <div class="topmenu">
	<ul style="list-style-type: none">
		<li style="display:inline; color: #fff;"><%=session.getAttribute("username") %>???, ???????????????.</li>
		<li style="display:inline"><a href="/user/logout" id="mainOut">????????????</a></li>
		<li style="display:inline"><a href="/mypage">???????????????</a></li>
		<li style="display:inline"><a href="/user/update">??????????????????</a></li>
	</ul>    
</div>
<% }  %>

</nav>

<div class="all">  
	<div class="collapse navbar-collapse header1 topcon" id="midmenu">
		<a href="/"><img src="/resources/img/logo.jpg" style="height:65px;"></a>
	</div>
	<div>
	<header>
		<div class="header2">
	      <ul class="nav navbar-nav nav-pills topcon" data-bs-target="#navbarToggleExternalContent">
	        <li><a href="/musical/mcList">?????????</a></li>
	        <li><a href="/">????????????</a></li>
	        <li><a href="/">????????????</a></li>
	        <li><a href="/">????????????</a></li>
	        <!--  ??? ?????????  --> 
			<% if(session.getAttribute("login") == null )  { %>
	        <li class="noLoginTC"><a href="/user/login">My??????</a></li> <!-- ???????????? ???????????? ??????&?????? ???????????? -->
	      	<% } %>
	      	
	      	<!--  ?????????  -->
			<% if(session.getAttribute("login") != null  && (boolean)session.getAttribute("login"))  { %>
	      		<li class="LoginTC"><a href="/mypage">My??????</a></li>
	      	<% } %>
	      	
	      </ul>
		</div>
	</header>
	</div>
</div>


<script type="text/javascript"> 
  $(document).ready(function(){
	// ???????????? ?????? ????????? ???
	 $('#mainOut').click(function() {
	  alert('???????????? ???????????????.')
	 });
  	
	// ???????????? my?????? ?????? ????????? ???
	 $('.noLoginTC').click(function() {
		  alert('????????? ??? ???????????? ??? ????????????.')
	 });
	
  });
  
</script>   




<!-- ????????? ????????? -->
      <form style="margin-right:50px;" class="navbar-form navbar-right" role="search"
      	 method="get" action="/musical/mcSearch">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="????????? ??????" name="keyword">
        </div>
        <button type="submit" class="btn">
         	<span class="glyphicon glyphicon-search" aria-hidden="true"></span> 
        </button>
      </form>

      

<!-- ----------------------------Header end---------------------------- -->
<main>
<div class="container">