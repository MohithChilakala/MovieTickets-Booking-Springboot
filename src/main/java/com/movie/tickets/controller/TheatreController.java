package com.movie.tickets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.tickets.entity.Hall;
import com.movie.tickets.entity.Theatre;
import com.movie.tickets.service.TheatreService;

@RestController
@RequestMapping("/theatre")
public class TheatreController {
	
	@Autowired
	private TheatreService tService;
	
	@PatchMapping("/add/hall/{theatre_id}")
	public void addHall(@PathVariable long theatre_id, @RequestBody Hall hall) {
		Theatre theatre = tService.findById(theatre_id);
		List<Hall> halls = theatre.getHalls();
		
		hall.setTheatre(theatre);
		halls.add(hall);
		theatre.setHalls(halls);
		
		tService.save(theatre);
	}
}
