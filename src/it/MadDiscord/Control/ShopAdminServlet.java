package it.MadDiscord.Control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.UUID;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.MadDiscord.Model.ShopBean;
import it.MadDiscord.Model.ShopModelDM;

@WebServlet(urlPatterns = {"/ShopAdmin","/admin/ShopAdmin"})
public class ShopAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	static ShopModelDM model = new ShopModelDM();
	
	
    public ShopAdminServlet() {
        super();

    }

	
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sort = request.getParameter("sort");
		
		String action = request.getParameter("action");
		
		try {
		if(action!=null) {
			if(action.equals("details")) {
				String id = request.getParameter("id");
				request.removeAttribute("product");
				request.setAttribute("product", model.doRetrieveBy(id));
			}
			if(action.equals("insert")) {
					String name = request.getParameter("nome_oggetto");
					float price = Float.parseFloat(request.getParameter("prezzo"));
					int quantity = Integer.parseInt(request.getParameter("quant"));
					
					ShopBean bean = new ShopBean();
					bean.setNome_oggetto(name);
					bean.setPrezzo(price);
					bean.setQuant(quantity);
					
					model.doSave(bean);
					request.setAttribute("message", "Prodotto"+bean.getNome_oggetto()+"salvato");
				}
				else if(action.equals("delete")) {
					String id = request.getParameter("nome_utente");
					ShopBean bean = model.doRetrieveBy(id);
					
					if(bean!=null && !((Collection<ShopBean>) bean).isEmpty()) {
						model.doDelete(bean);	
						request.setAttribute("message", "Prodotto "+bean.getNome_oggetto()+" rimosso con successo");
					}
				} else if(action.equals("update")) {
					UUID id = UUID.fromString(request.getParameter("id"));
					String name = request.getParameter("nome_oggetto");
					int price = Integer.parseInt(request.getParameter("prezzo"));
					int quantity = Integer.parseInt(request.getParameter("quant"));
					
					ShopBean bean= new ShopBean();
					bean.setId(id);
					bean.setNome_oggetto(name);
					bean.setPrezzo(price);
					bean.setQuant(quantity);
					System.out.println("prima della doUpdate");
					model.doUpdate(bean);	
					request.setAttribute("message", "Prodotto "+bean.getNome_oggetto()+" aggiornato");
				}
		}
		
	} catch (SQLException | NumberFormatException e) {
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

	response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+"/admin/gestioneShop.jsp"));


}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
