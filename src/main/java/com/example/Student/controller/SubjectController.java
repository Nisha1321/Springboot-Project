package com.example.Student.controller;

import com.example.Student.model.Subject;
import com.example.Student.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller  // Using @Controller to handle the requests
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    // Get all subjects
    @GetMapping
    @ResponseBody  // Ensures response is returned as JSON
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();  // Automatically returns JSON
    }

    // Get subject by ID
    @GetMapping("/{id}")
    @ResponseBody  // Ensures response is returned as JSON
    public Optional<Subject> getSubjectById(@PathVariable Long id) {
        return subjectService.getSubjectById(id);  // Automatically returns JSON
    }

    // Create a new subject
    @PostMapping
    @ResponseBody  // Ensures response is returned as JSON
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectService.saveSubject(subject);  // Automatically returns the created subject as JSON
    }

    // Update an existing subject
    @PutMapping("/{id}")
    @ResponseBody  // Ensures response is returned as JSON
    public Subject updateSubject(@PathVariable Long id, @RequestBody Subject subject) {
        return subjectService.updateSubject(id, subject);  // Automatically returns the updated subject as JSON
    }

    // Delete a subject
    @DeleteMapping("/{id}")
    @ResponseBody  // Ensures response is returned as JSON
    public void deleteSubject(@PathVariable Long id) {
        subjectService.deleteSubject(id);  // No return value, it just deletes the subject
    }

    // Delete all subjects
    @DeleteMapping("/all")
    @ResponseBody  // Ensures response is returned as JSON
    public void deleteAllSubjects() {
        subjectService.deleteAllSubjects();  // Call the service method to delete all subjects
    }
}
