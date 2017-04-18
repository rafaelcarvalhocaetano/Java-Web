package br.com.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.CidadeDAO;
import br.com.drogaria.dao.EstadoDAO;
import br.com.drogaria.domain.Cidade;
import br.com.drogaria.domain.Estado;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class CidadeBean implements Serializable {

	private Cidade cidade;
	private List<Cidade> cidades;
	private List<Estado> estados;

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@PostConstruct
	public void listar() {
		try {
			CidadeDAO dao = new CidadeDAO();
			cidades = dao.listar();

		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao editar a cidade");
			e.printStackTrace();
		}
	}

	public void novo() {

		try {
			cidade = new Cidade();

			EstadoDAO dao = new EstadoDAO();

			estados = dao.listar("nome");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao gerar uma nova cidade");
			e.printStackTrace();
		}
	}

	public void salvar() {
		try {
			CidadeDAO dao = new CidadeDAO();
			dao.merge(cidade);

			EstadoDAO sdao = new EstadoDAO();
			estados = sdao.listar();

			cidade = new Cidade();
			cidades = dao.listar();

			Messages.addGlobalInfo("Cidade salva com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao tentar salvar");
			e.printStackTrace();
		}
	}

	public void excluir(ActionEvent event) {
		try {
			cidade = (Cidade) event.getComponent().getAttributes().get("cidadeSelecionada");

			CidadeDAO dao = new CidadeDAO();
			dao.excluir(cidade);

			cidades = dao.listar();

			Messages.addGlobalInfo("Cidade excluida com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao excluir a cidade");
		}
	}

	public void editar(ActionEvent event) {
		try {
			cidade = (Cidade) event.getComponent().getAttributes().get("cidadeSelecionada");

			EstadoDAO dao = new EstadoDAO();
			estados = dao.listar("nome");

			Messages.addGlobalInfo("Cidade editada com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao tentar editar a cidade");
		}
	}

}
