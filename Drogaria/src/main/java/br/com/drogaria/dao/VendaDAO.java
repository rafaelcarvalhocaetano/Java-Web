package br.com.drogaria.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.drogaria.domain.ItemVenda;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.domain.Venda;
import br.com.drogaria.util.HibernateUtil;

public class VendaDAO extends GenericDAO<Venda>{
	
	public void salvar(Venda venda, List<ItemVenda> itensVendas){
		
		Session sessao = HibernateUtil.getFabricaDeSessao().openSession();
		Transaction transacao = null;

		try {

			transacao = sessao.beginTransaction();
			sessao.save(venda);
			
			for (int i = 0; i < itensVendas.size(); i++) {
				ItemVenda itemVenda = itensVendas.get(i);
				itemVenda.setVenda(venda);
				
				sessao.save(itemVenda);
				
				Produto produto = itemVenda.getProduto();
				
				int quantidade = produto.getQuantidade() - itemVenda.getQuantidade();
				
				if(quantidade >= 0){
					
					produto.setQuantidade(new Short(quantidade + ""));
					
					sessao.update(produto);
					
				}else{
					
					throw new RuntimeException("A quantidade insuficiente em estoque");
				}
					
				}
				
				
			
			transacao.commit();
			
		} catch (RuntimeException e) {

			if (transacao != null) {
				transacao.rollback();
			}

			throw e;

		} finally {

			sessao.close();
		}
	}

}
