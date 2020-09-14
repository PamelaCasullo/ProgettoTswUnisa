<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>Carrello</title>

	<script src="../script/chart.js"></script>

</head>
<body>
  <%@include file="../header.jsp"%>
	<form class="hide d-none">
        <input id="sessionid" type="hidden" name="" value="<%=request.getSession().getId()%>">
    </form>
    
    <div class="container-fluid">
    	<table class="table">
    		<thead>
    			<tr>
    			<th>Nome Prodotto</th>
    			<th>Prezzo</th>
    			</tr>
    		</thead>
    		<tbody id="data">
    		</tbody>
    	</table>
    </div>
     <div class="modal fade" id="pagamento" tabindex="-1" role="dialog" aria-labelledby="pagamentoLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                 <div class="col-12 text-left">
                        <button type="button"  id="procedialpagamento" class=" d-none btn btn-success" data-toggle="modal" data-target="#pagamento">Procedi Al Pagamento</button>
                    </div>
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                 <div class="modal-body">
                     <span class="form-text text-center border border-success p-3 rounded m-3">
                         Totale: <span id="totalecarrello" class="text-success"></span>
                     </span>
                </div>
                </div>
                </div>
                </div>
</body>
</html>