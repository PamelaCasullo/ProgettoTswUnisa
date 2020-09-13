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
	<link rel="stylesheet" href="../css/about.css">
	<link rel="stylesheet" href="../css/default.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" crossorigins=anomymous >
	<link rel="stylesheet" href="../css/layout.css">
	
</head>
<body> 
<%@include file="../header.jsp"%>

<div id=about>
	
    <h1>About Us</h1>
    <img style=float:left src="../images/esultanza.gif" width=600>
  	
  	<table id=tableclass>
  		<tr>
  			<th><span class=first>15</span><br><span class=second>years at the top</span></th>
  			<th><span class=first>€15m</span><br><span class=second>Prize Money won</span></th>
  			<th><span class=first>55m</span><br><span class=second>Global Audience</span></th>
  		</tr>
  		<tr>
  			<th><span class=first>209</span><br><span class=second>CHAMPIONSHIPS</span></th>
  			<th><span class=first>370+</span><br><span class=second>Medal Wins</span></th>
  			<th><span class=first>30</span><br><span class=second>Different Games</span></th>
  		</tr>
	</table>
	<br><br>

	<p class=clear>Mad Discord ormai conosciuta a livello nazionale è in continua crescita e punta alla vetta del settore Esports italiano. Fondata nel 2012 al centro di Salerno sotto il nome di "Discord E-sport" siamo la società più conosciuta e rinomata di tutto il sud Italia con numerosi premi vinti e diversi eventi ospitati dalla società stessa per far appassionare gamers e fanatici ad un ambiente al tempo visto quasi come un "insulto agli sport".
		Nel 2016 con il famoso cambio di roster e con la vittoria del torneo "PG-Esport Nats ITALIA" la società cambia nome in "Mad Discord" affamati sempre più di successo e fama.
		Il nostro scopo è cercare di portare ogni fanatico dei videogiochi in un ambiente competitivo e intrattenente fornendogli il massimo delle prestazioni e diverse possibilità di approccio in questo nuovo mondo.
		Con la nuova apertura della nostra gaming lobby al centro di Salerno sarà tutto più realizzabile e siamo sicuri di poter fornire nuove esperienze avvincenti per tutti i nuovi utenti. Vi Aspettiamo!
		<br><br>
		Per maggiori info guardare il nuovo articolo: <a href=article1.jsp>Nuova Gaming Lobby A Salerno</a>
  </p>
  
</div>



</body>
</html>