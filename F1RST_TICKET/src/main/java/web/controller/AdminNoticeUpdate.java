package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Notice;
import web.dto.Review;
import web.service.face.NoticeService;
import web.service.impl.NoticeServiceImpl;

@WebServlet("/admin/noticeUpdate")
public class AdminNoticeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	NoticeService noticeService = new NoticeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//해당 공지사항 게시글 번호 얻기
		Notice notino = noticeService.getnotino(req);
		
		//상세보기 결과 조회
		Notice updateNotice = noticeService.view(notino);
		
		//조회결과 MODEL값 전달
		req.setAttribute("updateNotice", updateNotice);
		
		//작성자 아이디 전달
		req.setAttribute("adminid", req.getSession().getAttribute("adminid"));
		
		//view지정, 응답
		req.getRequestDispatcher("/WEB-INF/views/admin/noticeUpdate.jsp").forward(req, resp);		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		noticeService.update(req);
		
		//관리자 공지사항 목록으로 리다이렉트
		resp.sendRedirect("/admin/noticeList");
		
	}

}
