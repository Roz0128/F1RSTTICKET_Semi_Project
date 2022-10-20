package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Musical;
import web.service.face.McService;
import web.service.impl.McServiceImpl;


@WebServlet("/musical/mcMd")
public class McMdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	//서비스 객체 생성
	private McService adminService = new McServiceImpl();
  
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//뮤지컬 인기 조회
			List<Musical> mcMdList = adminService.getMdMusical();
				
			//조회결과 전달
			req.setAttribute("mcMdList", mcMdList);
				
			//view 지정 및 응답
			req.getRequestDispatcher("/WEB-INF/views/musical/mcMd.jsp").forward(req, resp);

			
		}

}
