package com.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;


@SuppressWarnings("serial")
@Entity
public class Login extends GenericDomain{
	
	@Column(length = 20, nullable = false)
	private String nome;
	
	@Column(length = 40, nullable = false)
	private String sobreNome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}

}
