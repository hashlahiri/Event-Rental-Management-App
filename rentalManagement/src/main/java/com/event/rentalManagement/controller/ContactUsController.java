package com.event.rentalManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.event.rentalManagement.entity.ContactUs;
import com.event.rentalManagement.entity.enums.RequestStatus;
import com.event.rentalManagement.service.ContactUsService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/contactUs")
public class ContactUsController {

	
	@Autowired
	private ContactUsService contactUsService;
	
	@ApiOperation(value = "Get all contact us submissions", notes = "API to get contact us submission")
	@RequestMapping(value = "/getAllContactUs/list/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ContactUs>> getAllContactUsController() {
		
		List<ContactUs> response = contactUsService.getAllContactUsService();
		
		if(response == null)
			return new ResponseEntity<List<ContactUs>>(response, HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<ContactUs>>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get all contact us submissions paged", notes = "API to get contact us submissions paged")
	@RequestMapping(value = "/getAllContactUs/page/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<ContactUs>> getAllContactUsPagedController(Pageable page) {
		
		Page<ContactUs> response = contactUsService.getAllContactUsPagedService(page);
		
		if(response == null)
			return new ResponseEntity<Page<ContactUs>>(response, HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Page<ContactUs>>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get contact us by id", notes = "API to get contact us by id")
	@RequestMapping(value = "/getContactUsById/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ContactUs> getContactUsByIdController(
			@RequestParam(value = "contactUsId", required = true) String contactUsId) {
		
		ContactUs response = contactUsService.contactUsByIdService(contactUsId);
		
		if(response == null)
			return new ResponseEntity<ContactUs>(response, HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<ContactUs>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Insert a contact us request", notes = "API to insert a contact us request")
	@RequestMapping(value = "/insertIntoContactUs/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ContactUs> insertIntoContactUsController(
			@RequestBody(required = true) ContactUs contactUs) {
		
		ContactUs response = contactUsService.insertIntoContactUsService(contactUs);
		
		if(response == null)
			return new ResponseEntity<ContactUs>(response, HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<ContactUs>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Update contact us request status by contactUsId", notes = "API to update requestStatus of contact us request")
	@RequestMapping(value = "/updateContactUsRequestStatusById/", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ContactUs> updateContactUsById(
			@RequestParam(value = "contactUsId", required = true) String contactUsId,
			@RequestParam(value = "contactUsRequestStatus", required = true) RequestStatus contactUsRequestStatus) {
		
		ContactUs response = contactUsService.updateContactUsByIdService(contactUsId, contactUsRequestStatus);
		
		if(response == null)
			return new ResponseEntity<ContactUs>(response, HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<ContactUs>(response, HttpStatus.OK);
		
	}
	
	
}
