package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import util.Paging;
import web.dao.face.McDao;
import web.dto.Like;
import web.dto.Musical;

public class McDaoImpl implements McDao {
	
	private PreparedStatement ps; //SQL수행 객체
	private ResultSet rs; //SQL조회 결과 객체

	@Override
	public List<Musical> selectAll(Connection conn) {
		
		String sql = "";
		sql += "SELECT * FROM musical";
		sql += " ORDER BY mcno DESC";
		
		//결과 저장할 List객체
		List<Musical> musicalList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회결과 처리
			while (rs.next()) {
				Musical musical = new Musical(); //결과값 저장 객체
				
				musical.setMcno(rs.getInt("mcno"));
				musical.setMcname(rs.getString("mcname"));
				musical.setMcage(rs.getString("mcage"));
				musical.setMctime(rs.getString("mctime"));
				musical.setMcstart(rs.getString("mcstart"));
				musical.setMcend(rs.getString("mcend"));
				musical.setMcact(rs.getString("mcact"));
				musical.setMcloc(rs.getString("mcloc"));
				musical.setMclike(rs.getInt("mclike"));
				musical.setMcimg(rs.getString("mcimg"));
				musical.setMcimgcas(rs.getString("mcimgcas"));
				musical.setMcimginfo(rs.getString("mcimginfo"));
				musical.setMcimgchk(rs.getString("mcimgchk"));
				musical.setMcimgsale(rs.getString("mcimgsale"));
				
				//리스트에 결과값 저장
				musicalList.add(musical);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		//결과값 반환
		return musicalList;
	}
	
	@Override
	public List<Musical> selectNew(Connection conn) {

		String sql = "";
		sql += "SELECT * FROM (SELECT * FROM musical ORDER BY mcno DESC) WHERE ROWNUM < 8";
		
		//결과 저장할 List객체
		List<Musical> mcNewList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회결과 처리
			while (rs.next()) {
				Musical musical = new Musical(); //결과값 저장 객체
				
				musical.setMcno(rs.getInt("mcno"));
				musical.setMcname(rs.getString("mcname"));
				musical.setMcage(rs.getString("mcage"));
				musical.setMctime(rs.getString("mctime"));
				musical.setMcstart(rs.getString("mcstart"));
				musical.setMcend(rs.getString("mcend"));
				musical.setMcact(rs.getString("mcact"));
				musical.setMcloc(rs.getString("mcloc"));
				musical.setMclike(rs.getInt("mclike"));
				musical.setMcimg(rs.getString("mcimg"));
				musical.setMcimgcas(rs.getString("mcimgcas"));
				musical.setMcimginfo(rs.getString("mcimginfo"));
				musical.setMcimgchk(rs.getString("mcimgchk"));
				musical.setMcimgsale(rs.getString("mcimgsale"));
				
				//리스트에 결과값 저장
				mcNewList.add(musical);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		//결과값 반환
		return mcNewList;
	}
	
	@Override
	public List<Musical> selectLike(Connection conn) {
		String sql = "";
		sql += "SELECT * FROM (SELECT * FROM musical ORDER BY mclike DESC) ";
		
		//결과 저장할 List객체
		List<Musical> mcLikeList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회결과 처리
			while (rs.next()) {
				Musical musical = new Musical(); //결과값 저장 객체
				
				musical.setMcno(rs.getInt("mcno"));
				musical.setMcname(rs.getString("mcname"));
				musical.setMcage(rs.getString("mcage"));
				musical.setMctime(rs.getString("mctime"));
				musical.setMcstart(rs.getString("mcstart"));
				musical.setMcend(rs.getString("mcend"));
				musical.setMcact(rs.getString("mcact"));
				musical.setMcloc(rs.getString("mcloc"));
				musical.setMclike(rs.getInt("mclike"));
				musical.setMcimg(rs.getString("mcimg"));
				musical.setMcimgcas(rs.getString("mcimgcas"));
				musical.setMcimginfo(rs.getString("mcimginfo"));
				musical.setMcimgchk(rs.getString("mcimgchk"));
				musical.setMcimgsale(rs.getString("mcimgsale"));
				
				//리스트에 결과값 저장
				mcLikeList.add(musical);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		//결과값 반환
		return mcLikeList;
	}
	
	@Override
	public List<Musical> selectMd(Connection conn) {
		String sql = "";
		sql += "SELECT * FROM musical WHERE mcimg IS NOT NULL ORDER BY mcno DESC";
		
		//결과 저장할 List객체
		List<Musical> mcMdList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회결과 처리
			while (rs.next()) {
				Musical musical = new Musical(); //결과값 저장 객체
				
				musical.setMcno(rs.getInt("mcno"));
				musical.setMcname(rs.getString("mcname"));
				musical.setMcage(rs.getString("mcage"));
				musical.setMctime(rs.getString("mctime"));
				musical.setMcstart(rs.getString("mcstart"));
				musical.setMcend(rs.getString("mcend"));
				musical.setMcact(rs.getString("mcact"));
				musical.setMcloc(rs.getString("mcloc"));
				musical.setMclike(rs.getInt("mclike"));
				musical.setMcimg(rs.getString("mcimg"));
				musical.setMcimgcas(rs.getString("mcimgcas"));
				musical.setMcimginfo(rs.getString("mcimginfo"));
				musical.setMcimgchk(rs.getString("mcimgchk"));
				musical.setMcimgsale(rs.getString("mcimgsale"));
				
				//리스트에 결과값 저장
				mcMdList.add(musical);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		//결과값 반환
		return mcMdList;
	}
	
	@Override
	public Musical selectMusicalByMusical(Connection conn, Musical mcno) {
		String sql = "";
		sql += "SELECT *  FROM musical WHERE mcno = ?";
		
		Musical viewMC = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, mcno.getMcno());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				viewMC = new Musical();
				
				viewMC.setMcno(rs.getInt("mcno"));
				viewMC.setMcname(rs.getString("mcname"));
				viewMC.setMcage(rs.getString("mcage"));
				viewMC.setMctime(rs.getString("mctime"));
				viewMC.setMcstart(rs.getString("mcstart"));
				viewMC.setMcend(rs.getString("mcend"));
				viewMC.setMcact(rs.getString("mcact"));
				viewMC.setMcloc(rs.getString("mcloc"));
				viewMC.setMclike(rs.getInt("mclike"));
				viewMC.setMcimg(rs.getString("mcimg"));
				viewMC.setMcimgcas(rs.getString("mcimgcas"));
				viewMC.setMcimginfo(rs.getString("mcimginfo"));
				viewMC.setMcimgchk(rs.getString("mcimgchk"));
				viewMC.setMcimgsale(rs.getString("mcimgsale"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return viewMC;
	}
	
	@Override
	public List<Musical> searchList(Connection conn, String keyword) {
		//결과 저장할 List객체
		List<Musical> mcSearchList = new ArrayList<>();
		
		String sql = "";
		sql += "SELECT * FROM musical WHERE mcname ";
		
		try {
			 if(keyword != null && !keyword.equals("") ){
	                sql +=" LIKE '%"+keyword+"%' order by mcno desc";
	            }


			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회결과 처리
			while (rs.next()) {
				Musical musical = new Musical(); //결과값 저장 객체
				
				musical.setMcno(rs.getInt("mcno"));
				musical.setMcname(rs.getString("mcname"));
				musical.setMcage(rs.getString("mcage"));
				musical.setMctime(rs.getString("mctime"));
				musical.setMcstart(rs.getString("mcstart"));
				musical.setMcend(rs.getString("mcend"));
				musical.setMcact(rs.getString("mcact"));
				musical.setMcloc(rs.getString("mcloc"));
				musical.setMclike(rs.getInt("mclike"));
				musical.setMcimg(rs.getString("mcimg"));
				musical.setMcimgcas(rs.getString("mcimgcas"));
				musical.setMcimginfo(rs.getString("mcimginfo"));
				musical.setMcimgchk(rs.getString("mcimgchk"));
				musical.setMcimgsale(rs.getString("mcimgsale"));
				
				//리스트에 결과값 저장
				mcSearchList.add(musical);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		//결과값 반환
		return mcSearchList;
		
	}
	
	@Override
	public int selectCntisLike(Connection conn, Like like) {
		String sql = "";
		sql += "SELECT count(*) cnt FROM liketable";
		sql += " WHERE userid = ?";
		sql += "	AND mcno = ?";
		
		int cnt = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, like.getUserid());
			ps.setInt(2, like.getMcno());
			
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
	public int deleteLikes(Connection conn, Like like) {
		String sql = "";
		sql += "DELETE liketable";
		sql += " WHERE userid = ?";
		sql += "	AND mcno = ?";
		
		int res = 0;

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, like.getUserid());
			ps.setInt(2, like.getMcno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	@Override
	public int insertLikes(Connection conn, Like like) {
		String sql = "";
		sql += "INSERT INTO liketable (likeno, userid, mcno, likechk )";
		sql += " VALUES (like_seq.nextval, ?, ?, ? )";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, like.getUserid());
			ps.setInt(2, like.getMcno());
			ps.setInt(3, like.getLikechk());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	@Override
	public int updateLikedmm(Connection conn, Like like) {
		String sql = "";
		sql += "UPDATE musical";
		sql += "	SET mclike = mclike - 1 ";
		sql += " WHERE mcno = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, like.getMcno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	
	@Override
	public int updateLikedpp(Connection conn, Like like) {
		String sql = "";
		sql += "UPDATE musical";
		sql += "	SET mclike = mclike + 1 ";
		sql += " WHERE mcno = ?";
		
		int res = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, like.getMcno());
			
			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	@Override
	public Musical selectMusicalLike(Connection conn, Like like) {
		String sql = "";
		sql += "SELECT * ";
		sql += "	FROM ( musical INNER JOIN liketable ";
		sql += "	ON musical.mcno = liketable.mcno )";
		sql += " WHERE liketable.mcno = ?";

		Musical viewMc = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, like.getMcno());
			
			rs = ps.executeQuery();
			
			while( rs.next() ) {
				viewMc = new Musical();
				
				viewMc.setMcno(rs.getInt("mcno"));
				viewMc.setMcname(rs.getString("mcname"));
				viewMc.setMcage(rs.getString("mcage"));
				viewMc.setMctime(rs.getString("mctime"));
				viewMc.setMcstart(rs.getString("mcstart"));
				viewMc.setMcend(rs.getString("mcend"));
				viewMc.setMcact(rs.getString("mcact"));
				viewMc.setMcloc(rs.getString("mcloc"));
				viewMc.setMclike(rs.getInt("mclike"));
				viewMc.setMcimg(rs.getString("mcimg"));
				viewMc.setMcimgcas(rs.getString("mcimgcas"));
				viewMc.setMcimginfo(rs.getString("mcimginfo"));
				viewMc.setMcimgchk(rs.getString("mcimgchk"));
				viewMc.setMcimgsale(rs.getString("mcimgsale"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		return viewMc;
	}
	
	@Override
	public List<Musical> selectAllpage(Connection conn, Paging paging) {
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		SELECT *";
		sql += "		FROM musical";
		sql += "		ORDER BY mcno DESC";
		sql += "	) B";
		sql += " ) musical";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//결과 저장할 List
		List<Musical> musicalList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Musical b = new Musical(); //결과값 저장 객체
				
				//결과값 한 행씩 처리
				b.setMcno(rs.getInt("mcno"));
				b.setMcname(rs.getString("mcname"));
				b.setMcage(rs.getString("mcage"));
				b.setMctime(rs.getString("mctime"));
				b.setMcstart(rs.getString("mcstart"));
				b.setMcend(rs.getString("mcend"));
				b.setMcact(rs.getString("mcact"));
				b.setMcloc(rs.getString("mcloc"));
				b.setMclike(rs.getInt("mclike"));
				b.setMcimg(rs.getString("mcimg"));
				b.setMcimgcas(rs.getString("mcimgcas"));
				b.setMcimginfo(rs.getString("mcimginfo"));
				b.setMcimgchk(rs.getString("mcimgchk"));
				b.setMcimgsale(rs.getString("mcimgsale"));
				
				//리스트에 결과값 저장
				musicalList.add(b);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return musicalList;
	}
	
	@Override
	public int selectCntAllpage(Connection conn) {
		//SQL 작성
		String sql = "";
		sql += "SELECT count(*) cnt FROM musical";
		
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
	public List<Musical> selectLikepage(Connection conn, Paging paging) {
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		SELECT *";
		sql += "		FROM musical";
		sql += "		ORDER BY mclike DESC";
		sql += "	) B";
		sql += " ) musical";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//결과 저장할 List
		List<Musical> mcLikeList = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Musical b = new Musical(); //결과값 저장 객체
				
				//결과값 한 행씩 처리
				b.setMcno(rs.getInt("mcno"));
				b.setMcname(rs.getString("mcname"));
				b.setMcage(rs.getString("mcage"));
				b.setMctime(rs.getString("mctime"));
				b.setMcstart(rs.getString("mcstart"));
				b.setMcend(rs.getString("mcend"));
				b.setMcact(rs.getString("mcact"));
				b.setMcloc(rs.getString("mcloc"));
				b.setMclike(rs.getInt("mclike"));
				b.setMcimg(rs.getString("mcimg"));
				b.setMcimgcas(rs.getString("mcimgcas"));
				b.setMcimginfo(rs.getString("mcimginfo"));
				b.setMcimgchk(rs.getString("mcimgchk"));
				b.setMcimgsale(rs.getString("mcimgsale"));
				
				//리스트에 결과값 저장
				mcLikeList.add(b);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return mcLikeList;
	}
	
	@Override
	public List<Musical> searchpageList(Connection conn, String keyword, Paging paging) {
		
		//결과 저장할 List
		List<Musical> mcSearchList = new ArrayList<>();
		
		//SQL작성
		String sql = "";
		sql += "SELECT * FROM (";
		sql += "	SELECT rownum rnum, B.* FROM (";
		sql += "		SELECT *";
		sql += "		FROM musical WHERE mcname ";
		
		try {
			
			if(keyword != null && !keyword.equals("") ){
                sql +=" LIKE '%"+keyword+"%' order by mcno desc";
        		sql += "	) B";
        		sql += " ) musical";
        		sql += " WHERE rnum BETWEEN ? AND ?";
            }
			
			ps = conn.prepareStatement(sql); //SQL수행 객체
			
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery(); //SQL수행 및 결과 집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				Musical b = new Musical(); //결과값 저장 객체
				
				//결과값 한 행씩 처리
				b.setMcno(rs.getInt("mcno"));
				b.setMcname(rs.getString("mcname"));
				b.setMcage(rs.getString("mcage"));
				b.setMctime(rs.getString("mctime"));
				b.setMcstart(rs.getString("mcstart"));
				b.setMcend(rs.getString("mcend"));
				b.setMcact(rs.getString("mcact"));
				b.setMcloc(rs.getString("mcloc"));
				b.setMclike(rs.getInt("mclike"));
				b.setMcimg(rs.getString("mcimg"));
				b.setMcimgcas(rs.getString("mcimgcas"));
				b.setMcimginfo(rs.getString("mcimginfo"));
				b.setMcimgchk(rs.getString("mcimgchk"));
				b.setMcimgsale(rs.getString("mcimgsale"));
				
				//리스트에 결과값 저장
				mcSearchList.add(b);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return mcSearchList;
	}
}
