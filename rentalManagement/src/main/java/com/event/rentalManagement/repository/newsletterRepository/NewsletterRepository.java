package com.event.rentalManagement.repository.newsletterRepository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.rentalManagement.entity.Newsletter;
import com.event.rentalManagement.entity.enums.RequestStatus;

@Repository
public interface NewsletterRepository extends JpaRepository<Newsletter, Long>, NewsletterRepositoryCustom {

	public List<Newsletter> findAllByNewsletterEmail(String newsletterEmail);

	public Page<Newsletter> findAllByNewsletterEmail(String newsletterEmail, Pageable page);

	public List<Newsletter> findAllByNewsletterRequestStatus(RequestStatus newsletterRequestStatus);

	public Page<Newsletter> findAllByNewsletterRequestStatus(RequestStatus newsletterRequestStatus, Pageable page);

	public List<Newsletter> findAllByNewsletterEmailAndNewsletterRequestStatus(String newsletterEmail,
			RequestStatus newsletterRequestStatus);

	public Page<Newsletter> findAllByNewsletterEmailAndNewsletterRequestStatus(String newsletterEmail,
			RequestStatus newsletterRequestStatus, Pageable page);

}
