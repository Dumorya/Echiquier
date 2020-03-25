package com.tactfactory.monprojet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tactfactory.monprojet.databases.RoleRepository;
import com.tactfactory.monprojet.entities.Role;

@Service
public class RoleService implements BaseService<Role, Long> {

  @Autowired
  private RoleRepository roleRepository;

  @Override
  public Role save(Role item) {
    return this.roleRepository.save(item);
  }

  @Override
  public void delete(Role item) {
    this.roleRepository.delete(item);
  }

  @Override
  public Role get(Long id) {
    return this.roleRepository.findById(id).get();
  }

  @Override
  public List<Role> getAll() {
    return this.roleRepository.findAll();
  }
}
