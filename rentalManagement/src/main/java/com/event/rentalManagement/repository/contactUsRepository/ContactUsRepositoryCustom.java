package com.event.rentalManagement.repository.contactUsRepository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.event.rentalManagement.entity.ContactUs;
import com.event.rentalManagement.entity.enums.RequestStatus;

public interface ContactUsRepositoryCustom {
	
	public List<ContactUs> getAllContactUs();
	
	public Page<ContactUs> getAllContactUsPaged(Pageable page);
	
	public ContactUs contactUsById(String contactUsId);
	
	public ContactUs insertIntoContactUs(ContactUs contactUs);
	
	public ContactUs updateContactUsById(String contactUsId, RequestStatus contactUsRequestStatus);

}
