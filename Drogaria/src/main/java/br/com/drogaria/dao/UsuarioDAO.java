package br.com.drogaria.dao;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.drogaria.domain.Usuario;
import br.com.drogaria.util.HibernateUtil;

public class UsuarioDAO extends GenericDAO<Usuario>{
	
	public Usuario autenticar(String cpf, String senha){
		
		Session sessao = HibernateUtil.getFabricaDeSessao().openSession();
		
		try {
			Criteria consulta = sessao.createCriteria(Usuario.class);
			consulta.createAlias("pessoa", "p");
			consulta.add(Restrictions.eq("p.cpf", senha));
			
			SimpleHash hash = new SimpleHash("md5", senha);
			consulta.add(Restrictions.eq("senha", hash.toHex()));
			
			Usuario usuario = (Usuario) consulta.uniqueResult();
			
			return usuario;
			
		} catch (RuntimeException e) {
			throw e;
		}finally{
			sessao.close();
		}
	}

}
