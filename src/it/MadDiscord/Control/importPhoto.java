package it.MadDiscord.Control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import it.MadDiscord.Model.ArticleBean;

/**
 * Servlet implementation class importPhoto
 */
@WebServlet("/Admin/LoadPhotoArticle")
public class importPhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String tyPhoto= request.getParameter("tipo");
		
		switch (tyPhoto) {
		case "article": {
			HttpSession se = request.getSession(false);
			ArticleBean aBean = (ArticleBean) se.getAttribute("immagine");
			String filename = aBean.getImmagine();
			
			
			File f = new File(filename);
			FileInputStream fStream = new FileInputStream(f);
			byte[] bt = fStream.readAllBytes();
			ServletOutputStream out = response.getOutputStream();
			out.write(bt);
			
		}
		}
		
	}



}
