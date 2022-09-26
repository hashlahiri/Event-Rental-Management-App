package com.event.rentalManagement.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.event.rentalManagement.entity.enums.RequestStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ContactAdmin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contactAdminId;
	
	private String contactAdminName;
	
	private String contactAdminEmail;
	
	private String contactAdminPurpose;
	
	private String contactAdminMessage;
	
	@Enumerated(EnumType.STRING)
	private RequestStatus contactAdminRequestStatus;
	
	@CreationTimestamp
	private Date contactAdminCreated;
	
	@UpdateTimestamp
	private Date contactAdminUpdated;
	
}
