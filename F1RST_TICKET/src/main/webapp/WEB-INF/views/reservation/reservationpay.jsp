<%@page import="web.dto.ReservationPay"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.List" %>
<% List<ReservationPay> mlist = (List)request.getAttribute("mlist"); %> 
<%@ include file = "../layout/header.jsp" %>

    <script type="text/javascript" src = "https://code.jquery.com/jquery-2.2.4.min.js"></script>
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
	<link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="./resources/css/jquery.seat-charts.css">


<script type="text/javascript">
var today = new Date();
function buildCalendar(){
  var row = null
  var cnt = 0;
  var calendarTable = document.getElementById("calendar");
  var calendarTableTitle = document.getElementById("calendarTitle");
  calendarTableTitle.innerHTML = today.getFullYear()+"년"+(today.getMonth()+1)+"월";
  
  var firstDate = new Date(today.getFullYear(), today.getMonth(), 1);
  var lastDate = new Date(today.getFullYear(), today.getMonth()+1, 0);
  while(calendarTable.rows.length > 2){
  	calendarTable.deleteRow(calendarTable.rows.length -1);
  }

  row = calendarTable.insertRow();
  for(i = 0; i < firstDate.getDay(); i++){
  	cell = row.insertCell();
  	cnt += 1;
  }

  for(i = 1; i <= lastDate.getDate(); i++){
  	cell = row.insertCell();
  	cnt += 1;

    cell.setAttribute('id', i);
  	cell.innerHTML = i;
  	cell.align = "center";

    cell.onclick = function(){
    	console.log("onclick");
    	
    	clickedYear = today.getFullYear();
    	clickedMonth = ( 1 + today.getMonth() );
    	clickedDate = this.getAttribute('id');

    	clickedDate = clickedDate >= 10 ? clickedDate : '0' + clickedDate;
    	clickedMonth = clickedMonth >= 10 ? clickedMonth : '0' + clickedMonth;
    	clickedYMD = clickedYear + "-" + clickedMonth + "-" + clickedDate;
		
    	console.log(clickedYMD);
    	document.getElementById("scheduleDate").value=clickedYMD;
//     	document.getElementById("seatno").value=
    	
		
	
    	if(opener!=null){
    		const date = opener.document.getElementById("date");
    			console.log(date);
    		if(date!=null){
    			date.value = clickedYMD;
    		}
    	}
    
 
    }
    if (cnt % 7 == 1) {
    	cell.innerHTML = "<font color=#F79DC2>" + i + "</font>";
    }

    if (cnt % 7 == 0){
    	cell.innerHTML = "<font color=skyblue>" + i + "</font>";
    	row = calendar.insertRow();
    }
  }

  if(cnt % 7 != 0){
  	for(i = 0; i < 7 - (cnt % 7); i++){
  		cell = row.insertCell();
  	}
  }
}

function prevCalendar(){
	today = new Date(today.getFullYear(), today.getMonth()-1, today.getDate());
	buildCalendar();
}

function nextCalendar(){
	today = new Date(today.getFullYear(), today.getMonth()+1, today.getDate());
	buildCalendar();
}

function onChangeListener(selectedItem){
	console.log(selectedItem.value);

	document.getElementById("mcname").value=selectedItem.value;
}


function onChangeScheduleTime(selectedItem){
	console.log(selectedItem.value);

	document.getElementById("scheduletime").value=selectedItem.value;
}
</script>

<style>
.sec1img {
	top: 30px;
	height: 270px;
	width:220px;
	position: absolute;
	left: 80px;
}

#calendar{
	height: 300px;
	width: 350px;
}

.sec5{
	height: 600px;
}

select{
	height: 40px;
	width: 350px;
	text-align:center;
	font-size: 11pt;
}

.selectform p {
	font-size: 16px;
	font-weight: bold;
}

input{
	text-align:center;
	font-size: 16px;
}

td:hover{
	background: pink;
}

.buttonform{
	height: 450px;
}

.pay{
	display:flex;
	padding: 20px 0 20px 0;
	font-size: 16px;
	margin: 0;
}

label{
	padding-right: 10px;
}

.formitem{
	font-size: 16px;
	font-weight: bold;
}

.formitem>input{
	font-size: 15px;
}

.con1{
    padding-right: 180px;
    padding-left: 200px;
    margin-right: auto;
    margin-left: auto;
}

.resetbutton {
	background: #D4DFE6;
	color: black;
}

