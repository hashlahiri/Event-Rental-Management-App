package com.event.rentalManagement.repository.newsletterRepository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.event.rentalManagement.entity.Newsletter;
import com.event.rentalManagement.entity.enums.RequestStatus;

public class NewsletterRepositoryImpl implements NewsletterRepositoryCustom {

	@Autowired
	private NewsletterRepository newsletterRepository;
	
	Logger LOG = LoggerFactory.getLogger(NewsletterRepositoryImpl.class);

	@Override
	public List<Newsletter> getAllNewsletter() {

		try {
			
			LOG.info("getAllNewsletter function called");
			LOG.info("Get all newsletter api was hit to retrieve all newsletters as list");
			return newsletterRepository.findAll();
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getAllNewsletter");
			return null;
		}
		
	}

	@Override
	public Page<Newsletter> getAllNewsletterPaged(Pageable page) {
		
		try {
			
			LOG.info("getAllNewsletterPaged function called");
			return newsletterRepository.findAll(page);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getAllNewsletterPaged");
			return null;
		}
	}

	@Override
	public Newsletter getNewsletterById(String newsletterId) {
		
		try {
			
			LOG.info("getNewsletterById function called");
			Long newsId = Long.parseLong(newsletterId);

			return newsletterRepository.findById(newsId).orElse(null);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getNewsletterById");
			return null;
		}
	}

	@Override
	public List<Newsletter> getAllNewsletterByEmail(String newsletterEmail) {

		try {
			
			LOG.info("getAllNewsletterByEmail function called");
			return newsletterRepository.findAllByNewsletterEmail(newsletterEmail);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getAllNewsletterByEmail");
			return null;
		}
	}

	@Override
	public Page<Newsletter> getAllNewsletterByEmailPaged(String newsletterEmail, Pageable page) {

		try {
			
			LOG.info("getAllNewsletterByEmailPaged function called");
			return newsletterRepository.findAllByNewsletterEmail(newsletterEmail, page);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getAllNewsletterByEmailPaged");
			return null;
		}
	}

	@Override
	public List<Newsletter> getAllNewsletterByRequestStatusList(RequestStatus newsletterRequestStatus) {

		try {
			
			LOG.info("getAllNewsletterByRequestStatusList function called");
			return newsletterRepository.findAllByNewsletterRequestStatus(newsletterRequestStatus);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getAllNewsletterByRequestStatusList");
			return null;
		}
	}

	@Override
	public Page<Newsletter> getAllNewsletterByRequestStatusPaged(RequestStatus newsletterRequestStatus, Pageable page) {

		try {
			
			LOG.info("getAllNewsletterByRequestStatusPaged function called");
			return newsletterRepository.findAllByNewsletterRequestStatus(newsletterRequestStatus, page);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getAllNewsletterByRequestStatusPaged");
			return null;
		}
	}

	@Override
	public List<Newsletter> getAllNewsletterByNewsletterEmailAndNewsletterRequestStatusList(String newsletterEmail,
			RequestStatus newsletterRequestStatus) {

		try {
			
			LOG.info("getAllNewsletterByNewsletterEmailAndNewsletterRequestStatusList function called");
			return newsletterRepository.findAllByNewsletterEmailAndNewsletterRequestStatus(newsletterEmail,
					newsletterRequestStatus);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getAllNewsletterByNewsletterEmailAndNewsletterRequestStatusList");
			return null;
		}
	}

	@Override
	public Page<Newsletter> getAllNewsletterByNewsletterEmailAndNewsletterRequestStatusPaged(String newsletterEmail,
			RequestStatus newsletterRequestStatus, Pageable page) {

		try {
			
			LOG.info("getAllNewsletterByNewsletterEmailAndNewsletterRequestStatusPaged function called");
			return newsletterRepository.findAllByNewsletterEmailAndNewsletterRequestStatus(newsletterEmail,
					newsletterRequestStatus, page);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in getAllNewsletterByNewsletterEmailAndNewsletterRequestStatusPaged");
			return null;
		}
	}

	@Override
	public Newsletter insertNewsletter(String newsletterEmail) {

		try {
			
			LOG.info("insertNewsletter function called");
			Newsletter newsletterToSave = Newsletter.builder().newsletterEmail(newsletterEmail)
					.newsletterRequestStatus(RequestStatus.PENDING).build();

			return newsletterRepository.save(newsletterToSave);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in insertNewsletter");
			return null;
		}
	}

	@Override
	public Newsletter updateNewsletterById(String newsletterId, RequestStatus newsletterRequestStatus) {

		try {
			
			LOG.info("updateNewsletterById function called");
			Newsletter newsletterFetched = newsletterRepository.findById(Long.parseLong(newsletterId)).orElse(null);

			if (newsletterFetched == null) {
				return null;
			}

			newsletterFetched = newsletterFetched.toBuilder().newsletterRequestStatus(newsletterRequestStatus).build();

			return newsletterRepository.save(newsletterFetched);
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in updateNewsletterById");
			return null;
		}
	}

	@Override
	public List<Newsletter> updateNewsletterByEmail(String newsletterEmail, RequestStatus requestStatus) {
		
		try {
			
			LOG.info("updateNewsletterByEmail function called");
			List<Newsletter> newslettersFetched = newsletterRepository.findAllByNewsletterEmail(newsletterEmail);
			
			if(newslettersFetched.isEmpty())
				return null;
			
			List<Newsletter> updatedNewsletters = new ArrayList<Newsletter>();
			for(Newsletter newsletterFetched : newslettersFetched) {
				
				newsletterFetched.setNewsletterRequestStatus(requestStatus);
				
				updatedNewsletters.add(newsletterRepository.save(newsletterFetched));
			}
			
			return updatedNewsletters;
			
		} catch (Exception ex) {
			
			LOG.error("Exception caught in updateNewsletterByEmail");
			return null;
		}
	}

}
