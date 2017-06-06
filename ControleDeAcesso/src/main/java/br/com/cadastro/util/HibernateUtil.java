package br.com.cadastro.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	private static SessionFactory fabricaDeSessao = criaFabricaDeSessao();
	
	public static SessionFactory getFabricaDeSessao() {
		return fabricaDeSessao;
	}
	
	private static SessionFactory criaFabricaDeSessao(){
		
		try {
			
			Configuration config = new Configuration().configure();
			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			SessionFactory fabrica = config.buildSessionFactory(registro);
			return fabrica;
			
		} catch (Throwable e) {
			System.err.println("A fábrica de sessões não pode ser criada." + e);
			throw new ExceptionInInitializerError(e);
		}
	}

}