</style>
<h1 style="color:#6AAFE6">뮤 지 컬 선 택 / 공 연 일 정</h1>
<hr>
<div class="container-fluid con1">
	<div class="row">
		<div class="col-md-4">
			<img class="sec1img i1" alt="Bootstrap Image Preview" src="/resources/img/poster/ale.jpg" />
 			<img class="sec1img i2" alt="Bootstrap Image Preview" src="/resources/img/poster/bru.jsp" />
			<img class="sec1img i3" alt="Bootstrap Image Preview" src="/resources/img/poster/dre.jpg" />
			<img class="sec1img i4" alt="Bootstrap Image Preview" src="/resources/img/poster/hook.jpg" />
			<img class="sec1img i5" alt="Bootstrap Image Preview" src="/resources/img/poster/jes.jpg" />
			<img class="sec1img i6" alt="Bootstrap Image Preview" src="/resources/img/poster/pri.jpg" />
			<img class="sec1img i7" alt="Bootstrap Image Preview" src="/resources/img/poster/sam.jpg" />
			<img class="sec1img i7" alt="Bootstrap Image Preview" src="/resources/img/poster/seo.jpg" />
		</div>
		<div class="col-md-4 selectform">
			<hr>
			<div><p>뮤 지 컬 제 목</p></div>
			<select onchange="onChangeListener(this)" id="sel1" required>
				<option value="none">(예매하실 뮤지컬 선택)</option>
				<%for( int i=0; i < mlist.size(); i++) {%>
				<option><%= mlist.get(i).getMcname()%></option>
				<%} %>
			</select>
			<hr>
			<div><p>공연 시작시간</p></div>
			<select onchange="onChangeScheduleTime(this)" id="sel2" required>
				<option value="none">(공연시간 선택)</option>
				<option value="10:00">10:00</option>
				<option value="12:00">12:00</option>
				<option value="14:00">14:00</option>
				<option value="16:00">16:00</option>
				<option value="18:00">18:00</option>
			</select>
			<hr>
				
		<!-- 	<div><p>예  매  수  량</p></div>
			<select onchange="onChangeTicketcount(this)" id="sel3">
				<option value="none">()</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option> -->
			</select>
		</div>

		<div class="col-md-4">
		<table id="calendar" align="center">
	         <tr>
	            <td align="center"><label onclick="prevCalendar()"> ◀ </label></td>
	            <td colspan="5" align="center" id="calendarTitle">yyyy년 m월</td>
	            <td align="center"><label onclick="nextCalendar()"> ▶ </label></td>
	         </tr>
	         <tr>
	            <td align="center" style="font color ="#F79DC2">일</td>
	            <td align="center">월</td>
	            <td align="center">화</td>
	            <td align="center">수</td>
	            <td align="center">목</td>
	            <td align="center">금</td>
	            <td align="center"><font color ="skyblue">토</td>
	         </tr>
         <script type="text/javascript">buildCalendar();</script>
         </table>
		</div>
	</div>
	<hr>
	
	<div class="row">
		<div class="col-6 sm-6">
			<link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
			<link rel="stylesheet" type="text/css" href="./resources/css/jquery.seat-charts.css">
<style>
body {
	font-family: 'Roboto', sans-serif;
  background-color:#fafafa;
}
a {
	color: #b71a4c;
}
.front-indicator {
	width: 145px;
	margin: 5px 32px 15px 7px;
	background-color: #f6f6f6;	
	color: #adadad;
	text-align: center;
	padding: 3px;
	border-radius: 5px;
}
.wrapper {
	width: 100%;
	text-align: center;
  margin-top:150px;
}
.container {
	margin: 0 auto;
	width: 500px;
	text-align: left;
}
.booking-details {
	float: left;
	text-align: left;
	margin-left: 35px;
	font-size: 12px;
	position: relative;
	height: 380px;
}
.booking-details h2 {
	margin: 25px 0 20px 0;
	font-size: 17px;
}
.booking-details h3 {
	margin: 5px 5px 0 0;
	font-size: 14px;
}
div.seatCharts-cell {
	color: #182C4E;
	height: 25px;
	width: 25px;
	line-height: 25px;
	
}
div.seatCharts-seat {
	color: #FFFFFF;
	cursor: pointer;	
}
div.seatCharts-row {
	height: 35px;
}
div.seatCharts-seat.available {
	background-color: #6AAFE6;

}
div.seatCharts-seat.available.first-class {
/* 	background: url(vip.png); */
	background-color: red;
}
div.seatCharts-seat.focused {
	background-color: #76B474;
}
div.seatCharts-seat.selected {
	background-color: #E6CAC4;
}
div.seatCharts-seat.unavailable {
	background-color: #472B34;
}
div.seatCharts-container {
	border-right: 1px dotted #adadad;
	width: 200px;
	padding: 20px;
	float: left;
}
div.seatCharts-legend {
	padding-left: 0px;
	position: absolute;
	bottom: 16px;
}
ul.seatCharts-legendList {
	padding-left: 0px;
}
span.seatCharts-legendDescription {
	margin-left: 5px;
	line-height: 30px;
}
.checkout-button {
	display: block;
	margin: 10px 0;
	font-size: 14px;
}
#selected-seats {
	max-height: 137px;
	overflow-y: scroll;
	overflow-x: none;
	width: 160px;
}
</style>
</head>

