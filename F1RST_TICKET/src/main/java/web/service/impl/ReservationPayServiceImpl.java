package web.service.impl;

import java.sql.Connection;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import util.Paging;
import web.dao.face.ReservationPayDao;
import web.dao.impl.ReservationPayDaoImpl;
import web.dto.Musical;
import web.dto.ReservationPay;
import web.dto.User;
import web.service.face.ReservationPayService;

public class ReservationPayServiceImpl implements ReservationPayService {
	
	DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private ReservationPayDao rpayDao = new ReservationPayDaoImpl();
	
	@Override
	public List<ReservationPay> selectedMusical() {
		
		Connection conn = JDBCTemplate.getConnection();
		
		return rpayDao.selectAllM(conn);
	}

	
	@Override
	public List<ReservationPay> getRsPayList(Paging paging, User user) {
		return rpayDao.selectAllRsp(JDBCTemplate.getConnection(), paging, user);
	}
	
	@Override
	public ReservationPay getpush(HttpServletRequest req) {
//		DateFormat df = new SimpleDateFormat("yy-MM-dd");
				
		ReservationPay rpay = new ReservationPay();
		User user = new User();

		
		rpay.setMcname( req.getParameter("mcname") );
		rpay.setScheduledate(req.getParameter("scheduledate") );
		rpay.setScheduletime( req.getParameter("scheduletime") );
		user.setUserid((String)req.getSession().getAttribute("loginid") );
		rpay.setTicketcount( Integer.parseInt(req.getParameter("ticketcount")));
		rpay.setPayment( req.getParameter("payment") );
		rpay.setPaymoney( Integer.parseInt(req.getParameter("paymoney")));
		
		return rpay;
	}


	@Override
	public void join(ReservationPay rpay, User user) {
		Connection conn = JDBCTemplate.getConnection();
		
		if( rpayDao.insert(conn, rpay, user) > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}		
	}

	//------------------------------------------------
	
	@Override
	public boolean findMcname(User user) {

		if(rpayDao.selectCntMusicalByMcName(JDBCTemplate.getConnection(), user) > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public ReservationPay info(ReservationPay res, User user) {
		return rpayDao.selectMcByMcname(JDBCTemplate.getConnection(), user);
	}

	@Override
	public Paging getPaging(HttpServletRequest req, User user) {
		
		String param = req.getParameter("curPage");
		int curPage = 0;
		if( param != null && !"".equals(param) ) {
			curPage = Integer.parseInt(param);
		} else {
			System.out.println("[WARN] reservationService getPaging() - curPage가 null이거나 비어있음");
		}
		
		//총 게시글 수 조회하기
		int totalCount = rpayDao.selectCntAll(JDBCTemplate.getConnection(), user);
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);
	
		return paging;
	}
	
	@Override
	public ReservationPay selectMcno(HttpServletRequest req, User user) {

		
		ReservationPay getMcno = rpayDao.getMcno(JDBCTemplate.getConnection(), user);
		int mcno = 0;
		getMcno.setMcno(mcno);
		
		return getMcno;
	}
	
	@Override
	public List<ReservationPay> getRsPayListMain(Paging paging, User user) {
		return rpayDao.selectAllRspMain(JDBCTemplate.getConnection(), paging, user);
	}
	
	
}

//	@Override
//	public List<ReservationPay> getMcSearchList(String keyword, User user) {
//		return rpayDao.searchMc(JDBCTemplate.getConnection(), keyword, user);
//	}
//	
//	@Override
//	public boolean searchMc(String keyword, User user) {
//		if(rpayDao.selectCntRpBySearchMc(JDBCTemplate.getConnection(),keyword, user) > 0) {
//			return true;
//		}
//		return false;
//	}

//	@Override
//	public ReservationPay selectSearchMc(HttpServletRequest req, User user) {
//		ReservationPay getMcno = rpayDao.getMcno(JDBCTemplate.getConnection(), user);
//		int mcno = 0;
//		getMcno.setMcno(mcno);
//		
//		return getMcno;
//	}
//	
//	@Override
//	public ReservationPay info(ReservationPay res, User user, String keyword) {
//		return rpayDao.selectRpBySearchMc(JDBCTemplate.getConnection(), user, keyword);
//	}
//	
//	@Override
//	public void searchRpMc(HttpServletRequest req) {
//		Connection conn = JDBCTemplate.getConnection();
//		
//		ReservationPay resPay = new ReservationPay();
//		
//		resPay.setResdate(new Timestamp(System.currentTimeMillis()));
//		try {
//			resPay.setScheduledate(sdf.parse(req.getParameter("scheduleDate")));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		
//		resPay.setMcname(req.getParameter("mcname"));
//	}
//	@Override
//	public void write(HttpServletRequest req) {
//		Connection conn = JDBCTemplate.getConnection();
//		ReservationPay rvpay = new ReservationPay();
//		User user = new User();
//		String mcname = req.getParameter("mcname");
//		rvpay.setMcname(req.getParameter("mcname"));
//
//		int mcno = rpayDao.selectMcno(conn, mcname);
//		rvpay.setMcno(mcno);
//		rvpay.setScheduletime("scheduleTime");
//		try {
//			rvpay.setScheduledate(sdf.parse(req.getParameter("scheduleDate")));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//	
//		
////		rvpay.setResno("");
//		int setScheduleInfoid = rpayDao.selectSinfoid(conn);
//		rvpay.setScheduleInfoId(setScheduleInfoid);
//		rvpay.setPayment(req.getParameter("payment"));
//		rvpay.setPaymoney(Integer.parseInt(req.getParameter("paymoney")));
//		rvpay.setResdate(new Timestamp(System.currentTimeMillis()));
//		rvpay.setTicketcount(Integer.parseInt(req.getParameter("ticketcount")));
//
//		rvpay.setSeatno(Integer.parseInt("req.getParameter(seatno"));
//		user.setUserid( (String)req.getSession().getAttribute("userid") );
//		int wrt = rpayDao.writeReservation(conn, rvpay, user);
//		int wrs = rpayDao.writeScheduleInfo(conn, rvpay);
//		int wrseat = rpayDao.writeSeat(conn, rvpay);
//		
//	}


//------------

//	@Override
//	public ReservationPay getMcname(HttpServletRequest req) {
//		
//		ReservationPay rsPay = new ReservationPay();
//		Musical mc = new Musical();
//		
//		User user = new User();
//		user.setUserid((String) req.getSession().getAttribute("userid"));
//		rsPay.setUserid((String) req.getSession().getAttribute("userid"));
//		
//		String param = req.getParameter("mcno");
//		int mcno = 0;
//		if( param != null && !"".equals(param) ) {
//			mcno = Integer.parseInt(param);
//		} else {
//			System.out.println("[WARN] reservationService getPaging() - curPage가 null이거나 비어있음");
//		}
//		
//		
//		String mcname = req.getParameter("mcname");
//		rsPay.setMcname(mcname);
//		
//		System.out.println(rsPay);
//		return rsPay;
//	}