package com.movie.tickets.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.tickets.entity.Booking;
import com.movie.tickets.entity.Seat;
import com.movie.tickets.entity.Show;
import com.movie.tickets.entity.User;
import com.movie.tickets.service.SeatService;
import com.movie.tickets.service.ShowService;
import com.movie.tickets.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService uService;
	
	@Autowired
	private ShowService showService;
	
	@Autowired
	private SeatService seatService;
	
	
	
	@PostMapping("/register")
	public void register(@RequestBody User user) {
		uService.save(user);
	}
	
	@PatchMapping("/book/{user_id}/{show_id}")
	public void book(@PathVariable("user_id") long user_id, @PathVariable("show_id") long show_id, @RequestBody List<Long> seats_id) {
		Booking booking = new Booking();
		
		User user = uService.findById(user_id); booking.setUser(user);
		Show show = showService.findById(show_id); booking.setShow(show);
		
		List<Seat> seats = booking.getSeats();
		
		for(long id : seats_id) {
			Seat seat = seatService.findById(id);
			seat.setStatus(Seat.UNAVAILABLE);
			seat.setBooking(booking);
			
			seats.add(seat);
		}
		
		booking.setSeats(seats);
		uService.save(user);
	}
}
