package com.rodrick.restFactory.models.dtos;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDTO {
	private String username;
	private String email;
	private Date dateContract;
	private String rol;
}
