package com.raj.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.main.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	

}
