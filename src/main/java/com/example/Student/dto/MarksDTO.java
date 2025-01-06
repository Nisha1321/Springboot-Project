package com.example.Student.dto;

import com.example.Student.model.Marks;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MarksDTO {
    private Long id;
    private int marks;
    private String subjectName; // Include when needed
    private Long userId; // Include when needed
    private String username; // User's name (for subject context)

    public static MarksDTO userdto(Marks marks)
    {
        MarksDTO m = new MarksDTO();
        m.setId(marks.getId());
        m.setMarks(marks.getMarks());
        m.setSubjectName(marks.getSubject().getName());
        return m;
    }


    // Convert Marks entity to MarksDTO for subject context (exclude userId and subjectName)
    public static MarksDTO convertForSubjectContext(Marks marks) {
        MarksDTO a = new MarksDTO();
        a.setId(marks.getId());
        a.setMarks(marks.getMarks());
        a.setUsername(marks.getUser().getName()); // Include user's name only
        return a;
    }
    // Convert Marks entity to MarksDTO for general user context
    public static MarksDTO convertMToDTO(Marks marks) {
        MarksDTO marksDTO = new MarksDTO();
        marksDTO.setId(marks.getId());
        marksDTO.setMarks(marks.getMarks());
        marksDTO.setSubjectName(marks.getSubject().getName()); // Subject name
        marksDTO.setUsername(marks.getUser().getName()); // User ID
        return marksDTO;
    }
}
