package com.tactfactory.monprojet.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class User extends BaseEntity {

  private String firstname;
  private String lastname;
  private String email;

  @ManyToMany(targetEntity = Role.class, mappedBy = "users", cascade = CascadeType.ALL)
  private final List<Role> roles = new ArrayList<Role>();

  @OneToMany(cascade = CascadeType.ALL)
  private final List<Article> articles = new ArrayList<Article>();

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public List<Article> getArticles() {
    return articles;
  }

}
