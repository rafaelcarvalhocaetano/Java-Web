package br.com.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.CidadeDAO;
import br.com.drogaria.dao.PessoaDAO;
import br.com.drogaria.domain.Cidade;
import br.com.drogaria.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {

	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	private List<Cidade> cidades;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	@PostConstruct
	public void listar() {

		try {

			PessoaDAO dao = new PessoaDAO();
			pessoas = dao.listar();

		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao listar uma pessoa");
		}
	}

	public void novo() {
		try {

			pessoa = new Pessoa();

			PessoaDAO dao = new PessoaDAO();
			pessoas = dao.listar();

		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao tentar adicionar uma nova Pessoa");
		}

	}

	public void editar(ActionEvent evento) {
		
		try {
			
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");
			
			PessoaDAO dao = new PessoaDAO();
			pessoas = dao.listar();
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao editar Pessoa");
			e.printStackTrace();
		}

	}

	public void salvar() {
		try {

			PessoaDAO dao = new PessoaDAO();
			dao.merge(pessoa);

			CidadeDAO cdao = new CidadeDAO();
			cidades = cdao.listar();

			pessoa = new Pessoa();
			pessoas = dao.listar();

		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao tentar salvar uma nova Pessoa");
			e.printStackTrace();
		}

	}

	public void excluir(ActionEvent evento) {
		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoasSelecionadas");

			PessoaDAO dao = new PessoaDAO();
			dao.excluir(pessoa);

			pessoas = dao.listar();

			Messages.addGlobalInfo("Pessoa excluida com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao tentar excluir pessoa");
		}

	}

}
