<%@page import="web.dto.ReservationPay"%>
<%@page import="web.dto.Reservation"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%--     <%List<Reservation> resvList = (List)request.getAttribute("resvList"); %> --%>
    
    <% List<ReservationPay> rspList = (List)request.getAttribute("rspList"); %>
    

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
	padding-bottom: 10% !important;
}
</style>

<h1 style="text-align: center">마이페이지</h1>
<hr>

<form action="/mypage" method="post" name="mypage" id="mypage" class="form-horizontal">

<div class="container-fluid" id="mypageDiv">
	<div class="row text-center" id="mypageInfo" style="font-size: 24px; font-weight: bold">
		<div class="col-md-3"><a href="/mypage" style="text-decoration: none; color:black">My Ticket</a></div>
		<div class="col-md-8"><%=session.getAttribute("username") %>님, 반갑습니다.</div>
	</div>
	
	<div class="row">
		<div class="col-md-3 col-sm-offset-1" id="mypageMenu">
			<ul style="list-style-type: none; padding:0;">
				<li class="list-item"><a href="/mypage/view">예매확인
				 	<span class="glyphicon glyphicon glyphicon-menu-right" aria-hidden="true"></span> </a></li><br>
<!-- 				<li class="list-item"><a href="/watch/musical">나의 관람 공연 -->
<!-- 					<span class="glyphicon glyphicon glyphicon-menu-right" aria-hidden="true"></span></a></li><br> -->
				<li class="list-item"><a href="/user/update">회원 정보 수정
					<span class="glyphicon glyphicon glyphicon-menu-right" aria-hidden="true"></span></a></li><br>
			</ul>
		</div>
		<br>
		<div class="col-md-7 col-sm-offset-1" style="padding-left: 30px; ">
		
		<!-- 최근 예매 내역 확인. 최신 3개만 보여줄 수 있음 -->
			<h4 style="display: inline;">최근 예매 내역</h4>
			<span style="color: #8EC0E4">&nbsp;최근 내역 5개까지 표시 됩니다.</span><br><br>
			<table class="table">
				<thead>
					<tr>
						<th class="text-center">예매일</th>
						<th class="text-center">예매번호</th>
						<th class="text-center">공연명</th>
						<th class="text-center">매수</th>
						<th class="text-center">관람일시</th>
					</tr>
				</thead>
				
					
				<tbody>
					<tr>
						<td colspan="5" style="text-align: center; font-size: 18px;"><br><p>최근 예매 내역이 없습니다.</p></td>
					</tr>
				</tbody>
			</table>
			<br>
			
			
<!-- 			<!-- 최근 관람 공연 3개만 보여줌. 관람 완료 후 후기 작성 안된 부분은 버튼 보이도록 할 것 -->
<!-- 			<h4>나의 관람 공연</h4> -->
<!-- 			<table class="table"> -->
<!-- 				<thead> -->
<!-- 					<tr> -->
<!-- 						<th class="text-center">공연명(예매번호)</th> -->
<!-- 						<th class="text-center">매수</th> -->
<!-- 						<th class="text-center">관람일시</th> -->
<!-- 						<th>후기작성</th> -->
<!-- 					</tr> -->
<!-- 				</thead> -->
<!-- 				<tbody> -->
<%-- 					<%for (int i = 0; i < rspList.size(); i++) {%> --%>
<!-- 							<tr class="text-center"> -->
<%-- 								<td><%=rspList.get(i).getMcname()%>(<%=rspList.get(i).getResno() %>)</td> --%>
<%-- 								<td><%=rspList.get(i).getTicketcount()%>장</td> --%>
<%-- 								<td><%=rspList.get(i).getScheduledate()%></td> --%>
<!-- 							</tr> -->
<%-- 						<% } %> --%>
<!-- 				</tbody> -->
<!-- 			</table> -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </div> -->


<!-- </table> -->

</form>

<%@ include file = "../layout/footer.jsp" %>