package web.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dto.UserBoard;

public interface UserBoardService {

	/**
	 * 페이징 처리
	 * @param req
	 * @return
	 */
	public Paging getPaging(HttpServletRequest req);

	/**
	 * 회원 조회
	 * @param paging
	 * @return
	 */
	public List<UserBoard> getList(Paging paging);

}
