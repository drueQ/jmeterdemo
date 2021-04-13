package com.xdclass.jmeterdemo.service.impl;

import com.xdclass.jmeterdemo.model.User;
import com.xdclass.jmeterdemo.repository.UserRepository;
import com.xdclass.jmeterdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findBYId(long id) {
        User user = userRepository.findById(id).get();
        return user;
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void updateById(String password,long id) {
        userRepository.updateById(password, id);

    }
}
