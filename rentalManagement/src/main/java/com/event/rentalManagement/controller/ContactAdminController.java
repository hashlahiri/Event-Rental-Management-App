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

import com.event.rentalManagement.entity.ContactAdmin;
import com.event.rentalManagement.entity.enums.RequestStatus;
import com.event.rentalManagement.service.ContactAdminService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/contactAdmin")
public class ContactAdminController {

	@Autowired
	private ContactAdminService contactAdminService;
	
	@ApiOperation(value = "Get all contact admin submissions", notes = "API to get all contact admin submissions")
	@RequestMapping(value = "/getAllContactAdmin/list/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ContactAdmin>> getAllContactAdminController() {
		
		List<ContactAdmin> response = contactAdminService.getAllContactAdminService();
		
		if(response == null)
			return new ResponseEntity<List<ContactAdmin>>(response, HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<List<ContactAdmin>>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get all contact admin submissions paged", notes = "API to get all contact admin submissions paged")
	@RequestMapping(value = "/getAllContactAdmin/page/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<ContactAdmin>> getAllContactAdminPagedController(Pageable page) {
		
		Page<ContactAdmin> response = contactAdminService.getAllContactAdminPagedService(page);
		
		if(response == null)
			return new ResponseEntity<Page<ContactAdmin>>(response, HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Page<ContactAdmin>>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get contact admin by id", notes = "API to get contact admin by id")
	@RequestMapping(value = "/getContactAdminById/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ContactAdmin> getContactAdminByIdController(
			@RequestParam(value = "contactAdminId", required = true) String contactAdminId) {
		
		ContactAdmin response = contactAdminService.getContactAdminByIdService(contactAdminId);
		
		if(response == null)
			return new ResponseEntity<ContactAdmin>(response, HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<ContactAdmin>(response, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Insert a contact admin request", notes = "API to insert a contact admin request")
	@RequestMapping(value = "/insertIntoContactAdmin/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ContactAdmin> insertIntoContactAdminController(
			@RequestBody(required = true) ContactAdmin contactAdmin) {
		
		ContactAdmin response = contactAdminService.insertIntoContactAdminService(contactAdmin);
		
		if(response == null)
			return new ResponseEntity<ContactAdmin>(response, HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<ContactAdmin>(response, HttpStatus.ACCEPTED);
	}
	
	@ApiOperation(value = "Update contact admin request status by contactAdminId", notes = "API to update requestStatus of contact admin request")
	@RequestMapping(value = "/updateContactAdminRequestStatusById/", method = RequestMethod.PATCH, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ContactAdmin> updateContactAdminById(
			@RequestParam(value = "contactAdminId", required = true) String contactAdminId,
			@RequestParam(value = "contactAdminRequestStatus", required = true) RequestStatus contactAdminRequestStatus) {
		
		ContactAdmin response = contactAdminService.updateContactAdminByIdService(contactAdminId, contactAdminRequestStatus);
		
		if(response == null)
			return new ResponseEntity<ContactAdmin>(response, HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<ContactAdmin>(response, HttpStatus.OK);
		
	}
}
