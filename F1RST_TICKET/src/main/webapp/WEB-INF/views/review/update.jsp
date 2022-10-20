<%@page import="web.dto.ReviewFile"%>
<%@page import="web.dto.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "../layout/header.jsp" %>

<link rel="stylesheet" href="/resources/css/reviewWrite.css">

<%	Review updateReview = (Review) request.getAttribute("updateReview"); %>
<%	ReviewFile reviewFile = (ReviewFile) request.getAttribute("reviewFile"); %>

<!-- 스마트 에디터2 설치 -->
<script type="text/javascript" src="/resources/se2/js/service/HuskyEZCreator.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	//작성버튼
	$("#btnUpdate").click(function() {
		
		//작성된 내용을 <textarea>에 적용하기
		updateContents()
		
		$("form").submit();
	})
	
	//취소버튼
	$("#btnCancel").click(function() {
		history.go(-1)
	})
	
		//파일이 없을 경우
	if(<%=reviewFile != null %>) {
		$("#beforeFile").show();
		$("#afterFile").hide();
	}
	
	//파일이 있을 경우
	if(<%=reviewFile == null %>) {
		$("#beforeFile").hide();
		$("#afterFile").show();
	}
	
	//파일 삭제 버튼(X) 처리
	$("#delFile").click(function() {
		$("#beforeFile").toggle();
		$("#afterFile").toggle();
	})

})

function updateContents() {
	//스마트 에디터에 작성된 내용을 #content에 반영한다
	oEditors.getById["reviewcontent"].exec("UPDATE_CONTENTS_FIELD", [])
}

</script>

<div class="container">

<div class="page-header">
	<h1>공연 후기 수정</h1>
	<small>관람하신 공연에 대해서 얼마나 만족하시나요?</small>
</div>

<form action="./update" method="post" enctype="multipart/form-data">

<input type="hidden" name="reviewno" value="<%=updateReview.getReviewno() %>">

<div class="container-fluid row">
	<div class="col-xs-12">
		<div class="thumbnail row">
			<img class="col-xs-2" alt="..." src="../resources/img/mc/<%=updateReview.getMcimg() %>">
			<div class="caption col-md-10">
				<h3>뮤지컬 이름</h3>
				<p>별점</p>
				
				<div class="star-rating space-x mx-auto">

					<input type="radio" id="5-star" name="reviewscope" value="5">
					<label for="5-star" class="star pr-4"><span class="glyphicon glyphicon-star"></span></label>

					<input type="radio" id="4-star" name="reviewscope" value="4">
					<label for="4-star" class="star"><span class="glyphicon glyphicon-star"></span></label>
					
					<input type="radio" id="3-star" name="reviewscope" value="3" checked="checked">
					<label for="3-star" class="star"><span class="glyphicon glyphicon-star"></span></label>
					
					<input type="radio" id="2-star" name="reviewscope" value="2">
					<label for="2-star" class="star"><span class="glyphicon glyphicon-star"></span></label>
					
					<input type="radio" id="1-star" name="reviewscope" value="1">
					<label for="1-star" class="star"><span class="glyphicon glyphicon-star"></span></label>
					
				</div>
				
			</div>
		</div>
	</div>
</div>

<!-- <form action="./write" method="post" enctype="multipart/form-data"> -->

	<table class="table table-bordered">

		<tr><td>제목</td><td><input type="text" name="reviewtitle" style="width: 100%;" value="<%=updateReview.getReviewtitle() %>"></td></tr>
		<tr><td>상세리뷰</td><td><textarea id="reviewcontent" name="reviewcontent" style="width: 100%;"><%=updateReview.getReviewcontent() %></textarea></td></tr>
		<tr>
			<td>사진 첨부</td>
			<td>
				<div>
					<div id="beforeFile">
						<%	if( reviewFile != null ) { %>
						<a href="<%=request.getContextPath() %>/upload/<%=reviewFile.getStoredname() %>"
							download="<%=reviewFile.getOriginname() %>">
							<%=reviewFile.getOriginname() %>
						</a>
						<span id="delFile" style="color: red; font-weight: bold; cursor: pointer;">X</span>
						<%	} %>
					</div>
				
					<div id="afterFile">
						<input type="file" name="file">
					</div>
			
				</div>
			</td>
		</tr>

	</table>
	
</form>

</div>

<div class="text-center">
	<button id="btnUpdate" class="btn btn-md">수정하기</button>
	<button id="btnCancel" class="btn btn-md">취소하기</button>
</div>

<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "reviewcontent",	//에디터가 적용될 <textarea>의 id 적기
	sSkinURI: "/resources/se2/SmartEditor2Skin.html",
	fCreator: "createSEditor2"
})
</script>

<%@ include file = "../layout/footer.jsp" %>