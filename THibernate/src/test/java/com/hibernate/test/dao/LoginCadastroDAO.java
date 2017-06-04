package com.hibernate.test.dao;

import org.junit.Test;

import com.hibernate.domain.Login;

public class LoginCadastroDAO {
	
	@Test
	public void salvar(){
		
		Login lg = new Login();
		lg.setNome("Rafael");
		lg.setSobreNome("Carvalho Caetano");
	}

}
