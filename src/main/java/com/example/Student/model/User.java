package com.example.Student.model;

import jakarta.persistence.*;

@Entity
@Table(name = "app_user")  // Specify the table name explicitly
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")  // Specify column name explicitly
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")  // Specify column name explicitly
    private Role role;

    @Column(name = "email")  // Specify column name explicitly
    private String email;

    @Column(name = "phone_no")  // Specify column name explicitly
    private String phoneNo;

    @Column(name = "password")  // Specify column name explicitly
    private String password;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Enum for Role
    public enum Role {
        STUDENT, TEACHER
    }
}
