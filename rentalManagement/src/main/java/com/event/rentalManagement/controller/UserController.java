package com.event.rentalManagement.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.event.rentalManagement.entity.ForgotPassword;
import com.event.rentalManagement.entity.User;
import com.event.rentalManagement.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
//remove this when invoking the register user built-in api 'registerNewUser'
@RequestMapping("/api/user")
public class UserController {

	@Autowired
    private UserService userService;

    @PostConstruct
    public void initRoleAndUser() {
        userService.initRoleAndUser();
    }

    @PostMapping({"/registerNewUser"})
    public User registerNewUser(@RequestBody User user) {
        return userService.registerNewUser(user);
    }

    @PreAuthorize("hasRole('Admin')")
    @GetMapping({"/forAdmin"})
    public String forAdmin(){
        return "This URL is only accessible to the admin";
    }


    @PreAuthorize("hasRole('User')")
    @GetMapping({"/forUser"})
    public String forUser(){
        return "This URL is only accessible to the user";
    }
    
    //////////// V2 APIS /////////////////////////////////////////////////////
    
    @ApiOperation(value = "Register a new user v2", notes = "API to insert / register a new user and set role for user")
	@RequestMapping(value = "/insertNewUser/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> registerNewUserController(
			@RequestBody(required = true) User user) {

		User response = userService.registerNewUserService(user);

		return new ResponseEntity<User>(response, HttpStatus.ACCEPTED);
	}
    
    @ApiOperation(value = "Get user by username", notes = "API to get user by username")
	@RequestMapping(value = "/getByUsername/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> getUserByUsernameController(
			@RequestParam(value = "username", required = true) String username) {

		User response = userService.getByUsernameService(username);
		
		if(response == null)
			return new ResponseEntity<User>(response, HttpStatus.NO_CONTENT);

		return new ResponseEntity<User>(response, HttpStatus.OK);
	}
    
    @ApiOperation(value = "Get all user by list", notes = "API to get all user by list")
    @RequestMapping(value = "/getAllUsers/list/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUserByListController() {
    	
    	List<User> response = userService.getAllUsersListService();
    	
    	return new ResponseEntity<List<User>>(response, HttpStatus.OK);
    }
    
    @ApiOperation(value = "Get user by user email and user status", notes = "API to get user by email and user status")
    @RequestMapping(value = "/getUserByEmail/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserByEmailController(
    		@RequestParam(value = "userEmail", required = true) String userEmail) {
    	
    	User response = userService.getUserByUserEmailService(userEmail);
    	
    	return new ResponseEntity<User>(response, HttpStatus.OK);
    }
    
    //forgotPassword API
    @ApiOperation(value = "Get user by userEmail and secretPin and userStatus", notes = "API to reset password upon forgot password by email, pin")
    @RequestMapping(value="/forgotPassword/", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> forgotPasswordController(
    		@RequestBody(required = true) ForgotPassword forgotPassword) {
    	
    	User response = userService.forgotPasswordService(forgotPassword);
    	
    	return new ResponseEntity<User>(response, HttpStatus.OK);
    }
	
    //update Profile
    @ApiOperation(value = "Update User Profile", notes = "API to update profile")
    @RequestMapping(value="/updateProfile/", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUserProfileController(
    		@RequestBody(required = true) User user) {
    	
    	User response = userService.updateProfileService(user);
    	
    	return new ResponseEntity<User>(response, HttpStatus.OK);
    }
    
    //delete profile
    @ApiOperation(value = "Delete User Profile", notes = "API to delete profile")
    @RequestMapping(value="/deleteProfile/", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> deleteUserProfileController(
    		@RequestParam(value = "userEmail", required = true) String userEmail) {
    	
    	User response = userService.deleteUserProfileService(userEmail);
    	
    	return new ResponseEntity<User>(response, HttpStatus.OK);
    }
  
}
