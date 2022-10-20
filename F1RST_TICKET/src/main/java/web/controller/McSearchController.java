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


@WebServlet("/musical/mcSearch")
public class McSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//서비스 객체
	private McService mcService = new McServiceImpl();
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		///검색어 가져오기
		String keyword = req.getParameter("keyword");
		
		//전달파라미터에서 현재 페이징 객체 계산하기
		Paging paging = mcService.getPagingSearch(req);
		
		//검색된 뮤지컬 결과 조회
		List<Musical> mcSearchList1 = mcService.getSearchList(keyword);
			
		//게시글 페이징 목록 조회
		List<Musical> mcSearchList = mcService.gettSearchList( keyword, paging );

		//조회결과 MODEL값 전달
		req.setAttribute("mcSearchList", mcSearchList);
		
//		System.out.println(mcSearchList);
		
		//페이징 객체 MODEL값 전달
		req.setAttribute("paging", paging);
			
		//VIEW 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/musical/mcSearch.jsp").forward(req, resp);
	
		
	}
	


}
