package com.udemy.backend.respositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.backend.entity.Contact;

// TODO: Auto-generated Javadoc
/**
 * The Interface ContactRepository.
 */
@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact, Serializable>{

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the contact
	 */
	public Contact findById(int id); 
	
}
