package com.frvazquez.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.frvazquez.app.domain.TopicoEntity;
import java.util.List;
import java.util.Date;


public interface TopicoRepository extends JpaRepository<TopicoEntity, Long> {

	   Page<TopicoEntity> findByOrderByFechaCreacionDesc(Pageable paginacion);


}
