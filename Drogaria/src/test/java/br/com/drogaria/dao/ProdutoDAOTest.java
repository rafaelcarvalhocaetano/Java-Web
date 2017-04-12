package br.com.drogaria.dao;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

public class ProdutoDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		Produto produto = new Produto();
		
		Long codigo = 1L;
		FabricanteDAO dao = new FabricanteDAO();
		Fabricante fabricante = dao.buscar(codigo);
		
		produto.setDescricao("Cataflam 50 mg 20 comprimidos");
		produto.setPreco(new BigDecimal("13.70"));
		produto.setQuantidade(new Short("3"));
		produto.setFabricante(fabricante);
		
		ProdutoDAO dao2 = new ProdutoDAO();
		dao2.salvar(produto);
		
	}
	
	@Test
	@Ignore
	public void excluir(){
		
		Long codigo = 1L;
		
		ProdutoDAO dao = new ProdutoDAO();
		Produto produto = dao.buscar(codigo);
		
		if(produto == null){
			System.out.println("Nenhum produto encontrado...");
		}else{
			dao.excluir(produto);
			System.out.println("Produto removido com sucesso...");
		}
	}
	@Test
	@Ignore
	public void editar(){
		Long codigo = 2L;
		
		ProdutoDAO dao = new ProdutoDAO();
		Produto produto = dao.buscar(codigo);
		
		if(produto == null){
			System.out.println("Nenhuma produto encontrado....");
		}else{
			System.out.println(produto.getCodigo()+" "+produto.getDescricao()+" "+produto.getQuantidade()+" "+produto.getFabricante()+" "+produto.getPreco());
			produto.setDescricao("Novalgina com 30 mg");
			dao.editar(produto);
			System.out.println(produto.getCodigo()+" "+produto.getDescricao()+" "+produto.getQuantidade()+" "+produto.getFabricante()+" "+produto.getPreco());
		}
	}
	@Test
	@Ignore
	public void buscar(){
		
		Long codigo = 2L;
		
		ProdutoDAO dao = new ProdutoDAO();
		Produto produto = dao.buscar(codigo);
		
		
		if(produto == null){
			System.out.println("Nenhum produto encontrado...");
		}else{
			System.out.println(produto.getCodigo()+" "+produto.getDescricao()+" "+produto.getQuantidade()+" "+produto.getFabricante().getCodigo()+" "+produto.getPreco());
		}
	}
	

}
