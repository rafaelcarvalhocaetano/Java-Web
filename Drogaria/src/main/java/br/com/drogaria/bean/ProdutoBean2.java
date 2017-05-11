package br.com.drogaria.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean2 implements Serializable{
	private Produto produto;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	@PostConstruct
	public void novo(){
		produto = new Produto();
	}
	
	public void buscar(){
		try {
			
			ProdutoDAO dao = new ProdutoDAO();
			Produto resultado = dao.buscar(produto.getCodigo());
			
			if(resultado == null){
				Messages.addGlobalWarn("Item não existe");
			}else{
				produto = resultado;
			}
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao buscar");
			e.printStackTrace();
		}
	}

}
