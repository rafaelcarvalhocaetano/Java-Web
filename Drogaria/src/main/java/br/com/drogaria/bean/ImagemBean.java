package br.com.drogaria.bean;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.StreamedContent;

@ManagedBean
@RequestScoped
public class ImagemBean {
	
	@ManagedProperty("#{param.caminho}")
	private String caminho;
	private StreamedContent foto;
	
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	public StreamedContent getFoto() {
		
		if(caminho == null || caminho.isEmpty()){
			Path foto = Paths.get("C:/javaFotos/code.png");
			InputStream fluxo = Files.newInputStream(foto);
		}
		
		return foto;
	}
	public void setFoto(StreamedContent foto) {
		this.foto = foto;
	}
	
	

}
