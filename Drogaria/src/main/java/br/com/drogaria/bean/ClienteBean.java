package br.com.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.ClienteDAO;
import br.com.drogaria.domain.Cliente;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable{
	
	private List<Cliente> clientes;

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	
	@PostConstruct
	public void listar(){
		try {
			ClienteDAO dao = new ClienteDAO();
			clientes = dao.listar("dataCadastro");
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao listar clientes");
			e.printStackTrace();
		}
	}
	
	

}
