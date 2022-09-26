package com.event.rentalManagement.repository.contactAdminRepository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.event.rentalManagement.entity.ContactAdmin;
import com.event.rentalManagement.entity.enums.RequestStatus;

public interface ContactAdminRepositoryCustom {
	
	public List<ContactAdmin> getAllContactAdmin();
	
	public Page<ContactAdmin> getAllContactAdminPaged(Pageable page);
	
	public ContactAdmin getContactAdminById(String contactAdminId);
	
	public ContactAdmin insertIntoContactAdmin(ContactAdmin contactAdmin);
	
	public ContactAdmin updateContactAdminById(String contactAdminId, RequestStatus contactAdminRequestStatus);

}
