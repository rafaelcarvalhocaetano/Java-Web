package br.com.drogaria.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.StreamedContent;

@ManagedBean
@RequestScoped
public class ImagemBean {
	
	private String caminho;
	private StreamedContent foto;
	
	public String getCaminho() {
		return caminho;
	}
	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}
	public StreamedContent getFoto() {
		return foto;
	}
	public void setFoto(StreamedContent foto) {
		this.foto = foto;
	}
	
	

}
