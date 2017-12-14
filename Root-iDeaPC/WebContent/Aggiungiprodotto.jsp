<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import ="model.*"%>
     <%@page import = "gestioneprodotti.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>iDeaPC Admin</title>
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
	function checkPrezzo(){
		console.log("checkPrezzo");
		var prezzo = document.getElementById("prezzo").value;
		if(isNaN(prezzo)){
			alert("inserire valore valido");
			document.getElementById("prezzo").value = "";
		}
		if(document.getElementById("prezzo").value <= 0){
			alert("Prezzo non valido, inserito prezzo negativo!");
		}
	}
	function checkQuantita(){
		var quantita = document.getElementById("quantita").value;
		if(isNaN(quantita)){
			alert("inserire valore valido");
			document.getElementById("quantita").value = "";
		}
		if(document.getElementById("quantita").value <= 0){
			alert("Quantità non valida, inserita quantità negativa!");
		}
	}
	</script>
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
     <div class="parallax-container" style="height:400px">
      <div class="parallax"><img src="pizzeria1.png"></div>
      <div style="	float:right;	background-color: rgba(255,255,255,0.5)  ;   border-radius:5px; 	-moz-border-radius:5px;     -webkit-border-radius:5px;
    padding: 2% 2% 2% 2%;
    margin:3% 4%;
    position:relative;">
<p style=" text-align:center;"><i class="small material-icons">perm_identity</i> Ciao </p>  
<div class="btn-group red">
  <a href="Logout.jsp" class="btn btn-primary">Logout</a>
</div>
    </div>
    </div>

    </div>
        
   
	</header>
			<nav>
			<div class="nav-wrapper">
				
					 <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
				<ul id="nav-mobile" class="left hide-on-med-and-down"
					style="margin:0px 20px">

					<li><a href="Admin.jsp"> Home admin</a></li>
					<li><a href="gestione-cliente.jsp">gestione clienti</a></li>
					<li><a href="gestione-prodotto.jsp"> gestione prodotti</a></li>
					<li><a href="OrdiniEffettuatiTuttiA.jsp">gestione ordine</a></li>
				</ul>
        <ul class="side-nav" id="mobile-demo">
		<li><a href="Admin.jsp"> Home admin</a></li>
					<li><a href="gestione-cliente.jsp">gestione clienti</a></li>
					<li><a href="gestione-prodotto.jsp"> gestione prodotti</a></li>
					<li><a href="OrdiniEffettuatiTuttiA.jsp">gestione ordine</a></li>
      </ul>
			</div>
 </nav>

			<br> <br>
			<div class="MainContent">

				<div class="content">
					<article class="topcontent"> 
					
<h3>Aggiungi dati prodotto:</h3>

	<div>
 <FORM ACTION="InserimentoProdottoController" METHOD="post">
   <label for="fname">Immagine</label>
     <div class="file-field input-field">
      <div class="btn">
        <span>File</span>
        <input type="file" name="immagine">
      </div>
      <div class="file-path-wrapper">
        <input class="file-path validate" type="text" >
      </div>
    </div>
    <label for="fname">Nome</label>
    <input type="text"   name="nome" required>
<br>
    <label for="lname">Descrizione </label>
    <input type="text"   name="descrizione">
<br>
        <label for="lname">Prezzo </label>
    <input type="text"   name="prezzo" id = "prezzo" onChange="checkPrezzo();" required>
 	<br>
<br>
        <label for="lname">Quantità </label>
    <input type="text"   name="quantita" id = "quantita" onChange="checkQuantita();" required>
 	<br>
 	<br>
    <BUTTON type="submit" class="waves-effect waves-light btn" >SALVA</BUTTON>
    </FORM>
	<button type="submit" class="waves-effect waves-light btn" onClick ="location.href='gestione-prodotto.jsp'" >ANNULLA</button>
 	
</div>


					</article>
<br>

	
        <footer class="page-footer" style="margin:70px 0px -500px -0px;">
          <div class="container">
            <div class="row">
              <div class="col l6 s12">
                <h5 class="white-text">Pagina riassuntiva</h5>
                <p class="grey-text text-lighten-4">Link presenti nella barra di navigazione.</p>
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
            <div class="container">
            Â© 2017 Copyright by I.RICCI, V.DELGAUDIO, A.LEONE.
         
            </div>
          </div>
        </footer>


			
</body>
</html>