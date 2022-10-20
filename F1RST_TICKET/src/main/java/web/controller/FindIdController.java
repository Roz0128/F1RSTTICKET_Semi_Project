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

@WebServlet("/user/findid")
public class FindIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	// 서비스 객체
	private UserService userService = new UserServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/user/findid.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		User user = userService.getFindUserId(req); // 아이디를 찾기 위해 이름과 이메일 추출
		System.out.println(user); 
		
		
		boolean findId = userService.findId(user); // 일치하는 회원정보가 잇으면 true 없으면 false..
		System.out.println(findId); 
		
		HttpSession session = req.getSession();
		
		// 회원 인증 성공시
		if(findId) {
			user = userService.infoUser(user);
			
			session.setAttribute("findId", findId);
			session.setAttribute("findName", user.getUsername());
			session.setAttribute("findEmail", user.getEmail());
			session.setAttribute("userid", user.getUserid());
			session.setAttribute("userpw", user.getUserpw());
			
			// 회원 정보 확인시 이동 페이지
			req.getRequestDispatcher("/WEB-INF/views/user/findid_ok.jsp").forward(req, resp);
			
			
		} else {			
			// 회원 정보 확인 안될시 이동 페이지
			req.getRequestDispatcher("/WEB-INF/views/user/findid_err.jsp").forward(req, resp);
		}
	
	}
}
