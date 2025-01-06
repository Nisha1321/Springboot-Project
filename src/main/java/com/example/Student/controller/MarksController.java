package com.example.Student.controller;

import com.example.Student.dto.MarksDTO;
import com.example.Student.model.Marks;
import com.example.Student.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarksController {

    private final MarksService marksService;

    @Autowired
    public MarksController(MarksService marksService) {
        this.marksService = marksService;
    }

    // Create or Update Marks
    @PostMapping
    public Marks saveMarks(@RequestBody Marks marks) {
        return marksService.saveMarks(marks);
    }

    // Get Marks by ID (returns MarksDTO)
    @GetMapping("/{id}")
    public MarksDTO getMarksById(@PathVariable Long id) {
        return marksService.getMarksById(id);
    }

    // Get All Marks (returns list of MarksDTO)
    @GetMapping
    public List<MarksDTO> getAllMarks() {
        return marksService.getAllMarks();
    }

    // Update Marks by ID
    @PutMapping("/{id}")
    public Marks updateMarks(@PathVariable Long id, @RequestBody Marks marks) {
        return marksService.updateMarks(id, marks);
    }

    // Delete Marks by ID
    @DeleteMapping("/{id}")
    public boolean deleteMarks(@PathVariable Long id) {
        return marksService.deleteMarks(id);
    }
}
