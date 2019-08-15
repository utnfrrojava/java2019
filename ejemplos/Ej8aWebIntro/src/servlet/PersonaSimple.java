package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Persona;
import logic.PersonaControler;

/**
 * Servlet implementation class PersonaSimple
 */
@WebServlet({ "/PersonaSimple/*", "/personaSimple/*", "/personasimple/*", "/PERSONASIMPLE/*", "/persona-simple/*" })
public class PersonaSimple extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PersonaControler ctrlCrudPersona;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonaSimple() {
        super();
        ctrlCrudPersona=new PersonaControler();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Persona per= new Persona();
		per.setId(Integer.parseInt(request.getParameter("id")));
		switch (request.getPathInfo()) {
		case "/edit":
			forwardToUserCrud(ctrlCrudPersona.getById(per), "edit", request, response);
			break;
		case "/delete":
			ctrlCrudPersona.delete(per);
			request.setAttribute("listaPersonas", ctrlCrudPersona.getAll());
			RequestDispatcher rd= request.getRequestDispatcher("WEB-INF/UserManagement.jsp");
			
			request.getRequestDispatcher("/WEB-INF/UserManagement.jsp").forward(request, response);
			break;
		default:
			//redirigir a página de error
			break;
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Persona per= new Persona();
		String action="";
		switch (request.getPathInfo()) {
		case "/search":
			per.setEmail(request.getParameter("email"));
			per=ctrlCrudPersona.getByUser(per);
			action="search";
			
			break;
		case "/new":
			action="new";
			break;
		default:
			System.out.println("redirigir a página de error");
			break;
		}
		forwardToUserCrud(per,action,request,response);
		System.out.println("post: "+request.getPathInfo());
	}
	
	protected void forwardToUserCrud(Persona per, String action, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("person", per);
		request.setAttribute("action", action);
		request.getRequestDispatcher("/UserCrud.jsp").forward(request, response);
		//response.sendRedirect(request.getContextPath()+"/UserCrud.jsp");
	}

}
