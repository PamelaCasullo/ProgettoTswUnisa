<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">
	<!-- SCRIPT TAG-->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/popper.js@1.12.6/dist/umd/popper.js" integrity="sha384-fA23ZRQ3G/J53mElWqVJEGJzU0sTs+SvzG8fXVWP+kJQ1lwFAOkcUOysnlKJC33U" crossorigin="anonymous"></script>
    <script src="https://unpkg.com/bootstrap-material-design@4.1.1/dist/js/bootstrap-material-design.js" integrity="sha384-CauSuKpEqAFajSpkdjv3z9t8E7RlpJ1UP0lKM/+NdtSarroVKu069AlsRPKkFBz9" crossorigin="anonymous"></script>

	
	<!-- META TAG -->
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.6, shrink-to-fit=no">
	
	<meta name="description" content="layout template responsive">
	<meta name="author" content="Paolo Apostolico, Pamela Casullo, Giulio Triggiani">
	 <!--  LINK TAG -->
	<title>HomePage</title>
	<link rel="stylesheet" href="css/default.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" crossorigins=anomymous >
	<link rel="stylesheet" href="css/layout.css">
</head>
<body> 
<%@include file="header.jsp"%>
<%if(utente==null)  { %>
   <h4 style="color:white"> SE VUOI VISUALIZZARE TUTTI I CONTENUTI DEL NOSTRO SITO, SEI PREGATO DI EFFETTUARE L'ACCESSO ATTRAVERSO LA PAGINA DI LOGIN.<br>
   SE INVECE NON HAI ANCORA UN PROFILO, COSA STAI ASPETTANDO?! ENTRA A FARE PARTE DELLA FAMIGLIA "MAD DISCORD"!<br></h4>
<% } %>
<%@include file="homeInclusive.jsp" %>

</body>
</html>
