package br.com.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.PessoaDAO;
import br.com.drogaria.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable{
	
	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	@PostConstruct
	public void listar(){
		
		try {
			
			PessoaDAO dao = new PessoaDAO();
			pessoas = dao.listar();
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao listar uma pessoa");
		}
	}
	
	
	

}
