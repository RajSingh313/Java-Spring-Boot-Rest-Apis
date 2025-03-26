package com.raj.main.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.main.entities.User;
import com.raj.main.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
		
	}
	
	public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
	
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	
	public User updateUser(Long id, User updatedUser) {
		return userRepository.findById(id).map(user -> {
			user.setName(updatedUser.getName());
			user.setEmail(updatedUser.getEmail());
			return userRepository.save(user);
		}).orElseThrow(()-> new RuntimeException("user not found on id " + id));
	}
	
	public void deleteUser( long id) {
		userRepository.deleteById(id);
	}

}
