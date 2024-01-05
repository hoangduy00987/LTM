package Model.BEAN;

import java.sql.Date;

public class Booking {
	int booking_id;
	String full_name;
	String location;
	String phone_number; 
	Date bookingDate;
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	String  email; 
	Date booking_date;
	int num_participants;
	public int getBooking_id() {
		return booking_id;
	}
	public Date getDate() {
		return booking_date;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}
	public int getNum_participants() {
		return num_participants;
	}
	public void setNum_participants(int num_participants) {
		this.num_participants = num_participants;
	}
   public Booking(int bookingId, String fullName, String location, String phoneNumber, String email, Date bookingDate, int numParticipants) {
    	this.booking_id = bookingId;
    	this.full_name = fullName;
    	this.location = location;
    	this.phone_number = phoneNumber;
    	this.email = email;
    	this.booking_date = bookingDate;
    	this.num_participants = numParticipants;
    }
}
