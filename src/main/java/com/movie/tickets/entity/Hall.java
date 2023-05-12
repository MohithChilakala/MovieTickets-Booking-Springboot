package com.movie.tickets.entity;

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
import jakarta.persistence.Table;

@Entity
@Table(name = "hall")
public class Hall {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String hallName;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "hall")
	private List<Show> shows;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "theatre_id", referencedColumnName = "id")
	private Theatre theatre;
	
	public Hall() {}
	public Hall(String hallName) {
		this.hallName = hallName;
		this.shows = null;
	}
	
	public long getId() { return id; }
	
	public String getHallName() { return hallName; }
	public void setHallName(String hallName) { this.hallName = hallName; }
	
	public List<Show> getShows() { return shows; }
	public void setShows(List<Show> shows) { this.shows = shows; }
	
	public Theatre getTheatre() { return theatre; }
	public void setTheatre(Theatre theatre) { this.theatre = theatre; }	
}
