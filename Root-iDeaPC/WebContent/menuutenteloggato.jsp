<%@ 
page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@
     page
	import="gestioneprodotti.*, model.*, java.util.ArrayList, java.util.Collection, java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>iDeaPC</title>
<link rel="stylesheet" type="text/css" href="assets/css/styles.css">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
<link href="http://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
<script type="text/javascript">
	function myFunction() {
		// Declare variables 
		var input, filter, table, tr, td, i;
		input = document.getElementById("myInput");
		filter = input.value.toUpperCase();
		table = document.getElementById("myTable");
		tr = table.getElementsByTagName("tr");

		// Loop through all table rows, and hide those who don't match the search query
		for (i = 0; i < tr.length; i++) {
			td = tr[i].getElementsByTagName("td")[0];
			if (td) {
				if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
					tr[i].style.display = "";
				} else {
					tr[i].style.display = "none";
				}
			}
		}
	}
</script>

<script type="text/javascript">

$(document).ready(function(){
  $('.parallax').parallax();
});
$(document).ready(function(){
    // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
    $('.modal').modal();
  });
  </script>
</script>

<script type="text/javascript">
/**
 * bottone per diminuire la quantità nel carrello
 * controllo anche che la quantità inserita non sia un numero minore o uguale a zero
 */
function dif(index , indexp){
 var newcur;
 var cur=eval(document.getElementById(index).value);
 console.log("valore cur "+cur);
 if(cur > 0){
	 newcur=cur-1;
	 document.getElementById(indexp).value=newcur;
	 document.getElementById(index).value=newcur;
	
 }else{
	 alert("impossibile aggiungere al carrello un prodotto negativo riprovare");
 }
  
 
 console.log("new current " +newcur);
  console.log("Fuori form "+document.getElementById(index).value);

}
</script>

<script>
  function loadDoc() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	var valore = xhttp.getResponseHeader("ord");
	    	if(valore == 1){
	    		alert("Devi prima effettuare il login!");
	    		open("indexLoggato.jsp", "_SELF");
	    	}
	    	if(valore == 2){
	    		open("OrdiniEffettuati.jsp", "_SELF");
	    	}
	    	else{
	    		alert("ERRORE");
	    	}
	    }
	  };
	  xhttp.open("POST", "visualizzafatture", false);
	  xhttp.send();
	}
 </script>

<script type="text/javascript">
/**
 * bottone per aumentare la quantità nel carrello
 * controllo anche che la quantità non superi la quantita massima nel magazzino
 */
function add(index , indexp , indexk , indexc){
	var  quant = eval(document.getElementById(indexk).value);
 	var  newcur;
 	var cur=eval(document.getElementById(index).value);
 	if(quant == 0){
		document.getElementById(indexc).disabled=true;
	}
 	if(quant > cur){
 	 	newcur=cur+1;
 	 	document.getElementById(indexp).value=newcur;
 	 	document.getElementById(index).value=newcur;
 	 	}else{
 	 	alert("disponibilità in magazzino terminate")	
 	 	}
 	

}


</script>
<script type="text/javascript">
function islog(cliente){
	if(cliente==null){
		 var cells = document.getElementsByClassName("bottonelog");
		    for (var i = 0; i < cells.length; i++) { 
		        cells[i].disabled = true;
		    }
		    	
		    }
			
	}
	

</script>

<script type="text/javascript">

  $( document ).ready(function(){
	  $(".button-collapse").sideNav();
  });
 </script>
