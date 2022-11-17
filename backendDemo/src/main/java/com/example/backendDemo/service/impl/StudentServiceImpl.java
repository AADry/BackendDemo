package com.example.backendDemo.service.impl;

import com.example.backendDemo.model.Student;
import com.example.backendDemo.repository.StudentRepository;
import com.example.backendDemo.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    public StudentServiceImpl(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    private StudentRepository studentRepository;

    public Student saveStudent(Student student){
        return studentRepository.save(student);

    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> SearchStudentsByEmail(String query) {
        return studentRepository.searchByEmail(query);
    }

    @Override
    public List<Student> SearchStudentsByName(String query) {
        return studentRepository.searchByName(query);
    }

    @Override
    public List<Student> SearchStudentByDepartment(String query) {
        return studentRepository.searchByDepartment(query);
    }

}
