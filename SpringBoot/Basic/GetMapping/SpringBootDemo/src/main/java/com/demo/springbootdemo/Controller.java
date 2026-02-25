package com.demo.springbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    @GetMapping("/")
    public String welcome() {
        return "Welcome to RESTFUL-API's";
    }

    @GetMapping("/data")
    public int data() {
        return 8686;
    }

    @GetMapping("/get-student")
    public Student getStudent() {
        Student s1 = new Student(1, "Dhoni", 99.99f);
        return s1;
    }

    @GetMapping("/get-students")
    public List<Student> getStudents() {
        List<Student> studList = new ArrayList<>();
        studList.add(new Student(1, "Dhoni", 99.90f));
        studList.add(new Student(2, "Virat", 79.90f));
        studList.add(new Student(3, "Rohit", 89.90f));
        studList.add(new Student(4, "Ruturaj", 95.90f));
        return studList;
    }

    @GetMapping("/get-student/{id}")
    public Student getStudentById(@PathVariable int id) {

        List<Student> studList = getStudents(); // calling separate method

        for (Student s : studList) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }
}
