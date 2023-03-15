package com.example.backendDemo.repository;

import com.example.backendDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query( "SELECT s FROM User s WHERE " +
            "s.login LIKE CONCAT('%', :query, '%')"
    )
    public List<User> searchUser(String query);


}
