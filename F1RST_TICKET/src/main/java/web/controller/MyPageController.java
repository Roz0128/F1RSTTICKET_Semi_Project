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
import web.dto.Reservation;
import web.dto.ReservationPay;
import web.dto.User;
import web.service.face.ReservationPayService;
import web.service.face.ReservationService;
import web.service.impl.ReservationPayServiceImpl;
import web.service.impl.ReservationServiceImpl;

@WebServlet("/mypage")
public class MyPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	private ReservationService reservationSerivce = new ReservationServiceImpl();
	private ReservationPayService rspayService = new ReservationPayServiceImpl();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		User user = new User();
		user.setUserid((String) req.getSession().getAttribute("userid"));
		System.out.println(user);
		
		
		Paging paging = rspayService.getPaging(req, user);
		System.out.println(paging);
		
		ReservationPay res = rspayService.selectMcno(req, user);
		System.out.println(res);
		
		List<ReservationPay> rspList = rspayService.getRsPayListMain(paging, user);
		System.out.println(rspList);
		
		req.setAttribute("rspList", rspList);
		req.setAttribute("paging", paging);
		
		boolean isMcName = rspayService.findMcname(user);
		System.out.println(isMcName);
		
		if(isMcName) {
			res = rspayService.info(res, user);
			
			HttpSession session = req.getSession();
			
			session.setAttribute("rspList", rspList);

			session.setAttribute("isMcName", isMcName);
			
			session.setAttribute("userid", user.getUserid());

			req.getRequestDispatcher("/WEB-INF/views/user/mypage.jsp").forward(req, resp);
			
		} else {
			// 관람 내역 없으면.
			req.getRequestDispatcher("/WEB-INF/views/user/mypage_no.jsp").forward(req, resp);
		}
			
	
	}
		
	
}
