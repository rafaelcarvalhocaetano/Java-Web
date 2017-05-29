package br.com.drogaria.dao;

import java.util.List;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Pessoa;
import br.com.drogaria.domain.Usuario;

public class UsuarioDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Long codigo = 3L;

		PessoaDAO pd = new PessoaDAO();
		Pessoa pessoa = pd.buscar(codigo); // usando a referencia do codigo para os dois tipos

		System.out.println(pessoa.getNome());
		System.out.println(pessoa.getCpf());

		Usuario us = new Usuario();
		
		

		us.setPessoa(pessoa);
		us.setAtivo(true);
		us.setSenhaSemCriptografia("q1w2e3r4");
		
		SimpleHash sh = new SimpleHash("md5", us.getSenhaSemCriptografia());
		
		us.setSenha(sh.toHex());
		us.setTipo('B');

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
	@Ignore
	public void listar(){
		
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
	
	@Test
	@Ignore
	public void excluir(){
		
		Long codigo = 3L;
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario us = dao.buscar(codigo);
		
		if(us == null){
			System.out.println("Nenhum usuário encontrado");
		}else{
			dao.excluir(us);
			System.out.println("Usuário excluido com sucesso");
		}
	}
	@Test
	@Ignore
	public void editar(){

		Long codigo = 1L;
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario us = dao.buscar(codigo);
		
		if(us == null){
			System.out.println("Nenhum resultado encontrado...");
		}else{
			us.setTipo('A');
			us.setSenha("788888888");
			dao.editar(us);
			
			System.out.println("Alterações feitas com sucesso ...");
		}
	}
	public void autenticar(){
		String cpf = "999.999.999-99";
		String senha = "q1w2e3r4";
		
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.autenticar(cpf, senha);
		
		System.out.println(usuario);
	}

}
