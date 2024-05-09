package com.frvazquez.app.model;

import jakarta.validation.constraints.NotBlank;

public record TopicoActualizar(
		Long id,
	 	@NotBlank
		String respuesta) {

}
