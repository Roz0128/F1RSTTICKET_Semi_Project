package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import util.Paging;
import web.dao.face.NoticeDao;
import web.dto.Notice;

public class NoticeDaoImpl implements NoticeDao {
	
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public int selectCntAll(Connection conn) {
		//SQL 작성
		String sql = "";
		sql += "SELECT count(*) cnt FROM notice";
		
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
	public List<Notice> selectAll(Connection conn, Paging paging) {
		
		//--- SQL ---
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, N.* FROM (";
		sql += "		SELECT";
		sql += "			notino, adminid, notitype, notititle";
		sql += "			, opendate, noticontent, notihit, notidate";
		sql += "		FROM notice";
		sql += "	ORDER BY notino DESC";
		sql += "	) N";
		sql += " ) NOTICE";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//--- 조회 결과 저장할 List 객체 ---
		List<Notice> noticeList = new ArrayList<>();
		
		try {
			
			//--- SQL 수행 객체 생성 ---
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			//--- SQL 수행 및 결과 저장 ---
			rs = ps.executeQuery();
			
			//--- 조회 결과 처리 ---
			while( rs.next() ) {
				Notice n = new Notice();
				
				n.setNotino( rs.getInt("notino") );
				n.setAdminid( rs.getString("adminid") );
				n.setNotitype( rs.getString("notitype") );
				n.setNotititle( rs.getString("notititle") );
				n.setOpendate( rs.getString("opendate") );
				n.setNoticontent( rs.getString("noticontent") );
				n.setNotihit( rs.getInt("notihit") );
				n.setNotidate( rs.getDate("notidate") );
				
				noticeList.add(n);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//--- 최종 결과 반환 ---
		return noticeList;

	}
	
	@Override
	public int updateHit(Connection conn, Notice notino) {
		
		String sql = "";
		sql += "UPDATE notice";
		sql += "	SET notihit = notihit + 1";
		sql += " WHERE notino = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, notino.getNotino());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	@Override
	public Notice selectNoticeByNotino(Connection conn, Notice notino) {
		
		String sql = "";
		sql += "SELECT";
		sql += "	notino, adminid, notitype, notititle";
		sql += "	, notidate, noticontent, notihit, opendate";
		sql += " FROM notice";
		sql += " WHERE notino = ?";
		
		Notice notice = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, notino.getNotino());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				notice = new Notice();
				
				notice.setNotino( rs.getInt("notino") );
				notice.setAdminid( rs.getString("adminid") );
				notice.setNotitype( rs.getString("notitype") );
				notice.setNotititle( rs.getString("notititle") );
				notice.setNotidate( rs.getDate("notidate") );
				notice.setNoticontent( rs.getString("noticontent") );
				notice.setNotihit( rs.getInt("notihit") );
				notice.setOpendate( rs.getString("opendate") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return notice;
	}
	
	@Override
	public int insert(Connection conn, Notice notice) {
		
		String sql = "";
		sql += "INSERT INTO notice (notino, adminid, notitype, notititle, opendate, noticontent, notihit )";
		sql += " VALUES ( ?, ?, ?, ?, ?, ?, 0 )";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, notice.getNotino());
			ps.setString(2, notice.getAdminid());
			ps.setString(3, notice.getNotitype());
			ps.setString(4, notice.getNotititle());
			ps.setString(5, notice.getOpendate());
			ps.setString(6, notice.getNoticontent());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	@Override
	public int selectNextNotino(Connection conn) {
		
		String sql = "";
		sql += "SELECT notice_seq.nextval FROM dual";
		
		int nextNotino = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				nextNotino = rs.getInt("nextval");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return nextNotino;
	}
	
	@Override
	public int update(Connection conn, Notice notice) {
		
		String sql = "";
		sql += "UPDATE notice";
		sql += "	SET";
		sql += "		notititle = ?";
		sql += "		, notitype = ?";
		sql += "		, opendate = ?";
		sql += "		, noticontent = ?";
		sql += " WHERE notino = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, notice.getNotititle());
			ps.setString(2, notice.getNotitype());
			ps.setString(3, notice.getOpendate());
			ps.setString(4, notice.getNoticontent());
			ps.setInt(5, notice.getNotino());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}		
		
		return res;
	}
	
	@Override
	public int delete(Connection conn, Notice notice) {
		
		String sql = "";
		sql += "DELETE notice";
		sql += " WHERE notino = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, notice.getNotino());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}		
		
		return res;
	}
	
}
