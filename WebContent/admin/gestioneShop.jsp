<%@page import="java.util.Collection, it.MadDiscord.Model.ShopBean, java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	Collection<?> products = (Collection<?>)request.getAttribute("products");


	String error =(String)request.getAttribute("error");

	if(products==null&& error == null){
	response.sendRedirect(response.encodeRedirectURL("./ShopAdmin"));
	return;
	}
	
 	ShopBean product = (ShopBean) request.getAttribute("product");
	
%>

    
<!DOCTYPE html>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.6, shrink-to-fit=no">
	
	<meta name="description" content="layout template responsive">
	<meta name="author" content="Paolo Apostolico, Pamela Casullo, Giulio Triggiani">
	 
	
	
	<link rel=stylesheet href="css/default.css">
	<link rel="stylesheet" href="css/gestioneShop.css">

<title>Gestione Shop</title>

</head>

<body>

<%@include file="../header.jsp"%>


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
				<td><%=bean.getQuant() %></td>
				<td>
				<a href="<%=response.encodeURL("ShopAdmin?action=delete&id="+bean.getId())%>">Rimuovi dal database</a>
				<a href="<%=response.encodeURL("ShopAdmin?action=details&id="+bean.getId())%>">dettagli</a>
				</td>
			</tr>
		
		<% }
			
		} else {
		%>
		<tr>
			<td colspan=4>Database vuoto</td>
		</tr>
		<%} %>
	</table>


	<% if(product!=null && !product.isEmpty()) {  %>
	
		<h2>Details</h2>
		<table>
			<tr>
				<th>ID</th>
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
		
		<form action="<%=response.encodeURL("ShopAdmin") %>" method=POST>
		<fieldset>
		<legend><b> Update </b></legend>
		<input type=hidden name=action value=update>
		<input type=hidden name=id value="<%=product.getId()%>">
		
		<label for=name> Nome Oggetto:</label>
		<input name=name type=text maxlength=20  placeholder="enter name" value="<%=product.getNome_oggetto()%>"> <br>
		
		<label for=price>Prezzo:</label>
		<input name=price type="number" step="any" min=0 ><%=product.getPrezzo() %><br>
			
		<label for=quantity>Quantità:</label>
		<input name=quantity type=number min=1 ><%=product.getQuant() %><br>
		
		<input type=submit value=Update> 
		<input type=reset value=Reset>
		</fieldset>
	</form>

	<%
	} 
%>

	<form action="<%=response.encodeURL("ShopAdmin") %>" method=POST>
		<fieldset>
		<legend><b> Insert </b></legend>
		<input type=hidden name=action value=insert>
		
		<label for=nome_oggetto> Nome:</label>
		<input name=nome_oggetto type=text maxlength=20  placeholder="enter name" required> <br>
		
		<label for=prezzo>Prezzo:</label>
		<input name=prezzo type=number min=0 value=0 required><br>
		
			
		<label for=quant>Quantità:</label>
		<input name=quant type=number min=1 value=1 required><br>
		
		<input type=submit value=Insert> 
		<input type=reset value=Reset>
		</fieldset>
	</form>


</div>
</body>
</html>