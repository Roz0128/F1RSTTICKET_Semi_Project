package web.dao.face;

import java.sql.Connection;
import java.util.List;

import util.Paging;
import web.dto.UserBoard;

public interface UserBoardDao {

	/**
	 * 페이징 처리
	 * @param conn
	 * @return
	 */
	public int selectCntAll(Connection conn);

	/**
	 * 테이블 전체 조회
	 * @param conn
	 * @param paging
	 * @return
	 */
	public List<UserBoard> selectAll(Connection conn, Paging paging);

}
