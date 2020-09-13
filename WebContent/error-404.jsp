<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PAGE NOT FOUND</title>

</head>
<body>
<input type="hidden" value="<%=request.getSession().getId()%>" id="session">
<%@include file="header.jsp"%>
 <p align="center">
    <%
        out.println("Requested resource: " + request.getRequestURL()+ " not found");
    %>
</body>
</html>