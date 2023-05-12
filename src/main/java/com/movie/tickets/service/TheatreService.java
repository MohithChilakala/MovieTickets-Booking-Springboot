package com.movie.tickets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.tickets.entity.Address;
import com.movie.tickets.entity.Owner;
import com.movie.tickets.entity.Theatre;
import com.movie.tickets.repository.TheatreRepository;

@Service
public class TheatreService {
	
	@Autowired
	private TheatreRepository tRep;
	
	public Theatre findById(long id) {
		return tRep.findById(id).orElse(null);
	}
	
	public Theatre findByAddress(Address address) {
		return tRep.findByAddress(address);
	}
	
	public Theatre findByOwner(Owner owner) {
		return tRep.findByOwner(owner);
	}
	
	public void save(Theatre theatre) {
		tRep.save(theatre);
	}
}
