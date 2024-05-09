package com.frvazquez.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import com.frvazquez.app.domain.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

    @Query("SELECT u FROM UsuarioEntity u WHERE u.correoEletronico = :correo")
    UsuarioEntity buscarPorCorreo(String correo);
    
    UserDetails findByCorreoEletronico(String username);


}
