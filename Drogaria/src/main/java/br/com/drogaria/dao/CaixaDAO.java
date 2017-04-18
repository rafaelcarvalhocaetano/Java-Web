package br.com.drogaria.dao;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.drogaria.domain.Caixa;
import br.com.drogaria.util.HibernateUtil;

public class CaixaDAO extends GenericDAO<Caixa> {
	
	public Caixa buscar(Date dataAbertura){
		
		Session sessao = HibernateUtil.getFabricaDeSessao().openSession();
		
		try {
			
			Criteria consulta = sessao.createCriteria(Caixa.class);
			consulta.add(Restrictions.eq("dataAbertura", dataAbertura));
			Caixa resultado = (Caixa) consulta.uniqueResult();
			return resultado;
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}	
	}

}
