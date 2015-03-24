package com.iyoutingche.web.ordermodel;

import java.util.Date;

public class Pcar_Order {
	private String user_id;
	private String depot_code;
	private String space_code;
	private Date record_date;
	private Date record_again;
	private Date record_end;
	
	public Pcar_Order(){}

	public String getUser_id() {
		return user_id;
	}

	public Pcar_Order(String userId, String depotCode, String spaceCode,
			Date recordDate, Date recordAgain, Date recordEnd) {
		super();
		user_id = userId;
		depot_code = depotCode;
		space_code = spaceCode;
		record_date = recordDate;
		record_again = recordAgain;
		record_end = recordEnd;
	}
	public void setUser_id(String userId) {
		user_id = userId;
	}

	public String getDepot_code() {
		return depot_code;
	}

	public void setDepot_code(String depotCode) {
		depot_code = depotCode;
	}

	public String getSpace_code() {
		return space_code;
	}

	public void setSpace_code(String spaceCode) {
		space_code = spaceCode;
	}

	public Date getRecord_date() {
		return record_date;
	}

	public void setRecord_date(Date recordDate) {
		record_date = recordDate;
	}

	public Date getRecord_again() {
		return record_again;
	}

	public void setRecord_again(Date recordAgain) {
		record_again = recordAgain;
	}

	public Date getRecord_end() {
		return record_end;
	}

	public void setRecord_end(Date recordEnd) {
		record_end = recordEnd;
	}
	
}
