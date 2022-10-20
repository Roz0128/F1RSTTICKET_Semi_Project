<%@page import="java.util.List"%>
<%@ page import="web.dto.Musical"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<Musical> musicalList = (List) request.getAttribute("musicalList"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>F1rst Ticket</title>
       
<script type="text/javascript" src = "https://code.jquery.com/jquery-2.2.4.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script type="text/javascript" src="slick/slick.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
 
<!-- Slick 불러오기 -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.js"></script>
<link rel="stylesheet" type="text/css" href="slick/slick.css"/>
<link rel="stylesheet" type="text/css" href="slick/slick-theme.css"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/slick-carousel/1.9.0/slick-theme.min.css">

<style type="text/css">

/* Header */
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

#botmenuid ul li a{

	text-decoration: none;
	color : #fff;

}

#botmenuid ul li a:hover{

	text-decoration: none;
	color : black;
	background-color: #6AAFE6 !important;
	
}

img {
	transform: scale(0.95);
	-webkit-transform: scale(0.95);
	-moz-transform: scale(0.95);
	-ms-transform: scale(0.95);
	-o-transform: scale(0.95);
	transition: all 0.2s ease-in-out;
}

img:hover {
	transform: scale(1);
	-webkit-transform: scale(1);
	-moz-transform: scale(1);
	-ms-transform: scale(1);
	-o-transform: scale(1);
}

/* 슬라이더 */

.slider-hidden {
    width: 100%;
    max-width: 1920px;
    min-width: 1300px;
    overflow: hidden;
    margin: 0 auto;
    height: 500px;
    position: relative;
    margin-bottom: 50px;
}

.slider-wrap {
    width: 1350px;
    position: absolute;
    height: 430px;
    top: 60px;
    left: 50%;
    margin-left: -600px;
}

.slider {
    width: 1350px;
    height: 430px;
    margin-left: -78px;
}

.slick-next:before, .slick-prev:before {
    font-family: slick;
    font-size: 25px;
    line-height: 1;
    opacity: .75;
    color: #6AAFE6;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
}


.sec1 {
       border: 1px;
       height:450px;
       width: 350px;
    }


/* 뮤지컬 순위표 목록 */

section {
    width: 100%;
    min-width: 1300px;
    overflow: hidden;
	display: block;
	margin: 0;
	border: 0;
    font-size: inherit;
    font-style: normal;
    vertical-align: baseline;
    height:700px;
}

.main-sec2 {
    background: #f6f6f6;
    padding: 85px 0;
}

.more {
	float: right;
	margin-top: 35px;
 	}

/* what's hot */


.hotmain {
	float: left;
    border: 1px solid #ddd;
    background: #fff;
    position: relative;
    margin-left: 110px;
    
	display: grid; 
	grid-template-columns: 200px 200px 200px; 
	grid-template-rows:   80px 280px 70px 70px; 
	gap: 0px 3em; 
	grid-template-areas: 
    ". . ."; 
    justify-content: center; 
 	align-content: start; 
 	width: 800px; 
 	height: 500px; 
}

.hot-tit {
	background: fff;
	font-size: 30px;
	text-align: center;
    color: #333;
    font-family: 'Noto Sans KR','NanumBarunGothic','맑은 고딕','Malgun Gothic',sans-serif;
    font-weight: 700;
    justify-content: center;
    padding-left: -10px;
    margin-top: 40px;
}

.hot-tit-sub {
	font-size: 15px;
	background: fff;
	color: #333;
	text-align: center;
	font-weight: bold;
}

.hot-tit-sub2 {
	font-size: 12px;
    color: #999;
    text-align: center;
}

/* what's new */

.newmain {
	float: right;
    border: 1px solid #ddd;
    background: #fff;
    position: relative;
    margin-right: 100px;
    margin-bottom: 150px;
    
	display: grid; 
	grid-template-columns: 200px 200px 200px; 
	grid-template-rows:   80px 300px 70px 70px; 
	gap: 0px 3em; 
	grid-template-areas: 
    ". . ."; 
    justify-content: center; 
 	align-content: start; 
 	width: 800px; 
 	height: 550px; 

}

.new-tit {
	background: fff;
	font-size: 30px;
	text-align: center;
    color: #333;
    font-family: 'Noto Sans KR','NanumBarunGothic','맑은 고딕','Malgun Gothic',sans-serif;
    font-weight: 700;
    justify-content: center;
    padding-left: -10px;
    margin-top: 40px;
}

.new-tit-sub {
	font-size: 15px;
	background: fff;
	color: #333;
	text-align: center;
	font-weight: bold;
}

