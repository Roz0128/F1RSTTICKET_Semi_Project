package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import util.Paging;
import web.dao.face.ReviewDao;
import web.dto.Comment;
import web.dto.Review;
import web.dto.ReviewFile;

public class ReviewDaoImpl implements ReviewDao {

	//SQL수행 ,결과 객체 생성
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public int selectCntAll(Connection conn) {
		//SQL 작성
		String sql = "";
		sql += "SELECT count(*) cnt FROM review";
		
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
	public List<Review> selectAll(Connection conn, Paging paging) {
		
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, N.* FROM (";
		sql += "		SELECT";
		sql += "			R.reviewno, R.userid, R.mcno, M.mcimg, M.mcname, R.reviewtitle";
		sql += "			, R.reviewcontent, R.reviewscope, R.writedate";
		sql += "		FROM review R";
		sql += "		INNER JOIN musical M";
		sql += "		 ON R.mcno = M.mcno";
		sql += "		ORDER BY R.reviewno DESC";
		sql += "	) N";
		sql += " ) REVIEW";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		List<Review> reviewList = new ArrayList<>();
		
		try {
			
			//--- SQL 수행 객체 생성 ---
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			//--- SQL 수행 및 결과 저장 ---
			rs = ps.executeQuery();
			
			//--- 조회 결과 처리 ---
			while( rs.next() ) {
				Review r = new Review();
				
				r.setReviewno( rs.getInt("reviewno") );
				r.setUserid( rs.getString("userid") );
				r.setMcno( rs.getInt("mcno") );
				r.setReviewtitle( rs.getString("reviewtitle") );
				r.setReviewcontent( rs.getString("reviewcontent") );
				r.setReviewscope( rs.getInt("reviewscope") );
				r.setWritedate( rs.getDate("writedate") );
				
				//조인테이블 조회
				r.setMcimg( rs.getString("mcimg") );
				r.setMcname( rs.getString("mcname") );
				
				reviewList.add(r);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//--- 최종 결과 반환 ---
		return reviewList;		
		
	}
	
	@Override
	public Review selectReviewByReviewno(Connection conn, Review reviewno) {
		
		String sql = "";
		sql += "SELECT";
		sql += "	R.reviewno, R.userid, R.mcno, M.mcimg, M.mcname, R.reviewtitle";
		sql += "	, R.reviewcontent, R.reviewscope, R.writedate";
		sql += " FROM review R";
		sql += " INNER JOIN musical M";
		sql += "  ON R.mcno = M.mcno";
		sql += " WHERE reviewno = ?";
		
		Review review = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reviewno.getReviewno());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				review = new Review();
				
				review.setReviewno( rs.getInt("reviewno") );
				review.setUserid( rs.getString("userid") );
				review.setMcno( rs.getInt("mcno") );
				review.setReviewtitle( rs.getString("reviewtitle") );
				review.setReviewcontent( rs.getString("reviewcontent") );
				review.setReviewscope( rs.getInt("reviewscope") );
				review.setWritedate( rs.getDate("writedate") );
				
				//조인테이블 가져오기
				review.setMcimg( rs.getString("mcimg") );
				review.setMcname( rs.getString("mcname") );
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return review;		
		
	}
	
	@Override
	public ReviewFile selectFile(Connection conn, Review viewReview) {
		
		String sql = "";
		sql += "SELECT"; 
		sql += "	fileno, reviewno, originname, storedname, filesize, writedate";
		sql += " FROM reviewfile";
		sql += " WHERE reviewno = ?";
		sql += " ORDER BY fileno";
		
		ReviewFile reviewFile = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, viewReview.getReviewno());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				reviewFile = new ReviewFile();
				
				reviewFile.setFileno( rs.getInt("fileno") );
				reviewFile.setReviewno( rs.getInt("reviewno") );
				reviewFile.setOriginname( rs.getString("originname") );
				reviewFile.setStoredname( rs.getString("storedname") );
				reviewFile.setFilesize( rs.getInt("filesize") );
				reviewFile.setWritedate( rs.getDate("writedate") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return reviewFile;		
	}
	
	@Override
	public int selectNextReviewno(Connection conn) {
		
		String sql = "";
		sql += "SELECT review_seq.nextval FROM dual";

		int nextReviewno = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				nextReviewno = rs.getInt("nextval");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return nextReviewno;
		
	}
	
	@Override
	public int insert(Connection conn, Review review) {
		
		String sql = "";
		sql += "INSERT INTO review ( reviewno, userid, mcno, reviewtitle, reviewcontent, reviewscope ) ";
		sql += " VALUES ( ?, ?, ?, ?, ?, ? )";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, review.getReviewno());
			ps.setString(2, review.getUserid());
			ps.setInt(3, review.getMcno());
			ps.setString(4, review.getReviewtitle());
			ps.setString(5, review.getReviewcontent());
			ps.setInt(6, review.getReviewscope());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;

	}
	
	@Override
	public int insertFile(Connection conn, ReviewFile reviewFile) {
		
		String sql = "";
		sql += "INSERT INTO reviewFile ( fileno, reviewno, originname, storedname, filesize )";
		sql += " VALUES ( reviewfile_seq.nextval, ?, ?, ?, ? )";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, reviewFile.getReviewno());
			ps.setString(2, reviewFile.getOriginname());
			ps.setString(3, reviewFile.getStoredname());
			ps.setInt(4, reviewFile.getFilesize());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;		
		
	}
	
	@Override
	public int update(Connection conn, Review review) {
		
		String sql = "";
		sql += "UPDATE review";
		sql += "	SET";
		sql += "		reviewtitle = ?";
		sql += "		, reviewcontent = ?";
		sql += "		, reviewscope = ?";
		sql += " WHERE reviewno = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, review.getReviewtitle());
			ps.setString(2, review.getReviewcontent());
			ps.setInt(3, review.getReviewscope());
			ps.setInt(4, review.getReviewno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	@Override
	public int deleteFile(Connection conn, Review review) {
		
		String sql = "";
		sql += "DELETE reviewfile";
		sql += " WHERE reviewno = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, review.getReviewno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	@Override
	public int deleteComment(Connection conn, Review review) {
		
		String sql = "";
		sql += "DELETE commenttable";
		sql += " WHERE reviewno = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, review.getReviewno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
		
	}
	
	@Override
	public int delete(Connection conn, Review review) {
		
		String sql = "";
		sql += "DELETE review";
		sql += " WHERE reviewno = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, review.getReviewno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
		
	}
	
}
