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
	private Boolean exibir;
	
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Boolean getExibir() {
		return exibir;
	}
	public void setExibir(Boolean exibir) {
		this.exibir = exibir;
	}
	
	@PostConstruct
	public void novo(){
		produto = new Produto();
		exibir = false;
	}
	
	public void buscar(){
		try {
			
			ProdutoDAO dao = new ProdutoDAO();
			Produto resultado = dao.buscar(produto.getCodigo());
			
			if(resultado == null){
				exibir = false;
				Messages.addGlobalWarn("Item não existe");
			}else{
				exibir = true;
				produto = resultado;
			}
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao buscar");
			e.printStackTrace();
		}
	}

}
