package com.example.testtask.service;

import com.example.testtask.model.User;

public interface UserService {

    void create(User user);

    User view(int id);

    boolean change(User user, int id);

    boolean delete(int id);

}
