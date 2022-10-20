package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Paging;
import web.dto.UserBoard;
import web.service.face.UserBoardService;
import web.service.impl.UserBoardServiceImpl;

@WebServlet("/admin/user")
public class AdminUserListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserBoardService userBoardService = new UserBoardServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 페이징 처리
		Paging paging = userBoardService.getPaging(req);
		System.out.println(paging);
		
		List<UserBoard> userList = userBoardService.getList(paging);
		System.out.println(userList);
		
		req.setAttribute("userList", userList);
		req.setAttribute("paging", paging);
		
		req.getRequestDispatcher("/WEB-INF/views/adminBoard/userList.jsp").forward(req, resp);
		
	}
}
