package com.frvazquez.app.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.frvazquez.app.domain.TopicoEntity;
import com.frvazquez.app.model.Topico;
import com.frvazquez.app.model.TopicoActualizar;
import com.frvazquez.app.repository.TopicoRepository;
import com.frvazquez.app.service.ITppicoSeervice;

import jakarta.transaction.Transactional;

@Service
public class TopicoService implements ITppicoSeervice {

	private TopicoRepository repository;
	
	public TopicoService(TopicoRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Page<TopicoEntity> paginacion(Pageable paginacion) {

		return repository.findByOrderByFechaCreacionDesc(paginacion);
	}

	@Override
	public Topico getTopicoByID(Long id) {
		
		TopicoEntity topicoEntidad = repository.getById(id);
		Topico topico = new Topico(topicoEntidad.getTitulo(), topicoEntidad.getMensaje(), topicoEntidad.getAutor(), topicoEntidad.getCurso());
		return topico;
	}

	@Transactional
	@Override
	public Topico registrar(Topico topico) {
		
				TopicoEntity topicoEntidad  = repository.save(new TopicoEntity(topico));
		return new Topico(topicoEntidad.getTitulo(), topicoEntidad.getMensaje(), topicoEntidad.getAutor(), topicoEntidad.getCurso());
	
	}

	@Transactional
	@Override
	public Topico actualizar(TopicoActualizar topico) {
		TopicoEntity topicoEntidad = repository.getById(topico.id());
		topicoEntidad.setRespuestas(topico.respuesta());
		topicoEntidad  = repository.save(topicoEntidad);
	return new Topico(topicoEntidad.getTitulo(), topicoEntidad.getMensaje(), topicoEntidad.getAutor(), topicoEntidad.getCurso());

	}

	@Transactional
	@Override
	public void eliminar(Long id) {
		TopicoEntity topicoEntidad = repository.getById(id);
		repository.delete(topicoEntidad);
	}

}
