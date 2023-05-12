package com.movie.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.tickets.entity.Address;
import com.movie.tickets.entity.Theatre;
import com.movie.tickets.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository aRep;
	
	public Address findById(long id) {
		return aRep.findById(id).orElse(null);
	}
	
	public Address findByTheatre(Theatre theatre) {
		return aRep.findByTheatre(theatre);
	}
	
	public List<Address> findByCity(String city) {
		return aRep.findByCity(city);
	}
	
	public List<Address> findByPincode(String pincode) {
		return aRep.findByPincode(pincode);
	}
	
	public void save(Address address) {
		aRep.save(address);
	}
	
	public void deleteById(long id) {
		aRep.deleteById(id);
	}
	
	public void delete(Address address) {
		aRep.delete(address);
	}
}
