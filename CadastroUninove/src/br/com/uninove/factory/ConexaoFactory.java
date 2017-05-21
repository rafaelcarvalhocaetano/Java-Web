package br.com.uninove.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {
		
	private static final String USUARIO = "root";
	private static final String URL = "dbc:mysql://localhost:3306/cadastrouninove";
	private static final String SENHA = "q1w2e3r4";
	
	public static Connection conectar() throws SQLException{
		try {
			
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
						
		} catch (Exception e) {
			System.out.println("Erro de conexão");
		}
		Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
		
		return connection;
	}
	
	
}
