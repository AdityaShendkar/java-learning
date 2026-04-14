package com.postgresqlcrud.service;

import com.postgresqlcrud.entity.Student;
import com.postgresqlcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Student updateStudent(Long id, Student student) {
        Student existing = studentRepository.findById(id).orElse(null);

        if (existing != null) {
            existing.setName(student.getName());
            existing.setStandard(student.getStandard());
            return studentRepository.save(existing);
        }
        return null;
    }

    public String deleteStudent(Long id) {
        studentRepository.deleteById(id);
        return "Student deleted successfully";
    }


}
