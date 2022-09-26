package com.event.rentalManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.event.rentalManagement.entity.ContactAdmin;
import com.event.rentalManagement.entity.enums.RequestStatus;
import com.event.rentalManagement.repository.contactAdminRepository.ContactAdminRepository;

@Service
public class ContactAdminService {

	@Autowired
	private ContactAdminRepository contactAdminRepository;
	
	
	public List<ContactAdmin> getAllContactAdminService() {
		
		return contactAdminRepository.getAllContactAdmin();
	}
	
	public Page<ContactAdmin> getAllContactAdminPagedService(Pageable page) {
		
		return contactAdminRepository.getAllContactAdminPaged(page);
	}
	
	public ContactAdmin getContactAdminByIdService(String contactAdminId) {
		
		return contactAdminRepository.getContactAdminById(contactAdminId);
	}
	
	public ContactAdmin insertIntoContactAdminService(ContactAdmin contactAdmin) {
		
		return contactAdminRepository.insertIntoContactAdmin(contactAdmin);
	}
	
	public ContactAdmin updateContactAdminByIdService(String contactAdminId, RequestStatus contactAdminRequestStatus) {
		
		return contactAdminRepository.updateContactAdminById(contactAdminId, contactAdminRequestStatus);
	}
}
