package it.MadDiscord.Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.MadDiscord.Model.ShopModelDM;


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
		if(action!=null) {
			switch (action) {
			case "delete": {
				String nome_utente = request.getParameter("nome_utente");
				UtenteBean uBean = 
			
			}
			
		}}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
