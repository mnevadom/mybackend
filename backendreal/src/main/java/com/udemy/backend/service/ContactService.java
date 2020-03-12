package com.udemy.backend.service;

import java.util.List;

import com.udemy.backend.model.ContactModel;

// TODO: Auto-generated Javadoc
/**
 * The Interface ContactService.
 */
public interface ContactService {

	/**
	 * Adds the contact.
	 *
	 * @param contactM the contact M
	 * @return the contact model
	 */
	public ContactModel addContact(ContactModel contactM);
	
	/**
	 * List all contacts.
	 *
	 * @return the list
	 */
	public List<ContactModel> listAllContacts();
	
	/**
	 * Find contact by id.
	 *
	 * @param id the id
	 * @return the contact model
	 */
	public ContactModel findContactById(int id);
	
	/**
	 * Removes the contact.
	 *
	 * @param id the id
	 */
	public void removeContact(int id);
}
