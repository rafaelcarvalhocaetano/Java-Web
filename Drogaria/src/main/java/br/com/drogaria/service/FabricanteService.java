package br.com.drogaria.service;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

//http://localhost:8080/Drogaria/rest/fabricante
@Path("fabricante")
public class FabricanteService {

	//http://localhost:8080/Drogaria/rest/fabricante
	@GET
	public String listar(){
		FabricanteDAO dao = new FabricanteDAO();
		List<Fabricante> fabricantes = dao.listar("descricao");
		
		Gson gson = new Gson();
		String json = gson.toJson(fabricantes);
		
		return json;
	}
	
	//http://localhost:8080/Drogaria/rest/fabricante/3 ou 4 ...
	@GET
	@Path("{codigo}")
	public String buscar(@PathParam("codigo")Long codigo){
		FabricanteDAO dao = new FabricanteDAO();
		
		Fabricante fabricante = dao.buscar(codigo);
		
		Gson gson = new Gson();
		String json = gson.toJson(fabricante);
		
		return json;
	}
	
	//http://localhost:8080/Drogaria/rest/fabricante
	@POST
	public String salvar(String json){
		
		Gson gson = new Gson();
		Fabricante fab = gson.fromJson(json, Fabricante.class);
		
		FabricanteDAO dao = new FabricanteDAO();
		dao.salvar(fab);
		
		String jsonSaida = gson.toJson(fab);
		return jsonSaida;
	}
	
	//http://localhost:8080/Drogaria/rest/fabricante
		@PUT
		public String editar(String json){
			
			Gson gson = new Gson();
			Fabricante fab = gson.fromJson(json, Fabricante.class);
			
			FabricanteDAO dao = new FabricanteDAO();
			dao.editar(fab);
			
			String jsonSaida = gson.toJson(fab);
			return jsonSaida;
		}
		
		
		//http://localhost:8080/Drogaria/rest/fabricante
		@DELETE
		public String excluir(String json){
			Gson gson = new Gson();
			Fabricante fabricante = gson.fromJson(json, Fabricante.class);
			
			FabricanteDAO dao = new FabricanteDAO();
			
			fabricante = dao.buscar(fabricante.getCodigo());
			
			dao.excluir(fabricante);
			
			String saida = gson.toJson(fabricante);
			return saida;
		}
		@DELETE
		@Path("{codigo}")
		public String excluir(@PathParam("codigo")Long codigo){
			
			FabricanteDAO dao = new FabricanteDAO();
			
			Fabricante fabricante = dao.buscar(codigo);
			dao.excluir(fabricante);
			
			Gson gson = new Gson();
			String json = gson.toJson(fabricante);
			
			return json;
		}
}
