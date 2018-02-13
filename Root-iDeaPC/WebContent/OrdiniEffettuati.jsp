<%@
 page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ 
page
	import="model.*, java.util.ArrayList, java.util.Collection, java.util.*, java.text.DecimalFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Mike's Pizza</title>
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
/**
 * controllo se un utente è loggato
 * se un utente non è loggato non può accedere alla pagina e si viene reindirizzati al catalogo
 */
function checklog(){
	if(q==0){
		alert("non sei loggato");
		window.location = "menuutenteloggato.jsp"; } 
	else return;
}</script>

  <script>
function loadDoc() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	var valore = xhttp.getResponseHeader("ord");
	    	if(valore == 1){
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

$(document).ready(function(){
  $('.parallax').parallax();
});
  </script>
<script type="text/javascript">

  $( document ).ready(function(){
	  $(".button-collapse").sideNav();
  });
 </script>
</head>
<body class="body" onLoad="checklog()">

	<%		
	try{
HttpSession sessione = request.getSession();
Carrello carrello=(Carrello)sessione.getAttribute("carrello");
Cliente cliente=(Cliente)sessione.getAttribute("cliente");
String user=cliente.getEmail();
fatturaDS fatturads= new fatturaDS();
ComposizioneDs composizioneds= new ComposizioneDs();
int id_cli=cliente.getId();
Collection<Ordine> ordiniCliente=(Collection<Ordine>)sessione.getAttribute("ordine");
	%>

	<header class="mainheader">
	<div class="parallax-container" style="height: 400px">
		<div class="parallax">
			<img src="pizzeria1.png">
		</div>
		<div
			style="float: right; background-color: rgba(255, 255, 255, 0.5); border-radius: 5px; -moz-border-radius: 5px; -webkit-border-radius: 5px; padding: 2% 2% 2% 2%; margin: 3% 4%; position: relative;">
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


	</header>

	<nav>
	<div class="nav-wrapper">
		<a href="#" data-activates="mobile-demo" class="button-collapse"><i
			class="material-icons">menu</i></a>
		<ul id="nav-mobile" class="left hide-on-med-and-down"
			style="margin: 0px 20px">

			<li><a href="indexLoggato.jsp">HOME</a></li>
			<li><a href="menuutenteloggato.jsp">MENU</a></li>
			<li><a href="contattiutente.jsp">CONTATTI</a>
			<li><a href="#" onclick="loadDoc()">ORDINI EFFETTUATI</a></li>
		</ul>
		<ul class="side-nav" id="mobile-demo">
			<li><a href="menuutenteloggato.jsp">MENU</a></li>
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
			<h5>
				<B>ORDINI EFFETTUATI</B>:
			</h5>
			</header> </article>
		</div>
	</div>



	<div class="MainContent">
		<div class="content">
			<div class="topcontent">

				<%
        		Iterator<?> it = ordiniCliente.iterator();
				while (it.hasNext()) {
					Ordine ordine = (Ordine) it.next();
					%>
				<p style="float: left;">
					ID FATTURA:
					<%=ordine.getId_ordine()%></p>
				<p style="float: right;">
					DATA FATTURA:
					<%=ordine.getData_ordine() %></p>
				<br>
				<table id="myTable">

					<tr class="header">
						<th style="width: 45%;">PRODOTTO</th>
						<th style="width: 25%;">QUANTITA</th>
						<th style="width: 30%;">PREZZO</th>

					</tr>
					<% 
					Collection<Composizione> composizione= composizioneds.findbyid_ordine(ordine.getId_ordine());
					
					%>
					<%
				Iterator<?> it2 = composizione.iterator();
			while (it2.hasNext()) {
			Composizione comp = (Composizione) it2.next();
			%>
					<tr>
						<td><%= comp.getNome_p()%></td>
						<td><%= comp.getQuantita() %></td>
						<td><%= comp.getPrezzo() %></td>
					</tr>

					<%
				}
			%>
				</table>

				<b><p style="margin: 4% 70%;">
						<%
				Fattura fattura=fatturads.findbyid_ordine(ordine.getId_ordine());
				%>
						<% 
			double impo=fattura.getImponibile(); 
			%>
						IMPONIBILE:<br>
						<%=new DecimalFormat("#.##").format(impo)
					%>
						<br>

						<% 
					double iva=((double)(fattura.getImponibile()*22)/100);
					%>
						IVA: <br>
						<%= new DecimalFormat("#.##").format(iva) 
					%>
						<br>

						<%
					double totfat=fattura.getTotale();  
					  %>
						TOTALE FATTURA:<BR>
						<%=new DecimalFormat("#.##").format(totfat)
					%></p> </b>

				__________________________________________________________________________________________________________________________________
				<br> <br> <br>
				<%
					}
				%>

			</div>
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
						href="menuutenteloggato.jsp">MENU</a></li>
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
		sessione.setAttribute("carrello", carrello);
		sessione.setAttribute("cliente", cliente);
		}catch(Exception e){
		response.sendRedirect("erroreaccesso.jsp");
		}
		%>





</body>
</html>