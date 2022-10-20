package web.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import web.dao.face.AdminDao;
import web.dao.impl.AdminDaoImpl;
import web.dto.Admin;
import web.dto.Musical;
import web.service.face.AdminService;

public class AdminServiceImpl implements AdminService {

	// DAO 객체
	private AdminDao adminDao = new AdminDaoImpl();
	
	@Override
	public Admin getLoginAdmin(HttpServletRequest req) {
		Admin admin = new Admin();
		
		admin.setAdminid(req.getParameter("adminid"));
		admin.setAdminpw(req.getParameter("adminpw"));
		
		return admin;
	}
	
	@Override
	public boolean login(Admin admin) {

		// 관리자 로그인 성공
		if(adminDao.selectCntAdminByAdminidaAdminpw(JDBCTemplate.getConnection(), admin) > 0) {
			return true;
		}
		
		// 관리자 로그인 실패
		return false;
	}
	
	@Override
	public Admin info(Admin admin) {
		return adminDao.selectAdminByAdminid(JDBCTemplate.getConnection(), admin);
	}
	
	@Override
	public Musical getMusicalno(HttpServletRequest req) {
		//전달파라미터를 저장할 객체 생성
		Musical musical = new Musical();
		
		String param = req.getParameter("mcno");
		if( param != null && !"".equals(param) ) {
			musical.setMcno( Integer.parseInt(param) );
		}
		
		return musical;
	}
	
	@Override
	public boolean delete(Musical musical) {
		Connection conn = JDBCTemplate.getConnection();
		
		//뮤지컬 삭제
		if(adminDao.delete(conn, musical) > 0 ) {
			JDBCTemplate.commit(conn);
			return true;
			
		} else {
			JDBCTemplate.rollback(conn);
		}
			return false;
	}
}
