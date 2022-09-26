package com.event.rentalManagement.repository.contactUsRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.rentalManagement.entity.ContactUs;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs, Long>, ContactUsRepositoryCustom {
	

}
