package com.example.Student.service;

import com.example.Student.dto.MarksDTO;
import com.example.Student.model.Marks;
import com.example.Student.repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MarksService {
     @Autowired
    private  MarksRepository marksRepository;




    // Create or Update Marks (works with entity)
    public Marks saveMarks(Marks marks) {
        return marksRepository.save(marks);
    }

    // Get Marks by ID (returns MarksDTO)
    public MarksDTO getMarksById(Long id) {
        Optional<Marks> marks = marksRepository.findById(id);
        // or throw an exception like MarksNotFoundException
        return marks.map(MarksDTO::convertMToDTO).orElse(null);
    }

    // Get All Marks (returns list of MarksDTO)
    public List<MarksDTO> getAllMarks() {
        List<Marks> marksList = marksRepository.findAll();
        return marksList.stream().map(MarksDTO::convertMToDTO).collect(Collectors.toList());
    }

    // Update Marks by ID (works with entity)
    public Marks updateMarks(Long id, Marks marks) {
        Optional<Marks> existingMarks = marksRepository.findById(id);
        if (existingMarks.isPresent()) {
            Marks existing = existingMarks.get();
            existing.setMarks(marks.getMarks());
            return marksRepository.save(existing);
        }
        return null; // or throw an exception
    }

    // Delete Marks by ID (works with entity)
    public boolean deleteMarks(Long id) {
        Optional<Marks> marks = marksRepository.findById(id);
        if (marks.isPresent()) {
            marksRepository.delete(marks.get());
            return true;
        }
        return false; // or throw an exception
    }
}
