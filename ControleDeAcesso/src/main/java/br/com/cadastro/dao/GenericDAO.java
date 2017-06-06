package br.com.cadastro.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.cadastro.util.HibernateUtil;

public class GenericDAO<Entidade> {
	
	private Class<Entidade> classe;
	
	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	//Salvar
	public void salvar(Entidade entidade){
		
		Session ss = HibernateUtil.getFabricaDeSessao().openSession();
		Transaction transacao = null;
		
		try {
			
			transacao = ss.beginTransaction();
			ss.save(entidade);
			transacao.commit();
			
		} catch (RuntimeException e) {
			
			if(transacao != null){
				transacao.rollback();
				throw e;
			}
						
		}finally {
			ss.close();
		}
	}
	//metodo merge -- salva e faz a porra toda só não exclui....
	public void merge(Entidade entidade){
		
		Session ss = HibernateUtil.getFabricaDeSessao().openSession();
		Transaction tt = null;
		
		try {
			
			tt = ss.beginTransaction();
			ss.merge(entidade);
			tt.commit();		
			
		} catch (RuntimeException e) {
			
			if(tt != null){
				tt.rollback();
				throw e;
			}
						
		}finally {
			
			ss.close();
		}
		
	}
	//Lista todos os usuário Cadastrados no DB...
	@SuppressWarnings("unchecked")
	public List<Entidade> listar(){
		
		Session ss = HibernateUtil.getFabricaDeSessao().openSession();
		
		try {
			Criteria consulta = ss.createCriteria(classe);
			List<Entidade> resultado = consulta.list();
			return resultado;			
			
		} catch (RuntimeException e) {
			
			throw e;
			
		}finally {
			ss.close();
		}
	}
	
	//Busca através de um código...
	@SuppressWarnings("unchecked")
	public Entidade buscar(Long codigo){
		
		Session ss = HibernateUtil.getFabricaDeSessao().openSession();
		
		try {
			
			Criteria consulta = ss.createCriteria(classe);
			consulta.add(Restrictions.idEq(codigo));
			Entidade resultado = (Entidade) consulta.uniqueResult();
			return resultado;			
			
		} catch (RuntimeException e) {
			throw e;
		}finally {
			ss.close();
		}
	}
	
	//Excluir...
	public void excluir(Entidade entidade){
		
		Session ss = HibernateUtil.getFabricaDeSessao().openSession();
		Transaction tt = null;
		
		try {
			
			tt = ss.beginTransaction();
			ss.delete(entidade);
			tt.commit();			
			
		} catch (RuntimeException e) {
			
			if(tt != null){
				tt.rollback();
				throw e;
			}
			
		}finally {
			ss.close();
		}
	}
}
