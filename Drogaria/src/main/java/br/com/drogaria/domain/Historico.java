package br.com.drogaria.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Historico extends GenericDomain{
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horario;
	
	@Column(nullable = false, length = 200)
	private String observacoes;
	
	@ManyToOne
	@JoinColumn(nullable = false)
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
<<<<<<< HEAD
<<<<<<< HEAD
	}	
}
=======
	}
	
	
	
}
>>>>>>> 77aefe6 (# This is a combination of 42 commits.)
=======
	}	
}
>>>>>>> f8955c9 (Criando vendas controller e view)
