package com.rodrick.restFactory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrick.restFactory.models.dtos.SearchUserDTO;
import com.rodrick.restFactory.models.dtos.UserResponseDTO;
import com.rodrick.restFactory.models.entities.User;
import com.rodrick.restFactory.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/factory")
@CrossOrigin("*")
public class factoryController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user/all") //se supone que son todos pero por lo visto ahorita busco solo por id
	public ResponseEntity<?> findUserById(@Valid SearchUserDTO search, BindingResult validations){
		if(validations.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		User userFound = userService.findOneById(search.getIdentifier());
		if(userFound == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		
		return new ResponseEntity<>(userFound, HttpStatus.OK);
			
}
}