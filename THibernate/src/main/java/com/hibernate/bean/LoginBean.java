package com.hibernate.bean;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import org.omnifaces.util.Messages;

import com.hibernate.dao.LoginDAO;
import com.hibernate.domain.Login;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class LoginBean implements Serializable {

	private Login login;
	private List<Login> logins;

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<Login> getLogins() {
		return logins;
	}

	public void setLogins(List<Login> logins) {
		this.logins = logins;
	}
	@PostConstruct
	public void listar(){
		try {
			LoginDAO dao = new LoginDAO();
			logins = dao.listar();
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao listar clientes");
			e.printStackTrace();
		}
	}
	
	public void novo() {
		login = new Login();

	}

	public void salvar() {

		try {
			LoginDAO dao = new LoginDAO();
			dao.salvar(login);

			novo();
			logins = dao.listar();

			System.out.println("Salvo com sucesso");
		} catch (RuntimeException e) {
			System.out.println("Erro ... ");
			e.printStackTrace();
		}
	}
	

}
