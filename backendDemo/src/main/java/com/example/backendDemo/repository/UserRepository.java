package com.example.backendDemo.repository;

import com.example.backendDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query( "SELECT u FROM User u WHERE " +
            "u.login = :login"
    )
    public User searchUser(String login);
    @Modifying
    @Query(value = "DELETE FROM users WHERE u.login = :login", nativeQuery = true)
    public void deleteUser(String login);
    @Query(value = "Select * From users",nativeQuery = true)
    List<User> getAllUsers();
    @Query("select count(u) from User u")
    long countAll();
    
}
