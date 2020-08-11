<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
	<script type="text/javascript" src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
	<script type="text/javascript" src="script/login"></script>

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
<title>Pagina di Login</title>
</head>
<body>
    <div class="login-dark">
        <form action ="<%=request.getContextPath()%>/Login" method="post">
            <h1>LOGIN</h1>
            
            <div class="illustration"><i class="icon ion-ios-locked-outline"> </i></div>
            <div class="form-group"><input class="form-control" type="text" name="nome_utente" placeholder="nome utente"required></div>
            <div class="form-group"><input class="form-control" type="password" name="password_utente" placeholder="password" required></div>
            <div class="form-group">
            <button class="btn btn-primary btn-block" type="submit">Log In</button></div><a href="password.html" class="forgot">Password dimenticata?</a></form>
   			</div>


</body>
</html>