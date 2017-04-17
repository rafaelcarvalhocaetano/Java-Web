package br.com.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.CidadeDAO;
import br.com.drogaria.domain.Cidade;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable{
	
	private Cidade cidade;
	private List<Cidade> cidades;
	
	public List<Cidade> getCidades() {
		return cidades;
	}
	
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	@PostConstruct
	public void listar(){
		try {
			CidadeDAO dao = new CidadeDAO();
			cidades = dao.listar();
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao editar a cidade");
			e.printStackTrace();
		}
	}
	public void novo(){
		cidade = new Cidade();
	}

}
