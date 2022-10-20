package web.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import util.Paging;
import web.dao.face.MyReservationDao;
import web.dao.impl.MyReservationDaoImpl;
import web.dto.Musical;
import web.dto.MyReservation;
import web.dto.Reservation;
import web.dto.User;
import web.service.face.MyReservationService;

public class MyReservationServiceImpl implements MyReservationService {

	private MyReservationDao mrDao = new MyReservationDaoImpl();
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		} else {
			System.out.println("[WARN] reservationService getPaging() - curPage가 null이거나 비어있음");
		}
		
		//총 게시글 수 조회하기
		int totalCount = mrDao.selectCntAll(JDBCTemplate.getConnection());
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
	@Override
	public List<MyReservation> getList(Paging paging, User user, Musical mc, Reservation res) {
		
		List<MyReservation> list = mrDao.selectAll(JDBCTemplate.getConnection(), paging, user, mc, res);
		
		return list;
	}
	@Override
	public MyReservation getMcname(HttpServletRequest req) {
		
		MyReservation mc = new MyReservation();
//		myRes.setMcno(Integer.parseInt(req.getParameter("mcno")));
//		myRes.setUserid((String)req.getSession().getAttribute("userid"));
		
		mc.setMcname(req.getParameter("mcname"));
		
		return mc;
	}
	
	@Override
	public boolean findMyMc(MyReservation myRes, User user, Musical mc, Reservation res) {

		if(mrDao.selectCntmyResByMcUser(JDBCTemplate.getConnection(), myRes, user, mc, res) > 0) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public MyReservation info(MyReservation myRes, User user, Musical mc, Reservation res) {
		return mrDao.selectMyResByMcName(JDBCTemplate.getConnection(), myRes, user, mc, res);
	}
}
