package com.movie.tickets.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String state;
	private String city;
	private String pincode;
	private String address;
	private String contact;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "theatre_id", referencedColumnName = "id")
	private Theatre theatre;
	
	public Address() {}	
	public Address(String state, String city, String pincode, String address, String contact) {
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.address = address;
		this.contact = contact;
	}
	
	public long getId() { return id; }
	
	public String getState() { return state; }
	public void setState(String state) { this.state = state; }
	
	public String getCity() { return city; }
	public void setCity(String city) { this.city = city; }
	
	public String getPincode() { return pincode; }
	public void setPincode(String pincode) { this.pincode = pincode; }
	
	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }
	
	public String getContact() { return contact; }
	public void setContact(String contact) { this.contact= contact; }
	
	public Theatre getTheatre() { return theatre; }
	public void setTheatre(Theatre theatre) { this.theatre = theatre; }
}
