<%@page import="java.util.List"%>
<%@page import="web.dto.Comment"%>
<%@page import="web.dto.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%	Review viewReview = (Review) request.getAttribute("viewReview");
	List<Comment> commentList = (List) request.getAttribute("commentList");
	request.setCharacterEncoding("UTF-8");
	%>
	
<link rel="stylesheet" href="/resources/css/reviewView.css">

<%@ include file = "../layout/header.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	
	//후기게시판 목록으로 이동
	$("#btnList").click(function() {
		$(location).attr('href', './list')
	})
	
	//댓글작성버튼
	$("#btnCommentWrite").click(function() {
		
		if( $("#content").val != null ) {
			
			//#content의 값이 널값이 아닐때 댓글작성
			$("form").submit();
			
		} else {
			alert('댓글 입력을 안했습니다.')
		}
		
	})
	
	//수정버튼 클릭
	$("#btnUpdate").click(function() {
		$(location).attr('href', './update?reviewno=<%=viewReview.getReviewno() %>')
	})

	//삭제버튼 클릭
	$("#btnDelete").click(function() {
		$(location).attr('href', './delete?reviewno=<%=viewReview.getReviewno() %>')
	})
	
	$( ".star_rating a" ).click(function() {
		$(this).parent().children("a").removeClass("on");
		$(this).addClass("on").prevAll("a").addClass("on");
		return false;
	});
	
	
})
</script>

<div class="page-header">
<h1 class="text-center"><strong>관람후기</strong></h1>
</div>

<!-- 후기게시글 -->
<div class="container">

	<!-- 후기게시글 제목과 포스터 -->
	<img alt="포스터" src="/resources/img/mc/<%=viewReview.getMcimg() %>"
		onerror="this.src='/resources/img/mc/noImg.jpg">
	
	<div class="page-header">
	<div class="media">
		<div class="media-body">
			<h3 class="media-heading"><%=viewReview.getReviewtitle() %></h3>
			<%	for(int i=0; i < viewReview.getReviewscope(); i++) { %>
				<span class="glyphicon glyphicon-star" style="color: rgba(250, 208, 0, 0.99)"></span>
			<%	} %>
			
		</div>
	</div>
	</div>
	
	<div class="row row-cols-auto">
		<div class="row">
			<span class="col col-md-auto col-md-offset-9">작성자 : <%=viewReview.getUserid() %></span>
			<span class="col col-md-auto col-md-offset-9">등록일 : <%=viewReview.getWritedate() %></span>
		</div>
		
		<!-- 후기게시글내용 -->
		<div class="row">
			<div class="col"><%=viewReview.getReviewcontent() %></div>
		</div>
	</div>

</div>

<!-- 목록버튼 -->
<div class="text-center">
	<button id="btnList" class="btn btn-outline">목록으로</button>
	
	<!-- 해당 작성자만 수정/삭제할 수 있게끔 설정 -->
	<%	if( session.getAttribute("userid") != null ) { %>
		
			<%	if ( session.getAttribute("userid").equals(viewReview.getUserid() ) ) { %>
				<button id="btnUpdate" class="btn" style="background-color: #8EC0E4;">수정하기</button>
				<button id="btnDelete" class="btn" style="background-color: #ea9999;">삭제하기</button>
			<% } %>
	<%	} else { %>
		
				<button id="btnUpdate" class="hidden">수정하기</button>
				<button id="btnDelete" class="hidden">삭제하기</button>
		
	<%	} %>
	
</div>


<!-- 후기게시글 댓글 -->
<div class="container">

<div class="page-header">
	<h3 class="text-left"><strong>댓글</strong><small>로그인 후 댓글 작성 가능</small></h3>
</div>

<!-- 댓글 입력하는 폼 -->
<form action="./view" method="post">

	<table class="table table-striped">
		<tr>
			<td style="border-bottom:none;" valign="middle"><br><br><%=session.getAttribute("userid") %></td>
			<td><input type="text" style="height:100px; width:100%;" placeholder="댓글을 입력해주세요." name = "content" id="content"></td>
			<td><br><br><button type="button" id="btnCommentWrite" class="btn btn-outline-secondary">댓글작성</button></td>
		</tr>
	</table>
<input type="hidden" name="reviewno" value="<%=viewReview.getReviewno() %>">
<input type="hidden" name="login" value="<%=session.getAttribute("login") %>" >
</form>


<%	for( int i=0; i<commentList.size(); i++) { %>

<div class="media">
	<div class="media-left media-middle">
		<div class="media-object" style="padding: 5px;">
			<span class="glyphicon glyphicon-user" style="font-size: 40px;"></span>
		</div>
	</div>

	<div class="media-body text-left">
	
		<h4 class="media-heading"><%=commentList.get(i).getUserid() %></h4>
		<%=commentList.get(i).getContent() %>
	
		<div class="text-right">
			<span>작성일:<%=commentList.get(i).getWritedate() %></span>
		</div>
	</div>
	
</div>
<%	} %>

<%@	include file="../layout/commentPaging.jsp" %>

</div><!-- 댓글창 끝 -->
<%@ include file = "../layout/footer.jsp" %>