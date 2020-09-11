	$(document).ready(function(){
	
		var xhr = new XMLHttpRequest();

		  //var titolo=$('.titolo');
		   //var cont=$('.cont');
		   //var image=$('.image');

		   var articolo=$('.mostraArticolo');
		xhr.onreadystatechange = function() {
			
			if (xhr.status == 200 && xhr.readyState == 4) {
				let data = JSON.parse(xhr.responseText);
				console.log(data);	

				for (var i = 0; i < data['0'].length; i++) {
					articolo.append('<div><p>Titolo= '+data['0'][i]+'</p><a onclick="mostraArticolo(\''+data['0'][i]+'\')"><img src='+data['1'][i]+'></img></div><br>');	
		
				}
			
			}
	}
	xhr.open('GET', '../Article?action=show&id='+$('.id_article').val(), true);		
	xhr.send();
	})


	
	function mostraArticolo(i){
		var div=$('.dati');
		var xhr = new XMLHttpRequest();
	   
		xhr.onreadystatechange = function() {
		   if (xhr.status == 200 && xhr.readyState == 4) {
			   var data = JSON.parse(xhr.responseText);
			   console.log(data);	

			   div.empty();
			   div.append('<h3>'+data[0].titolo+'</h3><br>');
			   div.append('<span><small>'+data[0].immagine+'</small><br><br>'+
							' <small>'+data[0].cont+'</small><br><br>'+
						  '</span>');
			   
		   }
	   }
		
		xhr.open('GET', 'UserControl?action=getDatiGiocatore&nick='+i, true);	
		xhr.send();
		
	}
	
	