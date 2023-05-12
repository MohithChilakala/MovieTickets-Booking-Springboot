package com.movie.tickets.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.tickets.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByPhoneNo(String phoneNo);
	User findByEmail(String email);
	void deleteByEmail(String email);
	void deleteByPhoneNo(String phoneNo);

}
