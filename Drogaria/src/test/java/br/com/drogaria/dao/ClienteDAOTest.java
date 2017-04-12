package br.com.drogaria.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Cliente;
import br.com.drogaria.domain.Pessoa;

public class ClienteDAOTest {
	
	@Test
	@Ignore
	public void salvar() throws ParseException{
		
		Cliente cliente = new Cliente();
		
		cliente.setDataCadastro(new SimpleDateFormat("dd/mm/yyyy").parse("04/04/2017"));
		cliente.setLiberado(false);
		
		Long codigo = 1L;
		PessoaDAO dao = new PessoaDAO();
		Pessoa pessoa = dao.buscar(codigo);
				
		cliente.setPessoa(pessoa);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
		
		System.out.println("Cliente Salvo com sucesso ...");
	}
	
	@SuppressWarnings("unused")
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
	
	@Test
	@Ignore
	public void listar(){
		
		ClienteDAO dao = new ClienteDAO();
		List<Cliente> lista = dao.listar();
		
		for(Cliente cliente : lista){
			
			System.out.println(cliente.getCodigo()+" "+cliente.getDataCadastro()+" "+cliente.getLiberado());
			System.out.println(cliente.getPessoa().getNome());
		}
	}
	
	@Test
	@Ignore
	public void excluir(){

		Long codigo = 2L;
		
		ClienteDAO dao = new ClienteDAO();	
		Cliente c = dao.buscar(codigo);
		
		if(c == null){
			System.out.println("Nenhum resultado encontrado");
		}else{
			dao.excluir(c);
			System.out.println("Removido com sucesso:");
		}	
	}
	@Test
	public void editar(){
		
		Long codigo = 3L;
		
		ClienteDAO dao = new ClienteDAO();	
		Cliente c = dao.buscar(codigo);
		
		if(c == null){
			System.out.println("Nenhum resultado encontrado...");
		}else{
			System.out.println(c.getCodigo()+" "+c.getDataCadastro()+" - "+c.getLiberado()+" - "+c.getPessoa().getNome());
			
			c.setLiberado(true);
			dao.editar(c);
			
			System.out.println(c.getCodigo()+" "+c.getDataCadastro()+" - "+c.getLiberado()+" - "+c.getPessoa().getNome());
		}
	}

}
