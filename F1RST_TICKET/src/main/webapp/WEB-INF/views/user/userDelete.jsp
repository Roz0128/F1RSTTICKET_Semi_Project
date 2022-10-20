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
 	$("#btnUserDelete").click(function() {
 		$("form").submit();
	})  

})

</script>


<h1>회원 탈퇴</h1>

<form action="/user/delete" method="post" class="form-horizontal">
<div class="form-group">
	<label for="deleteChk" class="col-sm-4 control-label">비밀번호 확인</label>
	<div class="col-sm-4">
		<input type="text" name="findIdName" id="findIdName" class="form-control" placeholder="이름"> <br>
	</div>
</div>


<div class="form-group">
	<div class="col-sm-4 col-sm-offset-4">
		<button type="button" class="form-control btn" style="background-color: #6AAFE6; color:#fff;" id="btnUserDelete">탈퇴하기</button><br>
		<button type="button" class="form-control btn" style="background-color: #6AAFE6; color:#fff;" id="btnGoMain">메인으로</button><br>
	</div>
</div>


</form>
