package com.example.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdemo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	public boolean existsByUserName(String userName);
	public boolean existsByUserNameAndPassword(String userName, String password);
}