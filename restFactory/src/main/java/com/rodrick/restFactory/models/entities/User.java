package com.rodrick.restFactory.models.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class User {
	private String name;
	private String email;
	private String username;
	private String rol;
	private Date dateContract;
	
	@JsonIgnore
	private String password;
}
