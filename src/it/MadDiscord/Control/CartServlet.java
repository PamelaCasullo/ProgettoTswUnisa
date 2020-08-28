package it.MadDiscord.Control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.MadDiscord.Model.Cart;
import it.MadDiscord.Model.ShopBean;
import it.MadDiscord.Model.ShopModelDM;





@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static ShopModelDM model = new ShopModelDM();
       
    public CartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		@SuppressWarnings("unchecked")
		Cart<ShopBean> cart = (Cart<ShopBean>) request.getSession().getAttribute("carrello");
		
		if(cart==null) {
			cart = new Cart<ShopBean>();
			request.getSession().setAttribute("carrello", cart);
		}
		
		String action = request.getParameter("action");
		
		try {
			if(action!=null) {
				if(action.equals("clearCart")) {
					cart.deleteItems();
					request.setAttribute("message", "Carrello ripulito");
					
				}
				else if(action.equals("deleteCart")) {
					String id=request.getParameter("id");
					ShopBean bean = model.doRetrieveBy(id);
					
					if(bean!=null && !bean.isEmpty()) {
						cart.deleteItem(bean);
						request.setAttribute("message", "Oggetto "+ bean.getNome_oggetto()+" rimosso dal carrello");
					}
				}
			}
		} catch (SQLException | NumberFormatException e) {
			System.out.println("Error: "+e.getMessage());
			request.setAttribute("error", e.getMessage());
		}
	}
	
	response.sendRedirect("carrello.jsp");

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
