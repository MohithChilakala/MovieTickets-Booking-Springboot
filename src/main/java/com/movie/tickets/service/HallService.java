package com.movie.tickets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.tickets.entity.Hall;
import com.movie.tickets.repository.HallRepository;

@Service
public class HallService {
	
	@Autowired
	private HallRepository hRep;
	
	public Hall findById(long id) {
		return hRep.findById(id).orElse(null);
	}
	
	public void save(Hall hall) {
		hRep.save(hall);
	}
	
	public void deleteById(long id) {
		hRep.deleteById(id);
	}
}
