package com.movie.tickets.entity;

import java.sql.Time;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "show_time")
public class Show {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Time startingTime;
	private Time endingTime;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "movie_id", referencedColumnName = "id")
	private Movie movie;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "show")
	private List<Seat> seats;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "hall_id", referencedColumnName = "id")
	private Hall hall;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "show")
	private Booking booking;
	
	public Show() {}
	public Show(Time startingTime, Time endingTime, Movie movie) {
		this.startingTime = startingTime;
		this.endingTime = endingTime;
		this.movie = movie;
	}
	
	public long getId() { return id; }
	
	public Time getStartingTime() { return startingTime; }
	public void setStartingTime(Time startingTime) { this.startingTime = startingTime; }
	
	public Time getEndingTime() { return endingTime; }
	public void setEndingTime(Time endingTime) { this.endingTime = endingTime; }
	
	public Movie getMovie() { return movie; }
	public void setMovie(Movie movie) { this.movie = movie; }
	
	public List<Seat> getSeats() { return seats; }
	public void setSeats(List<Seat> seats) { this.seats = seats; }
	
	public Hall getHall() { return hall; }
	public void setHall(Hall hall) { this.hall = hall; }
}
