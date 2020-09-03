<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<link rel="stylesheet" href="css/login.css">
	<link rel="stylesheet" href="css/layout.css">
<title>Pagina di Login</title>
</head>
<body>
<%@include file="header.jsp"%>
<!--  LOGIN -->
    <div class="login-dark"">
        <form action ="<%=request.getContextPath()%>/Login" method="post">
            <h1>LOGIN</h1>
            
            <div class="illustration"><i class="icon ion-ios-game-controller-b-outline"> </i></div>
            <div class="form-group"><input class="form-control" type="email" name="email" placeholder="mario_rossi@dominio.it"required></div>
            <div class="form-group"><input class="form-control" type="password" name="password_utente" placeholder="password" required></div>
            <div class="form-group">
            <button class="btn btn-primary btn-block" type="submit">Log In</button></div>
   			<p style="text-align:center"> Se non avete ancora creato un profilo, siete pregati di farlo attraverso la pagina di <a href="signup.jsp">Registrazione</a></p>
			</form>
   			</div>


</body>
</html>