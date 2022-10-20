package web.service.impl;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.Session;

import common.JDBCTemplate;
import util.Paging;
import web.dao.face.NoticeDao;
import web.dao.impl.NoticeDaoImpl;
import web.dto.Notice;
import web.service.face.NoticeService;

public class NoticeServiceImpl implements NoticeService {
	
	//DAO객체
	private NoticeDao noticeDao = new NoticeDaoImpl();
	
	//conn연결
	private Connection conn = JDBCTemplate.getConnection();
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		} else {
			System.out.println("[WARN] NoticeService getPaging() - curPage가 null이거나 비어있음");
		}
		
		//총 게시글 수 조회하기
		int totalCount = noticeDao.selectCntAll(JDBCTemplate.getConnection());
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
	@Override
	public List<Notice> getList(Paging paging) {
		return noticeDao.selectAll(JDBCTemplate.getConnection(), paging);
	}
	
	
	
	@Override
	public Notice getnotino(HttpServletRequest req) {
		
		//전달 파라미터를 저장할 객체 생성
		Notice notice = new Notice();
		
		String param = req.getParameter("notino");
		
		if( param != null && !"".equals(param) ) {
			notice.setNotino( Integer.parseInt(param) );
		} else {
			System.out.println("[WARN] BoardService getBoardno() - boardno값이 null이거나 비어있음");
		}
		
		return notice;
	}
	
	@Override
	public Notice view(Notice notino) {
		
		//조회수 증가
		if( noticeDao.updateHit(conn, notino) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//게시글 조회
		Notice notice = noticeDao.selectNoticeByNotino(conn, notino);
		
		return notice;
	}
	
	@Override
	public void write(HttpServletRequest req) {
		
		Notice notice = new Notice();
		
		//게시글 번호 생성
		int notino = noticeDao.selectNextNotino(conn);
		
		//게시글 번호 삽입
		notice.setNotino(notino);
		
		//제목 처리
		notice.setNotititle( req.getParameter("notititle") );
		
		//본문 처리
		notice.setNoticontent( req.getParameter("noticontent") );
		
		//작성자 ID처리
		notice.setAdminid( (String) req.getSession().getAttribute("adminid") );
		
		//오픈일자처리
		notice.setOpendate( req.getParameter("opendate") );
		
		//게시글타입 처리
		notice.setNotitype( (String) req.getParameter("notitype") );
		
		Connection conn = JDBCTemplate.getConnection();
		
		if( noticeDao.insert(conn, notice) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}
	
	@Override
	public void update(HttpServletRequest req) {
		
		Notice notice = new Notice();
		
		notice.setNotino( Integer.parseInt( req.getParameter("notino") ) );
		notice.setNotititle( req.getParameter("notititle") );
		notice.setNoticontent( req.getParameter("noticontent") );
		notice.setNotitype( req.getParameter("notitype") );
		notice.setOpendate( req.getParameter("opendate") );
		
		if( noticeDao.update(conn, notice) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}		
		
	}
	
	@Override
	public void delete(Notice notice) {
		
		if(noticeDao.delete(conn, notice) > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}	
		
	}

}
