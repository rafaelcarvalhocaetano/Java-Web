package br.com.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.FuncionarioDAO;
import br.com.drogaria.dao.PessoaDAO;
import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FuncionarioBean implements Serializable {

	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	private List<Pessoa> pessoas;
	private Pessoa pessoa;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	@PostConstruct
	public void listar() {
		try {
			FuncionarioDAO dao = new FuncionarioDAO();
			funcionarios = dao.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as pessoas");
			erro.printStackTrace();
		}
	}

	

	public void salvar() {
		
		try {
			FuncionarioDAO dao = new FuncionarioDAO();
			dao.merge(funcionario);
			
			funcionarios = dao.listar("nome");
			
			funcionario = new Funcionario();
			pessoa = new Pessoa();
			
			PessoaDAO pdao = new PessoaDAO();
			pessoas = pdao.listar("nome");
			
			
			Messages.addGlobalInfo("Funcionário Salva com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar pessoa");
		}

	}

}
