/*Per login*/ 
function visualPassword(k){
	var x = $("."+k);
   if(x.attr("type")==="password"){
	console.log('Funziono');
		 x.attr("type","text");
	 } else {
		 x.attr("type", "password")
		 console.log('non Funziono');
	 }
}



 
function passwordCheck() {
	var x = $(".myInput");
	  var y= $(".myInput1");

		if(x.val()===y.val()) 
			console.text("Le due password coincidono");
		  else 
		  	error.text("Le due password non coincidono");
	
  }
