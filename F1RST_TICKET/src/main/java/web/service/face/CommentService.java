package web.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dto.Comment;
import web.dto.Review;

public interface CommentService {

	/**
	 * 댓글 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req);

	/**
	 * 댓글 리스트 불러오기
	 * 
	 * @param paging - 페이징 정보 객체
	 * @param viewReview - 댓글테이블과 연결된 게시글의 번호
	 * @return List<Comment> - 조회된 게시판의 목록을 List로 반환
	 */
	public List<Comment> getList(Paging paging, Review viewReview);

	/**
	 * 해당 게시글번호에 맞는 댓글을 작성한다
	 * 
	 * @param req - 요청 정보 객체
	 * @param reviewno - 게시글번호
	 */
	public void writeComment(HttpServletRequest req, int reviewno);



	
}
