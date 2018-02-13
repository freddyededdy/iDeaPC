<%@
 page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@
      page import="model.*"%>
<%@
     page import="gestioneprodotti.*"%>
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
/**
 * controllo sul prezzo 
 * controllo se nel campo prezzo è stato inserito un valore vuoto, minore di zero o zero, in questi casi compare un messaggio di errore
 */
	function checkPrezzo() {
		console.log("checkPrezzo");
		var prezzo = document.getElementById("prezzo").value;
		if (isNaN(prezzo)) {
			alert("inserire valore valido");
			document.getElementById("prezzo").value = "";
		}
		if (document.getElementById("prezzo").value <= 0) {
			alert("Prezzo non valido, inserito prezzo negativo!");
			document.getElementById("prezzo").value = "";
		}
	}
	/**
	*controllo sulla quantita
	*controllo se nel campo quantita è stata inserita una quanita negativa, o zero, in questi casi compare un messaggio di errrore
	*/
	function checkQuantita() {
		var quantita = document.getElementById("quantita").value;
		if (isNaN(quantita)) {
			alert("inserire valore valido");
			document.getElementById("quantita").value = "";
		}
		if (document.getElementById("quantita").value <= 0) {
			alert("Quantità non valida, inserita quantità negativa!");
			document.getElementById("quantita").value = "";
		}
	}
</script>

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
	$(document).ready(function() {
		$('.parallax').parallax();
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".button-collapse").sideNav();
	});
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
			<p style="text-align: center;">
				<i class="small material-icons"></i> Ciao Admin
			</p>
			<form action="LogoutController" method="post" class="btn btn-primary"
				style="padding: 0">
				<button class="btn btn-primary" type="submit">Logout</button>
			</form>
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

			<li><a href="Admin.jsp"> HOME ADMIN	</a></li>
			<li><a href="gestione-prodotto.jsp"> GESTIONE PRODOTTI</a></li>
			<li><a href="#" onclick="loadDoc()">TUTTI GLI ORDINI</a></li>
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
			<article class="topcontent">

			<h3>Aggiungi dati prodotto:</h3>

			<div>
				<FORM ACTION="InserimentoProdottoController" METHOD="post"
					enctype="multipart/form-data">
					<label for="fname">Immagine</label>
					<div class="file-field input-field">
						<div class="btn">
							<span>File</span> <input type="file" name="immagine">
						</div>
						<div class="file-path-wrapper">
							<input class="file-path validate" type="text">
						</div>
					</div>
					<label for="fname">Nome</label> <input type="text" name="nome" maxlength="40"
						required> <br> <label for="lname">Descrizione
					</label> <input type="text" name="descrizione"> <br> <label
						for="lname">Prezzo </label> <input type="text" name="prezzo"
						id="prezzo" onChange="checkPrezzo();" required> <br>
					<br> <label for="lname">Quantità </label> <input type="text"
						name="quantita" id="quantita" onChange="checkQuantita();" required>
					<br> <br>
					<BUTTON type="submit" class="waves-effect waves-light btn">SALVA</BUTTON>
				</FORM>
				<button type="submit" class="waves-effect waves-light btn"
					onClick="location.href='gestione-prodotto.jsp'">ANNULLA</button>

			</div>


			</article>
			<br>


			<footer class="page-footer" style="margin:70px 0px -500px -0px;">
			<div class="container">
				<div class="row">
					<div class="col l6 s12">
						<h5 class="white-text">Pagina riassuntiva</h5>
						<p class="grey-text text-lighten-4">Link presenti nella barra
							di navigazione.</p>
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
			<div class="footer-copyright">
				<div class="container"></div>
			</div>
			</footer>
</body>
</html>