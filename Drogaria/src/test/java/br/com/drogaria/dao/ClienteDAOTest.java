package br.com.drogaria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Cliente;
import br.com.drogaria.domain.Pessoa;

public class ClienteDAOTest {
	
	@Test
	@Ignore
	public void salvar() throws ParseException{
		
		Cliente cliente = new Cliente();
		
		cliente.setDataCadastro(new SimpleDateFormat("dd/mm/yyyy").parse("09/04/2017"));
		cliente.setLiberado(false);
		
		Long codigo = 1L;
		PessoaDAO dao = new PessoaDAO();
		Pessoa pessoa = dao.buscar(codigo);
				
		cliente.setPessoa(pessoa);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
		
		System.out.println("Cliente Salvo com sucesso ...");
	}
	
	@Test
	@Ignore
	public void buscar(){
		
		Long codigo = 1L;
				
		ClienteDAO clienteDAO = new ClienteDAO();
		
		if(clienteDAO == null){
			System.out.println("Nenhum Cliente cadastrado");
		}else{
			Cliente cliente = clienteDAO.buscar(codigo);
			System.out.println("Cliente "+cliente.getCodigo()+" "+cliente.getDataCadastro()+" "+cliente.getLiberado());
		}
		
		
	}

}
