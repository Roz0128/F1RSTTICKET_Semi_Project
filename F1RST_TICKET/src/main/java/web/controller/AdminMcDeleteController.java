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
import web.service.face.AdminService;
import web.service.face.McService;
import web.service.impl.AdminServiceImpl;
import web.service.impl.McServiceImpl;


@WebServlet("/admin/mcDelete")
public class AdminMcDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AdminService adminService = new AdminServiceImpl();
	private McService mcService = new McServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		// 페이징 처리
		Paging paging = mcService.getPaging(req);
//				System.out.println(paging);
		
		List<Musical> musicalList = mcService.getList(paging);
//				System.out.println(musicalList);
		
		req.setAttribute("musicalList", musicalList);
		req.setAttribute("paging", paging);
				
		Musical musical = adminService.getMusicalno(req);
		
		//뮤지컬 삭제 인증
		boolean isDel = adminService.delete(musical);
		
		if(isDel) {
			req.setAttribute("isDel", isDel);
			req.setAttribute("musicalList", musicalList);
			req.setAttribute("paging", paging);
		}
		
		req.getRequestDispatcher("/WEB-INF/views/adminBoard/mcDelete.jsp").forward(req, resp);
	
	}

}
