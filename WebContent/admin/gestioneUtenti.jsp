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


	UtenteBean uBean = (UtenteBean) request.getAttribute("user");


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
			<th>Password</th>
		</tr>
	<% if(users!=null && users.size()>0) { 
	
		Iterator <?> it = users.iterator();
		while(it.hasNext()){
			UtenteBean bean =(UtenteBean)it.next();
	
	%>

			<tr>
				<td><%=uBean.getNome_utente() %></td>
				<td><%=uBean.getEmail()%></td>
				<td><%=uBean.getPassword_utente()%></td>
			</tr>
	
	</table>
	
	
	
	<h2>DETTAGLI</h2>
	<table>
			<tr>
				<th>Nome Utente</th>
				<th>Email</th>
				<th>Password</th>
			</tr>
			<tr>
				<td><%=uBean.getNome_utente() %></td>
				<td><%=uBean.getEmail()%></td>
				<td><%=uBean.getPassword_utente()%></td>
			</tr>
		</table>
			
		<form action="<%=response.encodeURL("Utente") %>" method=POST>
		<fieldset>
		<legend><b> Update </b></legend>
		<input type=hidden name=action value=update>
		<input type=hidden name=nome_utente value="<%=uBean.getNome_utente()%>">
		
		<label for=name> Nome Utente:</label>
		<input name=nome_utente type=text maxlength=20  placeholder="enter name" required value="<%=uBean.getNome_utente()%>"> <br>
		
		<label for=price>Email:</label>
		<input name=email type="email" maxlength="20" placeholder="enter email" required><%=uBean.getEmail()%><br>
			
		<label for=quantity>Password</label>
		<input name=password_utente type="text" placeholder="enter password" required><%=uBean.getPassword_utente()%><br>
		
		<input type=submit value=Update> 
		<input type=reset value=Reset>
		</fieldset>
	</form>	
	
	<%} }%>
	
	<form action="<%=response.encodeURL("Utente") %>" method=POST>
		<fieldset>
		<legend><b> Insert </b></legend>
		<input type=hidden name=action value=insertUser>
		
		<label for=nome> Nome utente:</label>
		<input name=nome type=text maxlength=20  placeholder="enter name" required> <br>
		
		<label for=email>Email:</label>
		<input name=email type="email" required placeholder="enter email"><br>
		
			
		<label for=password>Password:</label>
		<input name=password type="password" required placeholder="enter password"><br>
		
		<input type=submit value=Insert> 
		<input type=reset value=Reset>
		</fieldset>
	</form>

</div>

</body>
</html>