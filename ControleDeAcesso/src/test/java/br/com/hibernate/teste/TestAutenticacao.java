package br.com.hibernate.teste;

import org.junit.Ignore;
import org.junit.Test;

import br.com.cadastro.dao.CadastroDAO;
import br.com.hibernate.domain.Cadastro;

public class TestAutenticacao {
	
	@Test
	@Ignore
	public void autenticar(){
		
		String ra = "1111111111";
		String senha = "11111111";
		
		CadastroDAO dao = new CadastroDAO();
		
		Cadastro cadastro = dao.autenticar(ra, senha);
		
		System.out.println("Cadastro encontrado"+cadastro);
	}

}
