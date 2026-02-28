package com.putmapping.springbootdemoputmapping.controller;

import com.putmapping.springbootdemoputmapping.entity.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {


    List<Student> studList = new ArrayList<>();

    public Controller() {
        studList.add(new Student(1, "Dhoni", 99.90f));
        studList.add(new Student(2, "Virat", 79.90f));
        studList.add(new Student(3, "Rohit", 89.90f));
        studList.add(new Student(4, "Ruturaj", 95.90f));
    }

    @GetMapping("/get-students")
    public List<Student> getStudents() {
        return studList;
    }

    // Update full student (ID, name, marks)
    @PutMapping("/update-student/{id}")
    public String updateStudent(@PathVariable int id, @RequestBody Student updatedStudent){
        for (Student s : studList){
            if (s.getId()==id){
//                System.out.println("Checking ID: " + s.getId());
                s.setName(updatedStudent.getName());
                s.setPer (updatedStudent.getPer());
            } return "Updated succesfully";
        }
        return "Student not found " ;
    }

    // Update only student name
    @PutMapping("/update-name/{id}")
    public String updateName(@PathVariable int id, @RequestParam String name) {
        for (Student s : studList) {
            if (s.getId() == id) {
                s.setName(name);
                return "Student name updated";
            }
        }
        return "Student not found";
    }

    // Update only student Per
    @PutMapping("/update-per/{id}")
    public String updateMarks(@PathVariable int id, @RequestParam float per) {
        for (Student s : studList) {
            if (s.getId() == id) {
                s.setPer(per);
                return "Student marks updated";
            }
        }
        return "Student not found";
    }


}
