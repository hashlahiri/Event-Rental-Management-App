package com.event.rentalManagement.repository.userRepository;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

import com.event.rentalManagement.entity.ForgotPassword;
import com.event.rentalManagement.entity.Role;
import com.event.rentalManagement.entity.User;
import com.event.rentalManagement.repository.roleRepository.RoleRepository;

public class UserRepositoryImpl implements UserRepositoryCustom {

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

	@Override
	public User insertNewUser(User user) {

		try {

			// insert a new user v2
			final String roleName = "User";
			Role role = roleRepository.findById(roleName).get();
			Set<Role> userRoles = new HashSet<>();
			userRoles.add(role);

			// building new User object
			user = user.toBuilder().role(userRoles).userPassword(getEncodedPassword(user.getUserPassword()))
					.userSecretPin(Long.parseLong(user.getUserSecretPin().toString())).userCreated(new Date()) .userStatus(true).build();
			
			return userRepository.save(user);

		} catch (Exception ex) {

			System.out.println("Could not save New User");
			System.out.println("Something went wrong in new user api: " + ex.getMessage());
			throw new RuntimeException("Could not generate a new user");
		}
	}

	@Override
	public User getByUsername(String username) {

		User userFetched = userRepository.findByUserNameAndUserStatus(username, true);
		if (userFetched == null) {
			System.out.println("Valid user could not be found");
			return null;
		}

		return userRepository.findByUserNameAndUserStatus(username, true);
	}

	@Override
	public List<User> getAllUsersList() {

		return userRepository.findAll();
	}

	@Override
	public User getUserByUserEmail(String userEmail) {

		return userRepository.findByUserEmailAndUserStatus(userEmail, true);
	}

	/**
	 * Forgot password
	 */
	@Override
	public User forgotPassword(ForgotPassword forgotPassword) {

		// find user, check by email and secret pin and status
		User userFetched = userRepository.findByUserEmailAndUserSecretPinAndUserStatus(forgotPassword.getUserEmail(),
				Long.parseLong(forgotPassword.getUserSecretPin()), true);

		// reset password to default, return user
		if (userFetched != null) {

			// reset password and save
			final String defaultUserPassword = "passwordResetHappened";
			userFetched = userFetched.toBuilder().userPassword(defaultUserPassword).build();

			return userRepository.save(userFetched);
		}

		return null;
	}

	/**
	 * Update User Profile
	 */
	@Override
	public User updateProfile(User user) {
		System.out.println("User email: " + user.getUserEmail().toString());
		System.out.println(user.toString());
		User userFetched = userRepository.findByUserEmailAndUserStatus(user.getUserEmail(), true);

		if (userFetched == null) {
			System.out.println("User by given Id could not be fetched");
			return null;
		}

		// updating the new values of the user
		
		String newUserFirstname = (StringUtils.isEmpty(user.getUserFirstName())) ? userFetched.getUserFirstName() : user.getUserFirstName();
		String newUserLastname = (StringUtils.isEmpty(user.getUserLastName())) ? userFetched.getUserLastName() : user.getUserLastName();
		String newUserPhoneNumber = (StringUtils.isEmpty(user.getUserPhoneNumber())) ? userFetched.getUserPhoneNumber() : user.getUserPhoneNumber();
		String newUserDob = (StringUtils.isEmpty(user.getUserDob())) ? userFetched.getUserDob() : user.getUserDob();
		String newUserAddress = (StringUtils.isEmpty(user.getUserAddress())) ? userFetched.getUserAddress() : user.getUserAddress();
		
		
		userFetched = userFetched.toBuilder().userFirstName(newUserFirstname)
				.userLastName(newUserLastname).userPassword(user.getUserPassword())
				.userPhoneNumber(newUserPhoneNumber).userAddress(newUserAddress)
				.userDob(newUserDob).build();

		return userRepository.save(userFetched);
	}

	/**
	 * Delete User Profile, soft delete, setting status to false
	 */
	@Override
	public User deleteUserProfile(String userEmail) {

		// find user and set status to false, return user
		User userFetched = userRepository.findByUserEmailAndUserStatus(userEmail, true);

		userFetched = userFetched.toBuilder().userStatus(false).build();

		return userRepository.save(userFetched);
	}

}
