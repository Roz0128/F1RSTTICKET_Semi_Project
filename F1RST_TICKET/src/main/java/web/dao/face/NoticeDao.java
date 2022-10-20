package web.dao.face;

import java.sql.Connection;
import java.util.List;

import util.Paging;
import web.dto.Notice;

public interface NoticeDao {

	/**
	 * 총 게시글 수 조회
	 * 
	 * @param conn - DB연결 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectCntAll(Connection conn);

	/**
	 * 테이블 전체 조회 -> 페이징 처리 추가
	 * 
	 * @param conn - DB연결 객체
	 * @param paging - 페이징 정보 객체
	 * @return List<Notice> - 테이블 페이징 목록 조회 결과
	 */
	public List<Notice> selectAll(Connection conn, Paging paging);

	/**
	 * 조회된 게시글의 조회수 증가시키기
	 * 
	 * @param conn - DB 연결 객체
	 * @param notino - 조회할 게시글의 notino를 가진 DTO 객체
	 * @return int - UPDATE 수행 결과
	 */
	public int updateHit(Connection conn, Notice notino);

	/**
	 * 지정된 notino의 게시글 조회하기
	 * 
	 * @param conn - DB 연결 객체
	 * @param notino - 조회할 게시글의 noticeno를 가진 DTO 객체
	 * @return Notice - 조회된 게시글의 상세정보 DTO객체
	 */
	public Notice selectNoticeByNotino(Connection conn, Notice notino);

	/**
	 * 공지사항 게시글 입력
	 * 
	 * @param conn - DB 연결 객체
	 * @param notice - 삽입될 게시글 내용
	 * @return int - INSERT 수행 결과
	 */
	public int insert(Connection conn, Notice notice);

	/**
	 * 시퀀스를 이용하여 다음 게시글 번호 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return int - 다음 게시글 번호
	 */
	public int selectNextNotino(Connection conn);

	/**
	 * 공지사항 게시글 수정
	 * 
	 * @param conn - DB연결 객체
	 * @param notice - 수정할 내용을 담은 객체
	 * @return int - UPDATE 수행 결과
	 */
	public int update(Connection conn, Notice notice);

	/**
	 * 공지사항 게시글 삭제
	 * 
	 * @param conn - DB연결 객체
	 * @param notice - 삭제할 게시글 번호
	 * @return int - DELETE 수행 결과
	 */
	public int delete(Connection conn, Notice notice);

}
