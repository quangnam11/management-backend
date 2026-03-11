package com.sinhvien.manager.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String studentCode; // Mã sinh viên

    @Column(nullable = false)
    private String fullName;

    private String email;
    private String phoneNumber;
    private String address;
}