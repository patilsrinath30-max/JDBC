package com.example.studentapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    // GET ALL
    @GetMapping
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id) {

        Optional<Student> student = repository.findById(id);

        return student.orElse(null);
    }

    // ADD
    @PostMapping
    public String addStudent(@RequestBody Student student) {

        repository.save(student);
        return "Student Added Successfully";
    }

    // UPDATE
    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id,
                                @RequestBody Student updatedStudent) {

        Optional<Student> optionalStudent = repository.findById(id);

        if (optionalStudent.isPresent()) {

            Student student = optionalStudent.get();

            student.setName(updatedStudent.getName());
            student.setBranch(updatedStudent.getBranch());
            student.setAge(updatedStudent.getAge());

            repository.save(student);

            return "Student Updated Successfully";
        }

        return "Student Not Found";
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {

        if (repository.existsById(id)) {

            repository.deleteById(id);

            return "Student Deleted Successfully";
        }

        return "Student Not Found";
    }

}
