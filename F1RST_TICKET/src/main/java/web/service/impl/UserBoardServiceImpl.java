package web.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import util.Paging;
import web.dao.face.UserBoardDao;
import web.dao.impl.UserBoardDaoImpl;
import web.dto.UserBoard;
import web.service.face.UserBoardService;

public class UserBoardServiceImpl implements UserBoardService {

	private UserBoardDao userBoardDao = new UserBoardDaoImpl();
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		} else { }
		
		int totalCount = userBoardDao.selectCntAll(JDBCTemplate.getConnection());
		
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
	@Override
	public List<UserBoard> getList(Paging paging) {
		return userBoardDao.selectAll(JDBCTemplate.getConnection(), paging);
	}
}
