package br.com.hibernate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Cadastro extends GenericDomain{
	
	@Column(nullable = false, length = 45)
	private String nome;
	
	@Column(length = 10, nullable = false)
	private String ra;
	
	@Column(length = 8, nullable = false)
	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
