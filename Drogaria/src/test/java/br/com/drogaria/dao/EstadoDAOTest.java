package br.com.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Estado;

public class EstadoDAOTest {

	@Test
	@Ignore
	public void salvar() {

		Estado estado = new Estado();

		estado.setNome("Rio Grande do Sul");
		estado.setSigla("RS");

		EstadoDAO dao = new EstadoDAO();

		dao.salvar(estado);

	}
	
	@Test
	public void listar(){
		EstadoDAO dao = new EstadoDAO();
		List<Estado> resultado = dao.listar();
		
		System.out.println("Total de resutlados: "+ resultado.size());
		
		for(Estado estado : resultado){
			System.out.println(estado.getCodigo()+" "+estado.getSigla()+" - "+estado.getNome());
		}
	}
	@Test
	public void buscar(){
		
		Long codigo = 2L;
		
		EstadoDAO dao = new EstadoDAO();		
		Estado estado = dao.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum resultado");
		}
		
		System.out.println(estado.getCodigo()+" "+estado.getSigla()+" - "+estado.getNome());
	}

}
