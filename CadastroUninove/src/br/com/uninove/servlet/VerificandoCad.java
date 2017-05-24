package br.com.uninove.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.uninove.dao.CadastroDAO;
import br.com.uninove.domain.Cadastro;

@WebServlet("/VerificandoCad")
public class VerificandoCad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VerificandoCad() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String ra = request.getParameter("cSenha");
		String senha = request.getParameter("registro");
				
		try {
			
			CadastroDAO dao = new CadastroDAO();
			dao.logar(ra, senha);
			
			System.out.println("login realizado com sucesso ...");
			
			RequestDispatcher redirect = request.getRequestDispatcher("ambiente.jsp");
			redirect.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("erro de verificação ...");
			
			RequestDispatcher redirect = request.getRequestDispatcher("erro.jsp");
			redirect.forward(request, response);
		}

	}

}
