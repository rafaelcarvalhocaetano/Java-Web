package com.hibernate.test;

import org.hibernate.Session;
import org.junit.Test;

import com.hibernate.util.HibernateUtil;

public class HibernateUtilTest {
	
	@Test
	public void conectar() {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession(); //acabou de ligar e a pessoa atendeu
		
		HibernateUtil.getFabricaDeSessoes().close(); //encerra a ligação
	}

}
