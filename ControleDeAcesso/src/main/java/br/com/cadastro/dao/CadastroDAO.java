package br.com.cadastro.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.cadastro.util.HibernateUtil;
import br.com.hibernate.domain.Cadastro;

public class CadastroDAO extends GenericDAO<Cadastro>{
	
	public Cadastro autenticar(String ra, String senha){
		
		Session ss = HibernateUtil.getFabricaDeSessao().openSession();
		
		try {
			
			Criteria consulta = ss.createCriteria(Cadastro.class);
			
			consulta.add(Restrictions.eq("ra", ra));
			consulta.add(Restrictions.eq("senha", senha));
			
			Cadastro resultado = (Cadastro) consulta.uniqueResult();
			
			return resultado;
			
		} catch (RuntimeException e) {
			throw e;
		}finally {
			ss.close();
		}
		
	}

}
