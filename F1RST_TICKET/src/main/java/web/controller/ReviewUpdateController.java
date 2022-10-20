package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import web.dto.Review;
import web.dto.ReviewFile;
import web.service.face.ReviewService;
import web.service.impl.ReviewServiceImpl;

@WebServlet("/review/update")
public class ReviewUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스객체
	private ReviewService reviewService = new ReviewServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//해당 후기 게시반 번호 얻기
		Review reviewno = reviewService.getReviewno(req);
		
		//상세보기 결과 조회
		Review updateReview = reviewService.view(reviewno);
		System.out.println("Update : " + updateReview );
		
		//조회결과 MODEL값 전달
		req.setAttribute("updateReview", updateReview);
		
		//작성자 아이디 전달
		req.setAttribute("userid", req.getSession().getAttribute("userid"));
		
		//첨부파일 정보 조회
		ReviewFile reviewFile = reviewService.viewFile(updateReview);
		
		//첨부파일 MODEL값 전달
		req.setAttribute("reviewFile", reviewFile);
		
		//view지정, 응답
		req.getRequestDispatcher("/WEB-INF/views/review/update.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		reviewService.update(req);
		
		resp.sendRedirect("/review/list");
		
	}

}
