package com.event.rentalManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.event.rentalManagement.entity.Newsletter;
import com.event.rentalManagement.entity.enums.RequestStatus;
import com.event.rentalManagement.repository.newsletterRepository.NewsletterRepository;

@Service
public class NewsletterService {

	@Autowired
	private NewsletterRepository newsletterRepository;

	public List<Newsletter> getAllNewsletterService() {

		return newsletterRepository.getAllNewsletter();
	}

	public Page<Newsletter> getAllNewsletterPagedService(Pageable page) {

		return newsletterRepository.getAllNewsletterPaged(page);
	}

	public Newsletter getNewsletterByIdService(String newsletterId) {

		return newsletterRepository.getNewsletterById(newsletterId);
	}

	public List<Newsletter> getAllNewsletterByEmailService(String newsletterEmail) {

		return newsletterRepository.getAllNewsletterByEmail(newsletterEmail);
	}

	public Page<Newsletter> getAllNewsletterByEmailPagedService(String newsletterEmail, Pageable page) {

		return newsletterRepository.getAllNewsletterByEmailPaged(newsletterEmail, page);
	}

	public List<Newsletter> getAllNewsletterByRequestStatusListService(RequestStatus newsletterRequestStatus) {

		return newsletterRepository.getAllNewsletterByRequestStatusList(newsletterRequestStatus);
	}

	public Page<Newsletter> getAllNewsletterByRequestStatusPagedService(RequestStatus newsletterRequestStatus,
			Pageable page) {

		return newsletterRepository.getAllNewsletterByRequestStatusPaged(newsletterRequestStatus, page);
	}

	public List<Newsletter> getAllNewsletterByNewsletterEmailAndNewsletterRequestStatusListService(
			String newsletterEmail, RequestStatus newsletterRequestStatus) {

		return newsletterRepository.getAllNewsletterByNewsletterEmailAndNewsletterRequestStatusList(newsletterEmail,
				newsletterRequestStatus);
	}

	public Page<Newsletter> getAllNewsletterByNewsletterEmailAndNewsletterRequestStatusPagedService(
			String newsletterEmail, RequestStatus newsletterRequestStatus, Pageable page) {

		return newsletterRepository.getAllNewsletterByNewsletterEmailAndNewsletterRequestStatusPaged(newsletterEmail,
				newsletterRequestStatus, page);
	}

	public Newsletter insertNewsletterSevice(String newsletterEmail) {

		return newsletterRepository.insertNewsletter(newsletterEmail);
	}

	public Newsletter updateNewsletterByIdService(String newsletterId, RequestStatus newsletterRequestStatus) {

		return newsletterRepository.updateNewsletterById(newsletterId, newsletterRequestStatus);
	}
	
	public List<Newsletter> updateNewsletterByEmailService(String newsletterEmail, RequestStatus requestStatus) {
		
		return newsletterRepository.updateNewsletterByEmail(newsletterEmail, requestStatus);
	}

}
