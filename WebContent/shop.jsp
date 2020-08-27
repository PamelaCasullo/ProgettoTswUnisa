<%@page import=" it.MadDiscord.Model.*,  java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Collection<?> products = (Collection<?>)request.getAttribute("products");


	if(products==null){
		response.sendRedirect(response.encodeRedirectURL("./Shop")); //QUI
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
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" crossorigins=anomymous >
	<link rel="stylesheet" href="css/shop.css">
	
	<title>Shop MadDiscord</title>
	
	
</head>

<body>
<%@ include file="header.jsp" %>

	<!-- SHOP   -->
    <header>
        <h1 class="shop_header">SHOP UFFICIALE DEI MAD DISCORD</h1>  
        <a href="carrello.jsp">CARRELLO</a>
    </header>

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

<!-- SCHEDE NEGOZIO -->
</html>