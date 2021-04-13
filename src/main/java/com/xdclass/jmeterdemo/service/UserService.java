package com.xdclass.jmeterdemo.service;

import com.xdclass.jmeterdemo.model.User;

import java.util.List;

public interface UserService {

    User findBYId(long id);

    void addUser(User user);

    void updateUser(User user);

    void deleteById(long id);

    List<User> getAllUser();

    void updateById(String password,long id);

}
