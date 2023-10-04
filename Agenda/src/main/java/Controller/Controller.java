package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.DAO;
import Model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();

	public Controller() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			contatos(request, response);
		} else if (action.equals("/insert")) {
			criarContato(request, response);
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			deletarContato(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JavaBeans> lista = dao.listarContatos();
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}

	protected void criarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		contato.setNome(request.getParameter("nome"));
		contato.setTelefone(request.getParameter("telefone"));
		contato.setEmail(request.getParameter("email"));
		dao.criarContato(contato);
		response.sendRedirect("main");
	}

	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String contato_id = request.getParameter("contato_id");
		int numberr = Integer.parseInt(contato_id);
		contato.setContato_id(numberr);
		dao.selecionarContato(contato);
		request.setAttribute("contato_id", contato.getContato_id());
		request.setAttribute("nome", contato.getNome());
		request.setAttribute("telefone", contato.getTelefone());
		request.setAttribute("email", contato.getEmail());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String contato_id = request.getParameter("contato_id");
		int numberr = Integer.parseInt(contato_id);
		contato.setContato_id(numberr);
		contato.setNome(request.getParameter("nome"));
		contato.setTelefone(request.getParameter("telefone"));
		contato.setEmail(request.getParameter("email"));
		dao.alterarContato(contato);

		response.sendRedirect("main");

	}

	protected void deletarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String contato_id = request.getParameter("contato_id");
		int numberr = Integer.parseInt(contato_id);
		contato.setContato_id(numberr);
		dao.deletarrContato(contato);
		response.sendRedirect("main");
	}
}
