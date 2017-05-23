package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import br.com.agenda.factory.ConexaoFactory;
import br.com.agenda.model.Contato;

public class AgendaDAO {
	
	public void inserir(Contato contato) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO contato ");
		sql.append("(nome, telefone, celular, dataNascimento, endereco, cidade, estado) ");
		sql.append("VALUES (?, ?, ?, ?, ?, ?, ?) ");
		
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement ps = conexao.prepareStatement(sql.toString());
		
		ps.setString(1, contato.getNome());
		ps.setString(2, contato.getTelefone());
		ps.setString(3, contato.getCelular());		
		ps.setDate(4, new Date(contato.getDataNascimento().getTime()) );
		ps.setString(5, contato.getEndereco());
		ps.setString(6, contato.getCidade());
		ps.setString(7, contato.getEstado());
			
		ps.executeUpdate();
				
	}
	
	public List<Contato> listarDados(){
		
		List contatos = new ArrayList<Contato>();
		
		
		
		
		return contatos;
		
	}

}
