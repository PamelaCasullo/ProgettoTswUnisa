package it.MadDiscord.Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.MadDiscord.Database.ShopDAO;
import it.MadDiscord.Model.ShopBean;
import it.MadDiscord.Model.ShopModelDM;

@WebServlet(urlPatterns = {"/ShopAdmin","/admin/ShopAdmin"})
public class ShopAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShopDAO sDAO = new ShopDAO();
	
	static ShopModelDM model = new ShopModelDM();
	
	
    public ShopAdminServlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sort = request.getParameter("sort");
		
		String action = request.getParameter("action");
		
		
		try {
		if(action!=null) {
			switch (action) {
			case "details": {
				String id = request.getParameter("id");
				request.removeAttribute("product");
				request.setAttribute("product", model.doRetrieveBy(id));
			}
			case "insert":{
				String name = request.getParameter("nome_oggetto");
				float price = Float.parseFloat(request.getParameter("prezzo"));
				
				UUID id = UUID.randomUUID();
				
				ShopBean bean = new ShopBean();
				bean.setId(id);
				bean.setNome_oggetto(name);
				bean.setPrezzo(price);
				
				model.doSave(bean);
				
				if(sDAO.insertShop(bean)!=0) {
				System.out.println("prodotto aggiunto con successo");

				}
				else System.out.println("prodotto non aggiunto con successo");

			}
			case "delete": {
					
				String id_prod =request.getParameter("id");

						
				ShopBean bean = model.doRetrieveById(id_prod);

				ShopBean sBean = new ShopBean();
				bean.getNome_oggetto();
			
					model.doDelete(sBean);	
					
					if(sDAO.deleteShop(bean)!=0) {
						System.out.println("prodotto eliminato");
					}
			}
				
			
			/*case "update": {
				String name = request.getParameter("nome_oggetto");
				int price = Integer.parseInt(request.getParameter("prezzo"));
				
				ShopBean bean= new ShopBean();
				bean.setNome_oggetto(name);
				bean.setPrezzo(price);
				System.out.println("prima della doUpdate");
				model.doUpdate(bean);	
				request.setAttribute("message", "Prodotto "+bean.getNome_oggetto()+" aggiornato");
			}*/
	
			}	
		
		}
	} catch (SQLException |ClassNotFoundException e) {
		System.out.println("Error: "+e.getMessage());
		request.setAttribute("error", e.getMessage());
	}
	
	
	try {
		request.removeAttribute("products");
		request.setAttribute("products", model.doRetrieveAll(sort));
		
	} catch (SQLException e) {
		System.out.println("Error: "+e.getMessage());
		request.setAttribute("error", e.getMessage());
	}


	RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/admin/gestioneShop.jsp");
	dispatcher.forward(request, response);


}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
