package com.example.studentapi.repository;

import com.example.studentapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

// Extending JpaRepository gives us save(), findAll(), findById(), deleteById() for free
public interface StudentRepository extends JpaRepository<Student, Long> {
}
