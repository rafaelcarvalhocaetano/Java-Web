package action;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.agenda.dao.AgendaDAO;
import br.com.agenda.model.Contato;


@WebServlet(asyncSupported = true, urlPatterns = { "/InserirContato" })
public class InserirContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InserirContato() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Alterações realizadas com sucesso");
		
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String data = request.getParameter("dataNascimento");
		String endereco = request.getParameter("endereco");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		
		
		Contato contato = new Contato();
		AgendaDAO dao = new AgendaDAO();
		
		dao.inserir(contato);
		
	}

}
