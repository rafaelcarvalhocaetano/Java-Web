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

@WebServlet("/CrudCadastro")
public class CrudCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CrudCadastro() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
				

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");
		String ra = request.getParameter("ra");

		Cadastro cadastro = new Cadastro();

		cadastro.setNome(nome);
		cadastro.setSenha(senha);
		cadastro.setRa(ra);
		cadastro.setEmail(email);

		try {
						
			if(nome == "" || senha == "" || ra == "" || email == ""){
				System.out.println("Erro ....");
				
				RequestDispatcher rd = request.getRequestDispatcher("erro.jsp");
				rd.forward(request, response);
			
			}else{
				
				CadastroDAO dao = new CadastroDAO();
				dao.salvar(cadastro);
				System.out.println("Cadastro realizado com sucesso ...");
			}
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao cadastrar ...");
		}

		
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
