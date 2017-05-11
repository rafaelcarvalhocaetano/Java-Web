package br.com.drogaria.domain;

import java.util.Date;

@SuppressWarnings("serial")
public class Historico extends GenericDomain{

	private Date horario;
	private String observacoes;
	private Produto produto;
	
	public Date getHorario() {
		return horario;
	}
	public void setHorario(Date horario) {
		this.horario = horario;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	
	
}
