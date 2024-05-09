package com.frvazquez.app.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record Usuario(
		 	@NotBlank
	        String nombre,
	        @NotBlank
	        @Email
	        String email,
	        @NotBlank
	        String contrasena
	        ) {

}
