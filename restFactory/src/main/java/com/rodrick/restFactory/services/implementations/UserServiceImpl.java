package com.rodrick.restFactory.services.implementations;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.rodrick.restFactory.models.dtos.LoginDTO;
import com.rodrick.restFactory.models.dtos.RegisterDTO;
import com.rodrick.restFactory.models.entities.User;
import com.rodrick.restFactory.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	//lista como bd
		private static List<User> users = new ArrayList<>();
		//para poder parsear la fecha
		private static DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
		
		static {
			try {
				
				users.add(new User("Manuel Madriz", "manuel@gmail.com", "manu", "admin", date.parse("04/05/2023"), "ola12345678"));
				users.add(new User("Mario Moisa", "moisa@gmail.com", "moisacan", "user", date.parse("03/05/2023"), "ola12345678"));
				users.add(new User("Wilmer Hernandez", "wil@gmail.com", "wilhs", "user", date.parse("03/05/2023"), "ola12345678"));
				users.add(new User("Rodrigo Molina", "rodri@gmail.com", "rodrick", "admin", date.parse("04/05/2023"), "ola12345678"));
			}catch(ParseException e) {
				e.printStackTrace();
			}
		}
		@Override
		public void register(RegisterDTO registerinfo) {
			User newUser = new User(
					registerinfo.getUsername(),
					registerinfo.getEmail(),
					"",
					registerinfo.getPassword() + "encriptado"
					);
			users = Stream.concat(users.stream(), Stream.of(newUser))
					.collect(Collectors.toList());
			
		}

		@Override
		public void login(LoginDTO info) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<User> findAll() {
			return users;
		}

		@Override
		public User findOneById(String identifier) {
			return users.stream()
					.filter(u-> (u.getUsername().equals(identifier) || u.getEmail().equals(identifier)))
					.findAny() //devuelve cualquiera que encuentre
					.orElse(null); //sino devuelve nulo
		}

		
}
