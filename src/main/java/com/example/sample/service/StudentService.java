package com.example.sample.service;

import com.example.sample.Entity.Student;
import com.example.sample.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public void saveUpdate(Student students) {
        studentRepo.save(students);
    }

    public Iterable<Student> listAll() {
        return this.studentRepo.findAll();
    }


    public void deleteStudent(String id) {
        studentRepo.deleteById(id);
    }

    public Student getStudentById(String studentId) {
        return (Student) studentRepo.findById(studentId).get();
    }
}
