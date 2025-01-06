package com.example.Student.dto;

import com.example.Student.model.User;
import lombok.*;
import com.example.Student.model.User.Role;
import java.util.List;
import java.util.stream.Collectors;
@Data
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String phoneNo;
    private Role role;
    private List<MarksDTO> marks;

    // Convert User entity to UserDTO
    public static UserDTO convertUToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNo(user.getPhoneNo());
        userDTO.setRole(user.getRole()); // Direct enum assignment



        // Convert List<Marks> to List<MarksDTO>
        List<MarksDTO> marksDTOList = user.getMarks().stream()
                .map(MarksDTO::userdto)
                .collect(Collectors.toList());
        userDTO.setMarks(marksDTOList);


        return userDTO;
    }



}
