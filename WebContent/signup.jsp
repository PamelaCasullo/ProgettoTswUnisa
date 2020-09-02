<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="script/signin.jsp"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js" integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js" integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9" crossorigin="anonymous"></script>
	
	<!--  SCRIPT PER ICONA  -->
	<script src="https://code.iconify.design/1/1.0.7/iconify.min.js"></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.6, shrink-to-fit=no">
	
	<meta name="description" content="layout template responsive">
	<meta name="author" content="Paolo Apostolico, Pamela Casullo, Giulio Triggiani">
	 
    <title>Pagina di Registrazione</title>
    
    <link rel="stylesheet" href="css/default.css">
    <link rel="stylesheet" href="css/signup.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
   
    
    <script type="text/javascript" src="script/password.js"></script>
    
</head>
<body>
<%@include file="header.jsp"%>
<!--  registration form -->
    <div class="registration-form">
        <form action="<%=request.getContextPath()+"/Signin"%>" method="post">
            <div class="form-icon">
                <span class="iconify icon:ion-person-add-outline icon-inline:false"></span>
            </div>
              <div class="form-group">
                <input type="email" class="form-control item" name="email" placeholder="E-mail*" required>
            </div>
            <div class="form-group">
                <input type="text" class="form-control item" name="nome_utente" placeholder="Nome Utente*" required>
            </div>
            <div class="form-group">
                <input type="password" class="form-control item myInput"placeholder="Password*" name="password_utente" required>
                <input type="checkbox" onclick="visualPassword('myInput')"><p>Mostra password</p>
            </div>
            
            <div class="form-group">
                <input type="password" class="form-control item myInput1" placeholder="Ripeti password*" required>
                <input type="checkbox" onclick="visualPassword('myInput1')"><p>Mostra password</p>
            </div>  
  
            <div> <p style="text-align:center">Creando un account accetterai la nostra <a href="#" id=privacy>politica sulla Privacy.</a>.</p></div>
            <div class="form-group">
                <button type="submit" class="btn btn-block create-account " onClick="passwordCheck()">Crea un account</button>
            </div>
            <p style="text-align:center"> Se avete già creato un profilo,<br> siete pregati di accedervi attraverso la pagina di<a href="login.jsp">Login</a></p>
        </form>
    </div>


</body>
</html>