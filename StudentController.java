// package com.example.demo;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RestController;

// @RestController
// public class StudentController {

//     @GetMapping("/student")
//     public Student getStudent() {

//         return new Student(101, "Rahul");

//     }

// }


package com.example.demo;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @GetMapping
    public String getAllStudents() {
        return "Displaying all students";
    }

    @PostMapping
    public String addStudent() {
        return "Student Added Successfully";
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable int id) {
        return "Student " + id + " Updated";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        return "Student " + id + " Deleted";
    }

}