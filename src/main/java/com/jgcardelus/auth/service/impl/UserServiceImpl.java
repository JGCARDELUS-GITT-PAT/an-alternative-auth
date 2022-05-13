package com.jgcardelus.auth.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.jgcardelus.auth.model.UserModel;
import com.jgcardelus.auth.repository.UserRepository;
import com.jgcardelus.auth.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository repository;

    @Override
    public Iterable<UserModel> retrieveAll() {
        return repository.findAll();
    }

    @Override
    public UserModel create(UserModel user) {
        user.setUserId(null);
        return repository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        UserModel user = repository.findByUsername(username);
        List<GrantedAuthority> authorities = new ArrayList<>();
        UserDetails newUser = new User(user.getUsername(), user.getPassword(), authorities);
        return newUser;
    }
}
