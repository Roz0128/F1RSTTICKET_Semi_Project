package web.dao.face;

import java.sql.Connection;

import web.dto.User;

public interface UserDao {

	// 로그인
	/**
	 * userid와 userpw를 동시에 만족하는 회원의 수 조회
	 * 	-> 로그인 인증 값으로 사용
	 * 
	 * @param conn - DB 연결 객체
	 * @param user - 조회할 회원 정보
	 * @return int - 0 존재하지 않는 회원 / 1 존재하는 회원
	 */
	public int selectCntUserByUseridUserpw(Connection conn, User user);

	/**
	 * userid를 이용해 회원 정보 찾기
	 * 
	 * @param conn - DB 연결 객체
	 * @param user - 조회할 userid를 가진 객체
	 * @return User - 조회된 회원 정보
	 */
	public User selectUserByUserid(Connection conn, User user);
	
	// 회원가입
	/**
	 * 회원가입
	 * @param conn
	 * @param user
	 * @return
	 */
	public int insert(Connection conn, User user);

	// 아이디 찾기
	/**
	 * username과 email를 동시에 만족하는 회원의 수 조회
	 * 	-> 아이디 찾기에 사용
	 * 
	 * @param conn - DB 연결 객체
	 * @param user - 조회할 회원 정보
	 * @return int - 0 존재하지 않는 회원 / 1 존재하는 회원
	 */
	public int selectCntUserByUsernameEmail(Connection conn, User user);

	/**
	 * username, email를 이용해 회원 정보 찾기
	 * 
	 * @param conn - DB 연결 객체
	 * @param user - 조회할 username, email를 가진 객체
	 * @return User - 조회된 회원 정보
	 */
	public User selectUserByUsernameEmail(Connection conn, User user);

	// 비밀번호 찾기
	/**
	 * userid, username, email를 동시에 만족하는 회원의 수 조회
	 * 	-> 비밀번호 찾기에 사용
	 * 
	 * @param conn - DB 연결 객체
	 * @param user - 조회할 회원 정보
	 * @return int - 0 존재하지 않는 회원 / 1 존재하는 회원
	 */
	public int selectCntUserByUseridUsernameEmail(Connection conn, User user);

	/**
	 * userid, username, email를 이용해 회원 정보 찾기
	 * 
	 * @param conn - DB 연결 객체
	 * @param user - 조회할 userid, username, email를 가진 객체
	 * @return User - 조회된 회원 정보
	 */
	public User selectUserByUseridUsernameEmail(Connection conn, User user);

	// 아이디 중복
	public int IdCheckController(User u);

	//회원 정보 수정
//	public int updateUser(Connection conn, User user);
//
//	public User selectOne(Connection conn, String userid);

//	/**
//	 * userid를 이용해 회원 정보 찾기
//	 * 
//	 * @param conn - DB 연결 객체
//	 * @param user - 조회할 userid를 가진 객체
//	 * @return User - 조회된 회원 정보
//	 */
//	public User selectUserByUserId(Connection conn, User userid);

	public int update(Connection conn, User user);

	public int delete(Connection conn, User userid);
	
}

// 안되는거 주석 처리

