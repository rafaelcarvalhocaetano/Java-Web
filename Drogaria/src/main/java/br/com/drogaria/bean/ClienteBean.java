package br.com.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.ClienteDAO;
import br.com.drogaria.dao.PessoaDAO;
import br.com.drogaria.domain.Cliente;
import br.com.drogaria.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ClienteBean implements Serializable{
	
	private List<Cliente> clientes;
	private Cliente cliente;
	private List<Pessoa> pessoas;

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
	public void novo(){
		try {
			cliente = new Cliente();
			
			PessoaDAO pdao = new PessoaDAO();
			pessoas = pdao.listar("nome");
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao adicionar um novo cliente");
		}
	}
	public void salvar(){
		
		try {
			ClienteDAO dao = new ClienteDAO();
			dao.merge(cliente);
			
			cliente = new Cliente();
			
			PessoaDAO pdao = new PessoaDAO();
			pessoas = pdao.listar("nome");
			
			clientes = dao.listar("dataCadastro");
			
			Messages.addGlobalInfo("Cliente Salvo com sucesso");
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao tentar salvar");
			e.printStackTrace();
		}
	}
	

}
