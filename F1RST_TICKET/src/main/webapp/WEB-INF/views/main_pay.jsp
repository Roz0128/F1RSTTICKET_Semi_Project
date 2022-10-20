<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ include file = "./layout/header.jsp" %>


<form action="/pay" method="post" name="payMain" id="payMain" class="form-horizontal">
<h1>예매 / 결제</h1>
<hr>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-7 col-xs-offset-3">
			<h4 style="text-align: left">구매자정보</h4>
			<table class="table">
				<thead>
					<tr >
						<th class="text-center">
							이름
						</th>
						<th class="text-center">
							핸드폰 번호
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>강디비[DB 작업]</td>
						<td>010-2817-0655[DB 작업]</td>
					</tr>
			</table>
		</div>
		
		<br>
		<div class="col-md-7 col-xs-offset-3">
			<h4 style="text-align: left">예매 내역 확인</h4>
			<table class="table">
				<thead>
					<tr >
						<th class="text-center">
							관람일시
						</th>
						<th class="text-center">
							공연명
						</th>
						<th class="text-center">
							예매번호
						</th>
						<th class="text-center">
							매수
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>2022-10-11[DB 작업]</td>
						<td>아 몰라...ㅡㅡ[DB 작업]</td>
						<td>123456789[DB 작업]</td>
						<td>2장[DB 작업]</td>
					</tr>
			</table>
		</div>
		
		<br>
		<div class="col-md-7 col-xs-offset-3">
			<h4 style="text-align: left">결제 정보</h4>
			<table class="table">
				<thead>
					<tr >
						<th class="text-center">티켓 가격</th>
						<th class="text-center">할인 쿠폰</th>
						<th class="text-center">MyPoint</th>
						<th class="text-center">총 결제 금액</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>싸게싸게[DB 작업]</td>
						<td>없음[DB 작업]</td>
						<td>없음[DB 작업]</td>
						<td>총 결제 금액[DB 작업]</td>
					</tr>
			</table>
		</div>
		
		<br>
		<div class="col-md-7 col-xs-offset-3">
			<h4 style="text-align: left">결제 방법</h4>
			<table class="table">
				<thead>
					<tr >
						<td class="text-center">
							<input type="radio" id="trancefer" name="trancefer">계좌이체
						</td>
						<td class="text-center">
							<input type="radio" id="bank" name="bank">무통장입금
						</td>
						<td class="text-center">
							<input type="radio" id="card" name="card">신용/체크카드
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>싸게싸게[DB 작업]</td>
						<td>없음[DB 작업]</td>
						<td>없음[DB 작업]</td>
						<td>총 결제 금액[DB 작업]</td>
					</tr>
					
			</table>
			<div class="col-md-7 col-xs-offset-3">
				<button type="button" class=" btn btn-sm" style="background-color: #D4DFE6;" id="btnPayCancel">취소하기</button>
				<button type="button" class=" btn btn-sm" style="background-color: #D4DFE6;" id="btnPayOk">결제하기</button>
				
			</div>
		</div>
		

		
	</div>
</div>

</form>

<%@ include file = "./layout/footer.jsp" %>