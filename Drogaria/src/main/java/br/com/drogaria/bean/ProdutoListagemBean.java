package br.com.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoListagemBean implements Serializable{
	
	private List<Produto> produtos;
	private ProdutoDAO dao;
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	@PostConstruct
	public void iniciar(){
		dao = new ProdutoDAO();
	}
	
	public void listar() {
		try {

			produtos = dao.listar("descricao");

		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao listar a mensagem");
			e.printStackTrace();
		}
	}

}
