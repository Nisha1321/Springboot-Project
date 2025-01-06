package com.example.Student.service;

import com.example.Student.dto.UserDTO;
import com.example.Student.model.User;
import com.example.Student.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    // Create or Update User (Works directly with User entity)
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Get User by ID (Only returns UserDTO)
    public UserDTO getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return UserDTO.convertUToDTO(user.get());
        }
        return null; // or throw an exception like UserNotFoundException
    }

    // Get All Users (Returns List of UserDTO)
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDTO::convertUToDTO).collect(Collectors.toList());
    }

    // Update User by ID (Works directly with User entity)
    public User updateUser(Long id, User user) {
        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isPresent()) {
            User existing = existingUser.get();
            existing.setName(user.getName());
            existing.setEmail(user.getEmail());
            existing.setPhoneNo(user.getPhoneNo());
            existing.setRole(user.getRole());
            // Update other fields if needed (like subjects, marks, etc.)

            return userRepository.save(existing);
        }
        return null; // or throw an exception
    }

    // Delete User by ID (Works directly with User entity)
    public boolean deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return true;
        }
        return false; // or throw an exception
    }
}
