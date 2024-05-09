package com.frvazquez.app.domain;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.frvazquez.app.model.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Usuarios")
public class UsuarioEntity implements UserDetails {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "correo_eletronico")
	private String correoEletronico;
	@Column(name = "contrasena")
	private String contrasena;
	@Column(name = "perfil")
	private String perfil;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));

	}

	@Override
	public String getPassword() {
		return this.contrasena;
	}

	@Override
	public String getUsername() {
		return this.correoEletronico;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;

	}

	@Override
	public boolean isAccountNonLocked() {
		return true;

	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;

	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	public UsuarioEntity() {
		
	}
	
	public UsuarioEntity(Usuario usuario) {
		this.nombre =  usuario.nombre();
		this.correoEletronico =  usuario.email();
		this.contrasena =  usuario.contrasena();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreoEletronico() {
		return correoEletronico;
	}

	public void setCorreoEletronico(String correoEletronico) {
		this.correoEletronico = correoEletronico;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	@Override
	public String toString() {
		return "UsuarioEntity [id=" + id + ", nombre=" + nombre + ", correoEletronico=" + correoEletronico
				+ ", contrasena=" + contrasena + ", perfil=" + perfil + "]";
	}


}
