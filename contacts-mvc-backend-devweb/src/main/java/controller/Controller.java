package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/cad", "/login", "/lixeira", "/lixeiraP", "/restaurar", "/deletedef", "/delall"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	JavaBeans contato = new JavaBeans();

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/main")) {
			contatos(request, response);
		}else if(action.equals("/insert")) {
			novoContato(request, response);
		}else if(action.equals("/select")) {
			listarContato(request, response);
		}else if(action.equals("/update")) {
			editarContato(request, response);
		}else if(action.equals("/cad")) {
			cadUsuario(request, response);
		}else if(action.equals("/login")) {
			loginUsuario(request, response);
		}else if(action.equals("/lixeira")) {
			lixeiraUsuario(request, response);
		}else if(action.equals("/lixeiraP")) {
			lixeiraPage(request, response);
		}else if(action.equals("/restaurar")) {
			lixeiraRestaurar(request, response);
		}else if(action.equals("/deletedef")) {
			deletarDef(request, response);
		}else if(action.equals("/delall")) {
			deletarAll(request, response);
		}else {
			response.sendRedirect("index.html");
		}
	}

	protected void contatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<JavaBeans> lista = dao.arrayC(contato);
		
		for (int i = 0; i<lista.size(); i++) {
			System.out.println(lista.get(i).getIdcontatos_ctt());
			System.out.println(lista.get(i).getNome_ctt());
			System.out.println(lista.get(i).getFone_ctt());
			System.out.println(lista.get(i).getEmail_ctt());
		}
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
		
	}
	
	protected void novoContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("fone"));
		System.out.println(request.getParameter("email"));
		
		contato.setNome_ctt(request.getParameter("nome"));
		contato.setFone_ctt(request.getParameter("fone"));
		contato.setEmail_ctt(request.getParameter("email"));
		
		dao.insertC(contato);
		
		response.sendRedirect("main");
	}
	
	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idcon = Integer.parseInt(request.getParameter("idcon"));
		contato.setIdcontatos_ctt(idcon);
		
		dao.selectC(contato);
		
		System.out.println(contato.getIdcontatos_ctt());
		System.out.println(contato.getNome_ctt());
		
		
		request.setAttribute("idcon", contato.getIdcontatos_ctt());
		request.setAttribute("nome", contato.getNome_ctt());
		request.setAttribute("fone", contato.getFone_ctt());
		request.setAttribute("email", contato.getEmail_ctt());
		
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}
	
	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		contato.setIdcontatos_ctt(Integer.parseInt(request.getParameter("idcon")));
		contato.setNome_ctt(request.getParameter("nome"));
		contato.setFone_ctt(request.getParameter("fone"));
		contato.setEmail_ctt(request.getParameter("email"));
		
		dao.updateC(contato);
		
		response.sendRedirect("main");
		//
	}
	protected void cadUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("senha"));
		
		contato.setNome_usr(request.getParameter("nome"));
		contato.setEmail_usr(request.getParameter("email"));
		contato.setSenha_usr(request.getParameter("senha"));
		boolean booal = dao.verifC(contato);
		
		if(booal == false) {
			dao.insertU(contato);
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Cadastro realizado!');");
			out.println("window.location.href='index.html';");  
			out.println("</script>");
		}else{
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Email de usuario já cadastrado, utilize outro!');");
			out.println("window.location.href='cadastro.html';");  
			out.println("</script>");
		}		
	}
	protected void loginUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		contato.setEmail_usr(request.getParameter("email"));
		contato.setSenha_usr(request.getParameter("senha"));
		boolean booal = dao.verifC_Login(contato);
		
		if(booal == true) {
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Login realizado!');");
			out.println("</script>");
			response.sendRedirect("main");
		}else{
			PrintWriter out = response.getWriter();  
			response.setContentType("text/html");  
			out.println("<script type=\"text/javascript\">");  
			out.println("alert('Usuário não encontrado!');");
			out.println("window.location.href='index.html';");  
			out.println("</script>");
		}		
		
	}
	protected void lixeiraUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idcon = Integer.parseInt(request.getParameter("idcon"));
		contato.setIdcontatos_ctt(idcon);
		dao.lixeiraC(contato);
		dao.deleteC(contato);
		response.sendRedirect("main");
	}
	protected void lixeiraPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JavaBeans> lista = dao.arrayLixeiraC(contato);

		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getIdcontatos_ctt());
			System.out.println(lista.get(i).getNome_ctt());
			System.out.println(lista.get(i).getFone_ctt());
			System.out.println(lista.get(i).getEmail_ctt());
		}
		request.setAttribute("contatos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("lixeira.jsp");
		rd.forward(request, response);
	}
	protected void lixeiraRestaurar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idcon = Integer.parseInt(request.getParameter("idcon"));
		
		contato.setIdcontatos_ctt(idcon);
		dao.lixeiraRest(contato);
		dao.deleteLixeira(contato);
		response.sendRedirect("lixeiraP");
	}
	protected void deletarDef(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idcon = Integer.parseInt(request.getParameter("idcon"));
		contato.setIdcontatos_ctt(idcon);
		dao.deleteLixeira(contato);
		response.sendRedirect("lixeiraP");
	}
	protected void deletarAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dao.deleteAll();
		response.sendRedirect("lixeiraP");
	}
}

