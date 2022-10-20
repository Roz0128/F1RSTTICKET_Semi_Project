package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.service.face.NoticeService;
import web.service.impl.NoticeServiceImpl;

@WebServlet("/admin/noticeWrite")
public class AdminNoticeWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NoticeService noticeService = new NoticeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/views/admin/noticeWrite.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//한글인코딩설정
		req.setCharacterEncoding("UTF-8");
		
		//공지사항 게시글 삽입
		noticeService.write(req);
		

		//관리자 공지사항 목록으로 리다이렉트
		resp.sendRedirect("/admin/noticeList");
		
	}

}
