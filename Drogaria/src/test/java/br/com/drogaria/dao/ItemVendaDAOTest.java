package br.com.drogaria.dao;

import org.junit.Ignore;
import org.junit.Test;

import br.com.drogaria.domain.ItemVenda;

public class ItemVendaDAOTest {
	
	@Test
	@Ignore
	public void buscar(){
		Long codigo = 1L;
		
		ItemVendaDAO dao = new ItemVendaDAO();
		ItemVenda itemVenda = dao.buscar(codigo);
		
		if(itemVenda == null){
			System.out.println("Nenhum item de venda encontrado");
		}else{
			System.out.println(itemVenda.getCodigo()+" "+itemVenda.getQuantidade()+" "+itemVenda.getProduto().getCodigo()+" "+itemVenda.getValorParcial());
		}
	}
	
	@Test
	public void excluir(){
		
		Long codigo = 2L;
		
		ItemVendaDAO dao = new ItemVendaDAO();
		ItemVenda itemVenda = dao.buscar(codigo);
		
		
		if(itemVenda == null){
			System.out.println("nenhum item de venda encontrado para ser excluido...");
		}else{
			dao.excluir(itemVenda);
			System.out.println("Item excluído ...");
		}
		
	}

}
