package com.udemy.backend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.backend.converter.ContactConverter;
import com.udemy.backend.model.ContactModel;
import com.udemy.backend.respositories.ContactRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactServiceImpl.
 */
@Service("contactService")
public class ContactServiceImpl implements ContactService{
	
	/** The contact repos. */
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepos;
	
	/** The converter. */
	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter converter;

	/**
	 * Adds the contact.
	 *
	 * @param contactM the contact M
	 * @return the contact model
	 */
	@Override
	public ContactModel addContact(ContactModel contactM) {
		return converter.entity2model(contactRepos.save(converter.model2entity(contactM)));
	}

	/**
	 * List all contacts.
	 *
	 * @return the list
	 */
	@Override
	public List<ContactModel> listAllContacts() {
		List<ContactModel> models = new ArrayList<ContactModel>();
		contactRepos.findAll().stream().forEach(c-> models.add(converter.entity2model(c)));
		
		return models;
	}

	/**
	 * Find contact by id.
	 *
	 * @param id the id
	 * @return the contact model
	 */
	@Override
	public ContactModel findContactById(int id) {
		return converter.entity2model(contactRepos.findById(id));
	}

	/**
	 * Removes the contact.
	 *
	 * @param id the id
	 */
	@Override
	public void removeContact(int id) {
		ContactModel contact = findContactById(id);
		if (contact != null)
			contactRepos.delete(converter.model2entity(contact));
	}

}
