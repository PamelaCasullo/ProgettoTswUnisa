<%@page import="it.MadDiscord.Model.UtenteBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UtenteBean utente=(UtenteBean)session.getAttribute("nome_utente");
	if(utente!=null) {
		System.out.println("utente diverso da null: "+ utente.getTipo());
	}

%>
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
	
	<meta name="description">
	<meta name="author" content="Paolo Apostolico, Pamela Casullo, Giulio Triggiani">
	 
	 <link rel="stylesheet" href="../css/default.css">
 	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
    <title>MAD DISCORD</title>
</head>
<body>

<!--  SIDEBAR -->
<nav id=nav class="navbar navbar-expand-lg navbar-dark">
<input type="hidden" value="<%=request.getSession().getId()%>" id="session">
 <%if(utente==null) { %> 
<form class="form-inline my-2 my-lg-0" style="float: left">
<a class="navbar-brand" href="<%=request.getContextPath()%>;jsessionid=<%=request.getSession().getId() %>/Homepage.jsp">
  <img id=logo alt="logo_azienda" src="<%=request.getContextPath()+"/images/LogoGif.gif"%>" width="60" style="	border-radius: 70%;border-width: none;">
  </a>
    <ul class="navbar-nav mr-auto">
      <li>
      <a class="nav-link" href="<%=request.getContextPath()%>;jsessionid=<%=request.getSession().getId() %>/utente/about.jsp">About</a>
      </li>
    </ul>
    <ul class="navbar-nav mr-auto">
    <li> 
    <span><a class="nav-link" href="jsessionid=<%=request.getSession().getId() %>signup.jsp"><u> Sign-up</u></a></span>

   <button class="btn btn-dark"> <a class="nav-link" href="jsessionid=<%=request.getSession().getId() %> login.jsp">Login</a> </button>
    </ul>
    </form>

   <% } else { %>
  <a class="navbar-brand" href="<%=request.getContextPath()%>;jsessionid=<%=request.getSession().getId() %>/Homepage.jsp">
  <img id=logo alt="logo_azienda" src="<%=request.getContextPath()+"/images/LogoGif.gif"%>" width="60" style="	border-radius: 70%;border-width: none;">
  
  </a>
   <nav id=nav class="navbar navbar-expand-lg navbar-dark">
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
	 <li class="nav-item">
		<p style="color:orange;">Benvenuto, <%=utente.getNome_utente() %>
		<a href="<%=request.getContextPath()%>;jsessionid=<%=request.getSession().getId() %>/Logout">Logout</a>
	</li> 
    </ul>
      </div>

<%if(utente.getTipo().equals("admin")) { %>

  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>;jsessionid=<%=request.getSession().getId() %>/Homepage.jsp">">PANNELLO DI CONTROLLO <span class="sr-only">(current)</span></a>
      </li>
 
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>;jsessionid=<%=request.getSession().getId() %>/admin/gestioneShop.jsp">">Gestione Shop</a>
      </li>
      <li>
      <a class="nav-link" href="<%=request.getContextPath()%>;jsessionid=<%=request.getSession().getId() %>admin/gestioneUtenti.jsp">Gestione Utenti</a>
      </li>
   
    </ul>
      
   <% } else  { %>
 	

  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">

    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="../Homepage.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
      <li>
      <a class="nav-link" href="<%=request.getContextPath()+"/about.jsp;jsessionid="+request.getSession().getId()%>">About</a>
      </li>
      <li>
      <a class="nav-link" href="<%=request.getContextPath()%>;jsessionid=<%=request.getSession().getId()%>/utente/shop.jsp">Shop</a>
      </li>
    </ul>
     <% } %>

   <% } %>
   </div>
    </div>
</nav>

</nav> 
		<footer>
		<span>APOSTOLICO PAOLO, 
		CASULLO PAMELA, 
		TRIGGIANI GIULIO. 
		Diritti ai rispettivi proprietari©</span>
		</footer>
	
</body>
</body>
</html>


