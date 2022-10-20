<%@page import="web.dto.Reservation"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- mypage.css -->
<link rel="stylesheet" href="/resources/css/mypage.css">

<%@ include file="../layout/header.jsp"%>

<%-- <%List<Reservation> rsList = (List)request.getAttribute("rsList"); %> --%>
<%List<Reservation> deleteList = (List)request.getAttribute("deleteList"); %>


<style type="text/css">
#mypageMenu{
	
	max-width:200px;
	background-color: #8EC0E4;
	padding-top: 10%;
	padding-bottom: 40% !important;
}
</style>

<!-- <script type="text/javascript">
$(document).ready(function(){
	$("#btnMyCancel").click(function(){
		if(confirm('정말 취소 하시겠습니까?')){
			alert('취소가 완료 되었습니다.')
			location.replace('resListCancel.jsp');
		} else{}
	})
})
</script> -->

<h1 style="text-align: center">마이페이지</h1>
<hr>

<form action="/mypage/resCancel" method="post" name="resCancel" id="resCancel" class="form-horizontal">

<input type="hidden" name="userid" value="<%=session.getAttribute("userid") %>">

	<div class="container-fluid" id="mypageDiv">
		<div class="row text-center" id="mypageInfo"
			style="font-size: 24px; font-weight: bold">
			<div class="col-md-3">
				<a href="/mypage" style="text-decoration: none; color: black">My
					Ticket</a>
			</div>
			<div class="col-md-8"><%=session.getAttribute("username")%>님,
				반갑습니다.
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-sm-offset-1" id="mypageMenu" >
				<ul style="list-style-type: none; padding: 0;">
					<li class="list-item "><a href="/mypage/view">예매확인 /취소 <!-- 				 	<span class="glyphicon glyphicon glyphicon-menu-right" aria-hidden="true"></span> </a></li><br> -->
							<!-- 				<li class="list-item"><a href="/advance/ticket">할인쿠폰 / 예매권 -->
							<span class="glyphicon glyphicon glyphicon-menu-right" aria-hidden="true"></span>
					</a></li>
					<br>
					<li class="list-item"><a href="/watch/musical">나의 관람 공연
							 <span class="glyphicon glyphicon glyphicon-menu-right" aria-hidden="true"></span></a></li>
					<br>
					<li class="list-item"><a href="/user/update">회원 정보 수정 
							<span class="glyphicon glyphicon glyphicon-menu-right" aria-hidden="true"></span></a></li>
					<br>
				</ul>
			</div>
			<br>
			<div class="col-md-7 col-sm-offset-1" style="padding-left: 30px;">
			<ul class="nav nav-tabs">
			  <li role="presentation" style="font-size: 14px;"><a href="/mypage/reservation">예매 내역</a></li>
			  <li role="presentation" class="active" style="font-size: 16px; font-weight: bold"><a href="/mypage/resCancel">예매 취소 내역</a></li>
			</ul>
			</div>

			<div class="col-md-7 col-sm-offset-1" style="padding-left: 30px;">
				<table class="table">
					<thead>
						<tr>
							<!-- 						<th class="text-center">예매일</th> -->
							<th class="text-center">예매번호</th>
							<th class="text-center">공연명</th>
							<th class="text-center">관람일시</th>
							<th class="text-center">매수</th>
							<th class="text-center">관람 상태</th>
						</tr>
					</thead>
					<tbody>
					
						<%for (int i = 0; i < deleteList.size(); i++) {%>
							<tr class="text-center">
								<td><%=deleteList.get(i).getResno() %></td>
								<td><%=deleteList.get(i).getScheduleInfoId()%></td>
								<td><%=deleteList.get(i).getResdate()%></td>
								<td><%=deleteList.get(i).getTicketcount()%></td>
								<td>취소 완료</td>
							</tr>
						<% } %>
					
				</table>
			</div>
			
			<div class="col-md-7 col-sm-offset-1">
				<%@ include file="../layout/paging_myreservation.jsp"%>
			</div>
			
			<br><br><br>
			<div class="col-md-4"></div>
			<div class="col-md-7 col-sm-offset-1" style="padding: 20px; border: 1px solid #CADBE9;">
			<hr>
				<span class="glyphicon glyphicon-ok-sign" aria-hidden="true" style="font-size: 16px; font-weight: bold">&nbsp;유의사항</span><br>
				<br> 
				<span style="color: red;">
					- 취소 시 예매수수료는 예매 당일 밤 12시
					이전까지 환불되며, 그 이후 기간에는 환불되지 않습니다.
				</span><br> 
				<span>- 티켓 수령 방법
					변경(현장수령 -> 배송)은 예매 완료된 건에 한하며, 배송비 결제는 신용카드만 결제 가능합니다.<br> (단
					공연일 기준 12일 전까지 / 일부 공연 불가)
				</span><br> 
				<span>- 예매 티켓 배송은 예매완료 후 4~5일 이내(영업일 기준) 배송해드립니다.
					티켓 분실 시 재발권이 불가하오니, 보관에 주의해주시기 바랍니다.<br> (일괄배송 공연일 경우 일괄배송일 기준
					4~5일(영업일 기준) 이내에 수령 가능)
				</span><br> 
				<span>- 사용기간이 지난 쿠폰은 사용하실 수 없습니다.</span>
				<hr>
			</div>
		</div>
	</div>

	<!-- </table> -->

</form>

<%@ include file="../layout/footer.jsp"%>