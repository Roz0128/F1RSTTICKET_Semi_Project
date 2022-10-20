//package web.controller;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import util.Paging;
//import web.dto.Reservation;
//import web.dto.User;
//import web.service.face.ReservationService;
//import web.service.face.UserService;
//import web.service.impl.ReservationServiceImpl;
//import web.service.impl.UserServiceImpl;
//
//@WebServlet("/mypage/reservation")
//public class MyPageResvationController extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	private ReservationService reservationSerivce = new ReservationServiceImpl();
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
//		Paging paging = reservationSerivce.getPaging(req);
////		System.out.println(paging);
//
//		User user = new User();
//		user.setUserid((String) req.getSession().getAttribute("userid"));
//		System.out.println(user);
//
//		List<Reservation> resvList = reservationSerivce.getList(paging,user);
//		System.out.println(resvList);
//		
//		req.setAttribute("resvList", resvList);
//		req.setAttribute("paging", paging);
//
//
//		Reservation resv = reservationSerivce.getResv(req);
//		System.out.println(resv);
//
//		boolean isResv = reservationSerivce.findResv(resv, user);
//		System.out.println(isResv);
//
//		if (isResv) {
//			
//			resv = reservationSerivce.info(resv, user);
//			
//			HttpSession session = req.getSession();
//
//			session.setAttribute("isResv", isResv);
//			
//			session.setAttribute("userid", user.getUserid());
//
//			// 아이디와 예약 번호가 일치하면
//			req.getRequestDispatcher("/WEB-INF/views/user/myReservation.jsp").forward(req, resp);
//			
//		} else {
//			// 아이디와 예약 번호가 일치하지 않으면
//			req.getRequestDispatcher("/WEB-INF/views/user/myReservation_err.jsp").forward(req, resp);
//		}
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.getRequestDispatcher("/WEB-INF/views/user/resCancel.jsp").forward(req, resp);
//		
//	}
//
//}
