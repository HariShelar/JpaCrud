package com.jpa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.jpa.Entity.Usernew;
import com.jpa.UserRepository.UserRepository;
import com.jpa.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
	@Autowired
	private UserRepository userRepository;
	
	//get all users
	@GetMapping
	public List<Usernew>getAllUsers(){
		return this.userRepository.findAll();
	}
	
	//get user by id
	@GetMapping("/{id}")
	public Usernew getUserById(@PathVariable(value="id") long userId) {
		return this.userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User not found with id:"+userId));
	}
	
	//create user
	@PostMapping
	public Usernew createUser(@RequestBody Usernew user) {
		return this.userRepository.save(user);
	}
	
	//update user
	@PutMapping("/{id}")
	public Usernew updateUser(@RequestBody Usernew user,@PathVariable("id") long userId) {
		Usernew existingUser=this.userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User not found with id:"+userId));
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		return this.userRepository.save(existingUser);
	}
	
	//delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<Usernew>deleteUser(@PathVariable("id") long userId){
		Usernew existingUser=this.userRepository.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User not found with id:" +userId));
		this.userRepository.delete(existingUser);
		return ResponseEntity.ok().build();
	}
	
}
