package com.example.Student.dto;

import com.example.Student.model.Subject;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class SubjectDTO {
    private Long id;
    private String name;
    private List<MarksDTO> marks;

    // Convert Subject entity to SubjectDTO
    public static SubjectDTO convertSToDTO(Subject subject) {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setId(subject.getId());
        subjectDTO.setName(subject.getName());


// Populate the marks field
        List<MarksDTO> marksDTOList = subject.getMarks().stream()
                .map(MarksDTO::convertForSubjectContext) // Convert marks for the subject context
                .collect(Collectors.toList());
        subjectDTO.setMarks(marksDTOList); // Set the marks list to the DTO

        return subjectDTO;
    }
}
