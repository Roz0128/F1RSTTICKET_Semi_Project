package web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.Paging;
import web.dto.Notice;
import web.service.face.NoticeService;
import web.service.impl.NoticeServiceImpl;

@WebServlet("/admin/noticeList")
public class AdminNoticeList extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private NoticeService noticeService = new NoticeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//한글인코딩설정
		req.setCharacterEncoding("UTF-8");
		
		//전달파라미터에서 현재 페이징 객체 계산하기
		Paging paging = noticeService.getPaging(req);

		//게시글 페이징 목록 조회
		List<Notice> noticeList = noticeService.getList( paging );
				
		//조회된 결과를 view에 전달
		req.setAttribute("noticeList", noticeList);
				
		//페이징 객체 MODEL값 전달
		req.setAttribute("paging", paging);
		
		req.getRequestDispatcher("/WEB-INF/views/admin/noticeList.jsp").forward(req, resp);
		
	}

}
