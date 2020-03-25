package com.tactfactory.monprojet.databases;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tactfactory.monprojet.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
