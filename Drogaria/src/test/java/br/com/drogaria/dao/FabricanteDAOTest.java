package br.com.drogaria.dao;

import org.junit.Test;

import br.com.drogaria.domain.Fabricante;

public class FabricanteDAOTest {

	@Test
	public void salvar(){
		
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("BAYER");
		
		Fabricante fb = new Fabricante();
		fb.setDescricao("Hinode");
		
		FabricanteDAO dao = new FabricanteDAO();
		
		dao.salvar(fabricante);
		dao.salvar(fb);
	}
}
