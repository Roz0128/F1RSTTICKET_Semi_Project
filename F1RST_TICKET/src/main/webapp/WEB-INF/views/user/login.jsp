<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../layout/header.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	// 아이디 포커스
	$("input").eq(0).focus()
	
	// 비밀번호 입력창에 엔터키 입력시 submit
	$("input").eq(1).keydown(function(e){
		if(e.keycode == 13) {
			$("#btnLogin").click();
		}
	})
	
	// 로그인버튼
	$("#btnLogin").click(function(){
		$(this).parents("form").submit();
	})

	$("#kakao-login-btn").click(function(){
		$("form").submit();
	})
})

</script>

<style type="text/css">
#pdBot{
	padding-top:100px;
	
}

#loginJoin ul li a{
	
	text-decoration: none; 
	color: black;
	
}

#loginJoin ul li a:hover{
	
	border-bottom: 2px solid #8EC0E4;
	width: auto;
	
}

main{
	padding: 0; !important;
}


</style>

<h1>LOGIN</h1>
<form action="/user/login" method="post" name="login" class="form-horizontal">

<div class="form-group">
	<label for="userid" class="col-sm-4 control-label"></label>
	<div class="col-sm-4">
		<input type="text" name="userid" id="userid" class="form-control" placeholder="아이디"> <br>
	</div>
</div>


<div class="form-group">
	<label for="userpw" class="col-sm-4 control-label"></label>
	<div class="col-sm-4">
		<input type="password" name="userpw" id="userpw" class="form-control" placeholder="비밀번호">
	</div>
</div>

<div class="form-group" >
	<div class="text-center" id="loginJoin">
		<ul style="list-style-type: none; padding:0px;">
			<li style="display:inline;"><a href="/user/findid">아이디 찾기</a></li>
			<li style="display:inline;">&nbsp;|&nbsp;</li>
			<li style="display:inline;"><a href="/user/findpw">비밀번호 찾기</a></li>
			<li style="display:inline">&nbsp;|&nbsp;</li>
			<li style="display:inline;"><a href="/join">회원가입</a></li>
		</ul>  
	</div> 
</div>


<div class="clearfix"></div>

<!-- --------------------------------------- -->


<div class="form-group">
	<div class="col-sm-4 col-sm-offset-4">
		<button type="button" class="btn btn-block " style="background-color: #6AAFE6; color:#fff;" id="btnLogin">로그인</button><br>
</div>
	

<!-- <div class="col-sm-4 col-sm-offset-4">
	<button type="button" class="form-control btn btn-block" style="background-color: #D4DFE6;" id="btnKakaoLogin" onclick="btnKakaoLogin">카카오 로그인 자리</button><br>
</div> -->

<!-- 카카오 로그인 구현.. 로그인창은 뜨는데 로그인이 안됨. -->
 <!-- <script src="https://t1.kakaocdn.net/kakao_js_sdk/2.0.0/kakao.min.js"
 integrity="sha384-PFHeU/4gvSH8kpvhrigAPfZGBDPs372JceJq3jAXce11bVA6rMvGWzvP4fMQuBGL" crossorigin="anonymous"></script>
<script>
 Kakao.init('f76d3a70c175116c158bd05a6aaa51bf'); // 사용하려는 앱의 JavaScript 키 입력
</script>

<a id="kakao-login-btn" href="javascript:loginWithKakao()">
 <img src="https://k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg" width="222"
   alt="카카오 로그인 버튼" />
</a>
<p id="token-result"></p>

<script>
 function loginWithKakao() {
   Kakao.Auth.authorize({
     redirectUri: 'http://localhost:8088/',
   });
 }

 // 아래는 데모를 위한 UI 코드입니다.
 displayToken()
 function displayToken() {
   var token = getCookie('authorize-access-token');

   if(token) {
     Kakao.Auth.setAccessToken(token);
     Kakao.Auth.getStatusInfo()
       .then(function(res) {
         if (res.status === 'connected') {
           document.getElementById('token-result').innerText
             = 'login success, token: ' + Kakao.Auth.getAccessToken();
         }
       })
       .catch(function(err) {
         Kakao.Auth.setAccessToken(null);
       });
   }
 }

 function getCookie(name) {
   var parts = document.cookie.split(name + '=');
   if (parts.length === 2) { return parts[1].split(';')[0]; }
 }
</script> -->

<!-- <div class="col-sm-4 col-sm-offset-4"> -->
<!-- 	<button type="button" class="form-control btn btn-block" style="border:1px solid black;" id="btnNaverTicket">네이버 로그인 자리</button> -->
<!-- </div> -->

</div>

</form>

<div id="pdBot"></div>


<!-- 해결될때까지 잠시 주석처리 -->
<%@ include file = "../layout/footer.jsp" %>