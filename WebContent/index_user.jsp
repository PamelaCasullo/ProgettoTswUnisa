<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js" integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js" integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9" crossorigin="anonymous"></script>

	<meta charset="ISO-8859-1">
	
	<title>La connessione ha avuto successo</title>
	
	<link rel="stylesheet" href="css/default.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" crossorigins=anomymous >
	<link rel="stylesheet" href="css/layout.css">
</head>
<body>
<%@include file="header.jsp"%>
<nav id=nav class="navbar navbar-expand-lg navbar-dark">
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
	 <li class="nav-item">
		<p style="color:orange;">Benvenuto, <%=request.getSession().getAttribute("nome_utente") %></p>
	</li> 
    </ul>
  </div>
</nav>

<!--  COMING SOON -->
	<p style="color:orange">
		BENVENUTO TRA I MAD DISCORD!
		</p>
<%@include file="homeInclusive.jsp"%>
</body>
</html>