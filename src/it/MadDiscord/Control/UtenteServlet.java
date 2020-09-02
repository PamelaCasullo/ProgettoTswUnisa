package it.MadDiscord.Control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.MadDiscord.Model.UtenteBean;


@WebServlet("/UtenteServlet")
public class UtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static UtenteModelDM model = new UtenteModelDM();
	
    public UtenteServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sort = request.getParameter("sort");
		
		String action = request.getParameter("action");

			try {
				if(action != null) {
					switch (action) {
					
					case "insertUser": {
						try {
							String nome_utente = request.getParameter("nome_utente");
							String password_utente = request.getParameter("password_utente");
							String email = request.getParameter("email");
							
							UtenteBean uBean = new UtenteBean();
							
							uBean.setNome_utente(nome_utente);
							uBean.setPassword_utente(password_utente);
							
							model.doSave(uBean);
							request.setAttribute("message", "Utente"+uBean.getNome_utente()+"salvato");
							
						} catch (SQLException e) {
							System.out.println(e);
						}
					}
					
					case "updateUser": {
						try {
							String nome_utente = request.getParameter("nome_utente");
							String password_utente = request.getParameter("password_utente");
							String email = request.getParameter("email");
							
							UtenteBean uBean = new UtenteBean();
							
							uBean.setNome_utente(nome_utente);
							uBean.setPassword_utente(password_utente);
							uBean.setEmail(email);
							
							model.doUpdate(uBean);
							request.setAttribute("message", "Utente"+uBean.getNome_utente()+"aggiornato");
						} catch (SQLException e) {
							System.out.println(e);
						}
					}
					
					case "delteUser": {
						try {
							String nome_utente = request.getParameter("nome_utente");
							
							UtenteBean uBean = model.doRetrieveBy(nome_utente);
							
							model.doDelete(uBean);
							request.setAttribute("message", "Utente"+uBean.getNome_utente()+"rimosso");
						} catch (SQLException e) {
							System.out.println(e);
						}
					}
					
					case "getUtente": {
						String nome_utente = request.getParameter("nome_utente");
						
						request.removeAttribute("user");
						try {
							request.setAttribute("user", model.doRetrieveBy(nome_utente));
						} catch (SQLException e) {
							System.out.println(e);
						}
					}
					
					//   	COME SI FA ??????????
	//				case "allUtente": {
	//					ArrayList<UtenteBean> users = request.getParameterNames("nome_utente");
	//					
	//					request.removeAttribute("user");
	//					try {
	//						request.setAttribute("user", model.doRetrieveAll(sort));
	//					} catch (SQLException e) {
	//						System.out.println(e);
	//					}
	//				}
					}
				}
			} catch (NumberFormatException e) {
				System.out.println("Error: "+e.getMessage());
				request.setAttribute("error", e.getMessage());
			}
			
			try {
				request.removeAttribute("users");
				request.setAttribute("users", model.doRetrieveAll(sort));
			} catch (SQLException e) {
				System.out.println("Error: "+e.getMessage());
				request.setAttribute("error", e.getMessage());
			}
		
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/gestioneUtenti.jsp");
			dispatcher.forward(request, response);
		
				
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
