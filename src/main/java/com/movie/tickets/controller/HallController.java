package com.movie.tickets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.tickets.entity.Hall;
import com.movie.tickets.entity.Show;
import com.movie.tickets.service.HallService;

@RestController
@RequestMapping("/hall")
public class HallController {
	
	@Autowired
	private HallService hService;
	
	@PatchMapping("/add/show/{hall_id}")
	public void addShow(@PathVariable long hall_id, @RequestBody Show show) {
		Hall hall = hService.findById(hall_id);
		List<Show> shows = hall.getShows();
		
		show.setHall(hall);
		show.getMovie().setShow(show);
		shows.add(show);
		hall.setShows(shows);
		
		hService.save(hall);
	}
}
