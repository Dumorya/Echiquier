package com.tactfactory.monprojet.databases;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tactfactory.monprojet.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
