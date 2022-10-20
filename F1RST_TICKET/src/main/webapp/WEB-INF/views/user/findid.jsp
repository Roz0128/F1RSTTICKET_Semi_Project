<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- <%@ include file = "../layout/header_login.jsp" %> --%>
<%@ include file = "../layout/header.jsp" %>

<style type="text/css">
#loginJoin ul li a{
	
	text-decoration: none; 
	color: black;
	
}

#loginJoin ul li a:hover{
	
	border-bottom: 2px solid #8EC0E4;
	width: auto;
	
}
</style>

<script type="text/javascript">
$(document).ready(function(){
	// 이름 포커스
	$("input").eq(0).focus()
	
	// 이메일 입력창에 엔터키 입력시 submit
	$("input").eq(1).keydown(function(e) {
		if( e.keyCode == 13 ) { //엔터키
			$("#btnFindId").click();
		}
	}) 
	
	// 로그인버튼
 	$("#btnFindId").click(function() {
 		$("form").submit();
		document.getElementById("findIdName").value ='';
		document.getElementById("findIdEmail").value ='';
	})  

})

</script>


<h1>아이디 찾기</h1>
<p style="font-size:20px; padding-bottom: 50px;">등록된 회원정보로 아이디를 찾을 수 있습니다.</p>

<form action="/user/findid" method="post" class="form-horizontal">
<div class="form-group">
	<label for="findIdName" class="col-sm-4 control-label">이름</label>
	<div class="col-sm-4">
		<input type="text" name="findIdName" id="findIdName" class="form-control" placeholder="이름"> <br>
	</div>
</div>

<div class="form-group">
	<label for="findIdEmail" class="col-sm-4 control-label">이메일</label>
	<div class="col-sm-4">
		<input type="email" name="findIdEmail" id="findIdEmail" class="form-control" placeholder="abc@ticket.com">
	</div>
</div>

<div class="form-group">
	<div class="col-sm-4 col-sm-offset-4">
		<button type="button" class="form-control btn btn-block" style="background-color: #6AAFE6; color:#fff;" id="btnFindId">조회하기</button><br>
	</div>
</div>

<div class="form-group" >
	<div class="text-center" id="loginJoin">
		<ul style="list-style-type: none; padding:0px;">
			<li style="display:inline;"><a href="/user/findpw">비밀번호 찾기</a></li>
			<li style="display:inline">&nbsp;|&nbsp;</li>
			<li style="display:inline;"><a href="/user/login">로그인</a></li>
			<li style="display:inline">&nbsp;|&nbsp;</li>
			<li style="display:inline;"><a href="/join">회원가입</a></li>
		</ul>  
	</div> 
</div>

</form>
