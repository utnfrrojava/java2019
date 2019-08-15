package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.*;
import logic.*;

/**
 * Servlet implementation class Signin
 */
@WebServlet({ "/Signin", "/signin", "/signIn", "/SignIn", "/SIGNIN" })
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Signin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Login ctrl=new Login();
		PersonaControler perCtrl= new PersonaControler();
		String email=request.getParameter("email");
        String password=request.getParameter("password");
        System.out.println(email+"|"+password);
        
        Persona p = new Persona();
        
        p.setEmail(email);
        p.setPassword(password);
        
        p = ctrl.validate(p);
        
        /* La información para utilizar en otro jsp puede almacenarse en la
         * sessión o en la propia request y utilizar forward.
         * En sessión debe evitarse almacenar información excesiva debido a
         * que se mantiene en memoria a través de todos los request hasta que
         * termina la sesión. Adicionalmente si se va a utilizar la información
         * en la siguiente página y no debe mantenerse es mejor almacenarla
         * en la request
         */
        request.getSession().setAttribute("usuario", p); // esto es correcto
        //request.getSession().setAttribute("listaPersonas", perCtrl.getAll()); //esto sería incorrecto
        request.setAttribute("listaPersonas", perCtrl.getAll()); //esto es correcto
        
        System.out.println(p);
        request.getRequestDispatcher("WEB-INF/UserManagement.jsp").forward(request, response);
        
	}

}
