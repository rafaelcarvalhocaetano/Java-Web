package br.com.drogaria.bean;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.HistoricoDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Historico;
import br.com.drogaria.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class HistoricoBean implements Serializable {
	
	private Produto produto;
	private Boolean exibir;
	private Historico historico;
	
	
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
	
	public Historico getHistorico() {
		return historico;
	}
	public void setHistorico(Historico historico) {
		this.historico = historico;
	}
	
	@PostConstruct
	public void novo(){
		historico = new Historico();
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
	
	public void salvar(){
		try {
			historico.setHorario(new Date());
			
			historico.setProduto(produto);
			HistoricoDAO dao = new HistoricoDAO();
			dao.salvar(historico);
			
			Messages.addGlobalInfo("Salvo com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao salvar o histórioco");
		}
	}

}