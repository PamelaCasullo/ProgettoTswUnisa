<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.Collection, it.MadDiscord.Model.Cart, it.MadDiscord.Model.ShopBean, java.util.*"%>
 
<%
	Collection<?> products = (Collection<?>)request.getAttribute("products");

	String error =(String)request.getAttribute("error");

	if(products==null&&error==null){
		response.sendRedirect(response.encodeRedirectURL("./Shop"));
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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>

	<%
	List<ShopBean> prodCart = cart.getItems();
	
	if(prodCart.size()>0){
	%>
	<a href="<%=response.encodeURL("ProductControl?action=clearCart")%>">Clear</a>
	<a href="">Buy</a>
	<%} %>
	<table>
		<tr>
		<th>Name</th>
		<th>Action</th>
		</tr>
		<%
		if(prodCart.size()>0){
			for(ShopBean prod : prodCart){
		%>
		<tr>
		<td><%=prod.getNome_oggetto() %></td>
		<td><a href="<%=response.encodeURL("ProductControl?action=deleteCart&id="+prod.getId())%>"> Delete </a></td>
		</tr>
		
		<%}
		}else { 
		%>
		<tr><td colspan = 2>No product Available in the cart</td></tr>
		<%} %>
	</table>
</body>
</html>