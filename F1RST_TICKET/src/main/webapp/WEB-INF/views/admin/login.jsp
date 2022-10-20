<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file = "../layout/header_admin.jsp" %>
<script type="text/javascript">
$(document).ready(function(){
	// 아이디 포커스
	$("input").eq(0).focus()
	
	// 비밀번호 입력창에 엔터키 입력시 submit
	$("input").eq(1).keydown(function(e){
		if(e.keycode == 13) {
			$("#adBtnLogin").click();
		}
	})

	// 로그인버튼
 	$("#adBtnLogin").click(function() {
		$("form").submit();
		document.getElementById("adminid").value ='';
	}) 
	
	// 관리자 메인페이지로
 	$("#BtnMainGo").click(function() {
		$(location).attr('href', '/admin/main');
	}) 
})


</script>

<hr>

<form action="/admin/login" method="post" class="form-horizontal">

<div class="form-group">
	<label for="adminid" class="col-sm-4 control-label"></label>
	<div class="col-sm-4">
		<input type="text" name="adminid" id="adminid" class="form-control" placeholder="아이디"> <br>
	</div>
</div>

<div class="form-group">
	<label for="adminpw" class="col-sm-4 control-label"></label>
	<div class="col-sm-4">
		<input type="password" name="adminpw" id="adminpw" class="form-control" placeholder="비밀번호">
	</div>
</div>


<div class="clearfix"></div>

<!-- --------------------------------------- -->


<div class="form-group">
	<div class="col-sm-4 col-sm-offset-4">
		<button type="button" class="form-control btn btn-block" style="background-color: #6AAFE6; color:#fff;" id="adBtnLogin">로그인</button><br>
	</div>
	
</div>

<!-- <div class="form-group"> -->
<!-- 	<div class="col-sm-4 col-sm-offset-4"> -->
<!-- 		<button type="button" class="form-control btn btn-block" style="background-color: #CADBE9;" id="BtnMainGo">관리자 메인페이지</button><br> -->
<!-- 	</div> -->
	
<!-- </div> -->

</form>


<!-- 해결될때까지 잠시 주석처리 -->
<%-- <%@ include file = "../layout/footer.jsp" %> --%>