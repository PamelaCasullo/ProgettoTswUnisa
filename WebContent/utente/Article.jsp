<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String idArticolo=(String)session.getAttribute("id_articolo");
		if(idArticolo==null){
		RequestDispatcher disp= request.getRequestDispatcher("errorPage404.jsp");
		disp.forward(request, response);
	}
%>  
    
    
    
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="script/article.js"></script>

<meta charset="UTF-8">
<title>ARTICOLO</title>
</head>
<body>
<%@include file="../header.jsp"%>
<div class="mostraArticoli"></div>
<form action="<%=response.encodeURL("ArticleServlet")%>" enctype="multipart/form-data">
 <input type="submit" value="Mostra Articoli">
	<div class="tutto">
		<div class="nomeSquadra"><h3><%=%></h3></div>
		<div class="giocatori"></div>
		<fieldset class="dati">
		</fieldset>
	</div>
	
	
	<!-- 
	<h1 align="left">Beer Selection</h1>
	
	<% 
		//String color =  (String) request.getParameter("color");
	
		//List<?> colors =  (List<?>) request.getAttribute("colors");
	 //   if(colors != null) {
	%> 		
	<form action="SelectBeer" method="get">
		Select beer characteristics
		<select name="color">
			<%    	
			//Iterator<?> cit = colors.iterator();
			//while(cit.hasNext()) {
				//String value = cit.next().toString();
			
				//if(value.equals(color)) {
			%>
	   			<option value="<%= //value%>" selected><%= //value%></option>
			<%
			//	} else {
			//		%>
		   	//		<option value="<%=//value%>"><%=// value%></option>
				<%		
			//		}
			//}
			%>
		</select>
		<input type="submit">
	</form>
	<%
	  //  }

	//	List<?> brands =  (List<?>) request.getAttribute("result");
	    if(brands != null) {
	%>    	
	  	<h2>Beer Recommendations (JSP) for <%=// color%></h2>
	<%    	
//	Iterator<?> it = brands.iterator();
//	while(it.hasNext()) {
	%>
	   try: <%= //it.next()%><br>
	<%
//						}
//	    }
	%>

	  -->
</form>
</body>
</html>