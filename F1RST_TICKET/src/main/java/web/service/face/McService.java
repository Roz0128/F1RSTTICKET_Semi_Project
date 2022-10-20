package web.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dto.Like;
import web.dto.Musical;

public interface McService {

	/**
	 * 뮤지컬 전체 조회
	 * 
	 * @return List<Musical> - 뮤지컬 전체 조회 결과 목록
	 */
	public List<Musical> getAllMusical();

	/**
	 * 뮤지컬 신규 조회
	 * 
	 * @return List<Musical> - 뮤지컬 신규 조회 결과 목록
	 */
	public List<Musical> getNewMusical();

	/**
	 * 뮤지컬 인기 조회
	 * 
	 * @return List<Musical> - 뮤지컬 인기 조회 결과 목록
	 */
	public List<Musical> getLikeMusical();

	/**
	 * 뮤지컬 MD-pick 조회
	 * 
	 * @return List<Musical> - 뮤지컬 MD-pick 조회 결과 목록
	 */
	public List<Musical> getMdMusical();

	/**
	 * 전달파라미터를 Musical DTO로 저장하여 반환
	 * 
	 * @param req - 요청 정보 객체
	 * @return Musical - 전달파라미터 mcno를 저장한 객체
	 */
	public Musical getMcno(HttpServletRequest req);

	/**
	 * 전달된 mcno를 이용하여 뮤지컬을 조회한다
	 * 
	 * @param mcno - 조회할 mcno를 가진 DTO객체
	 * @return Musical - 조회된 뮤지컬 정보
	 */
	public Musical view(Musical mcno);

	/**
	 * 전달된 keyword를 이용하여 뮤지컬을 검색한다
	 * 
	 * @param keyword - 검색어
	 * @return List<Musical> - 검색결과 뮤지컬 목록
	 */
	public List<Musical> getSearchList(String keyword);

	/**
	 * 전달파라미터를 Like DTO로 저장하여 반환
	 * 
	 * @param req - 요청 정보 객체
	 * @return Like - 전달파라미터 likehck, userid, mcno를 저장한 객체
	 */
	public Like getLIkes(HttpServletRequest req);

	/**
	 * 로그아웃상태에서 좋아요 눌렀을 때
	 * Like 테이블 mcno를 이용하여 Musical 테이블 mcno 저장하여 반환
	 * 
	 * @param likemcno - 조회할 mcno를 가진 Like DTO객체
	 * @return Musical - likeno와 같은 mcno를 저장한 객체
	 */
	public Musical getLikeMcno(int likemcno);

	/**
	 * 좋아요 기록 확인하기
	 * 
	 * @param like - 조회할 userid, mcno가진 객체
	 * @return boolean - true: 좋아요 삭제, false: 좋아요 삽입
	 */
	public boolean like(Like like);

	/**
	 * 좋아요 삭제
	 * 
	 * @param like - 삭제할 userid, mcno가진 객체
	 */
	public void deleteLike(Like like);

	/**
	 * 좋아요 추가
	 * 
	 * @param like - 추가할 userid, mcno가진 객체
	 */
	public void insertLike(Like like);

	/**
	 * 좋아요 감소
	 * 
	 * @param like - 감소할 mcno가진 객체
	 * @return Musical 좋아요 감소한 뮤지컬 상세보기
	 */
	public void updateLikeM(Like like);

	/**
	 * 좋아요 증가 후 상세보기 
	 * 
	 * @param like - 증가할 mcno가진 객체
	 * @return Musical 좋아요 증가한 뮤지컬 상세보기
	 */
	public Musical updateLikeP(Like like);

	/**
	 * 뮤지컬 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPaging(HttpServletRequest req);

	/**
	 * 뮤지컬 페이징 전체 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Musical> - 뮤지컬 전체 조회 결과 목록
	 */
	public List<Musical> getList(Paging paging);

	/**
	 * 뮤지컬 페이징 인기 조회
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<Musical> - 뮤지컬 인기 조회 결과 목록
	 */
	public List<Musical> getLikeList(Paging paging);

	/**
	 * 뮤지컬 페이징 검색 조회
	 * 
	 * @param paging - 페이징 정보 객체 / keyword - 검색어
	 * @return List<Musical> - 뮤지컬 검색 조회 결과 목록
	 */
	public List<Musical> gettSearchList(String keyword, Paging paging);

	/**
	 * 뮤지컬 검색 페이징 객체 생성
	 * 
	 * @param req - 요청 정보 객체
	 * @return Paging - 페이징 계산이 완료된 객체
	 */
	public Paging getPagingSearch(HttpServletRequest req);

	

	

}
