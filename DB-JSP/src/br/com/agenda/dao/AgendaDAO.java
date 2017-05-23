package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		
		List<Contato> contatos = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		try {
			
			sql.append("SELECT c.codigo, c.nome, c.telefone, c.celular, c.dataNascimento, c.endereco, c.cidade, c.estado ");
			sql.append("FROM Contato c ");
			
			Connection conexao = ConexaoFactory.conectar();
			
			PreparedStatement ps = conexao.prepareStatement(sql.toString());
			
			ResultSet resultado = ps.executeQuery();
			
			while(resultado.next()){
				
				Contato c = new Contato();
				
				c.setCodigo(resultado.getInt("c.codigo"));
				c.setNome(resultado.getString("c.nome"));
				c.setTelefone(resultado.getString("c.telefone"));
				c.setCelular(resultado.getString("c.celular"));
				c.setDataNascimento(resultado.getDate("c.dataNascimento"));
				c.setEndereco(resultado.getString("c.endereco"));
				c.setCidade(resultado.getString("c.cidade"));
				c.setEstado(resultado.getString("c.estado"));
				
				contatos.add(c);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao listar ....");
		}
		
		
		return contatos;
		
	}

}
