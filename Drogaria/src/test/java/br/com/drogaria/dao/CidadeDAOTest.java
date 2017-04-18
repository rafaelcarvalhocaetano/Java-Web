package br.com.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Cidade;
import br.com.drogaria.domain.Estado;

public class CidadeDAOTest {

	@Test
	@Ignore
	public void salvar() {
		EstadoDAO dao = new EstadoDAO();
		Estado estado = dao.buscar(1L);

		Cidade cidade = new Cidade();
		cidade.setNome("Osasco");
		cidade.setEstado(estado);

		CidadeDAO cidadeDAO = new CidadeDAO();
		cidadeDAO.salvar(cidade);

	}

	@Test
	@Ignore
	public void listar() {
		CidadeDAO dao = new CidadeDAO();
		List<Cidade> cidades = dao.listar();

		for (Cidade cd : cidades) {

			System.out.println("Código da cidade: " + cd.getCodigo());
			System.out.println("Nome da cidade: " + cd.getNome());
			System.out.println("Código do Estado: " + cd.getEstado().getCodigo());

			System.out.println("Sigla do Estado: " + cd.getEstado().getSigla());
			System.out.println("Nome do Estado: " + cd.getEstado().getNome());
			System.out.println();

		}
	}

	@Test
	@Ignore
	public void buscar() {

		Long codigo = 1L;

		CidadeDAO dao = new CidadeDAO();
		Cidade cidade = dao.buscar(codigo);

		System.out.println("Código da cidade: " + cidade.getCodigo());
		System.out.println("Nome da cidade: " + cidade.getNome());
		System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());

		System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
		System.out.println();
	}

	@Test
	@Ignore
	public void excluir() {

		Long codigo = 1L;

		CidadeDAO dao = new CidadeDAO();
		Cidade cidade = dao.buscar(codigo);
		
		System.out.println("Antes da remoção -- ");
		System.out.println("Código da cidade: " + cidade.getCodigo());
		System.out.println("Nome da cidade: " + cidade.getNome());
		System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());

		System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
		
		dao.excluir(cidade);
		
	}
	
	@Test
	@Ignore
	public void editar(){
		
		Long codigo = 2L;
		Long codigoEstado = 1L;
		
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigoEstado);
		
		System.out.println("Código da cidade: " + estado.getCodigo());
		System.out.println("Nome da cidade: " + estado.getSigla());
		System.out.println("Código do Estado: " + estado.getNome());

		CidadeDAO dao = new CidadeDAO();
		Cidade cidade = dao.buscar(codigo);
		
		System.out.println("Cidade a ser editada");
		System.out.println("Código da cidade: " + cidade.getCodigo());
		System.out.println("Nome da cidade: " + cidade.getNome());
		System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
		System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
		
		cidade.setNome("Jandira");
		cidade.setEstado(estado);
		dao.editar(cidade);
		
		System.out.println("Cidade editada");
		System.out.println("Código da cidade: " + cidade.getCodigo());
		System.out.println("Nome da cidade: " + cidade.getNome());
		System.out.println("Código do Estado: " + cidade.getEstado().getCodigo());
		System.out.println("Sigla do Estado: " + cidade.getEstado().getSigla());
		System.out.println("Nome do Estado: " + cidade.getEstado().getNome());
			
	}
	@Test
	public void buscarPorEstado() {
		
		Long estadoCodigo = 1L;
		
		
		CidadeDAO dao = new CidadeDAO();
		List<Cidade> cidades = dao.buscarPorEstado(estadoCodigo);

		for (Cidade cd : cidades) {

			System.out.println("Código da cidade: " + cd.getCodigo());
			System.out.println("Nome da cidade: " + cd.getNome());
			System.out.println("Código do Estado: " + cd.getEstado().getCodigo());

			System.out.println("Sigla do Estado: " + cd.getEstado().getSigla());
			System.out.println("Nome do Estado: " + cd.getEstado().getNome());
			System.out.println();

		}
	}

}
