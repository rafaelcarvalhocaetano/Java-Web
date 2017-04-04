package br.com.drogaria.util;

import org.hibernate.Session;
import org.junit.Test;

public class HibernateUtilTest {
	
	@Test
	public void conectar(){
		
		Session sessao = HibernateUtil.getFabricaDeSessao().openSession();
		sessao.close();
		HibernateUtil.getFabricaDeSessao().close();
	}

}
