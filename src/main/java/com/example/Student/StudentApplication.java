package com.example.Student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.Student.model.User;
import com.example.Student.model.Subject;
import com.example.Student.model.Marks;
import com.example.Student.repository.UserRepository;
import com.example.Student.repository.SubjectRepository;
import com.example.Student.repository.MarksRepository;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

}
