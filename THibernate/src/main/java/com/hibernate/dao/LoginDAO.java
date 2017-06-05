package com.hibernate.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.hibernate.domain.Login;
import com.hibernate.util.HibernateUtil;

public class LoginDAO extends GenericDAO<Login>{
	
public Login autenticar(String nome){
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			
			Criteria consulta = sessao.createCriteria(Login.class);
			consulta.createAlias("login", "l");
			
			consulta.add(Restrictions.eq("l.nome", nome));
		
			
			//SimpleHash hash = new SimpleHash("md5", senha);
			//consulta.add(Restrictions.eq("senha", hash.toHex()));
			
			Login login = (Login) consulta.uniqueResult();
			
			return login;
			
			
		} catch (RuntimeException e) {
			throw e;
		}finally {
			sessao.close();
		}
	}

}
