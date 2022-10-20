package web.service.face;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dto.Musical;
import web.dto.Reservation;
import web.dto.ReservationPay;
import web.dto.User;

public interface ReservationService {

	/**
	 * 페이징 처리
	 * 
	 * @param req
	 * @return
	 */
	public Paging getPaging(HttpServletRequest req);

	/**
	 * 예매 전체 조회 결과 처리 -> 페이징 처리
	 * 
	 * @param paging
	 * @return
	 */
	public List<Reservation> getList(Paging paging, User user);

	public Reservation getResv(HttpServletRequest req);

	public boolean findResv(Reservation resv, User user);

	public Reservation info(Reservation resv,  User user);

	public List<Reservation> getListMain(Paging paging, User user);

	public Paging getDeletePaging(HttpServletRequest req);

	public boolean findResvSearch(Reservation resv, User user, ReservationPay rsPay);

	public Reservation info(Reservation resv, User user, ReservationPay rsPay);

	public List<Reservation> getListRsPay(Paging paging, User user, ReservationPay rsPay);
	
//	public List<Reservation> getListSearch(Paging paging, User user, Musical musical); 
	
}
