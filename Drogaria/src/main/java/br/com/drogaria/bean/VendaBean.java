package br.com.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.ItemVenda;
import br.com.drogaria.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class VendaBean implements Serializable{
	
	private List<Produto> produtos;
	private List<ItemVenda> itensVendas;
	
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	public List<ItemVenda> getItensVendas() {
		return itensVendas;
	}
	public void setItensVendas(List<ItemVenda> itensVendas) {
		this.itensVendas = itensVendas;
	}
	
	@PostConstruct
	public void listar() {

		try {

			ProdutoDAO dao = new ProdutoDAO();
			produtos = dao.listar("descricao");

			Messages.addGlobalInfo("Sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro");
			e.printStackTrace();
		}

	}

}
