package com.event.rentalManagement.repository.roleRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.rentalManagement.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
