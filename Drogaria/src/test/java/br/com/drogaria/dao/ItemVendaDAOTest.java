package br.com.drogaria.dao;

import org.junit.Test;

import br.com.drogaria.domain.ItemVenda;

public class ItemVendaDAOTest {
	
	@Test
	public void buscar(){
		Long codigo = 1L;
		
		ItemVendaDAO dao = new ItemVendaDAO();
		ItemVenda itemVenda = dao.buscar(codigo);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		
		if(itemVenda == null){
			System.out.println("Nenhum item de venda encontrado");
		}else{
			System.out.println(itemVenda.getCodigo()+" "+itemVenda.getQuantidade()+" "+itemVenda.getProduto().getCodigo()+" "+itemVenda.getValorParcial());
		}
	}

}
