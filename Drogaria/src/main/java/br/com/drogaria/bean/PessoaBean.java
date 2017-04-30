package br.com.drogaria.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.CidadeDAO;
import br.com.drogaria.dao.EstadoDAO;
import br.com.drogaria.dao.PessoaDAO;
import br.com.drogaria.domain.Cidade;
import br.com.drogaria.domain.Estado;
import br.com.drogaria.domain.Pessoa;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {

	private Pessoa pessoa;
	private List<Pessoa> pessoas;
	private Estado estado;
	private List<Estado> estados;
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

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@PostConstruct
	public void listar() {
		try {
			PessoaDAO pessoaDAO = new PessoaDAO();
			pessoas = pessoaDAO.listar();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar as pessoas");
			erro.printStackTrace();
		}
	}

	public void novo() {
		try {
			pessoa = new Pessoa();
			
			estado = new Estado();

			EstadoDAO estadoDAO = new EstadoDAO();
			estados = estadoDAO.listar();

			cidades = new ArrayList<Cidade>();
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar gerar uma nova pessoa");
			erro.printStackTrace();
		}
	}

	public void editar(ActionEvent evento) {
		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");
			
			estado = pessoa.getCidade().getEstado();
			
			EstadoDAO edao = new EstadoDAO();
			estados = edao.listar("nome");
			
			CidadeDAO cdao = new CidadeDAO();
			cidades = cdao.buscarPorEstado(estado.getCodigo());
			
			Messages.addGlobalInfo(" 'Pessoa ' Editada com sucesso ");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao editar a 'Pessoa' ");
			e.printStackTrace();
		}

	}

	public void salvar() {
		
		try {
			
			PessoaDAO dao = new PessoaDAO();
			dao.merge(pessoa);
			
			pessoas = dao.listar("nome");
			
			pessoa = new Pessoa();
			estado = new Estado();
			
			EstadoDAO edao = new EstadoDAO();
			estados = edao.listar("nome");
			
			cidades = new ArrayList<>();
			Messages.addGlobalInfo("Pessoa Salva com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar pessoa");
		}

	}

	public void excluir(ActionEvent evento) {

	}
	public void popular(){
		
		try {
			if(estado != null){
				CidadeDAO dao = new CidadeDAO();
				cidades = dao.buscarPorEstado(estado.getCodigo());
			}else{
				cidades = new ArrayList<Cidade>();
			}
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao tentar buscar o Estado");
			e.printStackTrace();
		}
	}
}