<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="web.dto.Musical"%>
<!-- jstl 선언 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- doget List-->
<%	Musical viewMc = (Musical) request.getAttribute("viewMc"); %>
<!-- dopost session -->
<% session.getAttribute("viewMc"); %>
<%@ include file="../layout/header_muview.jsp" %>



<script>	
//좋아요 클릭
$(document).ready(function(){
	
    if( ${isLike eq true} ) {
		$('#heart').val('♥');
    }
    else if( ${isLike eq false } ){
		$('#heart').val('♡'); 
    }
	
    
    if( ${userid != null} ) {
		$('#likee').click(function(){
			 if( ${isLike eq true} ) {
					$('#heart').val('♥');
					alert('뮤지컬 [${viewMc.mcname}] 추천을 취소하였습니다.');
			 }
			 else if( ${isLike eq false } ){
					$('#heart').val('♡'); 
		 			alert('뮤지컬 [${viewMc.mcname}]를 추천하였습니다.');
			 }
		 });
    }
    else if( ${userid == null } ){
		$('#likee').click(function(){
			alert('추천은 로그인 후 사용 가능합니다.');
		});
    }
    
  
  
 
	
// 뮤지컬 위치 클릭 시 map으로 스크롤 이동          
	$('#moveLoc').click(function(){			
		var offset = $('#map').offset(); //offset : 선택한 태그의 위치를 반환                
		$('html').animate({scrollTop : offset.top}, 600);	//0.6초 동안 부드럽게 해당 위치로 이동	
	});	
	
// 아이콘 클릭 시 맨 위로 스크롤 이동          
	$('#moveTop').click(function(){			
		var offset = $('#top').offset(); //offset : 선택한 태그의 위치를 반환                
		$('html').animate({scrollTop : offset.top}, 600);	//0.6초 동안 부드럽게 해당 위치로 이동	
	});
	
	
	//후기 작성 버튼 클릭
	$("#bag").click(function() {
		
	});
	

});	
	
</script>


<!-- 맨 위로 스크롤 이동 버튼(고정) -->
<button id="moveTop"><span class="glyphicon glyphicon-arrow-up" aria-hidden="true"></span></button>

<hr id="top" >
<h6 style="text-align:left;">뮤지컬 > 상세보기</h6>
<h2 style="text-align:left;">뮤지컬 [${viewMc.mcname}]</h2>
<h5 style="text-align:left;">${viewMc.mcstart}> ~ ${viewMc.mcend} | 
	<!-- map으로 스크롤 이동 버튼 -->
	<button id="moveLoc" onclick="locMove()">
	${viewMc.mcloc}
	<span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
	</button>
</h5>
<hr style="border:solid 1px;">

<div class = "row">
	<div class="col-md-5">
		<img alt="포스터" src="${pageContext.request.contextPath}/resources/img/mc/${viewMc.mcimg}"
						onerror="this.src='${pageContext.request.contextPath}/resources/img/mc/noImg.jpg'">
		<div class="row">
		<div class="col-sm-6" style = "margin-left: 40px;">
		
<!-- 좋아요, 후기작성 전 로그인여부확인 -->
<c:if test="${sessionScope.userid == null}">
		추천과 후기 작성은<br>
		<a href="/user/login" type="button" id="newLogin"
		class="btn btn-outline-success" style="margin-left: -13px;">
		로그인</a> 후 사용 가능합니다.
</c:if>
<c:if test="${sessionScope.userid != null}">
	<div>
	<input type="hidden" id="likechk" value="${viewMc.mclike}">
	<input type="hidden" id="reviewMcno" value="${viewMc.mcno}">
	</div>
</c:if>
		</div><!-- col-sm-5  -->

