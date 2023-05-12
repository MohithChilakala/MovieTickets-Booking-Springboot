package com.movie.tickets.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String hero;
	private String heroine;
	private String director;
	private String discription;
	private float duration;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Show show;
	
	public Movie() {}
	public Movie(String hero, String heroine, String director, String discription, float duration) {
		this.hero = hero;
		this.heroine = heroine;
		this.director = director;
		this.discription = discription;
		this.duration = duration;
		show.setMovie(this);
	}
	
	public long getId() { return id; }
	
	public String getHero() { return hero; }
	public void setHero(String hero) { this.hero = hero; }
	
	public String getHeroine() { return heroine; }
	public void setHeroine(String heroine) { this.heroine = heroine; }
	
	public String getDirector() { return director; }
	public void setDirector(String director) { this.director = director; }
	
	public String getDiscription() { return discription; }
	public void setDiscription(String discription) { this.discription = discription; }
	
	public float getDuration() { return duration; }
	public void setDuration(float duration) { this.duration = duration; }
	
	public Show getShow() {	return show; }
	public void setShow(Show show) { this.show = show; }
}
