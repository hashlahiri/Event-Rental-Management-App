package com.event.rentalManagement.repository.contactUsRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.event.rentalManagement.entity.ContactUs;
import com.event.rentalManagement.entity.enums.RequestStatus;

public class ContactUsRepositoryImpl implements ContactUsRepositoryCustom {

	@Autowired
	private ContactUsRepository contactUsRepository;
	
	Logger LOG = LoggerFactory.getLogger(ContactUsRepositoryImpl.class);

	@Override
	public List<ContactUs> getAllContactUs() {
		
		try {
			
			LOG.info("getAllContactUs function called");
			return contactUsRepository.findAll();
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getAllContactUs");
			return null;
		}
		
	}

	@Override
	public Page<ContactUs> getAllContactUsPaged(Pageable page) {
		
		try {
			
			LOG.info("getAllContactUsPaged function called");
			return contactUsRepository.findAll(page);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getAllContactUsPaged");
			return null;
		}
		
	}

	@Override
	public ContactUs contactUsById(String contactUsId) {
		
		try {
			
			LOG.info("contactUsById function called");
			return contactUsRepository.findById(Long.parseLong(contactUsId)).orElse(null);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in contactUsById");
			return null;
		}
		
	}

	@Override
	public ContactUs insertIntoContactUs(ContactUs contactUs) {
		
		try {
			
			LOG.info("insertIntoContactUs function called");
			contactUs = contactUs.toBuilder().contactUsRequestStatus(RequestStatus.PENDING).build();
			
			return contactUsRepository.save(contactUs);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in insertIntoContactUs");
			return null;
		}
		
	}

	@Override
	public ContactUs updateContactUsById(String contactUsId, RequestStatus contactUsRequestStatus) {
		
		try {
			
			LOG.info("updateContactUsById function called");
			ContactUs contactUsFetched = contactUsById(contactUsId);
			
			contactUsFetched = contactUsFetched.toBuilder().contactUsRequestStatus(contactUsRequestStatus).build();
			
			return contactUsRepository.save(contactUsFetched);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in updateContactUsById");
			return null;
		}
		
	}
	
	
}