<body>

<div class="jquery-script-center">
<div class="jquery-script-ads"><script type="text/javascript">
</script>
<script type="text/javascript"
src="http://pagead2.googlesyndication.com/pagead/show_ads.js">
</script></div>
<div class="jquery-script-clear"></div>
</div>

  	<h1 style="color:#6AAFE6;">좌 석 선 택 / 결  제</h1>

    <div id="seat-map">
      <div class="front-indicator">Front</div>
    </div>
    <div class="booking-details">
      <h2>예약 세부 정보</h2>
      <h3> 선택된 좌석 (<span id="counter">0</span>):</h3>
      <ul id="selected-seats">
      </ul>
      결제예정 금액: <b><span id="total">0</span>원</b>
      <button id="checkout-btn" class="checkout-button seatBtn" id="seatBtn" onchange="onSelectedSeatListner">선 택 &raquo;</button>
      <div id="legend"></div>
    </div>



<script src="http://code.jquery.com/jquery-1.12.4.min.js"></script> 
<script src="./resources/js/jquery.seat-charts.js"></script> 
<script>
var firstSeatLabel = 1;

var seatInfo = $(document).ready(function() {
	var $cart = $('#selected-seats'),
		$counter = $('#counter'),
		$total = $('#total'),
		sc = $('#seat-map').seatCharts({
		map: [
			'eeeee',
			'eeeee',
			'eeeee',
			'eeeee',
			'eeeee',
			'eeeee',
			'eeeee',
			'eeeee',
		],
		seats: {
			e: {
				price   : 100000,
				classes : 'economy-class', //your custom CSS class
				category: ''
			}					
		
		},
		naming : {
			top : false,
			getLabel : function (character, row, column) {
				return firstSeatLabel++;
			},
		},
		legend : {
			node : $('#legend'),
		    items : [
				[ 'e', 'available',   '예약 가능'],
				[ 'f', 'unavailable', '예약 불가']
		    ]					
		},
		click: function () {
	         console.log("click");
	         console.log(this.status());
	         if (this.status() == 'available') {
	            
	            var seatno = document.getElementById("seatno");
	            
	            var ticketcount = document.getElementById("ticketcount");
	            var paymoney = document.getElementById('paymoney');
	         
	            
	            if(!ticketcount.value || ticketcount.value.length === 0 ){
	               ticketcount.value = 1;
	               paymoney.value = 100000;
	               seatno.value = [];
	            } else {
	               ticketcount.value = Number(ticketcount.value)+1;
	               paymoney.value = Number(paymoney.value)+100000;
	            }
	            var seatnoList = [];
	            if(!seatno.value || seatno.value.length === 0 ){
	               seatnoList.push(this.settings.label)
	            }else {
	               seatnoList = JSON.parse(seatno.value);
	               seatnoList.push(this.settings.label);
	            }
	         
	         
	            seatno.value = JSON.stringify(seatnoList)            
	            
//	             document.getElementById("seatno").value = document.getElementById("seatno").value + " , " + this.settings.label;
	            
	            //let's create a new <li> which we'll add to the cart items
	            $('<li>'+this.data().category+' 좌석번호: '+this.settings.label+': <b>'+this.data().price+'</b><a href="#" class="cancel-cart-item">[cancel]</a></li>')
	               .attr('id', 'cart-item-'+this.settings.id)
	               .data('seatId', this.settings.id)
	               .appendTo($cart);
	            
	            /*
	             * Lets update the counter and total
	             *
	             * .find function will not find the current seat, because it will change its stauts only after return
	             * 'selected'. This is why we have to add 1 to the length and the current seat price to the total.
	             */
	            $counter.text(sc.find('selected').length+1);
	            $total.text(recalculateTotal(sc)+this.data().price);
	            
	            return 'selected';
	         } else if (this.status() == 'selected') {
	            //update the counter
	            $counter.text(sc.find('selected').length-1);
	            //and total
	            $total.text(recalculateTotal(sc)-this.data().price);
	         
	            //remove the item from our cart
	            $('#cart-item-'+this.settings.id).remove();
	            
	            var ticketcount = document.getElementById("ticketcount");
	            var paymoney = document.getElementById('paymoney');
	            var seatno = document.getElementById('seatno');

	            if(!ticketcount.value || ticketcount.value.length === 0 ){
	               ticketcount.value = 0;
	               paymoney.value = 0;
	            } else {
	               ticketcount.value = Number(ticketcount.value)-1;
	               paymoney.value = Number(paymoney.value)-100000;
	            }   
	            var seatnoList = [];
	            if(seatno.value && seatno.value.length > 0 ){
	               seatnoList = JSON.parse(seatno.value);
	               console.log(this.settings.label);
	               const index = seatnoList.indexOf(this.settings.label);
	               if(index >= 0){
	                  delete seatnoList[index];
	                  seatnoList  = seatnoList.filter(function(item) {
	                     return item !== null && item !== undefined && item !== '';
	                  });
	                  seatno.value = JSON.stringify(seatnoList);
	               } else {
	                  seatno.value = "";
	               }
	            }
	            //seat has been vacated
	            return 'available';
	         
	         } else if (this.status() == 'unavailable') {
	            //seat has been already booked
	            return 'unavailable';
	         } else {
	            return this.style();
	            
	         }
	         document.getElementById('paymoney').value = 100000;
	      }
	   });

	   //this will handle "[cancel]" link clicks
	   $('#selected-seats').on('click', '.cancel-cart-item', function () {
	      //let's just trigger Click event on the appropriate seat, so we don't have to repeat the logic here
	      sc.get($(this).parents('li:first').data('seatId')).click();
	   });
	   $('#checkout-btn').on('click', '', function () {
	      var selectedList = [];
	      console.log(sc.find('selected'));
	      sc.find('selected').each(function () {
	         console.log(this.settings.label);
	         selectedList.push(this.settings.label);
	      });
	      console.log(selectedList);
	      
	   });

	});

