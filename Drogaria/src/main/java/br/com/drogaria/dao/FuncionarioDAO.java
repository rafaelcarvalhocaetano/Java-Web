package br.com.drogaria.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.drogaria.domain.Funcionario;
import br.com.drogaria.util.HibernateUtil;

public class FuncionarioDAO extends GenericDAO<Funcionario> {

	// listar ordenado
	@SuppressWarnings("unchecked")
	public List<Funcionario> listarOrdenado() {

		Session sessao = HibernateUtil.getFabricaDeSessao().openSession();

		try {
			Criteria consulta = sessao.createCriteria(Funcionario.class);
			consulta.createAlias("pessoa", "pn");
			consulta.addOrder(Order.asc("pn.nome"));
			List<Funcionario> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException e) {
			throw e;
		} finally {
			sessao.close();
		}
	}

}
