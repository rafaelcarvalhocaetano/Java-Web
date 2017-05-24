package br.com.uninove.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
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
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String ra = new String("");
		String senha = new String("");
		response.setContentType("text/html");
		try {
			Connection conexao = ConexaoFactory.conectar();

			String sql = "select ra,senha from cadastro";

			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet resultSet = ps.executeQuery();

			while (resultSet.next()) {

				ra = resultSet.getString("ra");
				senha = resultSet.getString("senha");
			}
			resultSet.close();
			resultSet.close();
		} catch (Exception e) {
			System.out.println("Exception is ;" + e);
		}
		if (ra.equals(request.getParameter("ra")) && senha.equals(request.getParameter("senha"))) {

			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);

		} else {
			
			RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
			rd.forward(request, response);

		}
	}

}
