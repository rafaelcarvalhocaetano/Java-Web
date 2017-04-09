package br.com.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Cliente;
import br.com.drogaria.domain.Pessoa;
import br.com.drogaria.domain.Usuario;

public class UsuarioDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Long codigo = 2L;

		PessoaDAO pd = new PessoaDAO();
		Pessoa pessoa = pd.buscar(codigo); // usando a referencia do codigo para os dois tipos

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
	@SuppressWarnings("unused")
	@Test
	@Ignore
	public void buscar(){
		
		Long codigo = 1L;
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario ca = new Usuario();
		
		if(ca == null){
			System.out.println("Nenhum usuário encontrado");
		}else{
			dao.buscar(codigo);
			//System.out.println(ca.getCodigo()+" "+ca.getSenha()+" "+ca.getTipo()+" "+ca.getAtivo()+" "+ca.getPessoa().getNome());
		}
	}
	@Test
	
	public void listar(){
		
		Long codigo = 2L;
		UsuarioDAO dao = new UsuarioDAO();
		
		List<Usuario> lista = dao.listar();
		
		System.out.println("Total "+lista.size());
		
		for(Usuario listas : lista){
			System.out.println(listas.getSenha());
			System.out.println(listas.getAtivo());
			System.out.println(listas.getCodigo());
			System.out.println(listas.getPessoa().getNome());
		}
		
		
	}

}
