package com.movie.tickets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.tickets.entity.Show;
import com.movie.tickets.repository.ShowRepository;

@Service
public class ShowService {
	
	@Autowired
	private ShowRepository sRep;
	
	public Show findById(long id) {
		return sRep.findById(id).orElse(null);
	}
	
	public void save(Show show) {
		sRep.save(show);
	}
}
