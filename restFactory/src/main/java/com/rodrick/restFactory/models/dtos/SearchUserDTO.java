package com.rodrick.restFactory.models.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SearchUserDTO {
	
	@NotEmpty(message = "Identifier required")
	private String identifier;
}
