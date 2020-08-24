package it.MadDiscord.Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.MadDiscord.Model.ShopBean;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/Cart")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action==null) {
			doGet_DisplayCart(request,response);
		} else {
			if(action.equalsIgnoreCase("buy")) {
				doGet_Buy(request,response);
			} else if(action.equalsIgnoreCase("remove")) {
				doGet_Remove(request, response);
			}
		}
	}
	
	protected void doGet_DisplayCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("carrello/carrello.jsp").forward(request, response);
		
	}
	
	protected void doGet_Remove(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		List<CartBean> cart = (List<CartBean>)session.getAttribute("cart");
		int i = isExisting(request.getParameter("id"), cart);
		cart.remove(i);
		session.setAttribute("cart", cart);
		response.sendRedirect("carrello.jsp");
	}
	
	protected void doGet_Buy(HttpServletRequest request, HttpServletResponse response) {
	
	}
	protected int isExisting(String string, List<CartBean> cart) throws ServletException, IOException {
	
		return -1;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
