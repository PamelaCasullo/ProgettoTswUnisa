    function validate(){
            var nome=document.getElementsByName("nome_utente").value;
            var pw=document.getElementsByName("password_utente").value;


            if(nome!=''||pw!='')
                return(true);
            else{
                alert("Non hai compilato il nome utente");
                return(false);
            }
    }


 

