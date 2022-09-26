package com.event.rentalManagement.repository.contactAdminRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.event.rentalManagement.entity.ContactAdmin;
import com.event.rentalManagement.entity.enums.RequestStatus;

public class ContactAdminRepositoryImpl implements ContactAdminRepositoryCustom {

	@Autowired
	private ContactAdminRepository contactAdminRepository;
	
	Logger LOG = LoggerFactory.getLogger(ContactAdminRepositoryImpl.class);

	@Override
	public List<ContactAdmin> getAllContactAdmin() {
		
		try {
			
			LOG.info("getAllContactAdmin searched for entries");
			return contactAdminRepository.findAll();
		
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getAllContactAdmin");
			return null;
		}
	}

	@Override
	public Page<ContactAdmin> getAllContactAdminPaged(Pageable page) {
		
		try {
			
			LOG.info("getAllContactAdminPaged searched for entries");
			return contactAdminRepository.findAll(page);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getAllContactAdminPaged");
			return null;
		}
	}

	@Override
	public ContactAdmin insertIntoContactAdmin(ContactAdmin contactAdmin) {
		
		try {
			
			contactAdmin = contactAdmin.toBuilder().contactAdminRequestStatus(RequestStatus.PENDING).build();
			LOG.info("insertIntoContactAdmin built object to save");
			return contactAdminRepository.save(contactAdmin);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in insertIntoContactAdmin");
			return null;
		}
		
	}

	@Override
	public ContactAdmin getContactAdminById(String contactAdminId) {
		
		try {
			LOG.info("getContactAdminById function called");
			return contactAdminRepository.findById(Long.parseLong(contactAdminId)).orElse(null);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getContactAdminById");
			return null;
		}
		
	}

	@Override
	public ContactAdmin updateContactAdminById(String contactAdminId, RequestStatus contactAdminRequestStatus) {
		
		try {
			LOG.info("updateContactAdminById function called");
			
			ContactAdmin contactAdminFetched = getContactAdminById(contactAdminId);
			contactAdminFetched = contactAdminFetched.toBuilder().contactAdminRequestStatus(contactAdminRequestStatus).build();
			
			return contactAdminRepository.save(contactAdminFetched);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in updateContactAdminById");
			return null;
		}	
	}
	
}
