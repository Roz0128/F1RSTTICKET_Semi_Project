package web.dao.face;

import java.sql.Connection;

import web.dto.ScheduleInfo;

public interface ScheduleInfoDao {

	public ScheduleInfo selectAll(Connection conn);

	 
}
