
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
	
<script>
function loadDoc() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    		open("OrdiniEffettuatiTuttiA.jsp", "_SELF");
	    }
	  };
	  xhttp.open("POST", "visualizzatuttelefattureA", false);
	  xhttp.send();
	}
</script>
	
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

  $( document ).ready(function(){
	  $(".button-collapse").sideNav();
  });
 </script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.parallax').parallax();
	});
</script>
<script type="text/javascript">
<!--
	var stile = "top=30, left=150, width=300, height=700, status=no, menubar=no, toolbar=no scrollbars=no";

	function Popup(apri) {
		window.open(apri, "", stile);
	}
//-->
</script>
</head>
<body class="body">

	<header class="mainheader">
	<div class="parallax-container" style="height: 400px">
		<div class="parallax">
			<img src="ideapc.jpeg">
		</div>
		<div
			style="float: right; background-color: rgba(255, 255, 255, 0.5); border-radius: 5px; -moz-border-radius: 5px; -webkit-border-radius: 5px; padding: 2% 2% 2% 2%; margin: 3% 4%; position: relative;">
			 <p style=" text-align:center;"><i class="small material-icons">perm_identity</i> Ciao Admin <p>   
			<div class="btn-group red">
			<form action="LogoutController" method="post" class="btn btn-primary"
				style="padding: 0">
				<button class="btn btn-primary" type="submit">Logout</button>
			</form>


			</div>

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

			<li><a href="Admin.jsp"> HOME ADMIN</a></li>
			<li><a href="gestione-prodotto.jsp"> GESTIONE PRODOTTI</a></li>
			<li><a href="#" onclick="loadDoc()">TUTTI GLI ORDINI</a></li>
		

			<% System.out.println(session.getId()); %>
		</ul>
		<ul class="side-nav" id="mobile-demo">
			<li><a href="Admin.jsp"> Home admin</a></li>
			<li><a href="gestione-prodotto.jsp"> gestione prodotti</a></li>
			<li><a href="OrdiniEffettuatiTuttiA.jsp">gestione ordine</a></li>
		</ul>
	</div>
	</nav>

	<br>
	<br>
	<div class="MainContent">

		<div class="content">
			<article class="topcontent"> <header>
			<h2>
				Gestione prodotti
				<form action="Aggiungiprodotto.jsp" method="post">
					<button type="submit" class="waves-effect waves-light btn"
						alt="Aggiungiprodotto" title="Aggiungi prodotto"
						style="float: right;">
						<i class="tiny material-icons">playlist_add</i>
					</button>
				</form>
			</h2>
			</header> <footer>
			<p class="post-info">rimuovi o aggiungi prodotti..</p>
			</footer>
			<div style="overflow-x: auto;">


				<input type="text" id="myInput" onkeyup="myFunction()"
					placeholder="Search for names..">

				<table id="myTable">

					<%
					ProdottoDS prodottoDS = new ProdottoDS();
					Collection<Prodotto> prodotti = new LinkedList<Prodotto>();
					try {
						prodotti = prodottoDS.findAll();
						
					} catch (Exception e) {
						e.printStackTrace();
					};
				%>
					<tr class="header">
						<th style="width: 25%;">Nome prodotto</th>
						<th style="width: 200%;">immagine del prodotto</th>
						<th style="width: 25%;">Descrizione prodotto</th>
						<th style="width: 10%;">Prezzo prodotto</th>
						<th style="width: 10%;">Quantià prodotto</th>
						<th style="width: 10%;">Modifica/Rimuovi prodotto</th>
					</tr>
					<% 
				
				ArrayList<Prodotto> listaProdotti = new ArrayList<Prodotto>();
				
					Iterator<?> it = prodotti.iterator();
					while (it.hasNext()) {
						Prodotto pr = (Prodotto) it.next();
				%>
					<tr>
						<td><%=pr.getNome()%></td>
						<td><img class="materialboxed" width="130"
							src="<%=pr.getImmagine() %>"></td>
						<td><%=pr.getDescrizione()%></td>
						<td><%=pr.getPrezzo()%></td>
						<td><%= pr.getQuantità()%></td>
						<td>


							<form action="modificaprodotto.jsp" method="post">
								<input type="hidden" name="id" value="<%=pr.getId_prod()%>" />
								<button type="submit" class="waves-effect waves-light btn">
									<i class="tiny material-icons">mode_edit</i>
								</button>
							</form>
							<form action="EliminaProdottoController" method="post">
								<input type="hidden" name="id" value="<%=pr.getId_prod()%>" />
								<button type="submit" class="waves-effect waves-light btn">
									<i class="tiny material-icons">delete</i>
								</button>
							</form>
						</td>
					</tr>

					<%
				listaProdotti.add(pr);
				
					}
					 session.setAttribute("prodotto", listaProdotti);
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
					<li><a href="gestione-prodotto.jsp"> gestione prodotti</a></li>

					<li><a href="OrdiniEffettuatiTuttiA.jsp">gestione ordine</a></li>
				</ul>
			</div>
		</div>
	</div>

	</footer>





</body>
</html>