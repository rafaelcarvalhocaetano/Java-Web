package br.com.drogaria.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import br.com.drogaria.domain.Cliente;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import br.com.drogaria.domain.Funcionario;
>>>>>>> 77aefe6 (# This is a combination of 42 commits.)
=======
>>>>>>> f8955c9 (Criando vendas controller e view)
import br.com.drogaria.util.HibernateUtil;

public class ClienteDAO extends GenericDAO<Cliente>{
	
	// listar ordenado
		@SuppressWarnings("unchecked")
		public List<Cliente> listarOrdenado() {

			Session sessao = HibernateUtil.getFabricaDeSessao().openSession();

			try {
				Criteria consulta = sessao.createCriteria(Cliente.class);
				consulta.createAlias("pessoa", "pn");
				consulta.addOrder(Order.asc("pn.nome"));
				List<Cliente> resultado = consulta.list();
				return resultado;
			} catch (RuntimeException e) {
				throw e;
			} finally {
				sessao.close();
			}
		}

}
