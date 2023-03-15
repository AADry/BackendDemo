package com.example.backendDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.backendDemo.model.Student;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    @Query("SELECT s FROM Student s WHERE " +
        "s.name LIKE CONCAT('%', :query, '%')"
    )
    List<Student> searchByName(String query);
    @Query("SELECT s FROM Student s WHERE " +
            "s.email LIKE CONCAT('%', :query, '%')"
    )
    List<Student> searchByEmail(String query);

    @Query(value = "SELECT * FROM students s, departments d where s.department_id = d.id AND d.name LIKE concat('%', :department, '%')", nativeQuery = true)
    List<Student> searchByDepartment(String department);
}
