package br.com.cadastro.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.cadastro.dao.CadastroDAO;
import br.com.hibernate.domain.Cadastro;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
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
	@PostConstruct
	public void listar(){
		
		try {
			
			CadastroDAO cdao = new CadastroDAO();
			cadastros = cdao.listar();
			
		} catch (RuntimeException e) {
			e.printStackTrace();
			System.out.println("Erro ao listar ... ");
		}
	}
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
	
	

}
