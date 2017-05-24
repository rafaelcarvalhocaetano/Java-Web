package br.com.uninove.bean;

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			
			if(ra == "" && senha == ""){
				System.out.println("Erro Encontrado ....");
				RequestDispatcher red = request.getRequestDispatcher("erro.jsp");
				red.forward(request, response);
			}else{
				
				CadastroDAO dao = new CadastroDAO();
				dao.verificandoUsuario();
				System.out.println("login realizado com sucesso ...");	
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao acessar ...");
		}
		RequestDispatcher redirect = request.getRequestDispatcher("ambiente.jsp");
		redirect.forward(request, response);
	}
	

}
