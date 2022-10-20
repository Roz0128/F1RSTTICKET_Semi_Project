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

@WebServlet("/user/login")
public class UserLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// 서비스 객체
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/user/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 전달 파라미터 로그인 정보 얻어오기
		User user = userService.getLoginUser(req);
				
		// 로그인 인증
		boolean isLogin = userService.login(user);
		
		HttpSession session = req.getSession();

		// 로그인 인증 성공
		if( isLogin ) {
			
			user = userService.info(user);
			
			session.setAttribute("login", isLogin);
			System.out.println(isLogin);
			session.setAttribute("userid", user.getUserid());
			System.out.println(user.getUserid());
			session.setAttribute("userpw", user.getUserpw()); // 1007 추가
			System.out.println(user.getUserpw());
			session.setAttribute("username", user.getUsername()); // 1007 추가
			System.out.println(user.getUsername());
			
			session.setAttribute("gender", user.getGender());
			session.setAttribute("userbirth", user.getUserbirth());
			session.setAttribute("uphone", user.getUphone());
			session.setAttribute("address", user.getAddress());
			session.setAttribute("email", user.getEmail());
			
			//로그인 성공시 메인페이지
			req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp);
			
		}  else {
			// 아이디와 비밀번호 불일치시 에러 메시지 띄워주는 페이지로 이동
			req.getRequestDispatcher("/WEB-INF/views/user/login_err.jsp").forward(req, resp);
		}
		
//		resp.sendRedirect("/");
	}
}
