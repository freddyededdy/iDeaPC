<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="assets/css/styles.css">
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
   <!-- Compiled and minified CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/css/materialize.min.css">
 <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.2/js/materialize.min.js"></script>
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

<script type="text/javascript">
var password = document.getElementById("password")
, confirm_password = document.getElementById("confirm_password");

function validatePassword(){
if(password.value != confirm_password.value) {
  confirm_password.setCustomValidity("Passwords Don't Match");
} else {
  confirm_password.setCustomValidity('');
}
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;


  </script>
  
<title>Registrazione utente</title>
</head>
<body class="body">
<header class="mainheader">
   <div class="parallax-container" style="height:400px">
      <div class="parallax"><img src="pizzeria1.png"></div>


    </div>
   

    
        
   
	</header>
	 <nav>
    <div class="nav-wrapper">
      <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
      <ul id="nav-mobile" class="left hide-on-med-and-down" style="margin:0px 20px">
        
               <li><a href="indexLoggato.jsp">HOME</a></li>
        <li><a href="menuutenteloggato.jsp">MENU</a></li>
        <li><a href="contattiutente.jsp">CONTATTI</a>
        <form action = "visualizzafatture" method="post">
        <li><button type ="submit">ORDINI EFFETTUATI</button></li>
        </form>
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
			<article class="topcontent">
				<header>
					<h2>
						Benvenuto! 
					</h2>
				</header>

				<footer>
					<p class="post-info">Procedi con la registrazione!</p>
				</footer>
<FORM action="RegistrazioneController" method="post" >


<CENTER>

<p>Nome:</p> <INPUT TYPE="TEXT" required NAME="nome" id="nomeid" ><BR>



<p>Cognome:</p> <INPUT TYPE="TEXT" required NAME="cognome"><BR>
<p>Data di nascita:</p>  <input type="date" required name="data_nasc" max="1998-12-31" min ="1950-01-01" >
<BR>
<p>Città di  residenza:</p> <div class="citta"> <INPUT TYPE="TEXT"  class="indirizzo" NAME="citta" required> </div>
<p>Via:</p> <div class="via"> <INPUT TYPE="TEXT"placeholder="Via o piazza specificare" required NAME="via"></div>
<p>N. civico:</p> <div class="numero"> <INPUT TYPE="TEXT" NAME="numero_civico" required maxlength="5"></div><BR>
<p>Cellulare:</p> <INPUT TYPE="text" NAME="cellulare" id="cell"  required pattern=".{10,}" maxlength="10" onChange="checkcel()"><BR>
<script type="text/javascript">
function checkcel(){
	var cel=document.getElementById("cell").value;
	if(isNaN(cel)){ alert("Valore non corretto");
	document.getElementById("cell").value="";
	}
}</script>

<p>Email:</p> <INPUT name="mail" type="email" class="validate" required style="
    width: 100%;
    padding: 10px 12px;
    margin: 6px 0px;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    float: right;
    border-opacity:.8;"><BR>
<form class="pure-form">
   
        <p>Password:</p>
        <input type="password" name="password" id="pass" placeholder="inserisci una password compresa tra 8 e 16 caratteri" required pattern=".{8,}" maxlength="16" style="width: 100%;
    padding: 10px 12px;
    margin: 6px 0px;
    display: block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    float: right;
    border-opacity:.8;">
        <input type="password" placeholder="Confirm Password" id="confirm_password" required pattern=".{8,}" maxlength="16" onChange="checkpass()"
        style="    width: 100%;
    padding: 10px 12px;
    margin: 6px 0px;
    display: block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    float: right;
    border-opacity:.8;">
    <script type="text/javascript">
    function checkpass(){
    	var pas=document.getElementById("pass").value;
    	var conf_p= document.getElementById("confirm_password").value;
    	console.log("password "+pas+ " conf "+conf_p);
    	if(pas!=conf_p){
    		alert("le 2 password non coincidono");
    		document.getElementById("confirm_password").value="";
    	}
    }</script>
</form>
<span><INPUT class="button registrati"   style="vertical-align:middle" TYPE="SUBMIT" VALUE="Registrati"> </span>
</CENTER>
</FORM>
  
			
			

			</article>
			</div>
</div>



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
                  
                   <li><a class="grey-text text-lighten-3" href="index.html">HOME</a></li>
  <ul>
                  <li><a class="indexloggato.jsp" href="indexLoggato.jsp">HOME</a></li>
                  <li><a class="menuutenteloggato.jsp" href="menuutenteloggato.jsp">MENU</a></li>
                  <li><a class="contattiutente.jsp" href="contattiutente.jsp">CONTATTI</a></li>
                </ul>
                </ul>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            <a class="grey-text text-lighten-4 right" href="#!">ALTRI LINK</a>
            </div>
          </div>
        </footer>



</body>
</html>












