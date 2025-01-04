package com.example.Student.service;

import com.example.Student.model.Subject;
import com.example.Student.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    // Get all subjects
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    // Get a subject by ID
    public Optional<Subject> getSubjectById(Long id) {
        return subjectRepository.findById(id);
    }

    // Save a new subject
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    // Update an existing subject
    public Subject updateSubject(Long id, Subject subjectDetails) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subject not found with id " + id));

        subject.setName(subjectDetails.getName());

        return subjectRepository.save(subject);
    }

    // Delete a subject by ID
    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }
    // Delete all subjects
    public void deleteAllSubjects() {
        subjectRepository.deleteAll();  // Deletes all subjects from the database
    }
}
