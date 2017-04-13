package br.com.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Fabricante;

public class FabricanteDAOTest {

	@Test
	@Ignore
	public void salvar() {

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
	public void listar() {
		FabricanteDAO dao = new FabricanteDAO();

		List<Fabricante> resultado = dao.listar();

		System.out.println("Total de Resultados: " + resultado.size());

		for (Fabricante fabricante : resultado) {
			System.out.println(fabricante.getCodigo() + " " + fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void buscar() {

		Long codigo = 2L;

		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fb = dao.buscar(codigo);

		if (fb == null) {
			System.out.println("Nenhum resultado");
		}

		System.out.println(fb.getCodigo() + " " + fb.getDescricao());
	}

	
	@Test
	@Ignore
	public void excluir() {

		Long codigo = 4L;

		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fabricante = dao.buscar(codigo);

		if (fabricante == null) {
			System.out.println("Nenhum resultado encontrado");
		}else {
			dao.excluir(fabricante);
			System.out.println("Removido com sucesso:");
			System.out.println(fabricante.getCodigo() + " " + fabricante.getDescricao());
		}
	}
	
	@Test
	@Ignore
	public void editar(){
		
		Long codigo = 2L;
		
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fabricante = dao.buscar(codigo);
		
		if(fabricante == null){
			System.out.println("Nenhum resultado encontrado...");
		}else{
			System.out.println(fabricante.getCodigo()+" "+fabricante.getDescricao());
			
			fabricante.setDescricao("HINODE");
			dao.editar(fabricante);
			
			System.out.println(fabricante.getCodigo()+" "+fabricante.getDescricao());
		}
	}
	@Test
	@Ignore
	public void merge() {
		/*
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Fabricante A");

		FabricanteDAO dao = new FabricanteDAO();
		dao.merge(fabricante);
		*/
		FabricanteDAO dao = new FabricanteDAO();;
		Fabricante fb = dao.buscar(4L);
		fb.setDescricao("Fabricante B");
		dao.merge(fb);
		
	}
}
