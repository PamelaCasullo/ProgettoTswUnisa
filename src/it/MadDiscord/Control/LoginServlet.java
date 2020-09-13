package it.MadDiscord.Control;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.MadDiscord.Database.UtenteDAO;
import it.MadDiscord.Model.UtenteBean;
import it.MadDiscord.Model.UtenteModelDM;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UtenteModelDM userModel = new UtenteModelDM(); 
	private UtenteDAO uDAO = new UtenteDAO();
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session= request.getSession(false);
		try {
			
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		String str = request.getParameter("password_utente");
		System.out.println(str);
		byte curr[] = md.digest(str.getBytes());
		byte user[] = uDAO.getUserPassword(request.getParameter("email"));
		
		if (Arrays.compare(curr, user) == 0) {
			UtenteBean uBean = userModel.doRetrieveBy(request.getParameter("email"));
			session.setAttribute("nome_utente", uBean);
			
			session.setAttribute("error-type", null); 
			session.setAttribute("error", null);
			session.setAttribute("error-location", null);
			response.sendRedirect("Homepage.jsp");
		} else {
			session.setAttribute("error-type", "wrongCred");
			session.setAttribute("error", "Password o email errate");
			session.setAttribute("error-location", "login");
			response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"login.jsp"));
		}	    
		
		}
		catch (SQLException|NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
			    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
