package br.com.drogaria.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Produto;

//http://127.0.0.1:8080/Drogaria/rest/produto

@Path("produto")
public class ProdutoService {
	
	@GET
	public String listar(){
		ProdutoDAO dao = new ProdutoDAO();
		List<Produto> produtos = dao.listar();
		
		Gson gson = new Gson();
		
		String json = gson.toJson(produtos);
		return json;
	}
	
	@POST
	public String salvar(String json){
		
		Gson gson = new Gson();
		Produto produto = gson.fromJson(json, Produto.class);
		
		ProdutoDAO dao = new ProdutoDAO();
		produto = dao.merge(produto);
		
		String saida = gson.toJson(produto);
		return saida;
		
	}

}
