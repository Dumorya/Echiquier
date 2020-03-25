package com.tactfactory.monprojet.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Role extends BaseEntity {

  private String name;

  @ManyToMany(cascade = CascadeType.ALL)
  private final List<User> users = new ArrayList<User>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<User> getUsers() {
    return users;
  }
}