function recalculateTotal(sc) {

var total = 0;

//basically find every selected seat and sum its price
sc.find('selected').each(function () {
	total += this.data().price;
});

return total;
}

</script><script type="text/javascript">

var _gaq = _gaq || [];
_gaq.push(['_setAccount', 'UA-36251023-1']);
_gaq.push(['_setDomainName', 'jqueryscript.net']);
_gaq.push(['_trackPageview']);

(function() {
var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
})();

</script>

		</div>
		<div class="sec5 col-md-4" >
			<form class=" form-group buttonform" action="/reservationpay" method="POST">
				<label for="mcno" class="control-label"></label>
				<div class=" formitem">
					뮤 지 컬 선 택<input type="text" id="mcname" name="mcname" class="form-control" readonly required>
				</div>
				<div class=" formitem">
					공 연 날 짜<input type="text" id="scheduleDate" name="scheduledate" class="form-control" readonly required>
				</div>
				<div class=" formitem">
					공 연 시 작 시 간<input type="text" id="scheduletime" name="scheduletime" class="form-control" readonly required>
				</div>
				<div class=" formitem">
					예 매 수 량<input type="number" id="ticketcount" name="ticketcount" class="form-control" readonly required>
				</div>
				<div class=" formitem">
					좌 석 번 호<input type="text" id="seatno" name="" class="form-control" readonly required ><!-- style="display:none"; -->
				</div>
				<div class=" formitem">
					결 제 금 액<input type="text" id="paymoney" name="paymoney" class="form-control" readonly required>
				</div>
				<div class=" formitem">
					<input type="date" id="TIMESTAMP" name="TIMESTAMP" class="form-control" style="display:none;" >
				</div>
				<div class="btn-group btn-group-sm pay" role="group" id="payment" name="payment" readonly required>
					<div>
				    	<input type="radio" id="card" name="payment" value="카드" checked>
				     	<label for="card">카드</label>
				    </div>
					<div>
				    	<input type="radio" id="atm" name="payment" value="자동이체">
				      	<label for="atm">자동이체</label>
				    </div>
					<div>
				     	 <input type="radio" id="virtualAccount" name="payment" value="무통장">
				      	<label for="virtualAccount">무통장</label>
				    </div>
					<div>
				      	<input type="radio" id="Pay" name="payment" value="Pay">
				     	 <label for="Pay">Pay</label>
				    </div>
				    <input type="text" id="userid" name="userid" class="form-control" style="display:none;" >
				</div> 
			
				<button type="submit" class="btn btn-primary btn-md btn-block">
					결  제
				</button><a href="#" class="btn btn-secondary btn-block resetbutton" type="button">취 소</a>
			</form>
		</div>
<hr>

<%@ include file = "../layout/footer.jsp" %>