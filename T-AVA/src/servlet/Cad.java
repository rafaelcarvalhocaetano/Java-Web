package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CadastroDAO;
import domain.Cadastro;

@WebServlet("/CrudCadastro")
public class Cad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Cad() {
		super();
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
				
				PrintWriter out = response.getWriter();
				
				out.println("Erro ao preencher os campos .... ");
			
			}else{
				
				CadastroDAO dao = new CadastroDAO();
				dao.salvar(cadastro);
				System.out.println("Cadastro realizado com sucesso ...");
			}
			RequestDispatcher rd = request.getRequestDispatcher("dados.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao cadastrar ...");
		}

		
	}

	
}
