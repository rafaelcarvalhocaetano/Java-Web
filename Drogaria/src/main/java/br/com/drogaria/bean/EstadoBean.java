package br.com.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
//import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.com.drogaria.dao.EstadoDAO;
import br.com.drogaria.domain.Estado;
//import org.omnifaces.util.Messages.Message;
//import javax.faces.context.FacesContext;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class EstadoBean implements Serializable {

	private Estado estado;
	private List<Estado> estados;

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public void novo() {
		estado = new Estado();
	}

	@PostConstruct
	public void listar() {
		try {
			EstadoDAO dao = new EstadoDAO();
			estados = dao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao acessar o Estado");
		}
	}

	public void salvar() {

		try {
			EstadoDAO dao = new EstadoDAO();
			dao.merge(estado);

			estado = new Estado();
			estados = dao.listar();

			Messages.addGlobalInfo("Estado salvo com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao salvar o Estado");
			e.printStackTrace();
		}
		/*
		 * String texto = "Programação web com java"; FacesMessage mensagem =
		 * new FacesMessage(FacesMessage.SEVERITY_INFO, texto, texto);
		 * 
		 * FacesContext contexto = FacesContext.getCurrentInstance();
		 * contexto.addMessage(null, mensagem);
		 */

	}

	public void excluir(ActionEvent event) {
		try{
		estado = (Estado) event.getComponent().getAttributes().get("estadoSelecionado");
		
		
		EstadoDAO dao = new EstadoDAO();
		dao.excluir(estado);
		
		estados = dao.listar();
		
		Messages.addGlobalInfo("Estado excluído com sucesso");
		}catch(RuntimeException e){
			Messages.addGlobalError("Erro ao tentar excluir o Estado");
			e.printStackTrace();
		}
	}
	public void editar(ActionEvent event){
		try {
			
			estado = (Estado)event.getComponent().getAttributes().get("estadoSelecionado");
			
			Messages.addGlobalInfo("Estado: "+estado.getNome()+" Sigla: "+estado.getSigla());
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao editar o estado");
		}
		
	}

}
