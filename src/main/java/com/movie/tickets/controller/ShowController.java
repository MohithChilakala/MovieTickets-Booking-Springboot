package com.movie.tickets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.tickets.entity.Seat;
import com.movie.tickets.entity.Show;
import com.movie.tickets.service.ShowService;

@RestController
@RequestMapping("/show")
public class ShowController {
	
	@Autowired
	private ShowService sService;
	
	@PatchMapping("/add/seats/{show_id}")
	public void addSeats(@PathVariable long show_id, @RequestBody List<Seat> seats) {
		Show show = sService.findById(show_id);
		
		List<Seat> seats2 = show.getSeats();
		for(Seat seat : seats) {
			seat.setShow(show);
			seat.setStatus(Seat.AVAILABLE);
			seats2.add(seat);
		}
		show.setSeats(seats2);
		
		sService.save(show);
	}
}
