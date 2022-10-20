package web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.dto.Notice;
import web.service.face.NoticeService;
import web.service.impl.NoticeServiceImpl;

@WebServlet("/admin/noticeView")
public class AdminNoticeView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private NoticeService noticeService = new NoticeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달파라미터 저장 객체 얻기
		Notice notino = noticeService.getnotino(req);
		
		//상세보기 결과 조회
		Notice viewNotice = noticeService.view(notino);
		
		//조회결과 MODEL값 전달
		req.setAttribute("viewNotice", viewNotice);
		
		//관리자 공지사항 상세보기 뷰 전달
		req.getRequestDispatcher("/WEB-INF/views/admin/noticeView.jsp").forward(req, resp);
		
		
	}
	
}
