<%@page import="java.util.Collection, it.MadDiscord.Model.Cart, it.MadDiscord.Model.ShopBean, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Collection<?> products = (Collection<?>)request.getAttribute("products");

	if(products==null){
	response.sendRedirect(response.encodeRedirectURL("./Shop"));
	return;
	}
	

	String error =(String)request.getAttribute("error");

 	ShopBean product = (ShopBean) request.getAttribute("product");
	
%>

    
<!DOCTYPE html>
<html>
<head>
<title>Gestione Shop</title>

</head>
<body>

<%@ include file="header.jsp" %>


<!--  GESTIONE CARRELLO:insert -->

<div class="Shop_container" align="center">
<table style="color:white">
	<tr>
		<th>ID</th>
		<th>NOME</th>
		<th>PREZZO</th>
	</tr>
	<%
		if(products!=null && products.size()>0){
			
			Iterator <?> it = products.iterator();
			while(it.hasNext()){
				ShopBean bean =(ShopBean)it.next();
		%>
			<tr>
				<td><%=bean.getId() %> </td>
				<td><%=bean.getNome_oggetto() %> </td>				
				<td><%=bean.getPrezzo() %></td>
				<td>
				<a href="<%=response.encodeURL("Shop?action=addCart&id="+bean.getId())%>">Aggiungi al carrello</a>
				</td>
			</tr>
		
		<% }
			
		} else {
		%>
		<tr>
			<td colspan=4>Nessun prodotto disponibile</td>
		</tr>
		<%} %>
	</table>
</div>

	
	<% if(product!=null && !product.isEmpty()) {  %>
		<h2>Dettagli</h2>
		<table>
		<tr>
			<th>Id</th>
			<th>Nome</th>
			<th>Prezzo</th>
			<th>Quantità</th>
		</tr>
		<tr>
				<td><%=product.getId()%></td>
				<td><%=product.getNome_oggetto()%></td>
				<td><%=product.getPrezzo()%></td>
				<td><%=product.getQuant()%></td>
			</tr>
		</table>
		
		<form action="<%=response.encodeURL("Shop") %>" method=POST>
		<fieldset>
		<legend><b> Update </b></legend>
		<input type=hidden name=action value=update>
		<input type=hidden name=id value="<%=product.getId()%>">
		
		<label for=name> Nome Oggetto:</label>
		<input name=name type=text maxlength=20  placeholder="enter name" required value="<%=product.getNome_oggetto()%>"> <br>
		
		<label for=price>Prezzo:</label>
		<input name=price type=number min=0 required><%=product.getPrezzo() %><br>
			
		<label for=quantity>Quantità:</label>
		<input name=quantity type=number min=1 required><%=product.getQuant() %><br>
		
		<input type=submit value=Update> 
		<input type=reset value=Reset>
		</fieldset>
	</form>

	

	<%
	String message = (String)request.getAttribute("message");
	if(message!=null && !message.equals("")){ %>
	<p style = "color: green;"><%=message %></p>
	
	<% } if(error != null && !error.equals("")) { %>

	<p style="color: red;">Error: <%= error%></p>
<%
	}
%>	
<%  } %>
	<form action="<%=response.encodeURL("Shop") %>" method=POST>
		<fieldset>
		<legend><b> Insert </b></legend>
		<input type=hidden name=action value=insert>
		
		<label for=nome_oggetto> Name:</label>
		<input name=nome_oggetto type=text maxlength=20  placeholder="enter name" required> <br>
		
		<label for=prezzo>Price:</label>
		<input name=prezzo type=number min=0 value=0 required><br>
		
			
		<label for=quant>Quantity:</label>
		<input name=quant type=number min=1 value=1 required><br>
		
		<input type=submit value=Insert> 
		<input type=reset value=Reset>
		</fieldset>
	</form>



</body>
</html>