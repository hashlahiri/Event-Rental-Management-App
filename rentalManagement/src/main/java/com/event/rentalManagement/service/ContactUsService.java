package com.event.rentalManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.event.rentalManagement.entity.ContactUs;
import com.event.rentalManagement.entity.enums.RequestStatus;
import com.event.rentalManagement.repository.contactUsRepository.ContactUsRepository;

@Service
public class ContactUsService {

	@Autowired
	private ContactUsRepository contactUsRepository;
	
	public List<ContactUs> getAllContactUsService() {
		
		return contactUsRepository.getAllContactUs();
	}
	
	public Page<ContactUs> getAllContactUsPagedService(Pageable page) {
		
		return contactUsRepository.getAllContactUsPaged(page);
	}
	
	public ContactUs contactUsByIdService(String contactUsId) {
		
		return contactUsRepository.contactUsById(contactUsId);
	}
	
	public ContactUs insertIntoContactUsService(ContactUs contactUs) {
		
		return contactUsRepository.insertIntoContactUs(contactUs);
	}
	
	public ContactUs updateContactUsByIdService(String contactUsId, RequestStatus contactUsRequestStatus) {
		
		return contactUsRepository.updateContactUsById(contactUsId, contactUsRequestStatus);
	}
}
