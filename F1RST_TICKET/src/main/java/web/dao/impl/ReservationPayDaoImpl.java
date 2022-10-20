package web.dao.impl;

import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import util.Paging;
import web.dao.face.ReservationPayDao;
import web.dto.ReservationPay;
import web.dto.User;

public class ReservationPayDaoImpl implements ReservationPayDao {

	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public List<ReservationPay> selectAllM(Connection conn) {

		String sql = "";
		sql = "SELECT mcname,mcno FROM MUSICAL";
		List<ReservationPay> mlist = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				ReservationPay r = new ReservationPay();
				
				r.setMcname(rs.getString("mcname"));
				r.setMcno(rs.getInt("mcno"));
				
				mlist.add(r);
				System.out.println("mlist =" + mlist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return mlist;
	
	}


	@Override
	public int selectMcno(Connection conn, String mcname) {
		String sql = "";
		sql = "SELECT mcno FROM musical WHERE mcname = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mcname);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
			ReservationPay r = new ReservationPay();
			res = rs.getInt("mcno");
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
	public int selectSinfoid(Connection conn) {
		String sql = "";
		sql = "SELECT ScheduleInfo_seq.nextval FROM dual";
		
		int nextScheduleInfono = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next() ) {
				nextScheduleInfono = rs.getInt("nextval");
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return nextScheduleInfono;
	}
	



	//------------------------
	@Override
	public int selectCntAll(Connection conn, User user) {
		
		String sql = "";
		sql += "SELECT count(*) cnt"; 
		sql += " FROM reservation R, Musical M, usertable U, scheduleinfo S, reservationPay P";
		sql += " WHERE S.mcno = M.MCNO";  
		sql += " AND P.resno = R.resno";
		sql += " AND R.userid = U.userid";
		sql += " AND S.SCHEDULEINFOID  = R.SCHEDULEINFOID"; 
		sql += " AND P.userid = ?";
		
		int cnt = 0;
		
		try {
			ps=conn.prepareStatement(sql);
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
		return cnt;
	}

	@Override
	public List<ReservationPay> selectAllRsp(Connection conn, Paging paging, User user) {

		String sql="";
		
		sql += "SELECT * FROM (";
		sql += " SELECT rownum rnum, DATA.* FROM (";
		sql += " SELECT  P.*";
		sql += " FROM  reservation R, musical M, usertable U, scheduleinfo S , reservationPay P";
		sql += " WHERE S.mcno  = M.mcno";
		sql += " AND R.userid = U.userid";
		sql += " AND P.resno = R.resno";
		sql += " AND S.scheduleinfoid = R.scheduleinfoid";
		sql += " AND P.userid = ?";
		sql += ") DATA )" ; 
		sql += " WHERE rnum BETWEEN ? AND ?";
		sql += " order by scheduledate DESC"; 
		
		List<ReservationPay> rsPay = new ArrayList<>();
				
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, user.getUserid());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				ReservationPay rsp = new ReservationPay();
				
				rsp.setMrno(rs.getInt("mrno"));
				rsp.setResno(rs.getInt("resno"));
				rsp.setScheduleInfoId(rs.getInt("scheduleinfoid"));
				rsp.setMcno(rs.getInt("mcno"));
				rsp.setMcname(rs.getString("mcname"));
				rsp.setScheduledate(rs.getString("scheduledate"));
				rsp.setScheduletime(rs.getString("scheduletime"));
				rsp.setUserid(rs.getString("userid"));
				rsp.setResdate(rs.getTimestamp("resdate"));
				rsp.setTicketcount(rs.getInt("ticketcount"));
				rsp.setPayno(rs.getInt("payno"));
				rsp.setPayment(rs.getString("payment"));
				rsp.setPaymoney(rs.getInt("paymoney"));
				
				rsPay.add(rsp);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("rsPay : " + rsPay);
		return rsPay;
	}
	
	@Override
	public int selectCntMusicalByMcName(Connection conn, User user) {

		String sql = "";
		sql += "SELECT count(*) cnt";
		sql += " FROM reservation R, Musical M, usertable U, scheduleinfo S, reservationPay P";
		sql += " WHERE S.mcno = M.MCNO";
		sql += " AND P.resno = R.resno";
		sql += " AND R.userid = U.userid";
		sql += " AND S.SCHEDULEINFOID  = R.SCHEDULEINFOID";
		sql += " AND P.userid = ?";
		
		int cnt = 0;
		
		try {
		ps=conn.prepareStatement(sql);
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
	public ReservationPay getMcno(Connection conn, User user) {

		String sql = "";
		sql+= "SELECT *";
		sql += " FROM reservation R, Musical M, usertable U, scheduleinfo S, reservationPay P";
		sql += " WHERE S.mcno = M.MCNO";
		sql += " AND P.resno = R.resno";
		sql += " AND R.userid = U.userid";
		sql += " AND S.SCHEDULEINFOID  = R.SCHEDULEINFOID";
		sql += " AND P.userid = ?";
		sql += " order by S.scheduledate DESC"; 
		
		ReservationPay rsp = new ReservationPay();
		
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, user.getUserid());

				rs=ps.executeQuery();
				
				while(rs.next()) {
					
					rsp.setMrno(rs.getInt("mrno"));
					rsp.setResno(rs.getInt("resno"));
					rsp.setScheduleInfoId(rs.getInt("scheduleInfoId"));
					rsp.setMcno(rs.getInt("mcno"));
					rsp.setMcname(rs.getString("mcname"));
					rsp.setScheduledate(rs.getString("scheduledate"));
					rsp.setScheduletime(rs.getString("scheduletime"));
					rsp.setUserid(rs.getString("userid"));
					rsp.setResdate(rs.getTimestamp("resdate"));
					rsp.setTicketcount(rs.getInt("ticketcount"));
					rsp.setPayno(rs.getInt("payno"));
					rsp.setPayment(rs.getString("payment"));
					rsp.setPaymoney(rs.getInt("paymoney"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(rs);
				JDBCTemplate.close(ps);
			}
	
		return rsp;
	}

	@Override
	public ReservationPay selectMcByMcname(Connection conn, User user) {
		
		String sql="";
		sql += "SELECT * FROM (";
		sql += " SELECT rownum rnum, DATA.* FROM (";
		sql += " SELECT P.*";
		sql += " FROM  reservation R, musical M, usertable U, scheduleinfo S , reservationPay P";
		sql += " WHERE S.mcno  = M.mcno";
		sql += " AND R.userid = U.userid";
		sql += " AND P.resno = R.resno";
		sql += " AND S.scheduleinfoid = R.scheduleinfoid";
		sql += " AND P.userid = ?";
		sql += ") DATA )"; 
		sql += " order by scheduledate DESC"; 
		
		
		ReservationPay rsp = new ReservationPay();
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, user.getUserid());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				rsp.setMrno(rs.getInt("mrno"));
				rsp.setResno(rs.getInt("resno"));
				rsp.setScheduleInfoId(rs.getInt("scheduleInfoId"));
				rsp.setMcno(rs.getInt("mcno"));
				rsp.setMcname(rs.getString("mcname"));
				rsp.setScheduledate(rs.getString("scheduledate"));
				rsp.setScheduletime(rs.getString("scheduletime"));
				rsp.setUserid(rs.getString("userid"));
				rsp.setResdate(rs.getTimestamp("resdate"));
				rsp.setTicketcount(rs.getInt("ticketcount"));
				rsp.setPayno(rs.getInt("payno"));
				rsp.setPayment(rs.getString("payment"));
				rsp.setPaymoney(rs.getInt("paymoney"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return rsp;
	}
	
	@Override
	public List<ReservationPay> selectAllRspMain(Connection conn, Paging paging, User user) {
		String sql="";
		
		sql += "SELECT * FROM (";
		sql += " SELECT rownum rnum, DATA.* FROM (";
		sql += " SELECT  P.*";
		sql += " FROM  reservation R, musical M, usertable U, scheduleinfo S , reservationPay P";
		sql += " WHERE S.mcno  = M.mcno";
		sql += " AND R.userid = U.userid";
		sql += " AND P.resno = R.resno";
		sql += " AND S.scheduleinfoid = R.scheduleinfoid";
		sql += " AND P.userid = ?";
		sql += " ) DATA )" ; 
		sql += " WHERE rnum BETWEEN 1 AND 5";
		sql += " order by scheduledate DESC";
		
		List<ReservationPay> rsPay = new ArrayList<>();
		
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, user.getUserid());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				ReservationPay rsp = new ReservationPay();
				
				rsp.setMrno(rs.getInt("mrno"));
				rsp.setResno(rs.getInt("resno"));
				rsp.setScheduleInfoId(rs.getInt("scheduleInfoId"));
				rsp.setMcno(rs.getInt("mcno"));
				rsp.setMcname(rs.getString("mcname"));
				rsp.setScheduledate(rs.getString("scheduledate"));
				rsp.setScheduletime(rs.getString("scheduletime"));
				rsp.setUserid(rs.getString("userid"));
				rsp.setResdate(rs.getTimestamp("resdate"));
				rsp.setTicketcount(rs.getInt("ticketcount"));
				rsp.setPayno(rs.getInt("payno"));
				rsp.setPayment(rs.getString("payment"));
				rsp.setPaymoney(rs.getInt("paymoney"));
				
				rsPay.add(rsp);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		System.out.println("rsPay : " + rsPay);
		return rsPay;
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
	
}


//@Override
//public int writeReservation(Connection conn, ReservationPay rvpay, User user) {
//	String sql = "";
//	sql = "INSERT INTO reservation (resno,scheduleinfoid,userid,resdate,ticketcount,payment,paymoney)";
//	sql += " VALUES( reservation_seq.nextval, ?, ?, ?, ?, ?, ?)";
//	int res = 0;
//	
//	
//	try {
//		ps = conn.prepareStatement(sql);
//		
//		ps.setInt(1, rvpay.getScheduleInfoId());
//		ps.setString(2, user.getUserid());
//		ps.setTimestamp(3, rvpay.getResdate());
//		ps.setInt(4, rvpay.getTicketcount());
//		ps.setString(5, rvpay.getPayment());
//		ps.setInt(6, rvpay.getPaymoney());
//		
//		
//		res = ps.executeUpdate();
//
//	
//		
//	} catch (SQLException e) {
//		e.printStackTrace();
//	} finally {
//
//		JDBCTemplate.close(ps);
//	}
//	return res;
//
//
//}
//
//
//@Override
//public int writeScheduleInfo(Connection conn, ReservationPay rvpay) {
//	String sql = "";
//	sql = "INSERT INTO scheduleinfo (scheduleinfoid, mcno, scheduledate, scheduletime)";
//	sql += " VALUES( ?, ?, ?, ?)";
//	int res = 0;
//	
//	
//	try {
//		ps = conn.prepareStatement(sql);
//		
//		ps.setInt(1, rvpay.getScheduleInfoId());
//		ps.setInt(2, rvpay.getMcno());
//		ps.setDate(3, (Date)rvpay.getScheduledate());
//		ps.setString(4, rvpay.getScheduletime());
//		
//		res = ps.executeUpdate();
//
//	
//		
//	} catch (SQLException e) {
//		e.printStackTrace();
//	} finally {
//
//		JDBCTemplate.close(ps);
//	}
//	return res;
//
//
//}
//
//
//@Override
//public int writeSeat(Connection conn, ReservationPay rvpay) {
//	String sql = "";
//	sql = "INSERT INTO seat (seatno, scheduleinfoid)";
//	sql += " VALUES( ?, ?)";
//	int res = 0;
//	
//	
//	try {
//		ps = conn.prepareStatement(sql);
//		
//		ps.setInt(1, rvpay.getSeatno());
//		ps.setInt(2, rvpay.getScheduleInfoId());
//
//		res = ps.executeUpdate();
//		
//	} catch (SQLException e) {
//		e.printStackTrace();
//	} finally {
//
//		JDBCTemplate.close(ps);
//	}
//	return res;
//
//}

//	@Override
//	public ReservationPay getMrno(Connection conn, User user) {
//		String sql = "";
//		sql += "SELECT *";
//		sql += " FROM reservation R, Musical M, usertable U, scheduleinfo S, reservationPay P";
//		sql += " WHERE S.mcno = M.MCNO";
//		sql += " AND P.resno = R.resno";
//		sql += " AND R.userid = U.userid";
//		sql += " AND S.SCHEDULEINFOID  = R.SCHEDULEINFOID";
//		sql += " AND P.userid = ? " ;
//		
//		
//		ReservationPay rsp = new ReservationPay();
//		
//			try {
//				ps=conn.prepareStatement(sql);
//				ps.setString(1, user.getUserid());
//
//				rs=ps.executeQuery();
//				
//				while(rs.next()) {
//					
//					rsp.setMrno(rs.getInt("mrno"));
//					rsp.setResno(rs.getInt("resno"));
//					rsp.setScheduleInfoId(rs.getInt("scheduleInfoId"));
//					rsp.setMcno(rs.getInt("mcno"));
//					rsp.setMcname(rs.getString("mcname"));
//					rsp.setScheduledate(rs.getString("scheduledate"));
//					rsp.setScheduletime(rs.getString("scheduletime"));
//					rsp.setUserid(rs.getString("userid"));
//					rsp.setResdate(rs.getTimestamp("resdate"));
//					rsp.setTicketcount(rs.getInt("ticketcount"));
//					rsp.setPayno(rs.getInt("payno"));
//					rsp.setPayment(rs.getString("payment"));
//					rsp.setPaymoney(rs.getInt("paymoney"));
//					
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				JDBCTemplate.close(rs);
//				JDBCTemplate.close(ps);
//			}
//	
//		return rsp;
//	}
//	
//	
//	@Override
//	public List<ReservationPay> searchMc(Connection conn, String keyword, User user) {
//
//		String sql = "";
//		
//		sql+= "SELECT *";
//		sql += " FROM reservation R, Musical M, usertable U, scheduleinfo S, reservationPay P";
//		sql += " WHERE S.mcno = M.MCNO";
//		sql += " AND P.resno = R.resno";
//		sql += " AND R.userid = U.userid";
//		sql += " AND S.SCHEDULEINFOID  = R.SCHEDULEINFOID";
//		sql += " AND P.userid = ?";
//		sql += " AND M.mcname LIKE '%"+keyword.trim()+"%'";
//		sql += " order by S.scheduledate DESC"; 
//		
//		List<ReservationPay> rspList = new ArrayList<>();
//		
//		try {
//			ps=conn.prepareStatement(sql);
//			ps.setString(1, user.getUserid());
//			ps.setString(2, keyword);
//			rs=ps.executeQuery();
//			
//			while (rs.next()) {
//				
//				ReservationPay rsp = new ReservationPay();
//				
//				rsp.setMrno(rs.getInt("mrno"));
//				rsp.setResno(rs.getInt("resno"));
//				rsp.setScheduleInfoId(rs.getInt("scheduleInfoId"));
//				rsp.setMcno(rs.getInt("mcno"));
//				rsp.setMcname(rs.getString("mcname"));
//				rsp.setScheduledate(rs.getString("scheduledate"));
//				rsp.setScheduletime(rs.getString("scheduletime"));
//				rsp.setUserid(rs.getString("userid"));
//				rsp.setResdate(rs.getTimestamp("resdate"));
//				rsp.setTicketcount(rs.getInt("ticketcount"));
//				rsp.setPayno(rs.getInt("payno"));
//				rsp.setPayment(rs.getString("payment"));
//				rsp.setPaymoney(rs.getInt("paymoney"));
//				
//				rspList.add(rsp);
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(ps);
//		}
//				
//		return rspList;
//	}
//	
//	@Override
//	public int selectCntRpBySearchMc(Connection conn, String keyword, User user) {
//		
//		String sql = "";
//		
//		sql+= "SELECT count(*) cnt";
//		sql += " FROM reservation R, Musical M, usertable U, scheduleinfo S, reservationPay P";
//		sql += " WHERE S.mcno = M.MCNO";
//		sql += " AND P.resno = R.resno";
//		sql += " AND R.userid = U.userid";
//		sql += " AND S.SCHEDULEINFOID  = R.SCHEDULEINFOID";
//		sql += " AND P.userid = ?";
//		sql += " AND M.mcname LIKE '%"+keyword.trim()+"%'";
//		sql += " order by S.scheduledate DESC"; 
//		
//		int cnt = 0;
//		
//		try {
//		ps=conn.prepareStatement(sql);
//		ps.setString(1, user.getUserid());
//		ps.setString(2, keyword);
//		
//		rs = ps.executeQuery();
//		
//		while(rs.next()) {
//			cnt=rs.getInt("cnt");
//		}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			JDBCTemplate.close(rs);
//		JDBCTemplate.close(ps);
//		}
//		System.out.println(cnt);
//		return cnt;
//	}
//	
//	@Override
//	public ReservationPay selectRpBySearchMc(Connection conn, User user, String keyword) {
//
//		String sql = "";
//		
//		sql+= "SELECT *";
//		sql += " FROM reservation R, Musical M, usertable U, scheduleinfo S, reservationPay P";
//		sql += " WHERE S.mcno = M.MCNO";
//		sql += " AND P.resno = R.resno";
//		sql += " AND R.userid = U.userid";
//		sql += " AND S.SCHEDULEINFOID  = R.SCHEDULEINFOID";
//		sql += " AND P.userid = ?";
//		sql += " AND M.mcname LIKE '%"+keyword.trim()+"%'";
//		sql += " order by S.scheduledate DESC"; 
//		
//		ReservationPay rsp = new ReservationPay();
//		
//		try {
//			ps=conn.prepareStatement(sql);
//			
//			ps.setString(1, user.getUserid());
//			
//			rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				
//				rsp.setMrno(rs.getInt("mrno"));
//				rsp.setResno(rs.getInt("resno"));
//				rsp.setScheduleInfoId(rs.getInt("scheduleInfoId"));
//				rsp.setMcno(rs.getInt("mcno"));
//				rsp.setMcname(rs.getString("mcname"));
//				rsp.setScheduledate(rs.getString("scheduledate"));
//				rsp.setScheduletime(rs.getString("scheduletime"));
//				rsp.setUserid(rs.getString("userid"));
//				rsp.setResdate(rs.getTimestamp("resdate"));
//				rsp.setTicketcount(rs.getInt("ticketcount"));
//				rsp.setPayno(rs.getInt("payno"));
//				rsp.setPayment(rs.getString("payment"));
//				rsp.setPaymoney(rs.getInt("paymoney"));
////				rsp.setSeatno(rs.getInt("seatno"));
//				
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			JDBCTemplate.close(rs);
//			JDBCTemplate.close(ps);
//		}
//		
//		return rsp;
//	}