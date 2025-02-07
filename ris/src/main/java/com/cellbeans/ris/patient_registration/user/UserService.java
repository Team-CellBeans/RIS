package com.cellbeans.ris.patient_registration.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserDTO> getAllUsers() {
		return userRepository.findAll().stream().map(user -> {
			UserDTO dto = new UserDTO();
			dto.setId(user.getId());
			dto.setName(user.getUserName());
			dto.setEmail(user.getEmail());
			dto.setRole(user.getRole());
			return dto;
		}).toList();
	}

	public Optional<UserDTO> getUserById(Long id) {
		return userRepository.findById(id).map(user -> {
			UserDTO dto = new UserDTO();
			dto.setId(user.getId());
			dto.setName(user.getUserName());
			dto.setEmail(user.getEmail());
			dto.setRole(user.getRole());
			return dto;
		});
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public User updateUser(Long id, User userDetails) {
		return userRepository.findById(id).map(user -> {
			user.setUserName(userDetails.getUserName());
			user.setEmail(userDetails.getEmail());
			user.setPassword(userDetails.getPassword());
			user.setRole(userDetails.getRole());
			return userRepository.save(user);
		}).orElseThrow(() -> new RuntimeException("User not found"));
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}
	

    public Optional<UserDTO> login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password).map(user -> {
            UserDTO dto = new UserDTO();
            dto.setId(user.getId());
            dto.setName(user.getUserName());
            dto.setEmail(user.getEmail());
            dto.setRole(user.getRole());
            return dto;
        });
    }

}
