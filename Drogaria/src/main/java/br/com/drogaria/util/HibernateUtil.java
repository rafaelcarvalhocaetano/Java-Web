package br.com.drogaria.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	
	
	private static SessionFactory fabricaDeSessao = criarFabricaDeSessao();
	
	public static SessionFactory getFabricaDeSessao() {
		return fabricaDeSessao;
	}
	
	private static SessionFactory criarFabricaDeSessao(){
		
		try {
			Configuration config = new Configuration().configure();
			ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
			
			SessionFactory  fabrica = config.buildSessionFactory(registro);
			
			return fabrica;

		} catch (Throwable e) {
			
			System.out.println("A fabrica de sessões falhou... "+e);
			throw new ExceptionInInitializerError(e);
			
		}
	}
}
