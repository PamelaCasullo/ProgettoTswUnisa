<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection, it.MadDiscord.Model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
  <%
	Collection <?> articles =(Collection<?>) request.getAttribute("users");

	String error =(String)request.getAttribute("error");

	if(articles==null&& error == null){
	response.sendRedirect(response.encodeRedirectURL("./Utente"));
		return;
	}


	ArticleBean aBean = (ArticleBean) request.getAttribute("user");


%>    
 
 
<!DOCTYPE html>
<html>
<head>
<title>GESTIONE UTENTI</title>
</head>

<body>
<%@include file="header.jsp"%>

</body>
</html>