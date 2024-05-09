package com.frvazquez.app.domain;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.frvazquez.app.model.Topico;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "Topicos")
public class TopicoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "mensaje")
	private String mensaje;
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	@Column(name = "autor")
	private Integer autor;
	@Column(name = "curso")
	private String curso;
	@Column(name = "respuestas")
	private String respuestas;

	public TopicoEntity() {

	}

	public TopicoEntity(Topico topico) {
		this.titulo =  topico.titulo();
		this.mensaje =  topico.mensaje();
		this.autor =  topico.autor();
		this.curso =  topico.curso();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getAutor() {
		return autor;
	}

	public void setAutor(Integer autor) {
		this.autor = autor;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(String respuestas) {
		this.respuestas = respuestas;
	}

	@Override
	public String toString() {
		return "TopicoEntity [id=" + id + ", titulo=" + titulo + ", mensaje=" + mensaje + ", fechaCreacion="
				+ fechaCreacion + ", autor=" + autor + ", curso=" + curso + ", respuestas=" + respuestas + "]";
	}

}
