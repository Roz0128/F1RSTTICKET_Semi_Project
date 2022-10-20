package web.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import util.Paging;
import web.dao.face.McDao;
import web.dao.impl.McDaoImpl;
import web.dto.Like;
import web.dto.Musical;
import web.service.face.McService;

public class McServiceImpl implements McService {

	//DAO 객체 생성
	private McDao mcDao = new McDaoImpl();
	
	@Override
	public List<Musical> getAllMusical() {
		
		return mcDao.selectAll(JDBCTemplate.getConnection());
	}

	@Override
	public List<Musical> getNewMusical() {
		
		return mcDao.selectNew(JDBCTemplate.getConnection());
	}
	
	@Override
	public List<Musical> getLikeMusical() {

		return mcDao.selectLike(JDBCTemplate.getConnection());
	}
	
	@Override
	public List<Musical> getMdMusical() {

		return mcDao.selectMd(JDBCTemplate.getConnection());
	}
	
	@Override
	public Musical getMcno(HttpServletRequest req) {
		//전달파라미터를 저장할 객체 생성
		Musical musical = new Musical();
		
		String param = req.getParameter("mcno");
		if( param != null && !"".equals(param) ) {
			musical.setMcno( Integer.parseInt(param) );
		} else {
//			System.out.println("mcno값 null이거나 비어있음");
		}
		return musical;
	}
	
	@Override
	public Musical view(Musical mcno) {

		return mcDao.selectMusicalByMusical(JDBCTemplate.getConnection(), mcno);
	}

	@Override
	public List<Musical> getSearchList(String keyword) {
		return mcDao.searchList(JDBCTemplate.getConnection(), keyword);
	}
	
	@Override
	public Like getLIkes(HttpServletRequest req) {
		//전달파라미터를 저장할 객체 생성
		Like like = new Like();
		
		String likechk = req.getParameter("likechk");
		String userid = req.getParameter("userid");
		String mcno = req.getParameter("mcno");
		if( likechk != null && !"".equals(likechk) 
				&& mcno != null && !"".equals(mcno) 
				&& userid != null && !"".equals(userid) ) {
			like.setLikechk( Integer.parseInt(likechk) );
			like.setMcno( Integer.parseInt(mcno) );
			like.setUserid( userid );
		} else {
			like.setMcno( Integer.parseInt(mcno) );
			
		} return like;
	}
	
	@Override
	public Musical getLikeMcno(int likemcno) {
		Musical likemu = new Musical();
		
		//전달된 Like테이블의 mcno를 Musical에 저장
		likemu.setMcno( likemcno );
		
		return likemu;
	}
	
	@Override
	public boolean like(Like like) {
		
		if( mcDao.selectCntisLike(JDBCTemplate.getConnection(), like) > 0 ) {
			return true;
		}
		return false;
	}
	
	@Override
	public void deleteLike(Like like) {

		Connection conn = JDBCTemplate.getConnection();
		
		//좋아요 기록 삭제
		if(mcDao.deleteLikes(conn, like) > 0 ) {
			JDBCTemplate.commit(conn);
//			System.out.println("삭제성공");
		} else {
			JDBCTemplate.rollback(conn);
//			System.out.println("삭제실패");
		}
	}
	
	@Override
	public void insertLike(Like like) {
		Connection conn = JDBCTemplate.getConnection();
		
		//좋아요 기록 추가
		if( mcDao.insertLikes(conn, like) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}
	
	@Override
	public void updateLikeM(Like like) {
		Connection conn = JDBCTemplate.getConnection();
		
		//좋아요 감소
		if( mcDao.updateLikedmm(conn, like) > 0 ) {
			JDBCTemplate.commit(conn);
//			System.out.println("좋아요 감소 성공");
		} else {
			JDBCTemplate.rollback(conn);
//			System.out.println("좋아요 감소 실패");
		}
	}
	
	@Override
	public Musical updateLikeP(Like like) {
		Connection conn = JDBCTemplate.getConnection();

		//좋아요 증가
		if( mcDao.updateLikedpp(conn, like) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//뮤지컬 조회
		Musical viewMc= mcDao.selectMusicalLike(conn, like);
		
		//조회된 뮤지컬 리턴
		return viewMc;
	}
	
	@Override
	public List<Musical> getList(Paging paging) {
		//뮤지컬 전체 조회 결과 처리
		return mcDao.selectAllpage(JDBCTemplate.getConnection(), paging);
	}
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		} else {
			System.out.println("[WARN] getPaging() - curPage가 null이거나 비어있음");
		}
		
		//총 게시글 수 조회하기
		int totalCount = mcDao.selectCntAllpage(JDBCTemplate.getConnection());
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage, 12, 5);
		
		return paging;
	}
	
	@Override
	public List<Musical> getLikeList(Paging paging) {
		//뮤지컬 인기 조회 결과 처리
		return mcDao.selectLikepage(JDBCTemplate.getConnection(), paging);
	}
	
	@Override
	public List<Musical> gettSearchList(String keyword, Paging paging) {
		//뮤지컬 검색 조회 결과 처리
		return mcDao.searchpageList(JDBCTemplate.getConnection(), keyword , paging);
	}
	
	@Override
	public Paging getPagingSearch(HttpServletRequest req) {
		//전달파라미터 curPage 추출하기
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		} else {
//			System.out.println("[WARN] getPaging() - curPage가 null이거나 비어있음");
		}
		
		//총 게시글 수 조회하기
		int totalCount = mcDao.selectCntAllpage(JDBCTemplate.getConnection());
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage, 6, 5);
		
		return paging;
	}
}
