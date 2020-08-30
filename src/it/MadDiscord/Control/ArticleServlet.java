package it.MadDiscord.Control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import it.MadDiscord.Database.ArticleDAO;
import it.MadDiscord.Model.ArticleBean;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB after which the file will be
// 10MB maximum size allowed for uploaded files
maxRequestSize = 1024 * 1024 * 50) // 50MB overall size of all uploaded files
@WebServlet("/ArticleUser")

public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ArticleServlet() {
        super();
    }

    
    static String SAVE_DIR = "images";
    ArticleDAO aDAO = new ArticleDAO();
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action!=null) {
			switch (action) {
		case "insert": {
			
			
			try {
				String ti = request.getParameter("titolo");
				String cont = request.getParameter("cont");
				String imm = request.getParameter("immagine");
				
				String sPath = request.getServletContext().getRealPath("")+File.separator+SAVE_DIR+File.separator+"article";
				ArticleBean arBean = new ArticleBean(ti, sPath, cont);
				aDAO.newArticle(arBean);
				
				RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/gestioneArticoli.jsp");
				rd.forward(request, response);					
						
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			}
			
			
		}
		case "insertImageArticle": {
			String sPath =  request.getServletContext().getRealPath("")+File.separator+SAVE_DIR;
		
			File fSaveDir = new File(sPath);
			if(!fSaveDir.exists()) {
				fSaveDir.mkdir();
			}
		
			if(request.getParts()!=null&&request.getParts().size()>0) {
				for(Part p: request.getParts()) {
					if(p.getSize()>1024*1024*10) {
						response.setStatus(500);
						request.setAttribute("fotoerr", true);
						RequestDispatcher rd = request.getRequestDispatcher("/gestioneArticoli.jsp");
						rd.forward(request, response);
					} else {
						String fName = extractFileName(p);
						if(fName!=null&&!fName.equals("")) {
							ArticleDAO artDAO = new ArticleDAO();
							ArticleBean artBean = new ArticleBean();
							HttpSession se = request.getSession(false);
							
						}
					}
				}
			}
		
		
		
		
		
		
		
		}
		
		}
		}
		
		
		
		
	}
	
	private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

}
