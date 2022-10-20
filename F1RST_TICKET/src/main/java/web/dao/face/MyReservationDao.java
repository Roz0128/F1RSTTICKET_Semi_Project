package web.dao.face;

import java.sql.Connection;
import java.util.List;

import util.Paging;
import web.dto.Musical;
import web.dto.MyReservation;
import web.dto.Reservation;
import web.dto.User;

public interface MyReservationDao {

	public int selectCntAll(Connection conn);

	public List<MyReservation> selectAll(Connection conn, Paging paging, User user, Musical mc, Reservation res);

	public int selectCntmyResByMcUser(Connection conn, MyReservation myRes, User user, Musical mc, Reservation res);

	public MyReservation selectMyResByMcName(Connection conn, MyReservation myRes, User user, Musical mc,
			Reservation res);

}
