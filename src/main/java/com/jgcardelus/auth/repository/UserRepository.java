package com.jgcardelus.auth.repository;

import com.jgcardelus.auth.model.UserModel;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Long>{
    public UserModel findByUsername(String username);
}
