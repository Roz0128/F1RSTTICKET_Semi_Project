package web.dao.face;

import java.sql.Connection;

import web.dto.Admin;
import web.dto.Musical;

public interface AdminDao {

	/**
	 * adminid와 adminpw가 동시에 만족하는 관리자의 수 조회
	 * 
	 * @param conn - DB 연결 객체
	 * @param admin - 조회할 관리자 정보
	 * @return int - 0 존재하지 않는 관리자 / 1 존재하는 관리자
	 */
	public int selectCntAdminByAdminidaAdminpw(Connection conn, Admin admin);

	/**
	 * adminid를 이용해 회원 정보 찾기
	 * 
	 * @param conn - DB 연결 객체
	 * @param admin - 조회할 adminid를 가진 객체
	 * @return Admin - 조회된 관리자 정보
	 */
	public Admin selectAdminByAdminid(Connection conn, Admin admin);

	/**
	 * 뮤지컬 삭제
	 * 
	 * @param conn - DB연결 객체
	 * @param musical - 삭제할 뮤지컬 번호
	 * @return delete 수행 결과
	 */
	public int delete(Connection conn, Musical musical);


}
