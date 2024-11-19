package com.ashishrai.rest.webservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	private UserDaoService service;

	public UserResource(UserDaoService service) {
		this.service = service;
	}

	@GetMapping("/users")
	public List<User> retrieveAllUser() {
		return service.findAll();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> retrieveUser(@PathVariable Integer id) {
		User user = service.findById(id);
		return ResponseEntity.ok(user);

	}

	@DeleteMapping("/users/{id}")
	public void removeUser(@PathVariable Integer id) {
		service.removeById(id);
	}

	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

}