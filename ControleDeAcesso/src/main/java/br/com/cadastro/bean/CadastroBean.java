package br.com.cadastro.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.view.ViewScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import br.com.cadastro.dao.CadastroDAO;
import br.com.hibernate.domain.Cadastro;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
@SessionScoped
public class CadastroBean implements Serializable{
	
	private Cadastro cadastro;
	private List<Cadastro> cadastros;
	
	public Cadastro getCadastro() {
		return cadastro;
	}
	public void setCadastro(Cadastro cadastro) {
		this.cadastro = cadastro;
	}
	public List<Cadastro> getCadastros() {
		return cadastros;
	}
	public void setCadastros(List<Cadastro> cadastros) {
		this.cadastros = cadastros;
	}
	
	public void listar(){
		
		try {
			
			CadastroDAO cdao = new CadastroDAO();
			cadastros = cdao.listar();
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			System.out.println("Erro ao listar ... ");
		}
	}
	@PostConstruct
	public void novo(){
		cadastro = new Cadastro();
	}
	
	public void salvar(){
		try {
			
			CadastroDAO dao = new CadastroDAO();
			dao.merge(cadastro);
			
			novo();
			
			cadastros = dao.listar();
			
			System.out.println("Salvo com sucesso ... ");
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			System.out.println("Erro ao salvar ");
		}
	}
	// autenticação
	public void autenticar(){
		
		try {
			
			CadastroDAO dao = new CadastroDAO();
			Cadastro cad = 	dao.autenticar(cadastro.getRa(), cadastro.getSenha());
			
			if(cad == null){
				Messages.addGlobalError("Erro ...");
				return;
			}
			
			
			Faces.redirect("./pages/ambiente.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	

}
