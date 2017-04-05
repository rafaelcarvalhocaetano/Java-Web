package br.com.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Fabricante;

public class FabricanteDAOTest {

	@Test
	@Ignore
	public void salvar(){
		
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("BAYER");
		
		Fabricante fb = new Fabricante();
		fb.setDescricao("Hinode");
		
		FabricanteDAO dao = new FabricanteDAO();
		
		dao.salvar(fabricante);
		dao.salvar(fb);
	}
	
	@Test
	@Ignore
	public void listar(){
		FabricanteDAO dao = new FabricanteDAO();
		
		List<Fabricante> resultado = dao.listar();
		
		System.out.println("Total de Resultados: "+resultado.size());
		
		for(Fabricante fabricante: resultado){
			System.out.println(fabricante.getCodigo()+" "+fabricante.getDescricao());
		}
	}
	@Test
	public void buscar(){
		
		Long codigo = 2L;
		
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fb = dao.buscar(codigo);
		
		if(fb == null){
			System.out.println("Nenhum resultado");
		}
		
		System.out.println(fb.getCodigo()+" "+fb.getDescricao());
	}
}