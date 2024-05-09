package com.frvazquez.app.service.impl;

import org.springframework.stereotype.Service;

import com.frvazquez.app.domain.UsuarioEntity;
import com.frvazquez.app.model.Usuario;
import com.frvazquez.app.model.UsuarioRespuesta;
import com.frvazquez.app.repository.UsuarioRepository;
import com.frvazquez.app.service.IUsuarioService;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService implements IUsuarioService {

	private UsuarioRepository repository;

	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	@Override
	public Usuario obtenerPorCorreo(String correo) {
		UsuarioEntity usuario = repository.buscarPorCorreo(correo);
		return new Usuario(usuario.getNombre(), usuario.getCorreoEletronico(), usuario.getContrasena());
	}

	@Transactional
	@Override
	public UsuarioRespuesta registrar(Usuario usuario) {
		UsuarioEntity usuarioRegistrado = repository.save(new UsuarioEntity(usuario));
		UsuarioRespuesta usuarioNuevo =  new UsuarioRespuesta(usuarioRegistrado.getNombre(), usuarioRegistrado.getCorreoEletronico(), "Usuario Registrado");
		return usuarioNuevo;
	}

}