.new-tit-sub2 {
	font-size: 12px;
    color: #999;
    text-align: center;
}


.main-sec3 {
	background: #fff;
    padding: 15px 0;
}

/* Ranking */

.rank {
	float: left;
    width: 600px;
    height: 400px;
    border: 1px solid #ddd;
    background: #f6f6f6;
    position: relative;
    margin-left: 200px;
    margin-top: 120px;
}

.more-rank {
	margin-top: -30px;
	margin-left: 290px;
}
.rank-tit {
	font-size: 26px;
    width: 370px;
    color: #333;
    position: absolute;
    left: 54px;
    top: 52px;
    font-weight: bold;
    text-align: left;
    font-family: 'Noto Sans KR','NanumBarunGothic','맑은 고딕','Malgun Gothic',sans-serif;
}

/* Ranking Table */

ul.rank-txt {
    position: absolute;
    left: 54px;
    top: 105px;
    width: 370px;
    border-top: 2px solid #333;
    height: 200px;
    list-style-type: none;
    font-size: 16px;
    padding-top: 6px;
    font-weight: bold;
}

ul.rank-txt > li {
    border-bottom: 1px solid #ddd;
    font-size: 17px;
    padding: 25px 0;
    margin-left: -20px;
    height: 16px;
    position: relative;
    text-align: left;
}

ul.rank-txt > li > a {
	white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    color: #000;
}



/* MD's Pick */

.pickmain {
	float: right;
    border: 1px solid #ddd;
    background: #f6f6f6;
    position: relative;
    margin-right: 100px;
    margin-top: 65px;
    
	display: grid; 
	grid-template-columns: 200px 200px 200px; 
	grid-template-rows:   80px 300px 60px 60px; 
	gap: 0px 3em; 
	grid-template-areas: 
    ". . ."; 
    justify-content: center; 
 	align-content: start; 
 	width: 800px; 
 	height: 500px; 
}

.pick-tit {
	background: fff;
	font-size: 30px;
	text-align: center;
    color: #333;
    font-family: 'Noto Sans KR','NanumBarunGothic','맑은 고딕','Malgun Gothic',sans-serif;
    font-weight: 700;
    justify-content: center;
    padding-left: -10px;
    margin-top: 40px;
}

.pick-tit-sub {
	font-size: 15px;
	background: fff;
	color: #333;
	text-align: center;
	font-weight: bold;
	margin-top: -20px;
}

.pick-tit-sub2 {
	font-size: 12px;
    color: #999;
    text-align: center;
}


</style>

<script>

// 슬라이드
   $(function(){
        $('.center').slick({
          centerMode: true,
          centerPadding: '100px',
          slidesToShow: 3,
          responsive: [
            {
              breakpoint: 768,
              settings: {
                arrows: true,
                centerMode: true,
                centerPadding: '40px',
                slidesToShow: 3
              }
            },
            {
              breakpoint: 480,
              settings: {
                arrows: true,
                centerMode: true,
                centerPadding: '40px',
                slidesToShow: 1
              }
            }
          ]
        });

    })
    
  </script>
  
<body>
<header>

<nav class="topmenu">

<!--  비 로그인   -->
<% if(session.getAttribute("login") == null )  { %>
  <div class="topmenu">
	<ul style="list-style-type: none">
		<li style="display:inline"><a href="/user/login">로그인</a></li> 
		<li style="display:inline"><a href="/join">회원가입</a></li>  
	</ul>
  </div>
<% }  %>

