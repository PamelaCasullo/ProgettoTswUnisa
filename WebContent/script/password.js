	function visualPassword(k){
		 var x = $("."+k);
		if(x.attr("type")==="password"){
	  		x.attr("type","text");
	  	} else {
	  		x.attr("type", "password")
	  	}
	  	
	}





	function passwordCheck() {
		var x = $(".myInput");
	  	var y= $(".myInput1");
	
    		if(x.val()===y.val()) 
    			alert("brav");
  			else 
  				alert("cattiv");
    	
  	}
