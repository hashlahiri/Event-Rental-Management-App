package com.event.rentalManagement.repository.newsletterRepository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.event.rentalManagement.entity.Newsletter;
import com.event.rentalManagement.entity.enums.RequestStatus;

public interface NewsletterRepositoryCustom {

	public List<Newsletter> getAllNewsletter();

	public Page<Newsletter> getAllNewsletterPaged(Pageable page);

	public Newsletter getNewsletterById(String newsletterId);

	public List<Newsletter> getAllNewsletterByEmail(String newsletterEmail);

	public Page<Newsletter> getAllNewsletterByEmailPaged(String newsletterEmail, Pageable page);

	public List<Newsletter> getAllNewsletterByRequestStatusList(RequestStatus newsletterRequestStatus);

	public Page<Newsletter> getAllNewsletterByRequestStatusPaged(RequestStatus newsletterRequestStatus, Pageable page);

	public List<Newsletter> getAllNewsletterByNewsletterEmailAndNewsletterRequestStatusList(String newsletterEmail,
			RequestStatus newsletterRequestStatus);

	public Page<Newsletter> getAllNewsletterByNewsletterEmailAndNewsletterRequestStatusPaged(String newsletterEmail,
			RequestStatus newsletterRequestStatus, Pageable page);

	public Newsletter insertNewsletter(String newsletterEmail);

	public Newsletter updateNewsletterById(String newsletterId, RequestStatus newsletterRequestStatus);
	
	public List<Newsletter> updateNewsletterByEmail(String newsletterEmail, RequestStatus requestStatus);

}
