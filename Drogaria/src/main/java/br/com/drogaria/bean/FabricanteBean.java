package br.com.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable {
	
	private List<Fabricante> fabricantes;
	
	private Fabricante fabricante;
	
	
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	public void novo(){
		fabricante = new Fabricante();
	}
	
	@PostConstruct
	public void listar(){
		try {
			FabricanteDAO dao = new FabricanteDAO();
			fabricantes = dao.listar();
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Fabricante não encontrado");
			e.printStackTrace();
		}
	}
	
	public void salvar(){
		
		try {
			
			FabricanteDAO dao = new FabricanteDAO();
			dao.salvar(fabricante);
			
			novo();
			
			Messages.addGlobalInfo("Fabricante salvo com sucesso");
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao salvar o fabricante");
			e.printStackTrace();
		}
	}

}
