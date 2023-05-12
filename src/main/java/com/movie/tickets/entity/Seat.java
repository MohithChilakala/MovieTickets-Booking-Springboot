package com.movie.tickets.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "seat")
public class Seat {
	
	public static final int AVAILABLE = 1;
	public static final int UNAVAILABLE = 0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String seatNo;
	private int status;
	private float price;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Show show;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Booking booking;
	
	public Seat() {}
	public Seat(String seatNo, float price) {
		this.seatNo = seatNo;
		this.price = price;
		this.booking = null;
	}
	
	public long getId() { return id; }

	public String getSeatNo() { return seatNo; }
	public void setSeatNo(String seatNo) { this.seatNo = seatNo; }
	
	public float getPrice() { return price; }
	public void setPrice(float price) { this.price = price; }
	
	public int getStatus() { return status; }
	public void setStatus(int status) { this.status = status; }
	
	public Show getShow() { return show; }
	public void setShow(Show show) { this.show = show; }
	
	public Booking getBooking() { return booking; }
	public void setBooking(Booking booking) { this.booking = booking; }
}
