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
public class Newsletter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long newsletterId;

	private String newsletterEmail;

	@Enumerated(EnumType.STRING)
	private RequestStatus newsletterRequestStatus;

	@CreationTimestamp
	private Date newsletterDateCreated;

	@UpdateTimestamp
	private Date newsletterLastUpdated;

}
