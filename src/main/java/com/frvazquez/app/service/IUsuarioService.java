package com.frvazquez.app.service;

import com.frvazquez.app.model.Usuario;
import com.frvazquez.app.model.UsuarioRespuesta;

public interface IUsuarioService {

	public Usuario obtenerPorCorreo(String correo);

	public UsuarioRespuesta registrar(Usuario usuario);
}
