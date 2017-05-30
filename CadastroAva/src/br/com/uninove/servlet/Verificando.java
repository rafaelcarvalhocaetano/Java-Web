package br.com.uninove.servlet;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import br.com.uninove.factory.ConexaoFactory;


@WebServlet("/Verificando")
public class Verificando extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Verificando() {
		super();
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			
					
			String rah = request.getParameter("ra");
			String senhah = request.getParameter("senha");
			
			request.getSession().setAttribute("rah", rah );
			
			
			try {
				
				if(rah != null && senhah != null){
					
					Connection conexao = ConexaoFactory.conectar();
					String sql = "SELECT * FROM cadastro WHERE ra=? AND senha=?";
					PreparedStatement ps = conexao.prepareStatement(sql);
					
					ps.setString(1, rah);
					ps.setString(2, senhah);
					
					ResultSet rs = ps.executeQuery();
					
					if(rs.next()){
						
						response.sendRedirect("ambiente.jsp");
					}else{
						response.sendRedirect("login.jsp");
						System.out.println("voltou.....");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("erro de DB");
			}
			
	}
}
