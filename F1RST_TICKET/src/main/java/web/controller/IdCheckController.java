package web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dao.impl.UserDaoImpl;
import web.dao.face.UserDao;
import web.dto.User;
import web.service.impl.UserServiceImpl;
import web.service.face.UserService;

@WebServlet("/idCheck")
public class IdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	public IdCheckController() {
		super();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserDao Dao = new UserDaoImpl();
		User u = new User();

		u.setUserid(req.getParameter("userid"));
		
		int result = Dao.IdCheckController(u);
		
		resp.setContentType("application/x-json; charset=UTF-8");
		resp.getWriter().write(result+"");


	}
	
}
