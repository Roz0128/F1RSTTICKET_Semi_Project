package web.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dto.Notice;

public interface NoticeService {

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
	 * @return List<Notice> - 조회된 게시판의 목록을 List로 반환한다
	 */
	public List<Notice> getList(Paging paging);

	/**
	 * 전달파라미터를 Board DTO로 저장하여 반환
	 * 
	 * @param req - 요정 정보 객체
	 * @return Notice - 전달파라미터 notino를 저장한 객체
	 */
	public Notice getnotino(HttpServletRequest req);

	/**
	 * 전달된 notino를 이용하여 게시글을 조회한다
	 * 조회된 게시글의 조회수를 1 증가 시킨다
	 * 
	 * @param notino - 조회할 notino를 가진 DTO객체
	 * @return Notice - 조회된 게시글 정보
	 */
	public Notice view(Notice notino);

	/**
	 * 공지사항 게시글 작성
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void write(HttpServletRequest req);

	/**
	 * 공지사항 게시글 수정
	 * 
	 * @param req - 요청 정보 객체
	 */
	public void update(HttpServletRequest req);

	/**
	 * 공지사항 게시글 삭제
	 * 
	 * @param notice - 삭제할 게시글 번호 객체
	 */
	public void delete(Notice notice);

}
