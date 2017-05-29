package br.com.drogaria.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

import org.omnifaces.util.Messages;

import com.google.gson.Gson;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable {
	
	private List<Fabricante> fabricantes;
	
	private Fabricante fabricante;
	
	
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	public void novo(){
		fabricante = new Fabricante();
	}
	
	@PostConstruct
	public void listar(){
		try {
			//FabricanteDAO dao = new FabricanteDAO();
			//fabricantes = dao.listar();
			
			Client cliente = ClientBuilder.newClient();
			WebTarget caminho = cliente.target("http://localhost:8080/Drogaria/rest/fabricante");
			String json = caminho.request().get(String.class);
			
			Gson gson = new Gson();
			Fabricante[] vetor = gson.fromJson(json, Fabricante[].class);
			
			fabricantes = Arrays.asList(vetor);
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Fabricante não encontrado");
			e.printStackTrace();
		}
	}
	
	public void salvar(){
		
		try {
			
			//FabricanteDAO dao = new FabricanteDAO();
			//dao.salvar(fabricante);
			
			//fabricante = new Fabricante();
			//fabricantes = dao.listar();
			
			Client cliente = ClientBuilder.newClient();
			WebTarget caminho = cliente.target("http://localhost:8080/Drogaria/rest/fabricante");
			
			Gson gson = new Gson();
			String jsonFalso = gson.toJson(fabricante);
			caminho.request().post(Entity.json(jsonFalso));
			
			fabricante = new Fabricante();
			
			String json = caminho.request().get(String.class);
			Fabricante[] vetor = gson.fromJson(json, Fabricante[].class);
			fabricantes = Arrays.asList(vetor);
			
			Messages.addGlobalInfo("Fabricante salvo com sucesso");
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao salvar o fabricante");
			e.printStackTrace();
		}
	}
	
	//passar para restfull
	public void excluir(ActionEvent event){
		try {
			fabricante =(Fabricante) event.getComponent().getAttributes().get("fabricanteSelecionado");
			
			Client cliente = ClientBuilder.newClient();
			
			WebTarget caminho = cliente.target("htpp:127.0.0.1:8080/Drogaria/rest/fabricnate");
			WebTarget caminhoExcluir = caminho.path("{codigo}").resolveTemplate("codigo", fabricante.getCodigo());
			
			caminhoExcluir.request().delete();
			String json = caminho.request().get(String.class);
			
			Gson gson = new Gson();
			Fabricante[] vetor = gson.fromJson(json, Fabricante[].class);
			
			fabricantes = Arrays.asList(vetor);
			
			Messages.addGlobalInfo("Fabricante Excluído com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao excluir o fabricante");
			e.printStackTrace();
		}
		
	}
	public void editar(ActionEvent event){
		try {
			fabricante = (Fabricante) event.getComponent().getAttributes().get("fabricanteSelecionado");
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao editar");
			e.printStackTrace();
		}
	}

}
