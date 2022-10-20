<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../layout/header_login.jsp" %>

<!-- 찾는 아이디/ 비번은 팝업창(또는 알림창)으로 나타나게 하기 -->
<!-- 같은 id 사용 해도 되는지 찾아보기 -->

<script type="text/javascript">
$(document).ready(function(){
	// 아이디 포커스
	$("input").eq(0).focus()
	
	// 이메일 입력창에 엔터키 입력시 submit
	$("input").eq(2).keydown(function(e){
		if(e.keycode == 13) {
			$("#btnSearch").click();
		}
	})
	
	// 조회하기 버튼
	$("#btnSearch").click(function(){
		$(this).parents("form").submit();
	})
	
})

</script>

<hr>

<form action="/lost/pw" method="post" class="form-horizontal">

<h1>비밀번호 찾기</h1>
<p style="font-size:20px; padding-bottom: 50px;">등록된 회원정보로 비밀번호를 찾을 수 있습니다.</p>

<div class="form-group">
	<label for="searchPwId" class="col-sm-4 control-label">아이디</label>
	<div class="col-sm-4">
		<input type="text" name="searchPwId" id="searchPwId" class="form-control" placeholder="아이디"> <br>
	</div>
</div>

<div class="form-group">
	<label for="searchPwName" class="col-sm-4 control-label">이름</label>
	<div class="col-sm-4">
		<input type="text" name="searchPwName" id="searchPwName" class="form-control" placeholder="이름"> <br>
	</div>
</div>

<div class="form-group">
	<label for="searchPwEmail" class="col-sm-4 control-label">이메일</label>
	<div class="col-sm-4">
		<input type="email" name="searchPwEmail" id="searchPwEmail" class="form-control" placeholder="abc@ticket.com">
	</div>
</div>

<div class="form-group">
	<div class="col-sm-4 col-sm-offset-4">
		<button type="button" class="form-control btn btn-block" style="background-color: #6AAFE6; color:#fff;" id="btnSearch">조회하기</button><br>
	</div>
</div>

<div class="form-group" id="loginJoin">
	<div class="text-center">
		<ul style="list-style-type: none; padding:0px;">
			<li style="display:inline;"><a href="/lost/id">아이디 찾기</a></li>
			<li style="display:inline">&nbsp;|&nbsp;</li>
			<li style="display:inline;"><a href="/user/login">로그인</a></li>
			<li style="display:inline">&nbsp;|&nbsp;</li>
			<li style="display:inline;"><a href="/">회원가입</a></li>
		</ul>  
	</div> 
</div>


</form>