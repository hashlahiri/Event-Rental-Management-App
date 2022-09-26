package com.event.rentalManagement.repository.userRepository;

import java.util.List;

import com.event.rentalManagement.entity.ForgotPassword;
import com.event.rentalManagement.entity.User;

public interface UserRepositoryCustom {
	
	public User insertNewUser(User user);
	
	public User getByUsername(String username);
	
	public List<User> getAllUsersList();
	
	public User getUserByUserEmail(String userEmail);
	
	public User forgotPassword(ForgotPassword forgotPassword);
	
	public User updateProfile(User user);
	
	public User deleteUserProfile(String userEmail);

}
