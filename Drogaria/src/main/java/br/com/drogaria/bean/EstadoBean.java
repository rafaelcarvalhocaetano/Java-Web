package br.com.drogaria.bean;

//import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.drogaria.domain.Estado;
//import org.omnifaces.util.Messages.Message;
//import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class EstadoBean {
	
	private Estado estado;
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public void novo(){
		estado = new Estado();
	}
	
	public void salvar(){
		/*
		String texto = "Programação web com java";
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, texto, texto);
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, mensagem);
		*/
		Messages.addGlobalInfo("Nome: "+estado.getNome()+" Sigla: "+estado.getSigla());
		
		
	}

}
