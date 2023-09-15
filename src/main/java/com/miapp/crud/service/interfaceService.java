package com.miapp.crud.service;

import java.util.List;

import com.miapp.crud.model.User;

public interface interfaceService {
  
  public User saveUser(User user);
  public List<User> getUserAll();
  public User updateUser(User user);
  public User getUserById(Long id);
  public void deleteUser(Long id);
  
}
