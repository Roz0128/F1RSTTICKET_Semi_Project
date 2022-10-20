package web.dao.face;

import java.sql.Connection;
import java.util.List;

import util.Paging;
import web.dto.Like;
import web.dto.Musical;

public interface McDao {

	/**
	 * 뮤지컬 테이블 전체 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return List<Musical> - 테이블 전체 조회 결과 목록
	 */
	public List<Musical> selectAll(Connection conn);

	/**
	 * 뮤지컬 테이블 신규 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return List<Musical> - 테이블 신규 조회 결과 목록(제일 최근 업로드된 7개 반환)
	 */
	public List<Musical> selectNew(Connection conn);

	/**
	 * 뮤지컬 테이블 인기 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return List<Musical> - 테이블 인기 조회 결과 목록(like순)
	 */
	public List<Musical> selectLike(Connection conn);

	/**
	 * 뮤지컬 테이블 MD-pick 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @return List<Musical> - 테이블 MD-pick 조회 결과 목록(img가 null이 아닌 뮤지컬)
	 */
	public List<Musical> selectMd(Connection conn);

	/**
	 * 지정된 mcno의 뮤지컬 조회하기
	 * 
	 * @param conn - DB 연결 객체
	 * @param mcno - 조회할 뮤지컬의 mcno를 가진 DTO객체
	 * @return Musical - 조회된 뮤지컬의 상세정보 DTO객체
	 */
	public Musical selectMusicalByMusical(Connection conn, Musical mcno);

	/**
	 * keyword 검색 뮤지컬 조회하기
	 * 
	 * @param conn - DB 연결 객체
	 * @param keyword - 뮤지컬 검색어
	 * @return List<Musical> - 검색된 뮤지컬 목록
	 */
	public List<Musical> searchList(Connection conn, String keyword);

	/**
	 * useid와 mcno를 동시에 만족하는 좋아요 수를 조회한다
	 * 
	 * @param conn - DB연결 객체
	 * @param like - 조회할 좋아요 정보
	 * @return int - 0: 좋아요 없음(삽입하기) 1: 좋아요 있음(삭제하기)
	 */
	public int selectCntisLike(Connection conn, Like like);

	/**
	 * 좋아요 삭제
	 * 
	 * @param conn - DB연결 객체
	 * @param like - 삭제할 좋아요
	 * @return delete 수행 결과
	 */
	public int deleteLikes(Connection conn, Like like);

	/**
	 * 좋아요 추가
	 * 
	 * @param conn  - DB연결 객체
	 * @param like  - 추가할 좋아요
	 * @return insert 수행 결과
	 */
	public int insertLikes(Connection conn, Like like);

	/**
	 * 조회된 뮤지컬 좋아요 감소
	 * 
	 * @param conn - DB연결 객체
	 * @param like - 조회할 mcno 저장 객체
	 * @return update 수행 결과
	 */
	public int updateLikedmm(Connection conn, Like like);

	/**
	 * 조회된 뮤지컬 좋아요 증가
	 * 
	 * @param conn - DB연결 객체
	 * @param like - - 조회할 mcno 저장 객체
	 * @return
	 */
	public int updateLikedpp(Connection conn, Like like);

	/**
	 * 좋아요 증가된 뮤지컬 상세보기
	 * 
	 * @param conn - DB연결 객체
	 * @param like - 조회할 mcno 저장 객체
	 * @return
	 */
	public Musical selectMusicalLike(Connection conn, Like like);

	/**
	 * 테이블 전체 조회
	 *	->페이징 처리 추가
	 * 
	 * @param conn - DB연결 객체
	 * @param paging - 페이징 정보 객체 
	 * @return List<Musical> - 테이블 페이징 목록 조회 결과 
	 */
	public List<Musical> selectAllpage(Connection conn, Paging paging);

	/**
	 * 총 게시글 수 조회
	 * 
	 * @param conn - DB연결 객체
	 * @return int - 테이블의 전체 행 수
	 */
	public int selectCntAllpage(Connection conn);

	/**
	 * 테이블 인기 조회
	 *	->페이징 처리 추가
	 * 
	 * @param conn - DB연결 객체
	 * @param paging - 페이징 정보 객체 
	 * @return List<Musical> - 테이블 페이징 목록 조회 결과 
	 */
	public List<Musical> selectLikepage(Connection conn, Paging paging);

	/**
	 * 테이블 검색 조회
	 *	->페이징 처리 추가
	 * 
	 * @param conn - DB연결 객체
	 * @param paging - 페이징 정보 객체 / keyword - 검색어
	 * @return List<Musical> - 테이블 페이징 목록 조회 결과 
	 */
	public List<Musical> searchpageList(Connection conn, String keyword, Paging paging);




}
