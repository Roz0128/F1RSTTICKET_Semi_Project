package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import util.Paging;
import web.dao.face.ReservationDao;
import web.dto.Musical;
import web.dto.Reservation;
import web.dto.ReservationPay;
import web.dto.User;

public class ReservationDaoImpl implements ReservationDao {

	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public int selectCntAll(Connection conn) {
		
		//SQL 작성
		String sql = "";
		sql += "SELECT count(*) cnt FROM reservation";
		
		//총 게시글 수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				count = rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return count;
	}
	
	@Override
	public List<Reservation> selectAll(Connection conn, Paging paging, User user) {
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		SELECT";
		sql += "			resno, scheduleInfoID, userid";
		sql += "			, resdate, ticketcount, payment, paymoney";
		sql += "		FROM Reservation WHERE userid = ?";
		sql += "		ORDER BY resno DESC";
		sql += "	) B";
		sql += " ) Reservation";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		// 뮤지컬, 예매 받아서 어떻게..??
//		sql += "SELECT rownum, R.resno, R.userid, M.mcno, R.scheduleinfoid, M.mcname";
//		sql += " FROM RESERVATION R, musical M, scheduleinfo S usertable U";
//		sql += " WHERE rownum BETWEEN ? AND ?";
//		sql += " AND M.mcno  = S.MCNO";
//		sql += " AND S.scheduleinfoid  = R.scheduleinfoid";
//		sql += " AND U.userid = '?'";
		
		//결과 저장할 List
		List<Reservation> reservationList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setString(1, user.getUserid());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			// 뮤지컬, 예매 받아서 어떻게..??
//			ps.setInt(1, paging.getStartNo());
//			ps.setInt(2, paging.getEndNo());
//			ps.setString(3, user.getUserid());
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Reservation r = new Reservation(); //결과값 저장 객체
				
				//결과값 한 행씩 처리
				r.setResno(rs.getInt("resno"));
				r.setScheduleInfoId(rs.getInt("scheduleInfoID"));
				r.setUserid(rs.getString("userid"));
				r.setResdate(rs.getDate("resdate"));
				r.setTicketcount(rs.getInt("ticketcount"));
				r.setPayment(rs.getString("payment"));
				r.setPaymoney(rs.getInt("paymoney"));
				
				
				
				//리스트에 결과값 저장
				reservationList.add(r);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println(reservationList);
		//최종 결과 반환
		return reservationList;
	}
	
