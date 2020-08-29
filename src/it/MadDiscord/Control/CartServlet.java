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
		Cart<ShopBean> cart = (Cart<ShopBean>) request.getSession().getAttribute("cart");
		
		if(cart==null) {
			cart = new Cart<ShopBean>();
			request.getSession().setAttribute("cart", cart);
		}
		
		String action = request.getParameter("action");
			if(action!=null) {
			switch (action) {
		
			case "clearCart": {
				cart.deleteItems();
				request.setAttribute("message", "Carrello ripulito");
			}
			
			case "deleteCart": {
					String id=request.getParameter("id");
					ShopBean bean;
					try {
						bean = model.doRetrieveBy(id);
						if(bean!=null && !bean.isEmpty()) {
							cart.deleteItem(bean);
							request.setAttribute("message", "Oggetto "+ bean.getNome_oggetto()+" rimosso dal carrello");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}
			
			
			default:
				throw new IllegalArgumentException("Unexpected value: " + action);
			}
			}
		
		response.sendRedirect(request.getContextPath()+"/carrello.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
