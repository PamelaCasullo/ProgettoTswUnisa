package it.MadDiscord.Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.MadDiscord.Database.SigninDAO;
import it.MadDiscord.Model.UtenteBean;

/**
 * Servlet implementation class SigninServlet
 */
@WebServlet("/Signin")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private SigninDAO sigDat = new SigninDAO();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher disp = request.getRequestDispatcher("index.html");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome_utente = request.getParameter("nome_utente");
		String password_utente = request.getParameter("password_utente");
		
		
		UtenteBean sigBean = new UtenteBean();
		sigBean.setNome_utente(nome_utente);
		sigBean.setPassword_utente(password_utente);
		
		try {
			sigDat.registerUser(sigBean);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		RequestDispatcher disp = request.getRequestDispatcher("signup.jsp");
		disp.forward(request, response);
	}

}
