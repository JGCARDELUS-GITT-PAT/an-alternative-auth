package com.jgcardelus.auth.service;

import com.jgcardelus.auth.model.UserModel;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    Iterable<UserModel> retrieveAll();
    UserModel create(UserModel user);
}
