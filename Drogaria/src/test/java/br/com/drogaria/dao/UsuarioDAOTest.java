package br.com.drogaria.dao;

import org.junit.Test;

import br.com.drogaria.domain.Pessoa;
import br.com.drogaria.domain.Usuario;

public class UsuarioDAOTest {
	
	
	@Test
	public void salvar(){
		
		Long codigo = 2L;
		
		PessoaDAO pd = new PessoaDAO();
		Pessoa pessoa = pd.buscar(codigo); //usando a referencia do codigo para os dois tipos
		
		System.out.println(pessoa.getNome());
		System.out.println(pessoa.getCpf());
		
		
		Usuario us = new Usuario();
	
		us.setPessoa(pessoa);
		us.setAtivo(true);
		us.setSenha("2222222");
		us.setTipo('M');
		
		UsuarioDAO dao = new UsuarioDAO();
		dao.salvar(us);
		
		System.out.println(us.getAtivo());
		System.out.println(us.getSenha());
		System.out.println(us.getCodigo());
		System.out.println(us.getTipo());
		

		

	}

}
