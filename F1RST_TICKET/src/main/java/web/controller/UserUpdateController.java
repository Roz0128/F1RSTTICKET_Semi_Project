package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.User;
import web.service.face.UserService;
import web.service.impl.UserServiceImpl;

@WebServlet("/user/update")
public class UserUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		User userid = new User();
		userid.setUserid((String)req.getSession().getAttribute("userid"));
		
		User updateUser = userService.view(userid);

		req.setAttribute("updateUser", updateUser);
		
		req.getRequestDispatcher("/WEB-INF/views/user/userUpdate.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		userService.update(req);
		
		req.getSession().invalidate();
		
		// 수정 후 로그아웃 하고 로그인 설정.
		resp.sendRedirect("/user/login");
		
		
	}
	
}
