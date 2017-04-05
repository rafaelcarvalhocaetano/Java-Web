package br.com.drogaria.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.drogaria.util.HibernateUtil;

public class GenericDAO<Entidade> {
	
	public void salvar(Entidade entidade){
		
		Session sessao = HibernateUtil.getFabricaDeSessao().openSession();
		Transaction transacao = null;
		
		try {
			
			transacao = sessao.beginTransaction();
			sessao.save(entidade);
			transacao.commit();
			
		} catch (RuntimeException e) {
			
			if(transacao != null){
				transacao.rollback();
			}
			
			throw e;
		
		}finally{
			
			sessao.close();
		}
	}

}
