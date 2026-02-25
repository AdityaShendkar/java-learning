package com.student.springbootdemopostmapping.Controller;

import com.student.springbootdemopostmapping.Entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class postController {

    List<Student> studList = new ArrayList<>();

    public postController() {
        studList.add(new Student(1, "Dhoni", 99.90f));
        studList.add(new Student(2, "Virat", 79.90f));
        studList.add(new Student(3, "Rohit", 89.90f));
        studList.add(new Student(4, "Ruturaj", 95.90f));
    }

    @GetMapping("/get-students")
    public List<Student> getStudents() {
        return studList;
    }

    @GetMapping("/get-student/{id}")
    public Student getStudentById(@PathVariable int id) {

        for (Student s : studList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    @PostMapping("/add-student")
    public String addStudent(@RequestBody Student student){
        studList.add(student);
        return "Student added successfully";
    }
}
