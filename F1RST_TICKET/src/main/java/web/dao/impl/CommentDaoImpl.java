package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import util.Paging;
import web.dao.face.CommentDao;
import web.dto.Comment;
import web.dto.Review;

public class CommentDaoImpl implements CommentDao {

	//객체생성
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public int selectCntAll(Connection conn) {
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM commenttable";
		
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
	public int selectCntAll(Connection conn, int reviewno) {
		
		String sql = "";
		sql += "SELECT count(*) cnt FROM commenttable";
		sql += " WHERE reviewno = ?";
		
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reviewno);
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
	public List<Comment> selectComment(Connection conn, Paging paging, Review viewReview) {
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, C.* FROM (";
		sql += "		SELECT cmno, userid, reviewno, content, writedate";
		sql += "		 FROM commenttable";
		sql += "		 WHERE reviewno = ?";
		sql += "		 ORDER BY cmno DESC";
		sql += "	) C";
		sql += " ) COMMENTTABLE";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Comment> commentList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, viewReview.getReviewno());
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				
				Comment c = new Comment();
				
				c.setCmno( rs.getInt("cmno") );
				c.setUserid( rs.getString("userid") );
				c.setReviewno( rs.getInt("reviewno") );
				c.setContent( rs.getString("content") );
				c.setWritedate( rs.getDate("writedate") );
				
				commentList.add(c);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return commentList;
	}
	
	@Override
	public int selectNextCmno(Connection conn) {
		
		String sql = "";
		sql += "SELECT commenttable_seq.nextval FROM dual";
		
		int nextCmno = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				nextCmno = rs.getInt("nextval");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return nextCmno;
	}
	
	@Override
	public int insertComment(Connection conn, Comment comment) {
		
		String sql = "";
		sql += "INSERT INTO commenttable ( cmno, userid, reviewno, content)";
		sql += " VALUES ( ?, ?, ?, ?)";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, comment.getCmno());
			ps.setString(2, comment.getUserid());
			ps.setInt(3, comment.getReviewno());
			ps.setString(4, comment.getContent());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	
	
}
