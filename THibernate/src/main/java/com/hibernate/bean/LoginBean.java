package com.hibernate.bean;

import java.io.Serializable;
import java.util.List;


import com.hibernate.domain.Login;


@SuppressWarnings("serial")

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
	
	
	

}
