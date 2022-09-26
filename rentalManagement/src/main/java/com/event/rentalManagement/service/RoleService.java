package com.event.rentalManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.rentalManagement.entity.Role;
import com.event.rentalManagement.repository.roleRepository.RoleRepository;

@Service
public class RoleService {

	@Autowired
    private RoleRepository roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
    
}
