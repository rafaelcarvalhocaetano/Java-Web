package br.com.uninove.servlet;

import java.io.IOException;
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

		String senha = request.getParameter("senha");
		String ra = request.getParameter("ra");

		if(senha == "" || ra == ""){
			RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
			rd.forward(request, response);
		}else{
			try{
				CadastroDAO dao = new CadastroDAO();
				List<Cadastro> cads = dao.listar();
				
				if(cads == null){
					System.out.println("Erro no retorno ....");
				}else{
					RequestDispatcher rd = request.getRequestDispatcher("ambiente.jsp");
					rd.forward(request, response);
				}
			}catch (Exception e) {
				RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
				rd.forward(request, response);
			}
			
		}

		
	}
}
