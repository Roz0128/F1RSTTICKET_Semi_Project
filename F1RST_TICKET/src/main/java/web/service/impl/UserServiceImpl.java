package web.service.impl;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import web.dao.face.UserDao;
import web.dao.impl.UserDaoImpl;
import web.dto.User;
import web.service.face.UserService;

public class UserServiceImpl implements UserService {

	// DAO 객체
	private UserDao userDao = new UserDaoImpl();

	// 로그인
	@Override
	public User getLoginUser(HttpServletRequest req) {

		User user = new User();

		user.setUserid(req.getParameter("userid"));
		user.setUserpw(req.getParameter("userpw"));

		return user;
	}

	@Override
	public boolean login(User user) {

		// 로그인 인증 성공
		if (userDao.selectCntUserByUseridUserpw(JDBCTemplate.getConnection(), user) > 0) {
			return true;
		}
		// 로그인 인증 실패
		return false;
	}

	@Override
	public User info(User user) {
		return userDao.selectUserByUserid(JDBCTemplate.getConnection(), user);
	}

	// 회원가입
	@Override
	public User getJoinUser(HttpServletRequest req) {

		User user = new User();

		user.setUsername(req.getParameter("username"));
		user.setUserid(req.getParameter("userid"));
		user.setUserpw(req.getParameter("userpw"));
		user.setGender(req.getParameter("gender"));
		user.setUserbirth(req.getParameter("userbirth"));
		user.setUphone(req.getParameter("uphone"));
		user.setAddress(req.getParameter("address"));
		user.setEmail(req.getParameter("email"));

		return user;
	}

	@Override
	public void Join(User user) {

		Connection conn = JDBCTemplate.getConnection();

		if (userDao.insert(conn, user) > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

	}

	// 아이디 찾기
	@Override
	public User getFindUserId(HttpServletRequest req) {

		User user = new User();

		user.setUsername(req.getParameter("findIdName"));
		user.setEmail(req.getParameter("findIdEmail"));

		return user;
	}

	@Override
	public boolean findId(User user) {
		// 회원 정보 찾기 성공
		if (userDao.selectCntUserByUsernameEmail(JDBCTemplate.getConnection(), user) > 0) {
			return true;
		}
		// 회원 정보 찾기 실패
		return false;
	}

	@Override
	public User infoUser(User user) {
		return userDao.selectUserByUsernameEmail(JDBCTemplate.getConnection(), user);
	}

	// 비밀번호 찾기
	@Override
	public User getFindUserPw(HttpServletRequest req) {
		User user = new User();

		user.setUserid(req.getParameter("findPwId"));
		user.setUsername(req.getParameter("findPwName"));
		user.setEmail(req.getParameter("findPwEmail"));

		return user;
	}

	@Override
	public boolean findPw(User user) {
		// 회원 정보 찾기 성공
		if (userDao.selectCntUserByUseridUsernameEmail(JDBCTemplate.getConnection(), user) > 0) {
			return true;
		}
		// 회원 정보 찾기 실패
		return false;
	}

	@Override
	public User infoUserpw(User user) {
		return userDao.selectUserByUseridUsernameEmail(JDBCTemplate.getConnection(), user);
	}

	@Override
	public User getUserid(HttpServletRequest req) {

		User user = new User();

		String param = req.getParameter("userid");
		if( param != null && !"".equals(param) ) {
			user.setUserid(param);
		} else {
			System.out.println("[WARN] User getUserid() - userid값이 null이거나 비어있음");
		}

		return user;
	}

	// 회원 정보 수정
	@Override
	public User view(User userid) {
		
		Connection conn = JDBCTemplate.getConnection();
		
		//게시글 조회
		User user = userDao.selectUserByUserid(conn, userid);
		
		//조회된 게시글 리턴
		return user;
	}
	// 회원 수정
	@Override
	public void update(HttpServletRequest req) {

		Connection conn = JDBCTemplate.getConnection();
		
		User user = new User();
		
		user.setUserid((String)req.getSession().getAttribute("userid"));
		user.setUserpw(req.getParameter("userpw"));
		user.setUphone(req.getParameter("uphone"));
		user.setAddress(req.getParameter("address"));
		user.setEmail(req.getParameter("email"));
//			
		if( userDao.update(conn, user) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}
	// 회원 탈퇴
	@Override
	public void delete(User userid) {

		Connection conn = JDBCTemplate.getConnection();

		if( userDao.delete(conn, userid) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}
	
	@Override
	public User getuserid(HttpServletRequest req) {
		User user = new User();
		
		user.setUserid((String)req.getSession().getAttribute("userid"));
	
		return user;
	}
	
}

