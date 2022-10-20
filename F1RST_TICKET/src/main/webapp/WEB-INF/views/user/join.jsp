<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- header include -->
<%@ include file = "../layout/header.jsp" %>

<style>
#joinform{
    padding: 20px 0 20px 0;
    position: relative;
}

#jcbutton {
	position: relative;
	right: 45px;	
}

label{
	color:black;
}
</style>
<script type="text/javascript">
function joinCheck() {
	if (document.joinform.userid.value.length < 4) {
		alert("아이디는 4자 이상, 16자 이하로 입력해주세요.");
		document.joinform.userid.focus();
		return false;
	}
	if (document.joinform.userpw.value != document.joinform.userpw2.value) {
		alert("패스워드가 일치하지 않습니다.");
		document.joinform.userpw2.focus();
		return false;
	}
	
	if (document.joinform.userid.value.length < 4) {
		alert("아이디는 4자 이상, 16자 이하로 입력해주세요.");
		document.joinform.userid.focus();
		return false;
	}
	if (document.joinform.idCheckBtn == false) {
		return false;	
	}
	return true;
// 	window.alert("회원가입이 완료되었습니다.")
}

/* $(document).ready(function(){
	$(#"joinCheck").click(function(){
	})
}) */

/* if()
$("#btnJoin").prop("disabled",true); */


function check(){
	var userid = $("#userid").val();
	
	$.ajax({
		type: 'POST',
		url: '${pageContext.request.contextPath}/idCheck?userid='+userid,
		data: {userid:userid},
		success: function(result){
			console.log("로그: ["+result+"]")
			if(result == 1){
				$("#result").text("사용이 가능한 아이디 입니다.");
				$("#result").css("color","blue");
				$("#btnJoin").prop("disabled",false);
			}
			else{
				$("#result").text("사용중인 아이디 입니다.");
				$("#result").css("color","red");
				$("#btnJoin").prop("disabled",true);
			}
	},
	error: function(a,b,c){ // 요청 보낸 곳(서블릿)에서 에러가 발생할 시 실행
			console.log("상태코드: "+a);
			console.log("메세지: "+b);
			console.log("에러설명: "+c);

		}
		
	})
}

</script>


<div class = "container">
<h1>회원가입</h1>
<form action="/join" method="post" class="form-horizontal" id="joinform" name="joinform" onsubmit="return check2()" >
	
	<div class="form-group">
		<label for="username" class="col-xs-2 col-xs-offset-1 control-label">이름</label>
		<div class="col-xs-6">
			<input type="text" id="username" name="username" class="form-control" placeholder="이름을 입력하세요" required>
		</div>
	</div>

	<div class="form-group">
		<label for="userid" class="col-xs-2 col-xs-offset-1 control-label" required>아이디</label>
		<div class="col-xs-6">
			<input type="text" id="userid" name="userid" class="form-control" placeholder="아이디를 입력하세요" maxlength="16" required>
			<div id="result"></div>
		</div>

		<div>
			<button type="button" class="btn btn-sm" value="중복확인" name="idCheckBtn" id="idCheckBtn" style="background-color: #6AAFE6; color:#fff; margin-right: 220px;" onclick="check()">중복체크</button>
		</div>
		<input type="hidden" name="idc" value="">
	</div>

	<div class="form-group">
		<label for="userpw" class="col-xs-2 col-xs-offset-1 control-label">패스워드</label>
		<div class="col-xs-6">
			<input type="password" id="userpw" name="userpw" class="form-control" placeholder="패스워드를 입력하세요" required>
		</div>
	</div>
	
	<div class="form-group">
		<label for="userpw2" class="col-xs-2 col-xs-offset-1 control-label">패스워드확인</label>
		<div class="col-xs-6">
			<input type="password" id="userpw2" name="userpw2" class="form-control" placeholder="패스워드 재확인" required>
		</div>
	</div>
	
	<div class="form-group">
		<label for="userbirth" class="col-xs-2 col-xs-offset-1 control-label">생년월일</label>
		<div class="col-xs-6">
			<input type="text" id="userbirth" class="form-control" name="userbirth" placeholder="@1995-12-25" required>
		</div>
	</div>
	
	<div class="form-group">
    	<label for="uphone" class="col-xs-2 col-xs-offset-1 control-label">휴대 전화</label>
    	<div class="col-xs-6">
    		<input type="tel" class="form-control" id="uphone" name="uphone" placeholder="-를 제외하고 숫자만 입력하세요." maxlength="11" required>
    	</div>
    </div>
	
	<div class="form-group">
	<label for="gender" class="col-xs-2 col-xs-offset-1 control-label">성별</label>
		<div class="col-xs-6">
         	<select class="form-control" id="gender" name="gender">
		    	<option value="M">남자</option>
		   	 	<option value="F">여자</option>
            </select>
         </div>
	</div>

	<div class="form-group">
		<label for="address" class="col-xs-2 col-xs-offset-1 control-label">주소</label>
		<div class="col-xs-6">
			<input type="text" id="address" name="address" class="form-control" placeholder="주소">
		</div>
	</div>
	
	<div class="form-group">
		<label for="email" class="col-xs-2 col-xs-offset-1 control-label">이메일</label>
		<div class="col-xs-6">
			<input type="email" id="email" name="email" class="form-control" placeholder="이메일을 입력하세요">
		</div>
	</div>

	<div class="text-center" id=jcbutton>
		<input type="submit" value="회원가입" class="btn" style="background-color: #6AAFE6; color:#fff;" id="btnJoin" onclick="return joinCheck()">
		<button type="reset" class="btn" style="background-color: #D4DFE6;" id="btnCancel">취소</button>
	</div>
</form>
</div>

<!-- footer include -->
<%@ include file = "../layout/footer.jsp" %> 