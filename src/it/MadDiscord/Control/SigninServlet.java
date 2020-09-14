package it.MadDiscord.Control;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.MadDiscord.Database.UtenteDAO;
import it.MadDiscord.Model.UtenteBean;
import it.MadDiscord.Model.UtenteModelDM;
import it.MadDiscord.Model.UtenteBean.Tipo;

/**
 * Servlet implementation class SigninServlet
 */
@WebServlet("/Signin")
public class SigninServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UtenteModelDM userModel = new UtenteModelDM(); 
	private UtenteDAO uDAO = new UtenteDAO();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher disp = request.getRequestDispatcher("Homepage.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String regMail="^(([^<>()\\[\\]\\\\.,;:\\s@\"]+(\\.[^<>()\\[\\]\\\\.,;:\\s@\"]+)*)|(\".+\"))@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		String regPsw="^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$";
		
		try (ByteArrayOutputStream bos = new ByteArrayOutputStream()){
			
			HttpSession session=request.getSession();
			
			//errori
			session.setAttribute("error-type", null); 
			session.setAttribute("error", null); 
			session.setAttribute("error-location", null);
			
			
			if (userModel.doRetrieveBy(request.getParameter("email")) != null) {
				System.out.println("Mail non valida");
				session.setAttribute("error-type", "email");
				session.setAttribute("error", "Questa mail è già stata utilizzata, scegline un'altra");
				session.setAttribute("error-location", "signup");
				response.sendRedirect(request.getContextPath()+"/login.jsp");
				return;
			}
			
			else 
				if (userModel.doRetrieveBy(request.getParameter("nome_utente")) != null) {
					System.out.println("guarda che sto user è stato usato");
					session.setAttribute("error-type", "nome_utente");
					session.setAttribute("error", "Questo username è stato utilizzato");
					session.setAttribute("error-location", "signup");
					response.sendRedirect(request.getContextPath()+"/signup.jsp");
					return;
				}
				else if(!request.getParameter("email").matches(regMail)) {
					System.out.println("mi fermo alla mail");
					session.setAttribute("error-type", "email");
					session.setAttribute("error", "La mail non è scritta correttamente");
					session.setAttribute("error-location", "signup");
					response.sendRedirect(request.getContextPath()+"/signup.jsp");
				}
				else if(!request.getParameter("password_utente").matches(regPsw)) {
					System.out.println("mi fermo alla psw");
					session.setAttribute("error-type", "password_utente");
					session.setAttribute("error", "Deve essere almeno 8 caratteri con almeno:un carattere speciale,un lowercase,un UPPERCASE e un numero ");
					session.setAttribute("error-location", "signup");
					response.sendRedirect(request.getContextPath()+"/signup.jsp");
				}
				else {
					String email = request.getParameter("email");
					String nome_utente = request.getParameter("nome_utente");
					String password_utente = request.getParameter("password_utente");
					
					
					
					UtenteBean sigBean = new UtenteBean();
					sigBean.setEmail(email);
					sigBean.setNome_utente(nome_utente);
					sigBean.setPassword_utente(password_utente);
					sigBean.setTipo(Tipo.utente);
					userModel.doSave(sigBean);
					
					if(uDAO.insertUser(sigBean)!=0) {
						System.out.println("account creato con successo!");
						RequestDispatcher disp = request.getRequestDispatcher("login.jsp");
						disp.forward(request, response);
					}
					else {
						System.out.println("account esistente");
						RequestDispatcher disp = request.getRequestDispatcher("Homepage.jsp");
						disp.forward(request, response);
					}
					
					
					
				}
	
			
		} catch (IOException|SQLException e) {
			e.printStackTrace();
		}

	}

}
