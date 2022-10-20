package web.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import util.Paging;
import web.dao.face.CommentDao;
import web.dao.impl.CommentDaoImpl;
import web.dto.Comment;
import web.dto.Review;
import web.service.face.CommentService;

public class CommentServiceImpl implements CommentService {

	//DAO 객체
	private CommentDao commentDao = new CommentDaoImpl();
	//conn 객체
	private Connection conn = JDBCTemplate.getConnection();
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		} else {
			System.out.println("[WARN] CommentService getPaging() - curPage가 null이거나 비어있음");
		}
		
		//총 게시글 수 조회하기
		int totalCount = commentDao.selectCntAll(conn, Integer.parseInt(req.getParameter("reviewno")));
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage, 5);
		
		return paging;
		
	}
	
	@Override
	public List<Comment> getList(Paging paging, Review viewReview) {
		return commentDao.selectComment(conn, paging, viewReview);
	}
	
	@Override
	public void writeComment(HttpServletRequest req, int reviewno) {
		
		Comment comment = new Comment();
		
		//댓글 번호 생성
		int cmno = commentDao.selectNextCmno(conn);
		
		//리뷰 번호 삽입
		comment.setReviewno(reviewno);
		
		//댓글 번호 삽입
		comment.setCmno(cmno);
		
		//본문 처리
		comment.setContent( req.getParameter("content") );
		
		//작성자 ID처리
		comment.setUserid( (String) req.getSession().getAttribute("userid"));
		
		if( commentDao.insertComment(conn, comment) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}
	
}
