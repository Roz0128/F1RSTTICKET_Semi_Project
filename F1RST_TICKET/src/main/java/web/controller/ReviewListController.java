package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Paging;
import web.dto.Musical;
import web.dto.Review;
import web.service.face.McService;
import web.service.face.ReviewService;
import web.service.impl.McServiceImpl;
import web.service.impl.ReviewServiceImpl;

@WebServlet("/review/list")
public class ReviewListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스객체
	private ReviewService reviewService = new ReviewServiceImpl();
	
	//서비스 객체
	private McService mcService = new McServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/review/list [GET]");
		
		//페이징 객체 계산
		Paging paging = reviewService.getPaging(req);
		
		//게시글 페이징 목록 조회
		List<Review> reviewList = reviewService.getList( paging );
		
		//조회결과 View 반환
		req.setAttribute("reviewList", reviewList);
		
		//페이징 객체 MODEL값 전달
		req.setAttribute("paging", paging);
		
		//리뷰리스트 페이지로 응답
		req.getRequestDispatcher("/WEB-INF/views/review/list.jsp").forward(req, resp);
		
	}
	
}
