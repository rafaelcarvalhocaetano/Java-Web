package br.com.drogaria.dao;

import org.junit.Test;

import br.com.drogaria.domain.Cliente;
import br.com.drogaria.domain.Pessoa;

public class ClienteDAOTest {
	
	@Test
	public void salvar(){
		
		Cliente cliente = new Cliente();
		
		cliente.setDataCadastro(dataCadastro);
		cliente.setLiberado(true);
		
		Long codigo = 2L;
		PessoaDAO dao = new PessoaDAO();
		Pessoa pessoa = dao.buscar(codigo);
				
		cliente.setPessoa(pessoa);
	}

}
