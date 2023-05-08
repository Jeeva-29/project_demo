package com.example.springdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springdemo.entity.DemoEntity;

@Repository
public interface DemoRepository extends JpaRepository<DemoEntity,Integer>{

}
