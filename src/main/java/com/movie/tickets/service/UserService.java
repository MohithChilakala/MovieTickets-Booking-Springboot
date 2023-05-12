package com.movie.tickets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.tickets.entity.User;
import com.movie.tickets.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository uRep;
	
	public User findById(Long id) {
		return uRep.findById(id).orElse(null);
	}
	
	public User findByPhoneNo(String phoneNo) {
		return uRep.findByPhoneNo(phoneNo);
	}
	
	public User findByEmail(String email) {
		return uRep.findByEmail(email);
	}
	
	public void save(User user) {
		uRep.save(user);
	}
	
	public void delete(User user) {
		uRep.delete(user);
	}
	
	public void deleteByPhoneNo(String phoneNo) {
		uRep.deleteByPhoneNo(phoneNo);
	}
	
	public void deleteByEmail(String email) {
		uRep.deleteByEmail(email);
	}
}
