package com.miapp.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miapp.crud.model.User;

public interface myRepository  extends JpaRepository<User, Long>{
  
}
