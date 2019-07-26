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
        
        request.getSession().setAttribute("usuario", p);
        request.getSession().setAttribute("listaPersonas", perCtrl.getAll());
        System.out.println(p);
        request.getRequestDispatcher("WEB-INF/UserManagement.jsp").forward(request, response);
        
	}

}
