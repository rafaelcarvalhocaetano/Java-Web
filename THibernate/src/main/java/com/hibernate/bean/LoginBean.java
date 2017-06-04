package com.hibernate.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;

import com.hibernate.domain.Login;

@SuppressWarnings("serial")
@ManagedBean
public class LoginBean implements Serializable{
	
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
	
	public void navegar(){
		
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("logar.xhtml");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	

}
