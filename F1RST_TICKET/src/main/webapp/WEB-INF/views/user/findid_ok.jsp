<%@page import="web.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file = "../layout/header_login.jsp" %>

<script type="text/javascript">
$(document).ready(function(){
	
	// 로그인버튼
 	$("#btnLogin").click(function() {
		$(location).attr('href', './login')
	})  

})

</script>


<% if(session.getAttribute("findId") != null  && (boolean)session.getAttribute("findId"))  { %>
<%-- <% if(session.getAttribute("login") == null )  { %> --%>
<!-- <h1>아이디 확인용 페이지</h1> -->

<p style="text-align:center; font-size: 16px;">
	고객님의 아이디는 [<%=session.getAttribute("userid") %>] 입니다.
</p>

<div class="form-group">
	<div class="col-sm-4 col-sm-offset-4">
		<button type="button" class="btn btn-block" style="background-color: #6AAFE6; color:#fff;" id="btnLogin">로그인</button><br>
	</div>
</div>

<br><br><br>
<div class="form-group" id="loginJoin">
	<div class="text-center">
		<ul style="list-style-type: none; padding:0px;">
			<li style="display:inline;"><a href="/user/findpw">비밀번호 찾기</a></li>
			<li style="display:inline">&nbsp;|&nbsp;</li>
			<li style="display:inline;"><a href="/join">회원가입</a></li>
			<li style="display:inline">&nbsp;|&nbsp;</li>
			<li style="display:inline;"><a href="/">메인으로</a></li>
		</ul>  
	</div> 
</div>

<% }  %>

