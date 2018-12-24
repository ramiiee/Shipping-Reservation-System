package com.wipro.srs.bean;

import java.util.Date;

public class ReservationBean {
	private String reservationID;
	
	private String scheduleID;
	
	private String userID;

	private Date bookingDate;

	private Date journeyDate;

	private int noOfSeats;

	private double totalFare;

	private String bookingStatus;

	public ReservationBean() {
		super();
	
	}

	/**
	 * 
	 * @param reservationID reservationID
	 * @param scheduleID scheduleID
	 * @param userID userID
	 * @param bookingDate bookingDate
	 * @param journeyDate journeyDate
	 * @param noOfSeats noOfSeats
	 * @param totalFare totalFare
	 * @param bookingStatus bookingStatus
	 */
	public ReservationBean(String reservationID, String scheduleID,
			String userID, Date bookingDate, Date journeyDate, int noOfSeats,
			double totalFare, String bookingStatus) {
		super();
		this.reservationID = reservationID;
		this.scheduleID = scheduleID;
		this.userID = userID;
		this.bookingDate = bookingDate;
		this.journeyDate = journeyDate;
		this.noOfSeats = noOfSeats;
		this.totalFare = totalFare;
		this.bookingStatus = bookingStatus;
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
 * @return userID
 */
	public String getUserID() {
		return userID;
	}
/**
 * 
 * @param userID userID
 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
/**
 * 
 * @return bookingDate
 */
	public Date getBookingDate() {
		return bookingDate;
	}
/**
 * 
 * @param bookingDate bookingDate
 */
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
/**
 * 
 * @return journeyDate
 */
	public Date getJourneyDate() {
		return journeyDate;
	}
/**
 * 
 * @param journeyDate journeyDate
 */
	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}
/**
 * 
 * @return noOfSeats
 */
	public int getNoOfSeats() {
		return noOfSeats;
	}
/**
 * 
 * @param noOfSeats noOfSeats
 */
	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
/**
 * 
 * @return totalFare
 */
	public double getTotalFare() {
		return totalFare;
	}
/**
 * 
 * @param totalFare totalFare
 */
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
/**
 * 
 * @return bookingStatus
 */
	public String getBookingStatus() {
		return bookingStatus;
	}
/**
 * 
 * @param bookingStatus bookingStatus
 */
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}


}
