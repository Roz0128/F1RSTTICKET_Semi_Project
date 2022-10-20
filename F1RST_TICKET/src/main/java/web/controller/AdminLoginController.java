package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.dto.Admin;
import web.service.face.AdminService;
import web.service.impl.AdminServiceImpl;

@WebServlet("/admin/login")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 서비스 객체
	private AdminService adminService = new AdminServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/admin/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 전달 파라미터 로그인 정보 얻어오기
		Admin admin = adminService.getLoginAdmin(req);
				
		// 로그인 인증
		boolean isLogin = adminService.login(admin);
		
		HttpSession session = req.getSession();

		// 로그인 인증 성공
		if( isLogin ) {
			
			admin = adminService.info(admin);
			
			session.setAttribute("adminlogin", isLogin);
			System.out.println(isLogin);
			session.setAttribute("adminid", admin.getAdminid());
			System.out.println(admin.getAdminid());
			session.setAttribute("adminpw", admin.getAdminpw());
			System.out.println(admin.getAdminpw());
		
			//로그인 성공시 메인페이지
			req.getRequestDispatcher("/WEB-INF/views/main_ad.jsp").forward(req, resp);
			
		}  else {
			// 아이디와 비밀번호 불일치시 에러 메시지 띄워주는 페이지로 이동
			req.getRequestDispatcher("/WEB-INF/views/user/login_err.jsp").forward(req, resp);
		}
		
//		resp.sendRedirect("/");
	}
}
