package com.example.testtask.service;

import com.example.testtask.model.User;
import com.example.testtask.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public User view(int id) {
        return userRepository.getOne(id);
    }

    public boolean change(User user, int id){

        if (userRepository.existsById(id)) {
            user.setId(id);
            userRepository.save(user);
            return true;
        }

        return false;
    }

    public boolean delete(int id){
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
