package br.com.hibernate.teste;

import org.hibernate.Session;

import br.com.cadastro.util.HibernateUtil;

public class HibernateUtilTest {
	
	public static void main(String[] args) {
		Session ss = HibernateUtil.getFabricaDeSessao().openSession();
		ss.close();
		
	}

}
