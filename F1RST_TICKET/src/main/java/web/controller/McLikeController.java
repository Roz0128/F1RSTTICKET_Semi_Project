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
import web.service.face.McService;
import web.service.impl.McServiceImpl;


@WebServlet("/musical/mcLike")
public class McLikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//서비스 객체 생성
	private McService adminService = new McServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달파라미터에서 현재 페이징 객체 계산하기
		Paging paging = adminService.getPaging(req);
				
		//뮤지컬 인기 조회
		List<Musical> mcLikeList1 = adminService.getLikeMusical();
		
		//게시글 페이징 목록 조회
		List<Musical> mcLikeList = adminService.getLikeList( paging );
				
		//조회결과 전달
		req.setAttribute("mcLikeList", mcLikeList);
		
		//페이징 객체 MODEL값 전달
		req.setAttribute("paging", paging);
		
		//view 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/musical/mcLike.jsp").forward(req, resp);

	}

}
