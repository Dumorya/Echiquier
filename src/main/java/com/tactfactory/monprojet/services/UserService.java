package com.tactfactory.monprojet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tactfactory.monprojet.databases.UserRepository;
import com.tactfactory.monprojet.entities.Role;
import com.tactfactory.monprojet.entities.User;

@Service
public class UserService implements BaseService<User, Long> {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User save(User item) {
    return this.userRepository.save(item);
  }

  @Override
  public void delete(User item) {
    this.userRepository.delete(item);
  }

  @Override
  public User get(Long id) {
    return this.userRepository.findById(id).get();
  }

  @Override
  public List<User> getAll() {
    return this.userRepository.findAll();
  }
}
