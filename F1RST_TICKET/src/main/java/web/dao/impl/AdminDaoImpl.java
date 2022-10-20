package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.JDBCTemplate;
import web.dao.face.AdminDao;
import web.dto.Admin;
import web.dto.Musical;

public class AdminDaoImpl implements AdminDao {

	private PreparedStatement ps;
	private ResultSet rs;
	
	// 관리자 로그인
	@Override
	public int selectCntAdminByAdminidaAdminpw(Connection conn, Admin admin) {
		
		String sql ="";
		sql += "SELECT count(*) cnt FROM admin";
		sql += " WHERE adminid = ?";
		sql += "  AND adminpw = ?";
		
		int cnt = 0;
		
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, admin.getAdminid());
			ps.setString(2, admin.getAdminpw());
			
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
	public Admin selectAdminByAdminid(Connection conn, Admin admin) {

		String sql = "";
		sql += "SELECT * FROM admin";
		sql += " WHERE adminid = ?";
		
		Admin ad = null;
		
		try {
			ps=conn.prepareStatement(sql);
			
			ps.setString(1, admin.getAdminid());
			
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				ad = new Admin();
				
				ad.setAdminid(rs.getString("adminid"));
				ad.setAdminpw(rs.getString("adminpw"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return ad;
	}
	
	@Override
	public int delete(Connection conn, Musical musical) {

		String sql = "";
		sql += "DELETE musical";
		sql += " WHERE mcno = ?";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, musical.getMcno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
		
	}
}
