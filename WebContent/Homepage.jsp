<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
    <!-- LOGIN -->

    <div id=login>
    <form action ="<%=request.getContextPath()%>/Login" method="post">
  <div class="form-group">
    <label >Username</label>
    <input type="text" class="form-control" name="nome_utente" placeholder="nome utente" >
    <small id="emailHelp" class="form-text text-muted">Non condividere la password con nessuno</small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" name="password_utente">
  </div>
  <div class="form-group"><label><a href="password.html">Password dimenticata?</a></label> </div>
  <div class="form-group form-check">
    <input type="checkbox" class="form-check-input" >
    <label class="form-check-label" >Mantienimi registrato</label>
  </div>
  <button type="submit" class="btn btn-primary">Accedi</button>
</form>
</div>

<%@include file="homeInclusive.jsp" %>

</body>
</html>