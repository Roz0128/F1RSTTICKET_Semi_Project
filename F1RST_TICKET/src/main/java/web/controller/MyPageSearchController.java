package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.Musical;
import web.dto.Reservation;
import web.dto.ReservationPay;
import web.dto.User;
import web.service.face.McService;
import web.service.face.ReservationPayService;
import web.service.face.ReservationService;
import web.service.impl.McServiceImpl;
import web.service.impl.ReservationPayServiceImpl;
import web.service.impl.ReservationServiceImpl;

@WebServlet("/mypage/search")
public class MyPageSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReservationService reservationSerivce = new ReservationServiceImpl();
//	private McService mcService = new McServiceImpl();
//	private ReservationPayService rpService = new ReservationPayServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
			req.getRequestDispatcher("/WEB-INF/views/user/watchmc.jsp").forward(req, resp);
			
	}


}
