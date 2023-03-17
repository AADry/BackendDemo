package com.example.backendDemo.service.impl;

import com.example.backendDemo.model.User;
import com.example.backendDemo.repository.UserRepository;
import com.example.backendDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        if(userRepository.searchUser(user.getLogin()) != null) return true;
        return false;
    }


    public void deleteUser(User user) {
        userRepository.delete(user);
    }
    public void deleteAll(){
        userRepository.deleteAll();
    }
    public void printUsers() {
        List<User> users = userRepository.findAll();
        System.out.println(users);
    }
    public long countUsers(){
        return  userRepository.count();
    }
    public long countAll(){
        return userRepository.countAll();
    }
}
