package br.com.drogaria.dao;

import org.junit.Test;

import br.com.drogaria.domain.Cidade;
import br.com.drogaria.domain.Estado;

public class CidadeDAOTest {
	
	@Test
	public void salvar(){
		EstadoDAO dao = new EstadoDAO();
		Estado estado = dao.buscar(1L);
		
		Cidade cidade = new Cidade();
		cidade.setNome("Osasco");
		cidade.setEstado(estado);
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);
		
	}

}