<head>
<%
	 HttpSession sessione = request.getSession();
 if(sessione!=null){
	 int indexc = 8000;
           Carrello carrello=(Carrello)sessione.getAttribute("carrello");
           Cliente cliente=(Cliente)sessione.getAttribute("cliente");
       		%>

<body class="body" onload="islog(<%=cliente%>)">
	<header class="mainheader">
	<div class="parallax-container" style="height: 400px">
		<div class="parallax">
			<img src="ideapc.jpeg">
		</div>
		<div
			style="float: right; background-color: rgba(255, 255, 255, 0.5); border-radius: 5px; -moz-border-radius: 5px; -webkit-border-radius: 5px; padding: 2% 2% 2% 2%; margin: 3% 4%; position: relative;">
			<%
    
    if (cliente==null){
    	%>
			<!-- Modal Trigger -->
			<a class="waves-effect waves-light btn" href="#modal1">LOGIN</a>

			<!-- Modal Structure -->
			<div id="modal1" class="modal">
				<div class="modal-content">
					<h4>LOGIN!</h4>
					<FORM class="formlogin" ACTION="LoginController" METHOD="post"
						target="_self" style="margin: 2% 2%;">
						EMAIL <INPUT TYPE="email" maxlenght = "30" placeholder="inserisci l'email" required
							NAME="email" style="color: black;"><BR> PASSWORD <INPUT
							TYPE="password" maxlenght = "16" placeholder="Inserisci la password" required
							NAME="pass"><BR> <span><INPUT
							class="btn small" style="vertical-align: middle" TYPE="SUBMIT"
							VALUE="LOGIN"> </span>

					</FORM>
					<a href="Registrati.jsp" style="float: inside; margin: 0px 0px;">
						<button class=" btn" type="submit">REGISTRATI</button>
					</a>
				</div>

			</div>
			<%
			} else {
		
		%>
			<p style="text-align: center;">
				<i class="small material-icons">perm_identity</i> Ciao
				<%=cliente.getNome() %></p>
			<form action="LogoutController" method="post" class="btn btn-primary"
				style="padding: 0">
				<button class="btn btn-primary" type="submit">Logout</button>
			</form>
			<span class="caret"></span>
			<button class="btn btn-primary"
				onclick="location.href='carrello.jsp'">
				<i class="material-icons">shopping_cart</i>
			</button>
		</div>
	</div>

	</div>

	<%
	} 
	%> </header>
	<nav>
	<div class="nav-wrapper">
		<a href="#" data-activates="mobile-demo" class="button-collapse"><i
			class="material-icons">menu</i></a>
		<ul id="nav-mobile" class="left hide-on-med-and-down"
			style="margin: 0px 20px">

			<li><a href="indexLoggato.jsp">HOME</a></li>
			<li><a href="menuutenteloggato.jsp">PRODOTTI</a></li>
			<li><a href="contattiutente.jsp">CONTATTI</a>
			<li><a href="#" onclick="loadDoc()">ORDINI EFFETTUATI</a></li>
		</ul>
		<ul class="side-nav" id="mobile-demo">
			<li><a href="menuutenteloggato.jsp">PRODOTTI</a></li>
			<li><a href="contattiutente.jsp">CONTATTI</a>
			<li><a href="OrdiniEffettuati.jsp">ORDINI EFFETTUATI</a></li>
		</ul>
	</div>

	</nav>


	<br>
	<br>
	<div class="MainContent">

		<div class="content">
			<article class="topcontent"> <header>
			<h2>
				<a href="#" title="first post">Lista dei prodotti</a>
			</h2>
			</header> <footer>
			<p class="post-info">Prodotti di ultima generazione!</p>
			</footer>


			<div style="overflow-x: auto;">
				<input type="text" id="myInput" onkeyup="myFunction()"
					placeholder="Search for names..">

				<table id="myTable" class="bordered" class="responsive-table">
					<%
					
					ProdottoDS prodottoDS = new ProdottoDS();
					Collection<Prodotto> prodotti = new LinkedList<Prodotto>();
					try {
						prodotti = prodottoDS.findAll();
						
					} catch (Exception e) {
						e.printStackTrace();
					};
					%>
					<tr>
						<th>Nome</th>
						<th>Immagine prodotto</th>
						<th>descrizione</th>
						<th>prezzo</th>
						<th>quantita'</th>
						<th>disponibilita'</th>
						<th>aggiungi al carrello</th>
						<th></th>

					</tr>



					<%	
        
				ArrayList<Prodotto> listaProdotti = new ArrayList<Prodotto>();
					Iterator<?> it = prodotti.iterator();
					int index=0;
				    int indexp = 1000;
				    int indexk = 5000;
					while (it.hasNext()) {
						
						Prodotto pr = (Prodotto) it.next();
				%>
					<tr>
						<td><%=pr.getNome()%></td>
						<td><img class="materialboxed" width="130"
							src="<%=pr.getImmagine() %>"></td>
						<td><%=pr.getDescrizione()%></td>
						<td><%=pr.getPrezzo()%></td>
						<td>
							<div class="quantity-widget">

								<button class="less small waves-effect waves-light btn"
									onClick="dif(<%=index%> , <%=indexp%> , <%=indexk%> )">-</button>
								<input type="text" disabled value="0" id="<%=index%>"
									style="color: black">
								<button class="more small waves-effect waves-light btn"
									onClick="add(<%=index%> , <%=indexp%> , <%=indexk%> ,<%=indexc%> )">+
								</button>
							</div>
						</td>
						<td><input type="text" disabled name="quantitamagazzino"
							value="<%=pr.getQuantità()%>" id="<%=indexk%>"
							style="color: black"></td>

						<td>

							<form action="AggiungialCarrello" method="post">
								<input type="hidden" name="quantita" id="<%=indexp%>" value="0" />
								<input type="hidden" name="id_prod" value="<%=pr.getId_prod()%>" />
								<button type="submit" id="<%=indexc%>" class="bottonelog">CARRELLO</button>
							</form>
						</td>


					</tr>
					<%
               index+=1;
               indexp+=1;
               indexk+=1;
               indexc+=1;
               } 
               %>



				</table>

			</div>
			</article>


		</div>
	</div>



	<footer class="page-footer" style="margin:70px 0px -500px -0px;">
	<div class="container">
		<div class="row">
			<div class="col l6 s12">
				<h5 class="white-text">Pagina riassuntiva</h5>
				<p class="grey-text text-lighten-4">Link presenti nella barra di
					navigazione.</p>
			</div>
			<div class="col l4 offset-l2 s12">
				<h5 class="white-text">LINK</h5>
				<ul>
					<li><a class="indexloggato.jsp" href="indexLoggato.jsp">HOME</a></li>
					<li><a class="menuutenteloggato.jsp"
						href="menuutenteloggato.jsp">PRODOTTI</a></li>
					<li><a class="contattiutente.jsp" href="contattiutente.jsp">CONTATTI</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="footer-copyright">
		<div class="container"></div>
	</div>
	</footer>

	<%
	sessione.setAttribute("cliente", cliente);
sessione.setAttribute("carrello", carrello);	 

 			
	 }else{
		 
	 }
 		%>

</body>
</html>