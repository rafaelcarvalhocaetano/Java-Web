package br.com.drogaria.bean;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ProdutoBean implements Serializable {

	private Produto produto;
	private List<Produto> produtos;
	private List<Fabricante> fabricantes;

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Produto getProduto() {
		return produto;
	}

	@PostConstruct
	public void listar() {
		try {
			ProdutoDAO dao = new ProdutoDAO();

			produtos = dao.listar();

		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao listar a mensagem");
		}
	}

	@PostConstruct
	public void novo() {

		try {

			produto = new Produto();

			FabricanteDAO dao = new FabricanteDAO();
			fabricantes = dao.listar();

			Messages.addGlobalInfo("Produto Salvo com sucesso");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao criar novo produto");
			e.printStackTrace();
		}

	}

	public void salvar() {
		try {
			
			if(produto.getCaminho() == null){
				Messages.addGlobalError("O campo foto é obrigatório");
				return;
			}
			
			ProdutoDAO dao = new ProdutoDAO();
			Produto produtoRetorno = dao.merge(produto);

			Path origem = Paths.get(produto.getCaminho());
			Path destino = Paths.get("C:/javaFotos/" + produtoRetorno.getCodigo() + ".png");
			Files.copy(origem, destino, StandardCopyOption.REPLACE_EXISTING);

			produto = new Produto();

			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();

			produtos = dao.listar();

			Messages.addGlobalInfo("Produto salvo com sucesso");
		} catch (RuntimeException | IOException e) {
			Messages.addGlobalError("Erro ao tentar salvar o produto");
			e.printStackTrace();
		}

	}

	public void editar(ActionEvent event) {
		try {
			produto = (Produto) event.getComponent().getAttributes().get("produtoSelecionado");
			produto.setCaminho("C:/javaFotos/" + produto.getCodigo() + ".png");

			FabricanteDAO dao = new FabricanteDAO();
			fabricantes = dao.listar();

		} catch (RuntimeException e) {
			Messages.addGlobalError("Erro ao tentar editar o produto");
		}
	}

	public void excluir(ActionEvent e) {

		try {

			produto = (Produto) e.getComponent().getAttributes().get("produtoSelecionado");

			ProdutoDAO dao = new ProdutoDAO();
			dao.excluir(produto);
			
			Path caminhoArquivo = Paths.get("C:/javaFotos/" + produto.getCodigo()+" .png ");
			
			Files.deleteIfExists(caminhoArquivo); //precisa do IOException

			produtos = dao.listar();

		} catch (RuntimeException | IOException e2) {
			Messages.addGlobalError("Erro ao tentar excluir o produto");
			e2.printStackTrace();
		}

	}

	public void upload(FileUploadEvent event) {
		/*
		 * String nome = event.getFile().getFileName(); String tipo =
		 * event.getFile().getContentType(); long tamanho =
		 * event.getFile().getSize();
		 * 
		 * Messages.addGlobalInfo("Nome: "+nome+" Tipo: "+tipo+" Tamanho: "
		 * +tamanho);
		 */
		// Usando o local do OS para salvar as fotos...
		try {
			UploadedFile arquivoUpload = event.getFile();
			Path arquivoTemp = Files.createTempFile(null, null);
			Files.copy(arquivoUpload.getInputstream(), arquivoTemp, StandardCopyOption.REPLACE_EXISTING);
			
			produto.setCaminho(arquivoTemp.toString());
			
			Messages.addGlobalInfo("Foto Salva com sucesso");
		} catch (IOException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o arquivo");
			e.printStackTrace();
		}
	}

}
