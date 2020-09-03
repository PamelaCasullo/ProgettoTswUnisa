	$(document).ready(function(){
	
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function() {
			
			if (xhr.status == 200 && xhr.readyState == 4) {
				let data = JSON.parse(xhr.responseText);
				console.log(data);			
				var div=$(".mostraArticoli");
				for (var i = 0; i < data.length; i++) {
					div.append('<p>Titolo= '+data[i].titolo+' <a href="../Article?action=delete&id='+data[i].id_articolo+'"><i class="fas fa-dumpster-fire"></i></a><br>');	
		
				}
			
			}
		

	}
	xhr.open('GET', '../Article?action=show', true);		
	xhr.send();
		})