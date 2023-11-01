package com.example.sample.controller;

import com.example.sample.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.sample.Entity.Student;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public String saveStudent(@RequestBody Student students) {
        studentService.saveUpdate(students);
        return students.get_id();
    }

    @GetMapping("/getAll")
    public Iterable<Student> getAllStudents() {
        return studentService.listAll();
    }

    @PutMapping("/edit/{id}")
    public  Student editStudent(@PathVariable(name="id") String _id, @RequestBody Student student) {
        student.set_id(_id);
        studentService.saveUpdate(student);
        return student;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable(name="id") String _id) {

        studentService.deleteStudent(_id);
    }

    @RequestMapping("/student/{id}")
    public Student getStudent(@PathVariable(name="id") String studentId) {
        return studentService.getStudentById(studentId);
    }
}
