<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<!-- mypage.css -->
<link rel="stylesheet" href="/resources/css/mypage.css">

<%@ include file = "../layout/header.jsp" %>


<script type="text/javascript">
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
</script>

<h1 style="text-align: center">마이페이지</h1>
<hr>

<form action="/advance/ticket" method="post" name="advance" id="advance" class="form-horizontal">

<div class="container-fluid" id="mypageDiv">
	<div class="row text-center" id="mypageInfo" style="font-size: 20px;">
		<div class="col-md-3" >My Ticket</div>
		<div class="col-md-3">미사용 티켓<br><a href='/noUseTicket'>[DB]</a> 장</div>
		<div class="col-md-3">할인쿠폰<br><a href='/mypage'>1</a> 장</div>
<!-- 		<div class="col-md-3">My Point<br><a href='/mypage'>500</a> 점</div> -->
	</div>
	<div class="row">
		<div class="col-md-3" id="mypageMenu">
			<ul style="list-style-type: none; padding:0;">
				<li class="list-item"><a href="/noticket">예매확인 / 취소
				 	<span class="glyphicon glyphicon glyphicon-menu-right" aria-hidden="true"></span> </a></li><br>
				<li class="list-item"><a href="/advance/ticket">할인쿠폰 / 예매권
					<span class="glyphicon glyphicon glyphicon-menu-right" aria-hidden="true"></span></a></li><br>
				<li class="list-item"><a href="/watch/musical">나의 관람 공연
					<span class="glyphicon glyphicon glyphicon-menu-right" aria-hidden="true"></span></a></li><br>
				<li class="list-item"><a href="/user/update">회원 정보 수정
					<span class="glyphicon glyphicon glyphicon-menu-right" aria-hidden="true"></span></a></li><br>
			</ul>
		</div>
		<br>
		<h3>할인예매권/예매권</h3>
		<div class="col-md-9" style="padding-left: 30px; ">
			<ul class="nav nav-tabs">
			  <li role="presentation" style="font-size: 14px;"><a href="/noticket">공연 할인예매권</a></li>
			  <li role="presentation" class="active" style="font-size: 14px;"><a href="#">공연 예매권</a></li>
			</ul>
			<table class="table">
				<thead>
					<tr>
						<th>예매권</th>
						<th>예매권번호</th>
						<th>사용기간</th>
						<th>예매가능 공연기간</th>
					</tr>
				</thead>
				
				<tbody>
					<tr style="text-align: center">
						<td colspan="5">사용 가능한 예매권 목록이 없습니다.</td>
					</tr>
					
			</table>
		</div>
		
		<div class="col-md-9" style="padding:20 20 20 20; border:1px solid #CADBE9">
			<span class="glyphicon glyphicon-ok-sign" aria-hidden="true" style="font-size: 16px; font-weight: bold">&nbsp;공연 예매권 사용 안내</span><br><br>
			<span>- 예매권은 사용 조건에 따라 장르, 특정 공연, 회차 등에 대한 제한이 있을 수 있으니, 반드시 사용조건을 확인해주시기 바랍니다.</span><br>
			<span>- 예매시 예매 시 사용하실 예매권을 클릭하시면 결제 시점에 자동으로 할인가격 만큼 차감되어 결제 총 금액에 표시됩니다.</span><br>
			<span>- 예매 취소 시 해당 공연에 적용된 할인금액을 제외하고 실 결제금액만큼 환불됩니다. <br>
					(단, 예매권을 사용한 경우 부분취소는 불가합니다. 부분취소를 원할 경우 고객센터로 문의해주세요.)</span><br>	
			<span>- 사용기간이 지난 예매권은 사용하실 수 없습니다.</span>
		</div>
	</div>
</div>


<!-- </table> -->

</form>

<%@ include file = "../layout/footer.jsp" %>