package action;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Alterações realizadas com sucesso");

		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		String celular = request.getParameter("celular");
		String endereco = request.getParameter("endereco");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String dataNascimento = request.getParameter("dataNascimento");
		
		Date data = null;
		try {
			data = new SimpleDateFormat("dd/MM/yyyy").parse(dataNascimento);
		} catch (ParseException e) {
			e.printStackTrace();
		}
			

		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setTelefone(telefone);
		contato.setCelular(celular);
		contato.setDataNascimento(data);
		contato.setEndereco(endereco);
		contato.setCidade(cidade);
		contato.setEstado(estado);

		
		try {
			
			AgendaDAO dao = new AgendaDAO();
			dao.inserir(contato);
			System.out.println("Salvo com sucesso, conexão sendo fechada ....");
		} catch (SQLException e) {
			System.out.println("Erro com a conexao no servlets");
			e.printStackTrace();
		}

	}

}
