package com.udemy.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.backend.model.ContactModel;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

	@GetMapping("/checkrest")
	public ResponseEntity<ContactModel> checkRest(){
		ContactModel contactModel = new ContactModel(2, "Mikel", "Perez", "1212121", "Madrid");
		
		return new ResponseEntity<ContactModel>(contactModel, HttpStatus.OK); 
	}
	
	@GetMapping("/checkreststr")
	public ResponseEntity<String> checkRestStr(){
		
		return new ResponseEntity<String>("OK", HttpStatus.OK); 
	}
}
