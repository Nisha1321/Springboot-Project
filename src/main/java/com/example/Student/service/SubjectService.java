package com.example.Student.service;

import com.example.Student.dto.SubjectDTO;
import com.example.Student.model.Subject;
import com.example.Student.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectService {
    @Autowired
    private  SubjectRepository subjectRepository;



    // Create or Update Subject (works with entity)
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    // Get Subject by ID (returns SubjectDTO)
    public SubjectDTO getSubjectById(Long id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        if (subject.isPresent()) {
            return SubjectDTO.convertSToDTO(subject.get());
        }
        return null; // or throw an exception like SubjectNotFoundException
    }

    // Get All Subjects (returns list of SubjectDTO)
    public List<SubjectDTO> getAllSubjects() {
        List<Subject> subjects = subjectRepository.findAll();
        return subjects.stream().map(SubjectDTO::convertSToDTO).collect(Collectors.toList());
    }

    // Update Subject by ID (works with entity)
    public Subject updateSubject(Long id, Subject subject) {
        Optional<Subject> existingSubject = subjectRepository.findById(id);
        if (existingSubject.isPresent()) {
            Subject existing = existingSubject.get();
            existing.setName(subject.getName());
            return subjectRepository.save(existing);
        }
        return null; // or throw an exception
    }

    // Delete Subject by ID (works with entity)
    public boolean deleteSubject(Long id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        if (subject.isPresent()) {
            subjectRepository.delete(subject.get());
            return true;
        }
        return false; // or throw an exception
    }
}
