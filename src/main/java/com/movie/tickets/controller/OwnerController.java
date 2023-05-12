package com.movie.tickets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.tickets.entity.Owner;
import com.movie.tickets.entity.Theatre;
import com.movie.tickets.service.OwnerService;

@RestController
@RequestMapping("/owner")
public class OwnerController {
	
	@Autowired
	private OwnerService oService;
	
	@PostMapping("/register")
	public String register(@RequestBody Owner owner) {
		return oService.register(owner);
	}
	
	@PatchMapping("/add/theatre/{id}")
	public void update(@PathVariable long id, @RequestBody Theatre theatre) {
		Owner owner = oService.findById(id);
		List<Theatre> theatres = owner.getTheatres();
		
		theatre.setOwner(owner);
		theatre.getAddress().setTheatre(theatre);
		theatres.add(theatre);
		owner.setTheatres(theatres);
		
		oService.save(owner);
	}
	
	@GetMapping("/search")
	public Owner getOwner(@RequestBody String search) {
		if(search.charAt(0) >= '0' && search.charAt(0) <= '9') return oService.findByPhoneNo(search);
		return oService.findByEmail(search);
	}
	
	@GetMapping("/login")
	public String login(@RequestBody Owner owner) {
		return oService.login(owner);
	}
}
