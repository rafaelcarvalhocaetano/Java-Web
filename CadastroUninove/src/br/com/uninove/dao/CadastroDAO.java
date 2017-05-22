package br.com.uninove.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.uninove.domain.Cadastro;
import br.com.uninove.factory.ConexaoFactory;

public class CadastroDAO {
	
	//salvar, editar, excluir, buscar,
	
	public void buscar(){
		
		
		
	}
	public void salvar(Cadastro cad) throws SQLException{
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO cadastro ");
		sql.append("(nome, ra, senha) ");
		sql.append("VALUES (?, ?, ?) ");
			
		Connection conexao = ConexaoFactory.conectar();
		
		PreparedStatement ps = conexao.prepareStatement(sql.toString());
		
		ps.setString(1, cad.getNome());
		ps.setString(2, cad.getRa());
		ps.setString(3, cad.getSenha());
		
		ps.executeUpdate();
		
	}
	
}
