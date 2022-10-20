package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import util.Paging;
import web.dao.face.MyReservationDao;
import web.dto.Musical;
import web.dto.MyReservation;
import web.dto.Reservation;
import web.dto.User;

public class MyReservationDaoImpl implements MyReservationDao {

	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public int selectCntAll(Connection conn) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM myreservation";
		
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
	public List<MyReservation> selectAll(Connection conn, Paging paging, User user, Musical mc, Reservation res) {
		
		String sql = "";
		sql += "SELECT rownum, R.resno, R.userid, Y.mcno";
		sql += " FROM reservation R, myreservationY, usertable U";
		sql += " WHERE rownum BETWEEN ? AND ?";
		sql += " AND R.resno = Y.resno";
		sql += " AND R.userid = U.userid";
		sql += " AND R.userid =?";
		
		List<MyReservation> myResList = new ArrayList<>();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			ps.setString(3, user.getUserid());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				MyReservation my = new MyReservation();
				
				my.setMcno(rs.getInt("mcno"));
				my.setMcname(rs.getString("mcname"));
				my.setPayment(rs.getString("payment"));
				my.setPaymoney(rs.getInt("paymoney"));
				my.setResdate(rs.getTimestamp("resdate"));
				my.setResno(rs.getInt("resno"));
				my.setScheduledate(rs.getDate("scheduledate"));
				my.setScheduleInfoid(rs.getInt("scheduleInfoid"));
				my.setSeatno(rs.getInt("seat"));
				
				myResList.add(my);
				
			}
					
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return myResList;
	}
	
	@Override
	public int selectCntmyResByMcUser(Connection conn, MyReservation myRes, User user, Musical mc, Reservation res) {

		String sql = "";
		sql += " SELECT count(*) cnt";
		sql += " FROM myReservation Y, usertable U, musical M, reservation R";
		sql += " WHERE R.userid = U.USERID"; 
		sql += " AND R.resno = Y.resno";
		sql += " AND Y.mcno = M.mcno";
		sql += " AND U.userid=?";
		
		int cnt = 0;
		
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUserid());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt("cnt");
				
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
	public MyReservation selectMyResByMcName(Connection conn, MyReservation myRes, User user, Musical mc,
			Reservation res) {

		String sql = "";
		sql += " SELECT * ";
		sql += " FROM myReservation Y, usertable U, musical M, reservation R";
		sql += " WHERE R.userid = U.USERID"; 
		sql += " AND R.resno = Y.resno";
		sql += " AND Y.mcno = M.mcno";
		sql += " AND U.userid=?";
		
		MyReservation my = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserid());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				my = new MyReservation();
				
				my.setMcno(rs.getInt("mcno"));
				my.setMcname(rs.getString("mcname"));
				my.setPayment(rs.getString("payment"));
				my.setPaymoney(rs.getInt("paymoney"));
				my.setResdate(rs.getTimestamp("resdate"));
				my.setResno(rs.getInt("resno"));
				my.setScheduledate(rs.getDate("scheduledate"));
				my.setScheduleInfoid(rs.getInt("scheduleInfoid"));
				my.setSeatno(rs.getInt("seat"));
				
				
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return my;
	}
}
