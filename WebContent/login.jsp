<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
String error=" ";
String type=" ";
String errorLocation=" ";
if(session.getAttribute("error")!=null && session.getAttribute("error-type")!=null && session.getAttribute("error-location")!=null){
	error = (String)session.getAttribute("error");
	type= (String)session.getAttribute("error-type");	
	errorLocation =(String)session.getAttribute("error-location");
}

System.out.println("location "+errorLocation);
System.out.println("error "+error);
System.out.println("type "+type);
%> 
    
<!DOCTYPE html>
<html>
<head>

	<script type="text/javascript" src="script/login.js"></script>
	<script type="text/javascript" src="script/password.js"></script>
	 <link rel="stylesheet" href="css/default.css">
	<link rel="stylesheet" href="css/login.css">
 <link rel="stylesheet" href="css/layout.css">

	
<title>Pagina di Login</title>
</head>
<body>
<%@include file="header.jsp"%>
<!--  LOGIN -->
    <div class="login-dark">
        <form action ="<%=request.getContextPath()%>/Login" method="post">
            <h1>LOGIN</h1>
            
            <div class="illustration"><i class="icon ion-ios-game-controller-b-outline"> </i></div>
            <div class="form-group"><input class="form-control" type="email" name="email" class=email placeholder="mario_rossi@dominio.it"required></div>
            <span class="error-cred" style="color:yellow;"><%if(type.equals("wrongCred")){ %><%=error%><%}%></span>
            <div class="form-group"><input class="form-control item myInput" type="password" name="password_utente" placeholder="password" required></div>
            <input type="checkbox" onclick="visualPassword('myInput')"><p>Mostra password</p>
          
            
            <div class="form-group">
            <span class="error-cred" style="color:yellow;"><%if(type.equals("wrongCred")){ %><%=error%><%}%></span>
            <button class="btn btn-primary btn-block" type="submit">Log In</button></div>
   			<p style="text-align:center"> Se non avete ancora creato un profilo, siete pregati di farlo attraverso la pagina di <a href="signup.jsp">Registrazione</a></p>
			
			</form>
   			</div>


</body>
</html>