package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import util.Paging;
import web.dao.face.UserBoardDao;
import web.dto.UserBoard;

public class UserBoardDaoImpl implements UserBoardDao {

	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public int selectCntAll(Connection conn) {

		String sql = "";
		sql += "SELECT count(*) cnt FROM usertable";
		
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
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
	public List<UserBoard> selectAll(Connection conn, Paging paging) {
		
		String sql = "";
		
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, U.* FROM (";
		sql += "		SELECT";
		sql += "			userid, username, userpw, gender";
		sql += "			, userbirth, uphone, address, email";
		sql += "		FROM usertable";
		sql += "	) U";
		sql += " ) USERTABLE";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<UserBoard> userList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				UserBoard u = new UserBoard(); //결과값 저장 객체
				
				//결과값 한 행씩 처리
			 	u.setUsername(rs.getString("username"));
			 	u.setUserid(rs.getString("userid"));
			 	u.setUserpw(rs.getString("userpw"));
			 	u.setGender(rs.getString("gender"));
			 	u.setUserbirth(rs.getString("userbirth"));
			 	u.setUphone(rs.getString("uphone"));
			 	u.setAddress(rs.getString("address"));
			 	u.setEmail(rs.getString("email"));
			 
				//리스트에 결과값 저장
			 	userList.add(u);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return userList;
	}
}
