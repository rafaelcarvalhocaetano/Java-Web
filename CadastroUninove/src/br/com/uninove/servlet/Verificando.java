package br.com.uninove.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.uninove.dao.CadastroDAO;
import br.com.uninove.domain.Cadastro;

@WebServlet("/Verificando")
public class Verificando extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Verificando() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String ra = request.getParameter("ra");
		String senha = request.getParameter("senha");

		try {
			CadastroDAO dao = new CadastroDAO();
			List<Cadastro> cadastros = dao.listar();
			
			Cadastro c = new Cadastro();
				
				if (ra == c.getRa() && senha == c.getSenha()) {

					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}
						
			

		} catch (SQLException e) {
			e.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
			rd.forward(request, response);
		}

	}
}
