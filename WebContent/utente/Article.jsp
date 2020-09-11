<%@page import="it.MadDiscord.Model.ArticleBean"%>
<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArticleBean aBean = (ArticleBean)request.getSession().getAttribute("id_articolo");
	
		if(aBean==null){
		RequestDispatcher disp= request.getRequestDispatcher("errorPage404.jsp");
		disp.forward(request, response);
	}
%>  
    
    
    
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="script/article.js"></script>

<meta charset="UTF-8">
<title>ARTICOLO</title>
</head>
<body>
<%@include file="../header.jsp"%>

<input type="hidden" value="<%=aBean%>" class="idArticolo">
<nav id="article-nav" class="position-fixed d-block bg-white">
	<a href=<!--prossimo articolo -->>Successivo</a>
	<a href=<!--articolo precedente -->>Precedente</a>
	

</nav>

	<div class="container">
		<div id="_article_container">
			<div class="row">
			<article class="article pb-5">
				<header class="articel_header px-3 pt-3"></header>
			
			</article>
			
			
			
			</div>
		</div>
	</div>
	
</body>
</html>