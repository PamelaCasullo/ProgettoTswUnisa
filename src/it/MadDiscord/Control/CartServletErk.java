package it.MadDiscord.Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.MadDiscord.Database.CartDAO;
import it.MadDiscord.Model.Cart;
import it.MadDiscord.Model.ShopBean;
import it.MadDiscord.Model.ShopModelDM;
import it.MadDiscord.Model.UtenteBean;

@WebServlet("/CartServletErk")
public class CartServletErk extends HttpServlet { 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static ShopModelDM model = new ShopModelDM();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		@SuppressWarnings("unchecked")
		Cart<ShopBean> cart = (Cart<ShopBean>) request.getSession().getAttribute("cart");

		HttpSession session = request.getSession(true);
		String action = request.getParameter("action");
		if(session.getAttribute("user") != null && action != null) {
			UtenteBean user = (UtenteBean) session.getAttribute("user");
			CartDAO cartDAO = new CartDAO();

			if(cart != null && (action != null && !action.equals(""))) {
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");
				switch (action) {
					case "delete": {
						String id=request.getParameter("id");
						ShopBean bean;
						try {
							bean = model.doRetrieveBy(id);
							if(bean!=null && !bean.isEmpty()) {
								cart.deleteItem(bean);
								request.setAttribute("message", "Oggetto "+ bean.getNome_oggetto()+" rimosso dal carrello");
							}
						} catch (SQLException e) {
								
							System.out.println(e);
						}
					}
						
					case "clear": {
						cart.deleteItems();
						request.setAttribute("message", "Carrello ripulito");
					}
							
				}
			}
		} 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
