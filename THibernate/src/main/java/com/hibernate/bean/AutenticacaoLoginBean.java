package com.hibernate.bean;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import com.hibernate.dao.LoginDAO;
import com.hibernate.domain.Login;


@SessionScoped
@ManagedBean
public class AutenticacaoLoginBean {
	
	private Login login;
	private Login loginLogado;
	
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public Login getLoginLogado() {
		return loginLogado;
	}
	public void setLoginLogado(Login loginLogado) {
		this.loginLogado = loginLogado;
	}
	
	
	@PostConstruct
	public void iniciar(){
		
		login = new Login();
		
		
	}
	
	public void autenticar(){
		try {
			LoginDAO dao = new LoginDAO();
			loginLogado = dao.autenticar(login.getNome());
			
			if(loginLogado == null){
				return;
			}
								
			Faces.redirect("./pages/ambiente.xhtml");
		} catch (IOException e) {
			Messages.addGlobalError("Erro ao redirecionar "+e.getMessage());
			e.printStackTrace();
		}
		
	}
	

}
