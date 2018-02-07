<%@ 
page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@
 page import="model.Cliente"%>
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
	$(document).ready(function() {
		$('.parallax').parallax();
	});
</script>
<script type="text/javascript">

  $( document ).ready(function(){
	  $(".button-collapse").sideNav();
  });
 </script>

</head>
<body class="body">
	<%
try{
		HttpSession sessione = request.getSession();
		Cliente cliente=(Cliente)sessione.getAttribute("cliente");		
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
				Admin</p>
			<div class="btn-group red">
				<a href="Logout.jsp" class="btn btn-primary">Logout</a>


			</div>

		</div>
	</div>

	</div>


	</header>


	</header>
	<nav>
	<div class="nav-wrapper">


		<a href="#" data-activates="mobile-demo" class="button-collapse"><i
			class="material-icons">menu</i></a>
		<ul id="nav-mobile" class="left hide-on-med-and-down"
			style="margin: 0px 20px">

			<li><a href="Admin.jsp"> Home admin</a></li>
			<li><a href="gestione-prodotto.jsp"> gestione prodotti</a></li>
			<form action="visualizzatuttelefattureA" method="post">
				<li><button type="submit">ORDINI EFFETTUATI</button></li>
			</form>
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

			<h4>Benvenuto amministratore!</h4>

			</header> <footer>
			<p class="post-info">Modifica o aggiungi prodotti...</p>
			</footer>


			<div class="row">
				<div class="col s12 m7">
					<div class="card">
						<div class="card-image">
							<img src="pizzeria3.jpg"> <span class="card-title">Gestione
								prodotti</span>
						</div>
						<div class="card-content">
							<p>Questa è la sezione dedicata all'aggiunta o alla modifica
								dei prodotti della casa</p>
						</div>
						<div class="card-action">
							<a href="gestione-prodotto.jsp">Vai alla sezione!</a>
						</div>
					</div>
				</div>
			</div>


			<div class="row">
				<div class="col s12 m7">
					<div class="card">
						<div class="card-image">
							<img src="pizzeria3.jpg"> <span class="card-title">Gestione
								clienti</span>
						</div>
						<div class="card-content">
							<p>Questa è la sezione dedicata alla modifica dei dati dei
								clienti iscritti al sito!</p>
						</div>
						<div class="card-action">
							<a href="gestione-cliente.jsp">Vai alla sezione!</a>
						</div>
					</div>
				</div>
			</div>

			<div class="row">
				<div class="col s12 m7">
					<div class="card">
						<div class="card-image">
							<img src="pizzeria3.jpg"> <span class="card-title">Gestione
								ordinazioni</span>
						</div>
						<div class="card-content">
							<p>Questa è la sezione dedicata alla gestione delle
								ordinazioni effettutate dagli iscritti al sito</p>
						</div>
						<div class="card-action">
							<a href="OrdiniEffettuatiTuttiA.jsp">Vai alla sezione!</a>
						</div>
					</div>
				</div>
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
					<li><a href="gestione-cliente.jsp">gestione clienti</a></li>

					<li><a href="OrdiniEffettuatiTuttiA.jsp">gestione ordine</a></li>
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
			}catch(Exception e){
		response.sendRedirect("erroreaccesso.jsp");
		}
		%>

</body>
</html>