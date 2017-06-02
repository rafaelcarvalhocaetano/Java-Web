package com.hibernate.test;

import org.hibernate.Session;

import com.hibernate.util.HibernateUtil;

public class HibernateUtilTest {
	
	public static void main(String[] args) {
		
		Session sessao = HibernateUtil.getFabricaDeSessao().openSession(); //acabou de ligar e a pessoa atendeu
		
		sessao.close(); //encerra a ligação
	}

}