<!-- 좋아요 기능 -->
		<div class="col-sm-4">
		<form action="/musical/mcView" method="post">
			<input type="hidden" name="likechk" value="${viewMc.mclike}">
			<input type="hidden" name="userid" value="${sessionScope.userid}">
			<input type="hidden" name="mcno" value="${viewMc.mcno}">
		
		
		<button type="button" id="likee" style="border:0px;background:none;">
		<input  type="submit" id="heart" value="♡">
		</button>

			${viewMc.mclike} Likes<br><br>
		</form>
		</div><!-- col-sm-5 -->
		</div><!-- row -->
	</div>
	<div class="col-md-7">
		<div class="row">
			<label class="col-sm-3">등급</label>
			<div class="col-sm-9">${viewMc.mcage}</div>
		</div>
		<div class="row">
			<label class="col-sm-3">관람시간</label>
			<div class="col-sm-9">--</div>
		</div>
		<div class="row">
			<label class="col-sm-3">출연</label>
			<div class="col-sm-9">${viewMc.mcact}</div>
		</div>
		<div class="row">
			<label class="col-sm-3">가격</label>
			<div class="col-sm-9" id="sale">
			<p class="seat">VIP석 <span>150,000</span>원</p>
			<p class="seat">R석 <span>120,000</span>원</p>
			<p class="seat">S석 <span>90,000</span>원</p>
			<p class="seat">A석 <span>70,000</span>원</p>
			<hr style="margin: 25px;">
			<p class="seat" style="font-size:11px;">현장 구매 시 최대 <span>3000</span>원 할인 진행 중</p>
			</div>
		</div>
		<hr style="border:solid 1px;">
		<div class="row">
			<label class="col-sm-3">공연시간 안내</label>
			<div class="col-sm-9">${viewMc.mctime}</div>
		</div>
		<div class="row">
			<label class="col-sm-3">배송정보</label>
			<div class="col-sm-9">현장 수령만 가능</div>
		</div>
		<hr style="border:solid 1px;">
	</div>

</div>

<div class="text-center">
<div id="btns" class="text-center">
<button id="tick"><a href="/reservationpay">예매하기</a></button>
<button id="bag"><a href="/review/write?mcno=${viewMc.mcno}&mcname=${viewMc.mcname}&mcimg=${viewMc.mcimg}">후기작성</a></button>
</div>

<p class="contents">유의사항</p>
<img alt="포스터" src="${pageContext.request.contextPath}/resources/img/mc/${viewMc.mcimgchk}"
						onerror="this.src='${pageContext.request.contextPath}/resources/img/mc/noImg.jpg'">
						
<p class="contents">할인정보</p>
<img alt="포스터" src="${pageContext.request.contextPath}/resources/img/mc/${viewMc.mcimgsale}"
						onerror="this.src='${pageContext.request.contextPath}/resources/img/mc/noImg.jpg'">
						
<p class="contents">공연정보</p>
<img alt="포스터" src="${pageContext.request.contextPath}/resources/img/mc/${viewMc.mcimginfo}"
						onerror="this.src='${pageContext.request.contextPath}/resources/img/mc/noImg.jpg'">
						
<p class="contents">캐스팅 일정</p>
<img alt="포스터" src="${pageContext.request.contextPath}/resources/img/mc/${viewMc.mcimgcas}"
						onerror="this.src='${pageContext.request.contextPath}/resources/img/mc/noImg.jpg'">
						
<hr style="border:solid 1px;">
</div>

<!-- 카카오맵 -->
<div id="loc">
	${viewMc.mcloc}
	<span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
</div>
<div id="map" style="width:880px;height:430px;margin-left:135px;"></div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=fe1f196c3457ab9e5845ff66728babb2&libraries=services"></script>
<script>
// 마커를 클릭하면 장소명을 표출할 인포윈도우
var infowindow = new kakao.maps.InfoWindow({zIndex:1});

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도 생성  
var map = new kakao.maps.Map(mapContainer, mapOption); 

//줌 컨트롤
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT)

// 장소 검색 객체
var ps = new kakao.maps.services.Places(); 

// 키워드 검색
ps.keywordSearch('${viewMc.mcloc}', placesSearchCB); 

// 키워드 검색 완료 시 호출되는 콜백함수
function placesSearchCB (data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        var bounds = new kakao.maps.LatLngBounds();

        for (var i=0; i<data.length; i++) {
            displayMarker(data[i]);    
            bounds.extend(new kakao.maps.LatLng(data[i].y, data[i].x));
        }       

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정
        map.setBounds(bounds);
    } 
}

// 지도에 마커를 표시하는 함수
function displayMarker(place) {
    
    // 마커를 생성하고 지도에 표시
    var marker = new kakao.maps.Marker({
        map: map,
        position: new kakao.maps.LatLng(place.y, place.x) 
    });

    // 마커에 클릭이벤트를 등록
    kakao.maps.event.addListener(marker, 'click', function() {
        // 마커를 클릭하면 장소명이 인포윈도우에 표출
        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name + '</div>');
        infowindow.open(map, marker);
    });
}
</script>

<%@ include file = "../layout/footer.jsp" %>