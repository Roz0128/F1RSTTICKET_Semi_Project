package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Paging;
import web.dto.Comment;
import web.dto.Review;
import web.dto.ReviewFile;
import web.service.face.CommentService;
import web.service.face.ReviewService;
import web.service.impl.CommentServiceImpl;
import web.service.impl.ReviewServiceImpl;

@WebServlet("/review/view")
public class ReviewViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스객체
	private ReviewService reviewService = new ReviewServiceImpl();
	private CommentService commentService = new CommentServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달파라미터 저장 객체 얻기
		Review reviewno = reviewService.getReviewno(req);
		
		//상세보기 결과 조회
		Review viewReview = reviewService.view(reviewno);
		
		//조회결과 MODEL값 전달
		req.setAttribute("viewReview", viewReview);
		
		//첨부파일 정보 조회
		ReviewFile reviewFile = reviewService.viewFile(viewReview);
		
		//첨부파일 MODEL값 전달
		req.setAttribute("reviewFile", reviewFile);
		
		//-----------------댓글------------------------------------
		//댓글 페이징 목록 조회
		Paging paging = commentService.getPaging(req);

		//댓글 페이징 목록 전달
		req.setAttribute("paging", paging);
		
		List<Comment> commentList = commentService.getList(paging, viewReview);
		
//		댓글 MODEL값 전달
		req.setAttribute("commentList", commentList);
		
		//View 지정응답
		req.getRequestDispatcher("/WEB-INF/views/review/view.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//한글인코딩
		req.setCharacterEncoding("UTF-8");
		
		//게시글번호 가져오기
		int reviewno = Integer.parseInt(req.getParameter("reviewno"));
		
		//유저아이디 가져오기
		String userid = (String) req.getSession().getAttribute("userid");
		
		//댓글작성 삽입
		commentService.writeComment(req, reviewno);
		
		//상세뷰로 리다이렉트
		resp.sendRedirect("/review/view?reviewno=" + reviewno + "&userid=" + userid );
		
	}

}
