<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>GESTIONE ARTICOLI</title>
</head>
<body>
<%@include file="header.jsp"%>
<div class=Articoli>
<h1>Inserimento degli articoli al sito. Sono richiesti un titolo, un'immagine ed un contenuto(200 caratteri max)</h1>
	
	
	<form action="<%=response.encodeURL("Article?action=insert")%>" enctype="multipart/form-data">
	
		<table>
		<tr>
		<th> Titolo	</th>
		<th> Contenuto</th>
		<th> Immagine</th>
		<th>
		
	<input type="text" class=selettore value="Inserisci un titolo" name="titolo">
	
	<input type="text" class=selettore value="Inserisci il contenuto" name="cont">
	
	<div class=immagine>
	<input type="file" class=selettore value="Inserisci un'immagine" name="immagine">	
	</div>	
	<input type="submit" value="bottone">
	</th>
	</tr>
	
	</table>
	
	</form>
	


</div>	
</body>
</html>