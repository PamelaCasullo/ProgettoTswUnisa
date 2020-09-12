package it.MadDiscord.Control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.MadDiscord.Database.CartDAO;
import it.MadDiscord.Database.ProdDAO;
import it.MadDiscord.Model.CartBean;
import it.MadDiscord.Model.ProdBean;
import it.MadDiscord.Model.ShopBean;
import it.MadDiscord.Model.ShopModelDM;
import it.MadDiscord.Model.UtenteBean;

import java.util.ArrayList;
import java.util.UUID;


@WebServlet(urlPatterns = {"/Shop","/utente/Shop"})
public class ShopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static ShopModelDM model = new ShopModelDM();

    public ShopServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  HttpSession session = request.getSession(true);
		  String azione = request.getParameter("action");
		  if(session.getAttribute("utente") != null && azione != null) {
			  UtenteBean utente = (UtenteBean) session.getAttribute("utente");
			  CartDAO carrelloDAO = new CartDAO();
			  try {
				  CartBean carrello = (CartBean) carrelloDAO.doRetrieveBy(utente.getEmail());
				  ProdDAO prodottoDAO = new ProdDAO();
				  if(carrello != null && (azione != null && !azione.equals(""))) {
					  response.setContentType("application/json");
	                  response.setCharacterEncoding("UTF-8"); 
	                  switch (azione) {
	                  		case "aggiungi":
	                  			String idprodottoStr = request.getParameter("id_prodotto");
	                  			 if(idprodottoStr != null) {
	                                 UUID id_prodotto = UUID.fromString(idprodottoStr);
	                                 ProdBean prodottoDaAggiungere = prodottoDAO.doRetrieveBy(id_prodotto);
	                               carrelloDAO.addCarrello(carrello, prodottoDaAggiungere);
                                   response.setStatus(200);
	                  			} break;
	                  			
	                  		case "elimina":
	                  			idprodottoStr = request.getParameter("IDPRODOTTO");
	                  			if(idprodottoStr != null) {
	                                UUID id_prodotto = UUID.fromString(idprodottoStr);
	                                ProdBean prodottoDaRimuovere = prodottoDAO.doRetrieveBy(id_prodotto);
	                                carrelloDAO.removeCarrello(carrello, prodottoDaRimuovere);
	                                response.setStatus(200);
	                            }
	                            else response.setStatus(401);
	                            break;    	                  			
	                  
	                  }
	                  
	                  
	                  
	                  
				  }
			  }catch (SQLException e) {
				  request.setAttribute("error", e.toString());
	                e.printStackTrace();
	                response.setStatus(500);
			}
		  }
		
	

	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/utente/shop.jsp");
	dispatcher.forward(request, response);
	
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
