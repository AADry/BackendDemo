package com.example.backendDemo.service.impl;

import com.example.backendDemo.model.User;
import com.example.backendDemo.repository.UserRepository;
import com.example.backendDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }
    @Transactional
    public User saveUser(User user){
        return userRepository.save(user);

    }
    public boolean isExists(User user){
        if(userRepository.searchUser(user.getLogin()).size() >0) return true;
        return false;
    }
}
