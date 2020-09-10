<%@page import="java.util.*,it.MadDiscord.Model.ShopBean,it.MadDiscord.Model.Cart"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Collection<?> products = (Collection<?>)request.getAttribute("products");


	if(products==null){
		response.sendRedirect(response.encodeRedirectURL("./Shop")); //QUI
		return;
	}
	
Cart<ShopBean> cart = (Cart<ShopBean>)request.getAttribute("cart");
	
 	if(cart == null) {
 		response.sendRedirect(response.encodeRedirectURL("./Shop"));
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
	 
	
	
	<!--  <link rel=stylesheet href="css/default.css">-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" crossorigins=anomymous >
	 <!-- <link rel="stylesheet" href="css/shop.css"> -->
	
	<title>Shop MadDiscord</title>
	
	
</head>

<body>

 <!-- <%@include file="../header.jsp"%> -->
	<!-- SHOP   -->
    <header>
        <h1 class="shop_header">SHOP UFFICIALE DEI MAD DISCORD</h1> 
         
  
        CARRELLO
    </header>
    
    <%
	List<ShopBean> prodcart = cart.getItems();

	if(prodcart.size() > 0) {
%>
	<a href="<%=response.encodeURL("Shop?action=clearCart")%>">Clear</a>
	<a href="">Buy</a>
<%  } %>

<table>
	<tr>
		<th>Name</th>
		<th>Prezzo</th>
		<th>Action</th>
	</tr>	
	<%
		if(prodcart.size() > 0) {
			for(ShopBean prod: prodcart) {
	%>
			<tr>
				<td><%= prod.getNome_oggetto() %> </td>
				<td><%= prod.getPrezzo() %></td>
				<td><a href="<%=response.encodeURL("Shop?action=deleteCart&id=" + prod.getId()) %>">Delete from cart</a>			
			</tr> 
	<% 		}
		} else {
	%>
		<tr><td colspan="2">No product available in the cart</td></tr>
	<%
		}
	%>
</table>





	

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