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


@WebServlet("/musical/mcList")
public class McController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	//서비스 객체 생성
	private McService mcService = new McServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달파라미터에서 현재 페이징 객체 계산하기
		Paging paging = mcService.getPaging(req);
//		System.out.println( "페이징객체" + paging );
				
		//뮤지컬 전체 조회
		List<Musical> musicalList1 = mcService.getAllMusical();
		
		//게시글 페이징 목록 조회
		List<Musical> musicalList = mcService.getList( paging );
		
		//조회결과 전달
		req.setAttribute("musicalList", musicalList);
		
		//페이징 객체 MODEL값 전달
		req.setAttribute("paging", paging);
				
		//view 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/musical/mcList.jsp").forward(req, resp);
	
	}
	

}
