package com.movie.tickets.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.tickets.entity.Owner;
import com.movie.tickets.repository.OwnerRepository;

@Service
public class OwnerService {
	
	@Autowired
	private OwnerRepository oRep;	
	
	public Owner findById(Long id) {
		return oRep.findById(id).orElse(null);
	}
	
	public Owner findByPhoneNo(String phoneNo) {
		return oRep.findByPhoneNo(phoneNo);
	}
	
	public Owner findByEmail(String email) {
		return oRep.findByEmail(email);
	}
	
	public void save(Owner owner) {
		oRep.save(owner);
	}
	
	public void delete(Owner owner) {
		oRep.delete(owner);
	}
	
	public void deleteByPhoneNo(String phoneNo) {
		oRep.deleteByPhoneNo(phoneNo);
	}
	
	public void deleteByEmail(String email) {
		oRep.deleteByEmail(email);
	}
	
	public String register(Owner owner) {
		if(owner.getName() == null) return "Enter your name";
		if(owner.getEmail() == null) return "Enter email";
		if(owner.getPhoneNo() == null) return "Enter phone number";
		if(owner.getPassword() == null) return "Enter password";
		
		if(oRep.save(owner) == owner) return "Registration successful";
		return "Unable to register, try again later";
	}
	
	public String login(Owner owner) {
		if(owner.getPhoneNo() != null) {
			Owner owner2 = oRep.findByPhoneNo(owner.getPhoneNo());
			if( owner2 != null ) {
				if( owner.getPassword().equals(owner2.getPassword()) ) return "login successful";
				else return "Invalid password";
			} else return "No user is registered with this number";
		}
		
		if(owner.getEmail() != null) {
			Owner owner2 = oRep.findByEmail(owner.getEmail());
			if( owner2 != null) {
				if(owner.getPassword() == owner2.getPassword()) return "login successful";
				else return "Invalid password";
			} else return "No user is registered with this email";
		}
		
		return "Enter number or email to login";
	}
}
