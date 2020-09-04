$(function(){
	$('.sub').submit(function () { 
	
		var res= mailCheck() && userCheck() && passCheck();	
		if(res){
			var d = new Date();
			var month = d.getMonth()+1;
			var day = d.getDate();
			var output = d.getFullYear() + '/' +
				(month<10 ? '0' : '') + month + '/' +
				(day<10 ? '0' : '') + day;
			$('#data').val(output);
			return true;
		}
		else
			return false;
	});
	
}); 
 
 
 
 
 
 function mailCheck(){
	
 	var emailReg=/^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
 	
 		var error=email.next();
     
 	if(!email.val()){	//Email non inserita
 			$('span').text("");
			error.text("Inserisci un'e-mail, non ti posso inviare spam altrimenti");
			console.log("email check not passed");
			return false;
		}
		
		else {
			if(!emailReg.test(email.val())){	//Email non corretta
				$('span').text("");
 	    	    error.text("Inserisci un'e-mail credibile dai");
				console.log("email check not passed");
				return false;
 		}
 	     
 		else{	//Controllo passato
 				error.text("");
				console.log("email check passed");
				return true;
			}	
		}
 }
 function userCheck(){
	var username=$("#username");
	var usernameReg=/^[A-Za-z0-9_-]{0,30}$/;
   let error=username.next();
	
	   if(!username.val()){	//Username non inserito
		   $('span').text("");
		   error.text("Devi mettere uno username prova xxSpinnerKillerxx");
		   console.log('username check not passed');
		   return false;
	   }
	   else{
	   
		   if(!usernameReg.test(username.val())){ 	//Username non corretto
			   $('span').text("");
			   error.text("Magari qualcosa di decente");
			   console.log('username check not passed');
			   return false;
		   }
		   
		   else{	//Controllo passato
			   
			   error.text("");
			   console.log('username check passed');
			   return true;
		   }
	   }
   }
   function showPass() {
    	
	if($('#login-form').css("display")=="block")
		var x=$('.password');
	else
		var x=$('#password');
	
	if(x.attr("type")==="password")
		x.attr("type","text");
	else
		x.attr("type","password");

}

   
 

