package com.movie.tickets.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.tickets.entity.Seat;
import com.movie.tickets.repository.SeatRepository;


@Service
public class SeatService {

	@Autowired
	private SeatRepository sRep;
	
	public Seat findById(long id) {
		return sRep.findById(id).orElse(null);
	}
	
	public List<Seat> findAllByShowId(long show_id) {
		return sRep.findAllByShowId(show_id);
	}

}
