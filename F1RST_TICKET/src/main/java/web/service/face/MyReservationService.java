package web.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import util.Paging;
import web.dto.Musical;
import web.dto.MyReservation;
import web.dto.Reservation;
import web.dto.User;

public interface MyReservationService {

	public Paging getPaging(HttpServletRequest req);

	public List<MyReservation> getList(Paging paging, User user, Musical mc, Reservation res);

	public MyReservation getMcname(HttpServletRequest req);

	public boolean findMyMc(MyReservation myRes, User user, Musical mc, Reservation res);

	public MyReservation info(MyReservation myRes, User user, Musical mc, Reservation res);

}
