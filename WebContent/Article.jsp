<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ARTICOLO</title>
</head>
<body>
<%@include file='header.jsp'%>
<form action="<%=response.encodeURL("ArticleServlet")%>" enctype="multipart/form-data">
 <input type="submit" value="Mostra Articoli">
	
</form>
</body>
</html>