<!--  로그인  -->
<% if(session.getAttribute("login") != null  && (boolean)session.getAttribute("login"))  { %>
  <div class="topmenu">
	<ul style="list-style-type: none">
		<li style="display:inline; color: #fff;"><%=session.getAttribute("username") %>님, 환영합니다.</li>
		<li style="display:inline"><a href="/user/logout" id="mainOut">로그아웃</a></li>
		<li style="display:inline"><a href="/mypage">마이페이지</a></li>
		<li style="display:inline"><a href="/user/update">회원정보수정</a></li>
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
	         <li><a href="/musical/mcList">뮤지컬</a></li>
	        <li><a href="/notice/list">공지사항</a></li>
	        <li><a href="/review/list">관람후기</a></li>
	        
        <!--  비 로그인  --> 
			<% if(session.getAttribute("login") == null )  { %>
	        <li class="noLoginTC"><a href="/user/login">My티켓</a></li>
	      	<% } %>
	      	
	      	<!--  로그인  -->
			<% if(session.getAttribute("login") != null  && (boolean)session.getAttribute("login"))  { %>
	      		<li class="LoginTC"><a href="/mypage">My티켓</a></li>
	      	<% } %>
	      	
	      </ul>
		</div>
	</header>
	</div>
</div>

<script type="text/javascript"> 
  $(document).ready(function(){
	// 로그아웃 버튼 눌렀을 시
	 $('#mainOut').click(function() {
	  alert('로그아웃 되었습니다.')
	 });
  	
	// 비회원이 my티켓 버튼 눌렀을 시
	 $('.noLoginTC').click(function() {
		  alert('로그인 후 사용하실 수 있습니다.')
	 });
	
  });
  
</script>   

</header>

<!-- 슬라이드 -->
<div class="slider-hidden">
<div class="slider-wrap">

	<div class="slider">
	
		<div class="center slick_slider">
			<div class="slide"><a href='/musical/mcView?mcno=204'><img src="${pageContext.request.contextPath}/resources/img/mc/pri.jpg${musical.mcimg}" class="sec1"></a></div>
			<div class="slide"><a href='/musical/mcView?mcno=205'><img src="${pageContext.request.contextPath}/resources/img/mc/seo.jpg${musical.mcimg}" class="sec1"></a></div>
			<div class="slide"><a href='/musical/mcView?mcno=200'><img src="${pageContext.request.contextPath}/resources/img/mc/hap.jpg${musical.mcimg}" class="sec1"></a></div>
			<div class="slide"><a href='/musical/mcView?mcno=201'><img src="${pageContext.request.contextPath}/resources/img/mc/hook.jpg${musical.mcimg}" class="sec1"></a></div>
			<div class="slide"><a href='/musical/mcView?mcno=206'><img src="${pageContext.request.contextPath}/resources/img/mc/ale.jpg${musical.mcimg}" class="sec1"></a></div>
			<div class="slide"><a href='/musical/mcView?mcno=208'><img src="${pageContext.request.contextPath}/resources/img/mc/jes.jpg${musical.mcimg}" class="sec1"></a></div>
			<div class="slide"><a href='/musical/mcView?mcno=207'><img src="${pageContext.request.contextPath}/resources/img/mc/sam.jpg${musical.mcimg}" class="sec1"></a></div>
			<div class="slide"><a href='/musical/mcView?mcno=202'><img src="${pageContext.request.contextPath}/resources/img/mc/per.jpg${musical.mcimg}" class="sec1"></a></div>
		</div>

	</div>
	
</div>
</div>

<section class="main-sec2">

<!-- WHAT'S HOT -->
	<div class="hotmain">
		<div class="hotitem"></div>
		<div class="hot-tit">WHAT'S HOT </div>
		<div class="hotitem"><a href='/musical/mcLike'><div class="more"><img src="${pageContext.request.contextPath}/resources/img/mc/more.png${musical.mcimg}"></div></a></div>
		<div class="hotitem"><a href='/musical/mcView?mcno=207'><img src="${pageContext.request.contextPath}/resources/img/mc/sam.jpg${musical.mcimg}" title="뮤지컬 <삼총사>" style="width:200px; height:260px;"></a></div>
		<div class="hotitem"><a href='/musical/mcView?mcno=204'><img src="${pageContext.request.contextPath}/resources/img/mc/pri.jpg${musical.mcimg}" title="뮤지컬 <프리즌>" style="width:200px; height:260px;"></a></div>
		<div class="hotitem"><a href='/musical/mcView?mcno=200'><img src="${pageContext.request.contextPath}/resources/img/mc/hap.jpg${musical.mcimg}" title="뮤지컬 <우연히 행복해지다>" style="width:200px; height:260px;"></a></div>
		<div class="hot-tit-sub">뮤지컬 <삼총사></div>
		<div class="hot-tit-sub">뮤지컬 <프리즌></div>
		<div class="hot-tit-sub">뮤지컬 <우연히 행복해지다></div>
		<div class="hot-tit-sub2">학생 할인 30%</div>
		<div class="hot-tit-sub2">평일 22,000원</div>
		<div class="hot-tit-sub2">평일 할인 40%</div>
	</div>

<!-- WHAT'S NEW -->
	<div class="hotmain">
		<div class="newitem"></div>
		<div class="new-tit">WHAT'S NEW </div>
		<div class="newitem"><a href='/musical/mcNew'><div class="more"><img src="${pageContext.request.contextPath}/resources/img/mc/more.png${musical.mcimg}"></div></a></div>
		<div class="newitem"><a href='/musical/mcView?mcno=201'><img src="${pageContext.request.contextPath}/resources/img/mc/hook.jpg${musical.mcimg}" title="뮤지컬 <더 훅 The Hook>" style="width:200px; height:260px;"></a></div>
		<div class="newitem"><a href='/musical/mcView?mcno=202'><img src="${pageContext.request.contextPath}/resources/img/mc/per.jpg${musical.mcimg}" title="뮤지컬 <사람은 무엇으로 사는가>" style="width:200px; height:260px;"></a></div>
		<div class="newitem"><a href='/musical/mcView?mcno=203'><img src="${pageContext.request.contextPath}/resources/img/mc/dre.jpg${musical.mcimg}" title="뮤지컬 <드리머스 Dreamers>" style="width:200px; height:260px;"></a></div>
		<div class="new-tit-sub">뮤지컬 <더 훅 The Hook></div>
		<div class="new-tit-sub">뮤지컬 <사람은 무엇으로 사는가></div>
		<div class="new-tit-sub">뮤지컬 <드리머스 Dreamers></div>
		<div class="new-tit-sub2">평일 할인 30%</div>
		<div class="new-tit-sub2">학생 할인 40%</div>
		<div class="new-tit-sub2">평일 20,000원</div> 
	</div>

</section>


<section class="main-sec3">

<!-- WEEKLY RANKING -->
	<div class="rank">
	
		<div class="rank-tit">
			WEEKLY RANKING
		</div>
		
		<ul class="rank-txt">
			<li><a href='/musical/mcView?mcno=208'>1위. 뮤지컬  <지저스 크라이스트 수퍼스타> </li></a>
			<li><a href='/musical/mcView?mcno=206'>2위. 뮤지컬 콘서트 〈엘그리아 Alegria〉</li></a>
			<li><a href='/musical/mcView?mcno=205'>3위. 뮤지컬 〈서편제〉</li></a>
			<li><a href='/musical/mcView?mcno=201'>4위. 뮤지컬 〈더 훅 The Hook〉</li></a>
			<li><a href='/musical/mcView?mcno=207'>5위. 뮤지컬 〈삼총사〉</li></a>
		</ul>
		
	</div>

<!-- MD'S PICK -->
	<div class="pickmain">
		<div class="pickitem"></div>
		<div class="pick-tit">MD'S PICK</div>
		<div class="pickitem"><a href='/musical/mcMd'><div class="more"><img src="${pageContext.request.contextPath}/resources/img/mc/more.png${musical.mcimg}"></div></a></div>
		<div class="pickitem"><a href='/musical/mcView?mcno=206'><img src= "${pageContext.request.contextPath}/resources/img/mc/ale.jpg${musical.mcimg}" title="뮤지컬 <엘그리아 Alegria>" style="width:200px; height:260px;"></a></div>
		<div class="pickitem"><a href='/musical/mcView?mcno=205'><img src="${pageContext.request.contextPath}/resources/img/mc/seo.jpg${musical.mcimg}" title="뮤지컬 <서편제>" style="width:200px; height:260px;"></a></div>
		<div class="pickitem"><a href='/musical/mcView?mcno=204'><img src="${pageContext.request.contextPath}/resources/img/mc/pri.jpg${musical.mcimg}" title="뮤지컬 <프리즌>" style="width:200px; height:260px;"></a></div>
		<div class="pick-tit-sub">뮤지컬 <엘그리아 Alegria></div>
		<div class="pick-tit-sub">뮤지컬 <서편제></div>
		<div class="pick-tit-sub">뮤지컬 <프리즌></div>
		<div class="pick-tit-sub2">평일 20,000원</div> 
		<div class="pick-tit-sub2">평일 할인 30%</div>
		<div class="pick-tit-sub2">학생 할인 40%</div>
	</div>
	
</section>

<!-- Footer start -->
<footer class="py-5 bg-dark mt-auto" id="footer">
	<div class="empty">
		<div class="footer-wrap">
<!-- 			<div class="collapse navbar-collapse" id="bottm-logo" style= "float:right; display:inline-block;"> -->
<!-- 				<a class="navbar-brand navbar-right" href="/"> -->
<%-- 					<img alt="logo" src="<%=request.getContextPath()%>/resources/img/logo.jpg"> --%>
<!-- 				</a> -->
<!-- 			</div> -->
			<div class="collapse navbar-collapse botmenu"  id="botmenuid">
				<ul class="nav navbar-nav">
					<li><a href="/">회사소개</a></li>
					<li><a href="/">개인정보 처리방침</a></li>
					<li><a href="/">이용약관</a></li>
					<li><a href="/">고객센터</a></li>
					<li><a href="/">티켓판매안내</a></li>
					<li><a href="/">광고안내</a></li>
				</ul>
			</div>
		</div>
	</div>	
</footer> <!-- Footer end -->
