package com.hibernate.test.dao;

import org.junit.Test;

import com.hibernate.dao.LoginDAO;
import com.hibernate.domain.Login;

public class LoginDaoTest {
	
	@Test
	public void salvar(){
		
		Login lg = new Login();
		lg.setNome("Vitor");
		lg.setSobreNome("Ribeiro Caetano");
		
		LoginDAO dao = new LoginDAO();
		dao.merge(lg);
	}

}
