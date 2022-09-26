package com.event.rentalManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.event.rentalManagement.entity.Newsletter;
import com.event.rentalManagement.entity.enums.RequestStatus;
import com.event.rentalManagement.service.NewsletterService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/newsletter")
public class NewsletterController {

	@Autowired
	private NewsletterService newsletterService;

	@ApiOperation(value = "Get all newsletter", notes = "API to get all newsletters")
	@RequestMapping(value = "/getAllNewsletter/list/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Newsletter>> getAllNewsletterController() {

		List<Newsletter> response = newsletterService.getAllNewsletterService();
		
		if(response == null)
			return new ResponseEntity<List<Newsletter>>(response, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Newsletter>>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Get all newsletter paged", notes = "API to get all newsletters paged")
	@RequestMapping(value = "/getAllNewsletter/page/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Newsletter>> getAllNewsletterPagedController(Pageable page) {

		Page<Newsletter> response = newsletterService.getAllNewsletterPagedService(page);
		
		if(response == null)
			return new ResponseEntity<Page<Newsletter>>(response, HttpStatus.NO_CONTENT);

		return new ResponseEntity<Page<Newsletter>>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Get newsletter by newsletterId", notes = "API to get newsletter by newsletterId")
	@RequestMapping(value = "/getNewsletterById/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Newsletter> getNewsletterByIdController(
			@RequestParam(value = "newsletterId", required = true) String newsletterId) {

		Newsletter response = newsletterService.getNewsletterByIdService(newsletterId);
		
		if(response == null)
			return new ResponseEntity<Newsletter>(response, HttpStatus.BAD_REQUEST);

		return new ResponseEntity<Newsletter>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Get all newsletter by newsletterEmail", notes = "API to get all newsletter by newsletterEmail")
	@RequestMapping(value = "/getAllNewsletterByEmail/list/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Newsletter>> getAllNewsletterByEmailController(
			@RequestParam(value = "newsletterEmail", required = true) String newsletterEmail) {

		List<Newsletter> response = newsletterService.getAllNewsletterByEmailService(newsletterEmail);
		
		if(response == null)
			return new ResponseEntity<List<Newsletter>>(response, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Newsletter>>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Get all newsletter by newsletterEmail paged", notes = "API to get all newsletter by newsletterEmail paged")
	@RequestMapping(value = "/getAllNewsletterByEmail/page/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Newsletter>> getAllNewsletterByEmailPagedController(
			@RequestParam(value = "newsletterEmail", required = true) String newsletterEmail, Pageable page) {

		Page<Newsletter> response = newsletterService.getAllNewsletterByEmailPagedService(newsletterEmail, page);
		
		if(response == null)
			return new ResponseEntity<Page<Newsletter>>(response, HttpStatus.NO_CONTENT);

		return new ResponseEntity<Page<Newsletter>>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Get all newsletter by newsletterRequestStatus list", notes = "API to get all newsletter by newsletterRequestStatus list")
	@RequestMapping(value = "/getAllNewsletterByRequestStatus/list/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Newsletter>> getAllNewsletterByRequestStatusListController(
			@RequestParam(value = "newsletterRequestStatus", required = true) RequestStatus newsletterRequestStatus) {

		List<Newsletter> response = newsletterService
				.getAllNewsletterByRequestStatusListService(newsletterRequestStatus);
		
		if(response == null)
			return new ResponseEntity<List<Newsletter>>(response, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Newsletter>>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Get all newsletter by newsletterRequestStatus Paged", notes = "API to get all newsletter by newsletterRequestStatus page")
	@RequestMapping(value = "/getAllNewsletterByRequestStatus/page/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Newsletter>> getAllNewsletterByRequestStatusPagedController(
			@RequestParam(value = "newsletterRequestStatus", required = true) RequestStatus newsletterRequestStatus,
			Pageable page) {

		Page<Newsletter> response = newsletterService
				.getAllNewsletterByRequestStatusPagedService(newsletterRequestStatus, page);
		
		if(response == null)
			return new ResponseEntity<Page<Newsletter>>(response, HttpStatus.NO_CONTENT);

		return new ResponseEntity<Page<Newsletter>>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Get all by email and status list", notes = "API to get all newsletter by email and status list")
	@RequestMapping(value = "/getAllByNewsletterEmailAndRequestStatus/list/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Newsletter>> getAllNewsletterByNewsletterEmailAndNewsletterRequestStatusListController(
			@RequestParam(value = "newsletterEmail", required = true) String newsletterEmail,
			@RequestParam(value = "newsletterRequestStatus", required = true) RequestStatus newsletterRequestStatus) {

		List<Newsletter> response = newsletterService
				.getAllNewsletterByNewsletterEmailAndNewsletterRequestStatusListService(newsletterEmail,
						newsletterRequestStatus);
		
		if(response == null)
			return new ResponseEntity<List<Newsletter>>(response, HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Newsletter>>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Get all by email and status page", notes = "API to get all newsletter by email and status page")
	@RequestMapping(value = "/getAllByNewsletterEmailAndRequestStatus/page/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Newsletter>> getAllNewsletterByNewsletterEmailAndNewsletterRequestStatusPagedController(
			@RequestParam(value = "newsletterEmail", required = true) String newsletterEmail,
			@RequestParam(value = "newsletterRequestStatus", required = true) RequestStatus newsletterRequestStatus,
			Pageable page) {

		Page<Newsletter> response = newsletterService
				.getAllNewsletterByNewsletterEmailAndNewsletterRequestStatusPagedService(newsletterEmail,
						newsletterRequestStatus, page);
		
		if(response == null)
			return new ResponseEntity<Page<Newsletter>>(response, HttpStatus.NO_CONTENT);

		return new ResponseEntity<Page<Newsletter>>(response, HttpStatus.OK);
	}

	@ApiOperation(value = "Insert newsletter", notes = "API to insert a newsletter")
	@RequestMapping(value = "/insertNewsletter/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Newsletter> insertNewsletterController(
			@RequestParam(value = "newsletterEmail", required = true) String newsletterEmail) {

		Newsletter response = newsletterService.insertNewsletterSevice(newsletterEmail);
		
		if(response == null)
			return new ResponseEntity<Newsletter>(response, HttpStatus.BAD_REQUEST);

		return new ResponseEntity<Newsletter>(response, HttpStatus.ACCEPTED);
	}

	@ApiOperation(value = "Update newsletter request status by newsletterId", notes = "API to update request Status of newsletter by newsletterId")
	@RequestMapping(value = "/updateNewsletterById/", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Newsletter> updateNewsletterByIdController(
			@RequestParam(value = "newsletterId", required = true) String newsletterId,
			@RequestParam(required = true) RequestStatus newsletterRequestStatus) {

		Newsletter response = newsletterService.updateNewsletterByIdService(newsletterId, newsletterRequestStatus);
		
		if(response == null)
			return new ResponseEntity<Newsletter>(response, HttpStatus.BAD_REQUEST);

		return new ResponseEntity<Newsletter>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update newsletter request status by newsletterEmail", notes = "API to update requestStatus of newsletter by newsletter Email")
	@RequestMapping(value = "/updateNewsletterByEmail/", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Newsletter>> updateNewsletterByEmailController(
			@RequestParam(value = "newsletterEmail", required = true) String newsletterEmail, 
			@RequestParam(value = "requestStatus", required = true) RequestStatus requestStatus) {
		
		List<Newsletter> response = newsletterService.updateNewsletterByEmailService(newsletterEmail, requestStatus);
		
		if(response == null)
			return new ResponseEntity<List<Newsletter>>(response, HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<Newsletter>>(response, HttpStatus.OK);
		
	}

}
