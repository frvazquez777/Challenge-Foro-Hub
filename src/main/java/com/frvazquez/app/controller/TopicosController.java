package com.frvazquez.app.controller;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frvazquez.app.domain.TopicoEntity;
import com.frvazquez.app.model.Topico;
import com.frvazquez.app.model.TopicoActualizar;
import com.frvazquez.app.service.ITppicoSeervice;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	private ITppicoSeervice service;

	private TopicosController(ITppicoSeervice service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Topico> registrarMedico(@RequestBody @Valid Topico topico) throws URISyntaxException {

		topico = service.registrar(topico);

		return ResponseEntity.created(new URI("/")).body(topico);

	}

	@GetMapping
	public ResponseEntity<Page<TopicoEntity>> listaTopicos(
			@PageableDefault(size = 10, sort = "fechaCreacion", direction = Sort.Direction.DESC) Pageable paginacion) {
		return ResponseEntity.ok(service.paginacion(paginacion));
	}

	@PutMapping
	public ResponseEntity actualizar(@RequestBody @Valid TopicoActualizar topico) {
		Topico actualizar = service.actualizar(topico);
		return ResponseEntity.ok(actualizar);
	}

	// DELETE LOGICO
	@DeleteMapping("/{id}")
	public ResponseEntity eliminarMedico(@PathVariable Long id) {
		service.eliminar(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Topico> retornaDatosMedico(@PathVariable Long id) {
		var topico = service.getTopicoByID(id);
		return ResponseEntity.ok(topico);
	}

}
