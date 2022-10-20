<%@page import="web.dto.ReservationPay"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% List<ReservationPay> mcSearchList = (List)request.getAttribute("mcSearchList"); %>
<!-- mypage.css -->
<link rel="stylesheet" href="/resources/css/mypage.css">

<%@ include file = "../layout/header.jsp" %>


<!-- <script type="text/javascript">
$(document).ready(function(){
	
	// 리뷰작성 버튼
	$("#btnReview").click(function(){
		$("form").submit();
		$(location).attr('href', '/') /* '/' 자리에 리뷰 작성 페이지 넘어가게 링크 작성 */
	})

	$('#btnResCancel').click(function() {
        var result = confirm('예매를 취소하시겠습니까?');
        if(result) {
        	
        	if(result == true){
        		
        	 $(location).attr('href', '/resListCancel')
        	}
        }
    });
	
})
</script> -->

<style type="text/css">
#mypageMenu{
	
	max-width:200px;
	background-color: #8EC0E4;
	padding-top: 10%;
	padding-bottom: 30% !important;
}
</style>


<h1 style="text-align: center">마이페이지</h1>
<hr>

<form action="/watch/musical" method="post" name="watchmc" id="watchmc" class="form-horizontal">

<div class="container-fluid" id="mypageDiv">
	<div class="row text-center" id="mypageInfo" style="font-size: 24px; font-weight: bold">
		<div class="col-md-3"><a href="/mypage" style="text-decoration: none; color:black">My Ticket</a></div>
		<div class="col-md-8"><%=session.getAttribute("username") %>님, 반갑습니다.</div>
	</div>
	<div class="row">
		<div class="col-md-3 col-sm-offset-1" id="mypageMenu">
			<ul style="list-style-type: none; padding:0;">
				<li class="list-item"><a href="/mypage/view">예매확인
					<span class="glyphicon glyphicon glyphicon-menu-right" aria-hidden="true"></span></a></li><br>
				<li class="list-item"><a href="/watch/musical">나의 관람 공연
					<span class="glyphicon glyphicon glyphicon-menu-right" aria-hidden="true"></span></a></li><br>
				<li class="list-item"><a href="/user/update">회원 정보 수정
					<span class="glyphicon glyphicon glyphicon-menu-right" aria-hidden="true"></span></a></li><br>
			</ul>
		</div>
		<br>
		<div class="col-md-7 col-sm-offset-1" >
		<h3>나의 관람 공연</h3><br>
		</div>
		<div class="col-md-7 col-sm-offset-1" style="padding-left: 30px; ">
			<input type="text" placeholder="공연명을 입력하세요." style="vertical-align: middle; height: 32px; width: 200px;">
			<button class="btn btn-sm" style="background-color:#6AAFE6; color:#fff; font-size: 14px;">조회</button>
		<br><br>
		<div class="col-md-12" style="padding:20 20 20 20; border:1px solid #CADBE9">
			<hr>
			
				<%for (int i = 0; i < mcSearchList.size(); i++) {%>
					<tr class="text-center">
						<td><%=mcSearchList.get(i).getResno() %></td>
						<td><%=mcSearchList.get(i).getMcname()%></td>
						<td><%=mcSearchList.get(i).getScheduledate()%></td>
						<td><%=mcSearchList.get(i).getTicketcount()%></td>
	<!-- 								<td><button class="btn btn-sm"  id="btnMyCancel">예매 취소</button></td> -->
					</tr>
				<% } %>
				
			<hr>
			
		</div>
	</div>
</div>
</div>


<!-- </table> -->

</form>

<%@ include file = "../layout/footer.jsp" %>