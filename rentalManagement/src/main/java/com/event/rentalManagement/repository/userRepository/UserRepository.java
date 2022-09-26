package com.event.rentalManagement.repository.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.rentalManagement.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>, UserRepositoryCustom {
	
	public User findByUserNameAndUserStatus(String username, Boolean userStatus);
	
	public User findByUserEmailAndUserStatus(String userEmail, Boolean userStatus);
	
	public User findByUserEmailAndUserSecretPinAndUserStatus(String userEmail, Long userSecretPin, Boolean userStatus);

}
