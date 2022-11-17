package com.example.backendDemo.service;

import com.example.backendDemo.model.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    List<Student> SearchStudentsByEmail(String query);
    List<Student> SearchStudentsByName(String query);
    List<Student> SearchStudentByDepartment(String query);
    //Student getEmployeeById(long id);
    //Student updateEmployee(Student employee, long id);
    //void deleteEmployee(long id);
}
