package com.event.rentalManagement.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.event.rentalManagement.entity.ForgotPassword;
import com.event.rentalManagement.entity.Role;
import com.event.rentalManagement.entity.User;
import com.event.rentalManagement.repository.roleRepository.RoleRepository;
import com.event.rentalManagement.repository.userRepository.UserRepository;

@Service
public class UserService {

	@Autowired
    private UserRepository userDao;

    @Autowired
    private RoleRepository roleDao;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin");
        adminUser.setUserPassword(getEncodedPassword("password"));
        adminUser.setUserEmail("admin@gmail.com");
        adminUser.setUserSecretPin(Long.parseLong("9696"));
        adminUser.setUserAddress("Nanded District, Hadgaon");
        adminUser.setUserPhoneNumber("9330689787");
        adminUser.setUserDob("01/02/1980");
        adminUser.setUserStatus(true);
        adminUser.setUserFirstName("Mr");
        adminUser.setUserLastName("Jaiswal");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

//        User user = new User();
//        user.setUserName("chanakya123");
//        user.setUserPassword(getEncodedPassword("chanakya@123"));
//        user.setUserFirstName("chanakya");
//        user.setUserLastName("Lahiri");
//        Set<Role> userRoles = new HashSet<>();
//        userRoles.add(userRole);
//        user.setRole(userRoles);
//        userDao.save(user);
    }

    public User registerNewUser(User user) {
        Role role = roleDao.findById("User").get();
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(role);
        user.setRole(userRoles);
        user.setUserPassword(getEncodedPassword(user.getUserPassword()));

        return userDao.save(user);
    }
    
    ////////Version 2 apis start////////////////////////////////////////////////////
    
    
    public User registerNewUserService(User user) {
    	
    	return userDao.insertNewUser(user);
    }
    
    public User getByUsernameService(String username) {
    	
    	return userDao.getByUsername(username);
    }
    
    public List<User> getAllUsersListService() {
    	
    	return userDao.getAllUsersList();
    }
    
    public User getUserByUserEmailService(String userEmail) {
    	
    	return userDao.getUserByUserEmail(userEmail);
    }
    
    public User forgotPasswordService(ForgotPassword forgotPassword) {
    	
    	return userDao.forgotPassword(forgotPassword);
    }
    
    public User updateProfileService(User user) {
    	
    	return userDao.updateProfile(user);
    }
    
    public User deleteUserProfileService(String userEmail) {
    	
    	return userDao.deleteUserProfile(userEmail);
    }
}
