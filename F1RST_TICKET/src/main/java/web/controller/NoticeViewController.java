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

@WebServlet("/notice/view")
public class NoticeViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체
	private NoticeService noticeService = new NoticeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//전달파라미터 저장 객체 얻기
		Notice notino = noticeService.getnotino(req);
		System.out.println("NoticeViewController doGet() - 전달파라미터 객체 : " + notino);
		
		//상세보기 결과 조회
		Notice viewNotice = noticeService.view(notino);
		System.out.println("NoticeViewController doGet() - 상세보기 객체 : " + viewNotice);
		
		//조회결과 MODEL값 전달
		req.setAttribute("viewNotice", viewNotice);
		
		//VIEW 지정 및 응답
		req.getRequestDispatcher("/WEB-INF/views/notice/view.jsp").forward(req, resp);		
		
	}
	
}
