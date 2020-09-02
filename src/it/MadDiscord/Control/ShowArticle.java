package it.MadDiscord.Control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ArticleServlet")
public class ShowArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowArticle() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		//String par1 = (String) request.getSession().getAttribute("articolo");
		
		PrintWriter out = response.getWriter();
		out.println("<!doctype html>");
		out.println("<html><head></head><body>");
		out.println("<p>PROVA RIUSCITA</p>");
		out.println("<button type=button >CIAO SONO UN BOTTONE</button>");
		
		
		out.println("</body></html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
