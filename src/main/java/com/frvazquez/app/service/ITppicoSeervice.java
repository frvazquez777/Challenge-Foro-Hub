package com.frvazquez.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.frvazquez.app.domain.TopicoEntity;
import com.frvazquez.app.model.Topico;
import com.frvazquez.app.model.TopicoActualizar;

public interface ITppicoSeervice {

	public Page<TopicoEntity> paginacion(Pageable paginacion);

	public Topico getTopicoByID(Long id);

	public Topico registrar(Topico topico);

	public Topico actualizar(TopicoActualizar topico);

	public void eliminar(Long id);

}
