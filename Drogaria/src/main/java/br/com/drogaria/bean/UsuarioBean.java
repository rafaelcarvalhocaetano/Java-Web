package br.com.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.PessoaDAO;
import br.com.drogaria.dao.UsuarioDAO;
import br.com.drogaria.domain.Pessoa;
import br.com.drogaria.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable{
	
	private Usuario usuario;
	
	private List<Pessoa> pessoas;
	private List<Usuario> usuarios;
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	@PostConstruct
	public void listar(){
		try {
			UsuarioDAO dao = new UsuarioDAO();
			usuarios = dao.listar("tipo");
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao tentar listar usuários");
			e.printStackTrace();
		}
	}
	
	public void novo(){
		
		try {
			usuario = new Usuario();
			
			PessoaDAO dao = new PessoaDAO();
			pessoas = dao.listar("nome");
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar criar um novo usuário");
			e.printStackTrace();
		}
		
	}
	public void salvar(){
		
		try {
			UsuarioDAO dao = new UsuarioDAO();
			dao.merge(usuario);
			
			usuario = new Usuario();
			usuarios = dao.listar("tipo");
			
			PessoaDAO pdao = new PessoaDAO();
			pessoas = pdao.listar("nome");
				
			Messages.addGlobalInfo("Usuário salvo com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao tentar salvar usuário");
			e.printStackTrace();
		}
		
	}

}
