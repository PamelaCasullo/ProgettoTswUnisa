package it.MadDiscord.Control;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.MadDiscord.Model.UtenteBean;

import javax.servlet.*;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"/admin/*", "/user/*"})
public class LoginFilter implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hRequest=(HttpServletRequest)request; 
		HttpServletResponse hResponse=(HttpServletResponse)response; 

		System.out.println("sono stata chiamata da "+hRequest.getHeader("referer"));
		
		System.out.println("la sessione è valida?"+hRequest.isRequestedSessionIdValid());
		HttpSession session= hRequest.getSession(true);
		if(!hRequest.isRequestedSessionIdValid()) {
			
			session=hRequest.getSession(true);
		}
		
		System.out.println("Sto filtrando la richiesta");
		String requestURI=hRequest.getRequestURI();
		
		if(requestURI.contains("/utente/")) {
			System.out.println("il path contiene *utente*");
			checkAccess(session, request, response, chain, hResponse, hRequest, "utente");
		}
		else if(requestURI.contains("/admin/")) {
			System.out.println("il path contiene *admin*");
			checkAccess(session, request, response, chain, hResponse, hRequest, "admin");
		}
		
	}
	
	
	public void checkAccess(HttpSession session, ServletRequest sRequest, ServletResponse sResponse, FilterChain chain, HttpServletResponse hResponse, HttpServletRequest hRequest, String tipoUtente) throws IOException, ServletException{
		
		if(session!=null) {
			System.out.println("la sessione va bene");
			UtenteBean user=(UtenteBean) session.getAttribute("nome_utente");
			
			if(user!=null && user.getTipo().equals(tipoUtente))
				chain.doFilter(sRequest, sResponse);
			else
				hResponse.sendRedirect(hResponse.encodeRedirectURL(hRequest.getContextPath()+"/login.jsp"));
		}
	
		
	}

}
