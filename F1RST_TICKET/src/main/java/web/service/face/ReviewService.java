package web.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dto.Comment;
import web.dto.Review;
import web.dto.ReviewFile;

public interface ReviewService {

	/**
	 * 게시글 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req);

	/**
	 * 게시판의 전체 목록을 조회한다
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Review> - 조회된 게시판의 목록을 List로 반환한다
	 */
	public List<Review> getList(Paging paging);

	/**
	 * 전달파라미터를 Review DTO로 저장하여 반환
	 * 
	 * @param req - 요청 정보 객체
	 * @return Review - 전달 파라미터 reviewno를 저장한 객체
	 */
	public Review getReviewno(HttpServletRequest req);

	/**
	 * 전달된 reviewno를 이용하여 게시글을 조회한다
	 * 
	 * @param reviewno - 조회할 reviewno를 가진 DTO객체
	 * @return Review - 조회된 게시글 정보
	 */
	public Review view(Review reviewno);

	/**
	 * 첨부파일 정보 조회하기
	 * 
	 * @param viewReview - 첨부파일과 연결된 게시글의 번호
	 * @return ReviewFile - 첨부파일 정보 DTO객체
	 */
	public ReviewFile viewFile(Review viewReview);

	/**
	 * 게시글 작성
	 * 입력한 게시글을 DB에 저장한다
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void write(HttpServletRequest req);

	/**
	 * 게시글 수정
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void update(HttpServletRequest req);

	/**
	 * 게시글 삭제
	 * 
	 * @param review - 삭제할 게시글 번호 객체
	 */
	public void delete(Review review);




}
