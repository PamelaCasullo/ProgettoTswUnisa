<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js" integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js" integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9" crossorigin="anonymous"></script>
	

	<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
	<script type="text/javascript" src="script/login.js"></script>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.6, shrink-to-fit=no">
	
	<meta name="description" content="layout template responsive">
	<meta name="author" content="Paolo Apostolico, Pamela Casullo, Giulio Triggiani">
	 
	<link rel="stylesheet" href="css/default.css">
 	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
	<link rel="stylesheet" href="css/index.css">
	<link rel="stylesheet" href="css/login.css">
	<link rel="stylesheet" href="css/layout.css">
<title>Pagina di Login</title>
</head>
<body>
<%@include file="header.jsp"%>
<!--  LOGIN -->
    <div class="login-dark" name="login">
        <form action ="<%=request.getContextPath()%>/Login" method="post">
            <h1>LOGIN</h1>
            
            <div class="illustration"><i class="icon ion-ios-game-controller-b-outline"> </i></div>
            <div class="form-group"><input class="form-control" type="email" name="email" placeholder="mario_rossi@dominio.it"required></div>
            <div class="form-group"><input class="form-control" type="password" name="password_utente" placeholder="password" required></div>
            <div class="form-group">
            <button class="btn btn-primary btn-block" type="submit" onclick="validate()">Log In</button></div><a href="password.html" class="forgot">Password dimenticata?</a>
   			<p style="text-align:center"> Se non avete ancora creato un profilo, siete pregati di farlo attraverso la pagina di <a href="signup.jsp">Registrazione</a></p>
			</form>
   			</div>


</body>
</html>