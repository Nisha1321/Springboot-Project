package com.example.Student.service;

import com.example.Student.model.Marks;
import com.example.Student.repository.MarksRepository;
import com.example.Student.model.User;
import com.example.Student.repository.UserRepository;  // Assuming a repository for User
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarksService {

    @Autowired
    private MarksRepository marksRepository;

    @Autowired
    private UserRepository userRepository;  // Assuming this exists to fetch User by ID

    // Get all marks
    public List<Marks> getAllMarks() {
        return marksRepository.findAll();
    }

    // Get marks by ID
    public Optional<Marks> getMarksById(Long id) {
        return marksRepository.findById(id);
    }

    // Save new marks entry
    public Marks saveMarks(Marks marks) {
        // Validate that user exists and is a student
        Optional<User> userOpt = userRepository.findById(marks.getUser().getId());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getRole() != User.Role.STUDENT) {
                throw new IllegalArgumentException("Only students can have marks assigned.");
            }
        } else {
            throw new IllegalArgumentException("User not found.");
        }

        return marksRepository.save(marks);
    }

    // Update an existing marks entry
    public Marks updateMarks(Long id, Marks marksDetails) {
        Marks marks = marksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marks not found with id " + id));

        // Validate user role during update
        Optional<User> userOpt = userRepository.findById(marksDetails.getUser().getId());
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getRole() != User.Role.STUDENT) {
                throw new IllegalArgumentException("Only students can have marks updated.");
            }
        } else {
            throw new IllegalArgumentException("User not found.");
        }

        marks.setMarks(marksDetails.getMarks());
        marks.setUser(marksDetails.getUser());
        marks.setSubject(marksDetails.getSubject());

        return marksRepository.save(marks);
    }

    // Delete marks by ID
    public void deleteMarks(Long id) {
        marksRepository.deleteById(id);
    }
}
