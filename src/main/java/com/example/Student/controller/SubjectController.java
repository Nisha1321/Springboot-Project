package com.example.Student.controller;

import com.example.Student.dto.SubjectDTO;
import com.example.Student.model.Subject;
import com.example.Student.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    // Create or Update Subject
    @PostMapping
    public Subject saveSubject(@RequestBody Subject subject) {
        return subjectService.saveSubject(subject);
    }

    // Get Subject by ID (returns SubjectDTO)
    @GetMapping("/{id}")
    public SubjectDTO getSubjectById(@PathVariable Long id) {
        return subjectService.getSubjectById(id);
    }

    // Get All Subjects (returns list of SubjectDTO)
    @GetMapping
    public List<SubjectDTO> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    // Update Subject by ID
    @PutMapping("/{id}")
    public Subject updateSubject(@PathVariable Long id, @RequestBody Subject subject) {
        return subjectService.updateSubject(id, subject);
    }

    // Delete Subject by ID
    @DeleteMapping("/{id}")
    public boolean deleteSubject(@PathVariable Long id) {
        return subjectService.deleteSubject(id);
    }
}
