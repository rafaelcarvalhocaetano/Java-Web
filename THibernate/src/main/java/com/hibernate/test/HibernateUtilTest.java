package com.hibernate.test;

import org.hibernate.Session;

import com.hibernate.util.HibernateUtil;

public class HibernateUtilTest {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession(); //acabou de ligar e a pessoa atendeu
		
		HibernateUtil.getFabricaDeSessoes().close(); //encerra a ligação
	}

}
