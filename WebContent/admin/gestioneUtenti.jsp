<%@page import="java.util.Iterator"%>
<%@page import="java.util.Collection, it.MadDiscord.Model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
  <%
	Collection <?> users =(Collection<?>) request.getAttribute("users");

	String error =(String)request.getAttribute("error");

	if(users==null&& error == null){
	response.sendRedirect(response.encodeRedirectURL("./Utente"));
		return;
	}


	UtenteBean user1 = (UtenteBean) request.getAttribute("user");


%>    
 
 
<!DOCTYPE html>
<html>
<head>
<title>GESTIONE UTENTI</title>
</head>

<body>
<%@include file="../header.jsp"%>
<div class=Utenti style="color:white">
<h1>Elenco degli utenti. Seleziona uno per visualizzarlo/modificarlo/eliminarlo.</h1>
<div class="mostraUtenti"></div>
<table style="color:white" border="" id="show">

		<tr>
			<th>Nome Utente</th>
			<th>Email</th>
		</tr>
	<% if(users!=null && users.size()>0) { 
	
		Iterator <?> it = users.iterator();
		while(it.hasNext()){
			UtenteBean bean =(UtenteBean)it.next();
	
	%>
			<tr>
				<td><%=bean.getNome_utente() %></td>
				<td><%=bean.getEmail()%></td>
				<td>
				<a href="<%=response.encodeURL("Utente?action=deleteUser&nome_utente="+bean.getNome_utente()) %>">Rimuovi dal database</a>
				<a href="<%=response.encodeURL("Utente?action=detailsUser&nome_utente="+bean.getNome_utente()) %>">dettagli</a>
				</td>
			</tr>
	

	<% } } else { %>	
	<tr>
			<td colspan=4>Database vuoto</td>
		</tr>
		<%} %>
			</table>
			
	
	<form action="<%=response.encodeURL("Utente")%>" method=POST>
		<fieldset>
		<legend><b> Crea un nuovo admin! </b></legend>
		<input type=hidden name=action value=insertUser>
		
		<label for=nome_utente> Nome utente:</label>
		<input name=nome_utente type=text maxlength=20  placeholder="enter name" required> <br>
		
		<label for=email>Email:</label>
		<input name=email type="email" required placeholder="enter email"><br>
		
		<label for=type>Tipo:</label>
		<input name=idAdmin type=text placeholder="admin o utente"><br>	
		
		<label for=password>Password:</label>
		<input name=password_utente type="text" required placeholder="enter password"><br>
		
		<input type=submit value=Insert> 
		<input type=reset value=Reset>
		</fieldset>
	</form>

</div>

</body>
</html>