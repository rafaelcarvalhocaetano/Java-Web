package br.com.uninove.teste;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;

import br.com.uninove.dao.CadastroDAO;
import br.com.uninove.domain.Cadastro;
import br.com.uninove.factory.ConexaoFactory;

public class CadastroDaoTest {
	
	@Test
	public void con(){
		try {
			Connection con = ConexaoFactory.conectar();
			System.out.println("Conectado");
		} catch (Exception e) {
			System.out.println("Não Conectado");
			e.printStackTrace();
		}
	}
	
	@Test
	@Ignore
	public void salvar() throws SQLException{
		
		Cadastro cad = new Cadastro();
		
		cad.setNome("rafael carvalho");
		cad.setRa("123456789");
		cad.setSenha("q1w2e3r4");
		
		CadastroDAO dao = new CadastroDAO();
		dao.salvar(cad);
	}

}
