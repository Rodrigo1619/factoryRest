package com.rodrick.restFactory.services;

import java.util.List;

import com.rodrick.restFactory.models.dtos.LoginDTO;
import com.rodrick.restFactory.models.entities.User;

public interface UserService {
	void login(LoginDTO info);
	User findOneById(String identifier);
	List<User> findAll();
}
