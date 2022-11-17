package com.example.backendDemo.controller;

import com.example.backendDemo.model.Student;
import com.example.backendDemo.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {
    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    private StudentService studentService;
    @PostMapping()
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
    }
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/searchByName")
    public ResponseEntity<List <Student>> searchByName(@RequestParam String query){
        return ResponseEntity.ok(studentService.SearchStudentsByName(query));
    }
    @GetMapping("/searchByEmail")
    public ResponseEntity<List <Student>> searchByEmail(@RequestParam String query){
        return ResponseEntity.ok(studentService.SearchStudentsByEmail(query));
    }
    @GetMapping("/searchByDepartment")
    public ResponseEntity<List <Student>> searchByDepartment(@RequestParam String department){
        return ResponseEntity.ok(studentService.SearchStudentByDepartment(department));
    }
}
