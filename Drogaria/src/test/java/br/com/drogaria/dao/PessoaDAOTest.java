package br.com.drogaria.dao;

import org.junit.Test;

import br.com.drogaria.domain.Cidade;
import br.com.drogaria.domain.Pessoa;

public class PessoaDAOTest {

	@Test
	public void salvar() {

		Pessoa pessoa = new Pessoa();

		pessoa.setNome("Fulano Beltrano");
		pessoa.setCpf("178910");
		pessoa.setRg("326607");
		pessoa.setRua("RuaA");
		pessoa.setNumero(new Short("1"));
		pessoa.setBairro("Centro");
		pessoa.setCep("99999999");
		pessoa.setComplemento("Em frente");
		pessoa.setTelefone("99999999");
		pessoa.setCelular("99999999");
		pessoa.setEmail("teteste.com");
				
		Long codigo = 1L;
		
		CidadeDAO cidadeDAO = new CidadeDAO();
		Cidade cidade = cidadeDAO.buscar(codigo);

		if(cidade == null){
			System.out.println("Nenhum");
		}else{
			pessoa.setCidade(cidade);
		}
		
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);
	}
}
