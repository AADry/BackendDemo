package com.example.backendDemo.service;

import com.example.backendDemo.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public interface UserService {
    @Transactional
    User saveUser(User user);
    @Transactional
    void deleteUser(User user);
    void printUsers();
}
