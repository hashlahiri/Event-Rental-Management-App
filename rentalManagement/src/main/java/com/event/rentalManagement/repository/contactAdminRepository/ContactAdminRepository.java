package com.event.rentalManagement.repository.contactAdminRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.event.rentalManagement.entity.ContactAdmin;

@Repository
public interface ContactAdminRepository extends JpaRepository<ContactAdmin, Long>, ContactAdminRepositoryCustom {

}
