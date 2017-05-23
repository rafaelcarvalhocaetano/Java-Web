package br.com.agenda.dao;

import java.util.List;

import br.com.agenda.model.Contato;

public class AgendaDAO {
	
	public void inserir(Contato contato){
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO contato ");
		sql.append("(nome, telefone, celular, dataNascimento, endereco, cidade, estado) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?) ");
		
	}
	
	public List<Contato> listarDados(){
		return null;
		
	}

}
