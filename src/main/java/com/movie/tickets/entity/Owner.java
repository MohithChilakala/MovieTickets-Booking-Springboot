package com.movie.tickets.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "owner")
public class Owner {
	
	@Id
	private long id;
	private String name;
	private String phoneNo;
	private String email;
	private String password;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "owner")
	private List<Theatre> theatres;
	
	public Owner() {}
	public Owner(String name, String phoneNo, String email, String password) {
		this.name = name;
		this.phoneNo = phoneNo;
		this.email = email;
		this.password = password;
	}
	
	public long getId() { return id; }
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	
	public String getPhoneNo() { return phoneNo; }
	public void setPhoneNo(String phoneNo) { this.phoneNo = phoneNo; }
	
	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	public List<Theatre> getTheatres() { return theatres; }
	public void setTheatres(List<Theatre> theatres) { this.theatres = theatres; }
	
}