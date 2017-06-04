package com.hibernate.test.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.hibernate.dao.LoginDAO;
import com.hibernate.domain.Login;

public class LoginDaoTest {
	
	@Test
	@Ignore
	public void salvar(){
		
		Login lg = new Login();
		lg.setNome("Vitor");
		lg.setSobreNome("Ribeiro Caetano");
		
		LoginDAO dao = new LoginDAO();
		dao.merge(lg);
	}
	
	@Test
	@Ignore
	public void listar(){
		
		LoginDAO dao = new LoginDAO();
		List<Login> logins = dao.listar();
		
		for(Login login: logins){
			System.out.println(login.getCodigo());
			System.out.println(login.getNome()+" "+login.getSobreNome());
		}
	}
	@Test
	public void buscar(){
		Long codigo = 2L;
		
		LoginDAO dao = new LoginDAO();
		Login login = dao.buscar(codigo);
		
		if(login == null){
			System.out.println("Nenhum resultado encontrado ...");
		}else{
			System.out.println(login.getCodigo()+" - "+login.getNome()+" "+login.getSobreNome());
		}
		
		
	}

}
