package br.com.drogaria.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable {
	
	
	private Fabricante fabricante;
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	public void novo(){
		fabricante = new Fabricante();
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
