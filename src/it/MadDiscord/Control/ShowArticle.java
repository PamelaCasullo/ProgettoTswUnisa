package it.MadDiscord.Control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import it.MadDiscord.Model.ArticleModelDM;


@WebServlet(urlPatterns = {"/ArticleServlet","/utente/ArticleServlet"})
public class ShowArticle extends HttpServlet {
		
		private static final long serialVersionUID = 1L;
		Gson gson= new Gson();
	
		ArticleModelDM pModel = new ArticleModelDM();
		
		ArrayList<String>art= new ArrayList<String>();
		
	     public ShowArticle() {
			
	        super();

	    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action= request.getParameter("action");

			switch (action) {
			case "show": {
				
			
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + action);
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
