package it.MadDiscord.Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import it.MadDiscord.Database.LoginDAO;
import it.MadDiscord.Model.UtenteBean;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private LoginDAO loginDat;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public void init() {
		loginDat = new LoginDAO();
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password_utente = request.getParameter("password_utente");
		
		UtenteBean logBean = new UtenteBean();
		logBean.setEmail(email);
		logBean.setPassword_utente(password_utente);
		
		try {
			
			if(loginDat.validate(logBean) != null) {
				System.out.println("validate funzia");
				HttpSession session= request.getSession();
			    session.setAttribute("email", email);
			    
			    
			    String control = "admin@admin.com";
			    
			    
<<<<<<< HEAD
			    if(logBean.getNome_utente().equals(control)) {
=======
			    if(logBean.getEmail().contentEquals(control)) {
>>>>>>> parent of 3252c48... nonfunziona
			    	
			    	System.out.println("funziono admin");
			    	response.sendRedirect("index_administrator.jsp");

			    
			    } else {
			    	System.out.println("funziono user");
			    	response.sendRedirect("index_user.jsp");

			    }
				
				} else {
				String message = "Hai sbagliato qualcosa, riprova!";
				System.out.println(request.getParameter("email") + " "+ logBean.getEmail());
				request.setAttribute("message", message);
				System.out.println("ciao");
				response.sendRedirect("login.jsp");
			}
			

		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
