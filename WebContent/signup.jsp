<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

    <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>


    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.6, shrink-to-fit=no">
	
	<meta name="description" content="layout template responsive">
	<meta name="author" content="Paolo Apostolico, Pamela Casullo, Giulio Triggiani">
	 
    <title>Pagina di Registrazione</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/simple-line-icons/2.4.1/css/simple-line-icons.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    
    <link rel="stylesheet" href="css/signup.css">
    
    <script type="text/javascript" src="script/password.js"></script>
    
</head>
<body>
 
    <div class="registration-form">
        <form>
            <div class="form-icon">
                <span><i class="icon icon-user"></i></span>
            </div>
            <div class="form-group">
                <input type="text" class="form-control item" id="username" placeholder="Nome Utente*" required>
            </div>
            <div class="form-group">
                <input type="password" class="form-control item myInput"placeholder="Password*" required>
                <input type="checkbox" onclick="visualPassword('myInput')">Show Password
            </div>
            
            <div class="form-group">
                <input type="password" class="form-control item myInput1" placeholder="Ripeti password*" required>
                <input type="checkbox" onclick="visualPassword('myInput1')">Show Password
            </div>
            <div class="form-group">
                <input type="email" class="form-control item" id="email" placeholder="E-mail*" required>
            </div>
            
            <div class="form-group">
                <input type="date" class="form-control item" id="birth-date" placeholder="Data di nascita" required>
            </div>
            <div class="form-group">
              <input type="text" class="form-control item" id="control-words" placeholder="Frase di sicurezza" required>
            </div>
            <div class="input-group">
               <select class="form-control" id="sel1">
                   <option selected disabled="disabled">Seleziona la domanda di sicurezza</option>
                   <option>Qual è il tuo film preferito?</option>
                   <option>Qual è il nome del tuo animale domestico?</option>
                    <option>Qual è il nome della tua città?</option>
                  </select>
            </div>
            <div> <p>Creando un account accetterai la nostra <a href="#" style="color:dodgerblue">politica sulla Privacy.</a>.</p></div>
            <div class="form-group">
                <button type="button" class="btn btn-block create-account " onClick="passwordCheck()">Crea un account</button>
            </div>
        </form>
    </div>


</body>
</html>