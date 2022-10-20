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
import web.dto.ReservationPay;
import web.dto.User;
import web.service.face.ReservationPayService;
import web.service.impl.ReservationPayServiceImpl;


@WebServlet("/mypage/view")
public class MypageListView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
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
		
//		ReservationPay getMrno = rspayService.getMrno(req, user);
//		System.out.println(getMrno);
		
		List<ReservationPay> rspList = rspayService.getRsPayList(paging, user);
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

			// 아이디와 예약 번호가 일치하면
			req.getRequestDispatcher("/WEB-INF/views/user/myReservation.jsp").forward(req, resp);
			
		} else {
			// 아이디와 예약 번호가 일치하지 않으면
			req.getRequestDispatcher("/WEB-INF/views/user/myReservation_err.jsp").forward(req, resp);
		}
	
	}
}
