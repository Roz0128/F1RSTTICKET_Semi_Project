package web.dao.face;

import java.sql.Connection;
import java.util.List;

import util.Paging;
import web.dto.ReservationPay;
import web.dto.User;

public interface ReservationPayDao {

	public List<ReservationPay> selectAllM(Connection conn);

	public int selectMcno(Connection conn, String mcname);

	public int selectSinfoid(Connection conn);

	public int insert(Connection conn, ReservationPay rpay, User user);
	
	
	//---------------

	// MyPageView
	public List<ReservationPay> selectAllRsp(Connection conn, Paging paging, User user);
	public int selectCntAll(Connection conn, User user);
	public ReservationPay getMcno(Connection conn, User user);

	// My Page Reservation
	public List<ReservationPay> selectAllRspMain(Connection conn, Paging paging, User user);
	public int selectCntMusicalByMcName(Connection conn, User user);
	public ReservationPay selectMcByMcname(Connection conn, User user);
	
}

//	public ReservationPay getMrno(Connection conn, User user);
//	public List<ReservationPay> searchMc(Connection conn, String keyword, User user);
//	public int selectCntRpBySearchMc(Connection conn, String keyword, User user);
//
//	public ReservationPay selectRpBySearchMc(Connection conn, User user, String keyword);
//	public int writeReservation(Connection conn, ReservationPay rvpay, User user);
//	public int writeScheduleInfo(Connection conn, ReservationPay rvpay);
//	public int writeSeat(Connection conn, ReservationPay rvpay);
//	public void dbpush(Connection conn, User user, ReservationPay rpay);