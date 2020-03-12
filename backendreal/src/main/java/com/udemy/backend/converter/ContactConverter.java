package com.udemy.backend.converter;

import org.springframework.stereotype.Component;

import com.udemy.backend.entity.Contact;
import com.udemy.backend.model.ContactModel;

// TODO: Auto-generated Javadoc
/**
 * The Class ContactConverter.
 */
@Component("contactConverter")
public class ContactConverter {
	
	/**
	 * Model 2 entity.
	 *
	 * @param model the model
	 * @return the contact
	 */
	public Contact model2entity(ContactModel model) {
		Contact entity =  new Contact();
		entity.setCity(model.getCity());
		entity.setTelephone(model.getTelephone());
		entity.setFirstname(model.getFirstname());
		entity.setLastname(model.getLastname());
		entity.setId(model.getId());
		
		return entity;
	}

	/**
	 * Entity 2 model.
	 *
	 * @param entity the entity
	 * @return the contact model
	 */
	public ContactModel entity2model(Contact entity) {
		ContactModel model = new ContactModel();
		
		model.setCity(entity.getCity());
		model.setTelephone(entity.getTelephone());
		model.setFirstname(entity.getFirstname());
		model.setLastname(entity.getLastname());
		model.setId(entity.getId());
		
		return model;
	}
}
