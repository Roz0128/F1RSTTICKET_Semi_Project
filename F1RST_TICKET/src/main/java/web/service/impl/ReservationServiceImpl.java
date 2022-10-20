package web.service.impl;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import util.Paging;
import web.dao.face.ReservationDao;
import web.dao.impl.ReservationDaoImpl;
import web.dto.Musical;
import web.dto.Reservation;
import web.dto.ReservationPay;
import web.dto.User;
import web.service.face.ReservationService;


public class ReservationServiceImpl implements ReservationService {

	private ReservationDao reservationDao = new ReservationDaoImpl();
	
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
		int totalCount = reservationDao.selectCntAll(JDBCTemplate.getConnection());
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}
	
	@Override
	public List<Reservation> getList(Paging paging, User user) {
		
		List<Reservation>  list = reservationDao.selectAll(JDBCTemplate.getConnection(), paging, user);
		
		
		return list;
	}
	@Override
	public List<Reservation> getListMain(Paging paging, User user) {
		
		List<Reservation>  list = reservationDao.selectAllMain(JDBCTemplate.getConnection(), paging, user);
		
		
		return list;
	}
//	@Override
//	public List<Reservation> getListSearch(Paging paging, User user, Musical musical) {
//		
//		List<Reservation>  list = reservationDao.selectAllSearch(JDBCTemplate.getConnection(), paging, user, musical);
//		
//		
//		return list;
//	}
	
	@Override
	public Reservation getResv(HttpServletRequest req) {
		
		Reservation resv = new Reservation();
		
		String resno = req.getParameter("resno");
		if( resno != null && !"".equals(resno) ) {
			resv.setResno( Integer.parseInt(resno) );
		}
		
		String scheduleInfoID = req.getParameter("scheduleInfoID");
		if( resno != null && !"".equals(resno) ) {
			resv.setScheduleInfoId( Integer.parseInt(scheduleInfoID) );
		}
		
		resv.setUserid((String)req.getSession().getAttribute("userid"));
		
		
		String ticketcount = req.getParameter("ticketcount");
		if( resno != null && !"".equals(resno) ) {
			resv.setTicketcount( Integer.parseInt(ticketcount) );
		}

//		resv.setTicketcount(Integer.parseInt(req.getParameter("ticketcount")));
//		resv.setScheduleInfoID(Integer.parseInt(req.getParameter("scheduleInfoID")));
//		resv.setResno(Integer.parseInt(req.getParameter("resno")));
		
//		Reservation resv = new Reservation();
//		resv.setPayment("free");
////		resv.setResno(Integer.parseInt(req.getParameter("resno").trim()));
//		System.out.println(req);
//		String param = req.getParameter("resno");
////		System.out.println("~~~~~~~~~~~~~~~~~~~~");
////		System.out.println(param);
//		if( param != null && !"".equals(param) ) {
//			resv.setResno(Integer.parseInt(param));
//		} else {
//			System.out.println("[WARN] getResv() - resno값이 null이거나 비어있음");
//		}
//		
		return resv;
	}
	
	@Override
	public boolean findResv(Reservation resv, User user) {
		
		if(reservationDao.selectCntResByResnoUserid(JDBCTemplate.getConnection(), resv, user) >0 ) {
			
			return true;
		}
		
		return false;
	}

	@Override
	public Reservation info(Reservation resv,  User user) {
		return reservationDao.selectUserByUserid(JDBCTemplate.getConnection(), resv, user);
	}
	
	@Override
	public Paging getDeletePaging(HttpServletRequest req) {
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		} else {
			System.out.println("[WARN] reservationService getPaging() - curPage가 null이거나 비어있음");
		}
		
		//총 게시글 수 조회하기
		int totalCount = reservationDao.selectCntAll(JDBCTemplate.getConnection());
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}

	public void delete(Reservation resv, User user) {
		Connection conn = JDBCTemplate.getConnection();
		
		if(reservationDao.delete(conn,resv, user)> 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
	}
	@Override
	public boolean findResvSearch(Reservation resv, User user, ReservationPay rsPay) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Reservation> getListRsPay(Paging paging, User user, ReservationPay rsPay) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Reservation info(Reservation resv, User user, ReservationPay rsPay) {
		// TODO Auto-generated method stub
		return null;
	}
}
	
