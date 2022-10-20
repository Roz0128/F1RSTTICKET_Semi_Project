package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Paging;
import web.dto.Musical;
import web.dto.MyReservation;
import web.dto.Reservation;
import web.dto.User;
import web.service.face.McService;
import web.service.face.MyReservationService;
import web.service.face.ReservationService;
import web.service.impl.McServiceImpl;
import web.service.impl.MyReservationServiceImpl;
import web.service.impl.ReservationServiceImpl;

@WebServlet("/mypage/reservation3")
public class MyPageResvationController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MyReservationService mrService = new MyReservationServiceImpl();
	private McService mcService = new McServiceImpl();
	private ReservationService resService = new ReservationServiceImpl();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Paging paging = mrService.getPaging(req);
		Musical mc = mcService.getMcno(req);
		Reservation res = resService.getResv(req);
		
		User user = new User();
		user.setUserid((String) req.getSession().getAttribute("userid"));
		MyReservation myRes = mrService.getMcname(req);
		
		List<MyReservation> myResList = mrService.getList(paging, user, mc, res);
		
		req.setAttribute("myResList", myResList);
		req.setAttribute("paging", paging);
		
		
		boolean isMyMc = mrService.findMyMc(myRes, user, mc, res);
		
		if(isMyMc) {
			myRes = mrService.info(myRes, user, mc, res);
			
			HttpSession session = req.getSession();
			session.setAttribute("isMyMc", isMyMc);
			
			session.setAttribute("userid", user.getUserid());
			
			// 아이디와 예약 번호가 일치하면
			req.getRequestDispatcher("/WEB-INF/views/user/myReservation.jsp").forward(req, resp);
		} else {
			// 아이디와 예약 번호가 일치하지 않으면
			req.getRequestDispatcher("/WEB-INF/views/user/myReservation_err.jsp").forward(req, resp);
		}
		

		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/myReservation.jsp").forward(req, resp);
	}
}
