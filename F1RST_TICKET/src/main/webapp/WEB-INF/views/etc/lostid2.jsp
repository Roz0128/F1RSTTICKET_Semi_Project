<%@page import="web.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../layout/header_login.jsp" %>


<!-- 찾는 아이디/ 비번은 팝업창(또는 알림창)으로 나타나게 하기 -->

<script type="text/javascript">
$(document).ready(function(){
	// 이름 포커스
	$("input").eq(0).focus()
	
	// 이메일 입력창에 엔터키 입력시 submit
	$("input").eq(1).keydown(function(e){
		if(e.keycode == 13) {
			$("#btnSearch").click();
		}
	})
			
	$("#btnSearchId").click(function(){
			
		/* 이름과 이메일 불일치시 */
		<% if (session.getAttribute("id") == null) { %>
			alert('이름과 이메일을 정확히 작성해주세요.')
		<% } %>
		
		/* 이름과 이메일 일치시 */
		<%if (session.getAttribute("id") != null && (boolean)session.getAttribute("id")) { %> 
			alert('회원님의 아이디는 <%=session.getAttribute("userid") %> 입니다.') 
		<% } %> 
	})
	
</script>

<hr>

<form action="/lost/id" method="post" class="form-horizontal">

<h1>아이디 찾기</h1>
<p style="font-size:20px; padding-bottom: 50px;">등록된 회원정보로 아이디를 찾을 수 있습니다.</p>

<div class="form-group">
	<label for="searchIdName" class="col-sm-4 control-label">이름</label>
	<div class="col-sm-4">
		<input type="text" name="searchIdName" id="searchIdName" class="form-control" placeholder="이름"> <br>
	</div>
</div>

<div class="form-group">
	<label for="searchIdEmail" class="col-sm-4 control-label">이메일</label>
	<div class="col-sm-4">
		<input type="email" name="searchIdEmail" id="searchIdEmail" class="form-control" placeholder="abc@ticket.com">
	</div>
</div>

<div class="form-group">
	<div class="col-sm-4 col-sm-offset-4">
		<button type="submit" class="form-control btn btn-block" style="background-color: #6AAFE6; color:#fff;" id="btnSearchId">조회하기</button><br>
	</div>
</div>

<div class="form-group" id="loginJoin">
	<div class="text-center">
		<ul style="list-style-type: none; padding:0px;">
			<li style="display:inline;"><a href="/lost/pw">비밀번호 찾기</a></li>
			<li style="display:inline">&nbsp;|&nbsp;</li>
			<li style="display:inline;"><a href="/user/login">로그인</a></li>
			<li style="display:inline">&nbsp;|&nbsp;</li>
			<li style="display:inline;"><a href="/">회원가입</a></li>
		</ul>  
	</div> 
</div>

</form>