package web.service.face;

import javax.servlet.http.HttpServletRequest;

import web.dto.User;

public interface UserService {

	// 로그인
	/**
	 * 로그인 정보 추출
	 * 
	 * @param req - 요청 정보 객체
	 * @return User - 로그인 정보(userid, userpw)
	 */
	public User getLoginUser(HttpServletRequest req);

	/**
	 * 로그인 인증 처리
	 * 
	 * @param user - 로그인 정보(userid, userpw)
	 * @return boolean - true 인증 성공 / false 인증 실패
	 */
	public boolean login(User user);

	/**
	 * 유저 정보 가져오기
	 * 
	 * @param user - 조회할 회원 아이디 가진 객체
	 * @return User - 조회된 회원 정보(userid, userpw, ...)
	 */
	public User info(User user);

	
	// 회원가입
	public User getJoinUser(HttpServletRequest req);

	public void Join(User user);
	
	// 아이디 찾기
	/**
	 * 회원 확인 처리
	 * 
	 * @param user - 회원 정보(username, email)
	 * @return boolean - true: 인증 성공 / false: 인증 실패
	 */
	public boolean findId(User user);

	/**
	 * 유저 정보 가져오기
	 * 
	 * @param user - 조회할 회원 이름과 이메일 가진 객체
	 * @return User - 조회된 회원 정보(username, email, ...)
	 */
	public User infoUser(User user);

	/**
	 * 회원 정보 추출
	 * 
	 * @param req - 요청 정보 객체
	 * @return User - 회원 정보(username, email)
	 */
	public User getFindUserId(HttpServletRequest req);

	// 비밀번호 찾기
	/**
	 * 회원 정보 추출
	 * 
	 * @param req - 요청 정보 객체
	 * @return User - 회원 정보(username, email)
	 */
	public User getFindUserPw(HttpServletRequest req);

	/**
	 * 회원 확인 처리
	 * 
	 * @param user - 회원 정보(userid ,username, email)
	 * @return boolean - true: 인증 성공 / false: 인증 실패
	 */
	public boolean findPw(User user);

	/**
	 * 유저 정보 가져오기
	 * 
	 * @param user - 조회할 회원 이름과 이메일, 아이디 가진 객체
	 * @return User - 조회된 회원 정보(userid, username, email, ...)
	 */
	public User infoUserpw(User user);

	/**
	 * 전달 파라미터 DTO로 저장하고 반환
	 * 
	 * @param req - 요청 정보 객체
	 * @return User - 전달파라미터 userid를 저장한 객체
	 */
	public User getUserid(HttpServletRequest req);

	//회원 정보 수정
//	public int updateUser(User user);
//
//	public User selectOne(String userid);

	public User view(User userid);

	public void update(HttpServletRequest req);

	// 회원 정보 삭제
	public void delete(User userid);

	// reservation에 넘겨줄 아이디 찾아오기
	public User getuserid(HttpServletRequest req);



	
}

// 안되는거 주석처리 해놓음

//
//