package com.movie.tickets.entity;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date date;
	private Time time;
	
	@OneToOne
	private Show show;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "booking")
	private List<Seat> seats;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private User user;
	
	public Booking() {
		this.date = Date.valueOf(LocalDate.now());
		this.time = Time.valueOf(LocalTime.now());
		seats = new ArrayList<>();
	}
	
	public long getId() { return id; }
	public Date getDate() { return date; }
	public Time getTime() { return time; }
	
	public Show getShow() { return show; }
	public void setShow(Show show) { this.show = show; }
	
	public List<Seat> getSeats() { return seats; }
	public void setSeats(List<Seat> seats) { this.seats = seats; }
	
	public User getUser() { return user; }
	public void setUser(User user) { this.user = user; }
}
