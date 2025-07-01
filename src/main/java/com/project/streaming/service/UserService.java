package com.project.streaming.service;

import com.project.streaming.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {

    public UserDetails loadUserByUsername(String username);

    public UserEntity saveUser(UserEntity user);

    public UserEntity updateUser(UserEntity user);

    public Optional<UserEntity> getUserById(String id);

    public Optional<UserEntity> getUserByEmail(String email);

    public Optional<UserEntity> findByUsername(String username);
}
