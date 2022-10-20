<%@page import="web.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- header include -->
<%@ include file = "../layout/header.jsp" %>

<%	User updateUser = (User) request.getAttribute("updateUser"); %>

<%
// 	User user = (User)session.getAttribute("loginUser");
	
/* 	String username = (String)session.getAttribute("loginname");
	String userid = (String)session.getAttribute("loginid");
	String userpw = (String)session.getAttribute("loginpw");
	String gender = (String)session.getAttribute("logingender");
	String userbirth = (String)session.getAttribute("loginuserbirth");
	String uphone = (String)session.getAttribute("loginuphone");
	String address = (String)session.getAttribute("loginaddress");
	String email = (String)session.getAttribute("loginemail"); */
	

%>

<style>

label{
	color:black;
}
</style>
<script type="text/javascript">

$(document).ready(function(){
	
	$("#btnUserView").click(function() {
		alert('회원 정보 수정이 완료되었습니다.\n다시 로그인 해주세요.')
		$(this).parents("form").submit();
	})
	
	$("#btnUserViewCancel").click(function(){
 		$(location).attr('href','/mypage')	
	})
	
	$("#btnUserDelete").click(function(){
		
		if(confirm('정말 탈퇴 하시겠습니까?')){
			$(this).parents("form").submit();
				alert('이용해 주셔서 감사합니다.\n다음에는 좋은 모습으로 뵙겠습니다')
	 		$(location).attr('href','/user/delete')	
		} else{
	 		$(location).attr('href','/mypage')	
		}
			
	})
})

</script>


<div class = "container">
<h1>회원정보</h1>
<br>
<form action="/user/update" method="post" class="form-horizontal" id="userUpdate" name="userUpdate" >
	
<%-- 	<input type="hidden" name="userid" value="<%=(String)request.getSession().getAttribute("userid") %>"> --%>
	
	
	<div class="form-group">
		<label for="username" class="col-xs-2 col-xs-offset-1 control-label">이름</label>
		<div class="col-xs-6">
			<input type="text" id="username" class="form-control" value="<%=(String)request.getSession().getAttribute("username") %>" readonly>
		</div>
	</div>

	<div class="form-group">
		<label for="userid" class="col-xs-2 col-xs-offset-1 control-label" >아이디</label>
		<div class="col-xs-6">
			<input type="text" id="userid" class="form-control" value="<%=(String)request.getSession().getAttribute("userid") %>" maxlength="16" readonly>
			<div id="result"></div>
		</div>
	</div>

 	<div class="form-group"> 
		<label for="userpw" class="col-xs-2 col-xs-offset-1 control-label">패스워드</label>
		<div class="col-xs-6">
<%-- 			<input type="password" id="userpw" name="userpw" class="form-control" placeholder="패스워드를 입력하세요" <%=(String)request.getSession().getAttribute("userpw") %> required> --%>
			<input type="password" id="userpw" name="userpw" class="form-control" placeholder="패스워드를 입력하세요" value="<%=(String)request.getSession().getAttribute("userpw") %>" required>
		</div>
	</div>
	
	<!-- <div class="form-group">
		<label for="userpw2" class="col-xs-2 col-xs-offset-1 control-label">패스워드확인</label>
		<div class="col-xs-6">
			<input type="password" id="userpw2" name="userpw2" class="form-control" placeholder="패스워드 재확인" required>
		</div>
	</div>  -->
	
	<div class="form-group">
		<label for="userbirth" class="col-xs-2 col-xs-offset-1 control-label">생년월일</label>
		<div class="col-xs-6">
			<input type="text" id="userbirth" class="form-control"  value="<%=(String)request.getSession().getAttribute("userbirth") %>" readonly>
		</div>
	</div>
	
	<div class="form-group">
    	<label for="uphone" class="col-xs-2 col-xs-offset-1 control-label">휴대 전화</label>
    	<div class="col-xs-6">
    		<input type="tel" class="form-control" id="uphone" name="uphone" value="<%=(String)request.getSession().getAttribute("uphone") %>" maxlength="11" required>
<%--     		<input type="tel" class="form-control" id="uphone" name="uphone" value="<%=updateUser.getUphone() %>" maxlength="11" required> --%>
    	</div>
    </div>
	
	<div class="form-group">
		<label for="address" class="col-xs-2 col-xs-offset-1 control-label">주소</label>
		<div class="col-xs-6">
			<input type="text" id="address" name="address" class="form-control" value="<%=(String)request.getSession().getAttribute("address") %>">
<%-- 			<input type="text" id="address" name="address" class="form-control" value="<%=updateUser.getAddress() %>"> --%>
		</div>
	</div>
	
	<div class="form-group">
		<label for="email" class="col-xs-2 col-xs-offset-1 control-label">이메일</label>
		<div class="col-xs-6">
			<input type="email" id="email" name="email" class="form-control" value="<%=(String)request.getSession().getAttribute("email") %>">
<%-- 			<input type="email" id="email" name="email" class="form-control" value="<%=updateUser.getEmail() %>"> --%>
		</div>
	</div>

	<div class="text-center" id=jcbutton>
	
<!-- 		<input type="submit" value="회원 정보 수정" class="btn" style="background-color: #6AAFE6; color:#fff;" id="btnUserView"> -->
		<button type="submit" class="btn" style="background-color: #6AAFE6; color: #fff;" id="btnUserView">수정하기</button>&nbsp;&nbsp;
		<button type="button" class="btn" style="background-color: #D4DFE6;" id="btnUserViewCancel">취소</button>&nbsp;&nbsp;
		<button type="button" class="btn" style="background-color: #ff7473 ; color: #fff;" id="btnUserDelete">회원탈퇴</button>
	</div>
</form>
</div>

<!-- footer include -->
<%@ include file = "../layout/footer.jsp" %> 