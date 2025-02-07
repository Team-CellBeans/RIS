package com.cellbeans.ris.patient_registration.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	  @Autowired
	    private UserService userService;

	    @GetMapping("/getAllUser")
	    public List<UserDTO> getAllUsers() {
	        return userService.getAllUsers();
	    }

	    @GetMapping("/{id}")
	    public Optional<UserDTO> getUserById(@PathVariable Long id) {
	        return userService.getUserById(id);
	    }

	    @PostMapping("/create")
	    public User createUser(@RequestBody User user) {
	        return userService.createUser(user);
	    }

	    @PutMapping("/{id}")
	    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
	        return userService.updateUser(id, userDetails);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteUser(@PathVariable Long id) {
	        userService.deleteUser(id);
	    }
	    
	    @PostMapping("/login")
	    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
	        Optional<UserDTO> user = userService.login(loginRequest.getEmail(), loginRequest.getPassword());
	        return user.<ResponseEntity<?>>map(ResponseEntity::ok)
	                   .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials"));
	    }


}
