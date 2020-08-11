<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
	<script type="text/javascript" src="script/signin.jsp"></script>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.6, shrink-to-fit=no">
	
	<meta name="description" content="layout template responsive">
	<meta name="author" content="Paolo Apostolico, Pamela Casullo, Giulio Triggiani">
	 
    <title>Pagina di Registrazione</title>
    <link rel="stylesheet" href="css/default.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    
    <link rel="stylesheet" href="css/signup.css">
    
    <script type="text/javascript" src="script/password.js"></script>
    
</head>
<body>
 
    <div class="registration-form">
        <form action="<%=request.getContextPath() %>/Signin" method="post">
            <div class="form-icon">
                <span><i class="icon icon-user"></i></span>
            </div>
            <div class="form-group">
                <input type="text" class="form-control item" name="nome_utente" placeholder="Nome Utente*" required>
            </div>
            <div class="form-group">
                <input type="password" class="form-control item myInput"placeholder="Password*" name="password_utente" required>
                <input type="checkbox" onclick="visualPassword('myInput')">Show Password
            </div>
            
            <div class="form-group">
                <input type="password" class="form-control item myInput1" placeholder="Ripeti password*" required>
                <input type="checkbox" onclick="visualPassword('myInput1')">Show Password
            </div>  
  
            <div> <p>Creando un account accetterai la nostra <a href="#" style="color:dodgerblue">politica sulla Privacy.</a>.</p></div>
            <div class="form-group">
                <button type="submit" class="btn btn-block create-account " onClick="passwordCheck()">Crea un account</button>
            </div>
        </form>
    </div>


</body>
</html>