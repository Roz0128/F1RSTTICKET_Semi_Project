package web.dao.face;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import util.Paging;
import web.dto.Musical;
import web.dto.Reservation;
import web.dto.ReservationPay;
import web.dto.User;

public interface ReservationDao {

	/**
	 * 총 예매 수
	 * @param conn
	 * @return
	 */
	public int selectCntAll(Connection conn);

	/**
	 * 테이블 전체 조회 -> 페이징 처리
	 * @param conn
	 * @param paging
	 * @return
	 */
	public List<Reservation> selectAll(Connection conn, Paging paging, User user);
	
	public int selectCntResByResnoUserid(Connection conn, Reservation resv, User user);

	public Reservation selectUserByUserid(Connection conn, Reservation resv,  User user);

	public List<Reservation> selectAllMain(Connection connection, Paging paging, User user);


	public int delete(Connection conn, Reservation resv, User user);

	public int selectCntRPByResnoMcnoUserid(Connection conn, Reservation resv, User user, ReservationPay rsPay);

	public int selectRPByResnoMcnoUserid(Connection conn, Reservation resv, User user, ReservationPay rsPay);

	public int insert(Connection conn, ReservationPay rpay, User user);


//	public Reservation selectResvByResnoMcnoUserid(Connection conn, Reservation resv, User user, ReservationPay rsPay);

//	public List<Reservation> selectAllSearch(Connection conn, Paging paging, User user, Musical musical);


}
