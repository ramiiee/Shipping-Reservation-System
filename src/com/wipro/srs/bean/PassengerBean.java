package com.wipro.srs.bean;

/**
 * 
 * @author Administrator
 *
 */
public class PassengerBean {
	
	private String reservationID;

	private String scheduleID;
	
	private String name;

	private int age;

	private String gender;

/**
 * @param null	
 */
	public PassengerBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PassengerBean(String reservationID, String scheduleID, String name,
			int age, String gender) {
		super();
		this.reservationID = reservationID;
		this.scheduleID = scheduleID;
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	/**
	 * 
	 * @return reservationID
	 */
	public String getReservationID() {
		return reservationID;
	}
	/**
	 * 
	 * @param reservationID reservationID
	 */

	public void setReservationID(String reservationID) {
		this.reservationID = reservationID;
	}

	/**
	 * 
	 * @return scheduleID
	 */
	public String getScheduleID() {
		return scheduleID;
	}
/**
 * 
 * @param scheduleID scheduleID
 */
	public void setScheduleID(String scheduleID) {
		this.scheduleID = scheduleID;
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * 
	 * @param age age
	 */

	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * 
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * 
	 * @param gender gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}


}
