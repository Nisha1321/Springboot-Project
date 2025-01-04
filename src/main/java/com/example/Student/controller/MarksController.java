package com.example.Student.controller;

import com.example.Student.model.Marks;
import com.example.Student.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@Controller
@RequestMapping("/marks")
public class MarksController {

    @Autowired
    private MarksService marksService;

    // Get all marks
    @GetMapping
    @ResponseBody
    public List<Marks> getAllMarks() {
        List<Marks> marksList = marksService.getAllMarks();
        return marksList;  // This will return the marks as JSON
    }

    // Get marks by ID
    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Marks> getMarksById(@PathVariable Long id) {
        Optional<Marks> marks = marksService.getMarksById(id);
        return marks;  // This will return the marks details as JSON
    }

    // Create a new marks entry
    @PostMapping
    @ResponseBody
    public String createMarks(@RequestBody Marks marks) {
        try {
            marksService.saveMarks(marks);
        } catch (IllegalArgumentException e) {
            // Handle exception and show an error message
            return "Only students can have marks assigned.";
        }
        return "Marks created successfully";  // Response message in plain text
    }

    // Update an existing marks entry
    @PutMapping("/{id}")
    @ResponseBody
    public String updateMarks(@PathVariable Long id, @RequestBody Marks marks) {
        try {
            marksService.updateMarks(id, marks);
        } catch (IllegalArgumentException e) {
            // Handle exception and show an error message
            return "Only students can have marks updated.";
        }
        return "Marks updated successfully";  // Response message in plain text
    }

    // Delete marks entry
    @DeleteMapping("/{id}")
    @ResponseBody
    public String deleteMarks(@PathVariable Long id) {
        marksService.deleteMarks(id);
        return "Marks deleted successfully";
    }
}
