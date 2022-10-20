package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Reservation;
import web.dto.User;
import web.service.face.UserService;
import web.service.impl.ReservationServiceImpl;
import web.service.impl.UserServiceImpl;

@WebServlet("/user/delete")
public class UserDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService = new UserServiceImpl();
	private ReservationServiceImpl resvService = new ReservationServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User userid = new User();
		userid.setUserid((String)req.getSession().getAttribute("userid"));
		
		Reservation resv = new Reservation();
		
		resvService.delete(resv, userid);
		
		userService.delete(userid);
		
		
		// 아이디 삭제 후 세션 삭제
		req.getSession().invalidate();
		
		resp.sendRedirect("/");
	}
}
