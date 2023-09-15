package com.miapp.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miapp.crud.model.User;
import com.miapp.crud.repository.myRepository;

@Service
public class myService implements interfaceService{

  @Autowired
  private myRepository repository;

  @Override
  public User saveUser(User user) {
    return this.repository.save(user);
  }

  @Override
  public List<User> getUserAll() {
    return this.repository.findAll();
  }

  @Override
  public User updateUser(User user) {
    return this.repository.save(user);
  }

  @Override
  public User getUserById(Long id) {
    return this.repository.findById(id).get();
  }

  @Override
  public void deleteUser(Long id) {
    this.repository.deleteById(id);
  }

  
}
