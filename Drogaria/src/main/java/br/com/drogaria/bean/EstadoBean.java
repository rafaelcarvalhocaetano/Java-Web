package br.com.drogaria.bean;

//import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import org.omnifaces.util.Messages;
//import org.omnifaces.util.Messages.Message;
//import javax.faces.context.FacesContext;

@ManagedBean
public class EstadoBean {
	
	public void salvar(){
		/*
		String texto = "Programação web com java";
		FacesMessage mensagem = new FacesMessage(FacesMessage.SEVERITY_INFO, texto, texto);
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, mensagem);
		*/
		Messages.addGlobalInfo("Programação web com java");
		
		
	}

}
