package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory fabricaDeSessao = createFS();
	
	public static SessionFactory getFabricaDeSessao() {
		return fabricaDeSessao;
	}
	
	private static SessionFactory createFS(){
		
		try {
			Configuration configuracao = new Configuration().configure(); //captura no hibernateu cfg as configurações.
			
			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
			
			SessionFactory fabrica = configuracao.buildSessionFactory(registro);
			
			return fabrica;
			
		} catch (Throwable e) {
			System.out.println("Falha na criação da sessão do hibernate util"+e);
			throw new ExceptionInInitializerError(e);
		}
	}
	


}