	@Override // 여기 조인 함. 오류 나면 와볼것.
	public int selectCntResByResnoUserid(Connection conn, Reservation resv, User user) {
		System.out.println("selectCntResByResnoUserid~~~~~~~~~~~~~~~~ " + (resv == null));
		System.out.println(user);
	
		String sql = "";
		sql += "SELECT COUNT(*) CNT FROM Reservation R";
		sql += "  INNER JOIN usertable U";
		sql += "	ON R.userid = U.userid";
		sql += " WHERE U.userid=?";

		int cnt = 0;
		
		try {
			ps=conn.prepareStatement(sql);
			
//			ps.setInt(1, resv.getResno());
			ps.setString(1, user.getUserid());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt=rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println(cnt);
		return cnt;
		
	}
	
	@Override
	public Reservation selectUserByUserid(Connection conn, Reservation resv,  User user) {

		String sql = "";
		sql += "SELECT * FROM Reservation R";
		sql += "  INNER JOIN usertable U";
		sql += "	ON R.userid = U.userid";
		sql += " WHERE R.userid=?";
//		sql += "SELECT * FROM Reservation";
//		sql += " WHERE userid = ?";
		
		Reservation res = null;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUserid());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				res = new Reservation();
				
				res.setResno(rs.getInt("resno"));
				res.setScheduleInfoId(rs.getInt("scheduleInfoID"));
				res.setUserid(rs.getString("userid"));
				res.setResdate(rs.getDate("resdate"));
				res.setTicketcount(rs.getInt("ticketcount"));
				res.setPayment(rs.getString("payment"));
				res.setPaymoney(rs.getInt("paymoney"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	@Override
	public List<Reservation> selectAllMain(Connection conn, Paging paging, User user) {
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		SELECT";
		sql += "			resno, scheduleInfoID, userid";
		sql += "			, resdate, ticketcount, payment, paymoney";
		sql += "		FROM Reservation WHERE userid = ?";
		sql += "		ORDER BY resno DESC";
		sql += "	) B";
		sql += " ) Reservation";
		sql += " WHERE rnum BETWEEN 1 AND 3";
		
		//결과 저장할 List
		List<Reservation> reservationList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setString(1, user.getUserid());
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Reservation r = new Reservation(); //결과값 저장 객체
				
				//결과값 한 행씩 처리
				r.setResno(rs.getInt("resno"));
				r.setScheduleInfoId(rs.getInt("scheduleInfoID"));
				r.setUserid(rs.getString("userid"));
				r.setResdate(rs.getDate("resdate"));
				r.setTicketcount(rs.getInt("ticketcount"));
				r.setPayment(rs.getString("payment"));
				r.setPaymoney(rs.getInt("paymoney"));
				
				//리스트에 결과값 저장
				reservationList.add(r);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return reservationList;
	}
	
	@Override
	public int delete(Connection conn, Reservation resv, User user) {

		String sql = "";
		sql += "DELETE reservation";
		sql += " WHERE userid = ?";
		
		int res = 0;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUserid());
			
			res = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		System.out.println("delete reservation" + res);
		return res;
	}
	
	@Override
	public int selectCntRPByResnoMcnoUserid(Connection conn, Reservation resv, User user, ReservationPay rsPay) {

		String sql = "";
		sql += "SELECT count(*) cnt";
		sql += " FROM  reservation R, reservationpay P, usertable U" ;
		sql += " WHERE R.mcno  = P.mcno ";
		sql += " AND R.userid = U.userid";
		sql += " AND S.scheduleinfoid = R.scheduleinfoid";
		sql += " AND R.userid = ?";
		
		int cnt = 0;
		
		try {
			ps=conn.prepareStatement(sql);
			
//			ps.setInt(1, resv.getResno());
			ps.setString(1, user.getUserid());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt=rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println(cnt);
		return cnt;
	}

	@Override
	public int selectRPByResnoMcnoUserid(Connection conn, Reservation resv, User user, ReservationPay rsPay) {

		String sql = "";
		sql += "SELECT rownum, R.resno, R.userid, P.mcno,  P.mcname, P.scheduledate";
		sql += " FROM  reservation R, reservationpay P, usertable U" ;
		sql += " WHERE R.mcno  = P.mcno ";
		sql += " AND R.userid = U.userid";
		sql += " AND S.scheduleinfoid = R.scheduleinfoid";
		sql += " AND R.userid = ?";
		
		int cnt = 0;
		
		try {
			ps=conn.prepareStatement(sql);
			
//			ps.setInt(1, resv.getResno());
			ps.setString(1, user.getUserid());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt=rs.getInt("cnt");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		System.out.println(cnt);
		return cnt;
		
	}
	
	@Override
	public int insert(Connection conn, ReservationPay rpay, User user) {
		
		String sql = "";

		sql+= "INSERT INTO reservationpay ("
				+ "    mrno,  resno, scheduleinfoid,"
				+ "    mcno, mcname, scheduledate, scheduletime,"
				+ "    userid, resdate, ticketcount,"
				+ "    payno, payment, paymoney)"
				+ "  VALUES ("
				+ "   reservationPay_seq.nextval , Reservation_seq.nextval, ScheduleInfo_seq.nextval,"
				+ "   musical_seq.nextval , ? , ? , ? , "
				+ "   ?, (CURRENT_TIMESTAMP), ?,  paytype_seq.nextval, ? , ?)";
		
		int res = 0;
			
		try {

			
		ps = conn.prepareStatement(sql);
		
		ps.setString(1, rpay.getMcname());
		ps.setString(2, rpay.getScheduledate());
		ps.setString(3, rpay.getScheduletime());
		ps.setString(4, user.getUserid());
		ps.setInt(5, rpay.getTicketcount());
		ps.setString(6, rpay.getPayment());
		ps.setInt(7, rpay.getPaymoney());
		
		res = ps.executeUpdate();
		
		if(res ==1) {
			JDBCTemplate.commit(conn);
		}
			JDBCTemplate.rollback(conn);
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
			
		}
		return res;
		
		
	}
	
	// Musical & scheduleinfoid & Reservation이 있어야 함.
//	@Override
//	public List<Reservation> selectAllSearch(Connection conn, Paging paging, User user, Musical musical) {
//		
//		String sql = "";
//		sql += "SELECT rownum, R.resno, R.userid, M.mcno, M.mcname";
//		sql += " FROM RESERVATION R, musical M";
//		sql += " WHERE rownum BETWEEN ? AND ?";
//		sql += " AND userid = ?";
//		
//		// scheduleinfoid 자바가 있어야 함..
////		sql += " AND M.mcno  = S.MCNO";  
////		sql += " AND S.scheduleinfoid  = R.scheduleinfoid"; 
//		
//		//결과 저장할 List
//		List<Musical> mcList = new ArrayList<>();
//		List<Reservation> reservationList = new ArrayList<>();
//		
//		try {
//			ps = conn.prepareStatement(sql); //SQL수행 객체
//			
//			ps.setInt(1, paging.getStartNo());
//			ps.setInt(2, paging.getEndNo());
//			ps.setString(3, user.getUserid());
//			
//			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
//			
//			//조회 결과 처리
//			while(rs.next()) {
//				Reservation r = new Reservation(); //결과값 저장 객체
//				Musical m = new Musical();
//				
//				//결과값 한 행씩 처리
//				r.setResno(rs.getInt("resno"));
//				r.setScheduleInfoID(rs.getInt("scheduleInfoID"));
//				r.setUserid(rs.getString("userid"));
//				r.setResdate(rs.getDate("resdate"));
//				r.setTicketcount(rs.getInt("ticketcount"));
//				r.setPayment(rs.getString("payment"));
//				r.setPaymoney(rs.getInt("paymoney"));
//				
//				m.set
//				//리스트에 결과값 저장
//				reservationList.add(r);
//				mcList.add(m);
//				
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			//DB객체 닫기
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(ps);
//		}
//		
//		//최종 결과 반환
//		return reservationList;
//		
//	}
	
}
