package br.com.drogaria.service;

import java.util.List;

import javax.ws.rs.Path;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

//http://localhost:8080/Drogaria/rest/fabricante
@Path("fabricante")
public class FabricanteService {

	public void listar(){
		FabricanteDAO dao = new FabricanteDAO();
		List<Fabricante> fabricantes = dao.listar("descricao");
	}
}
