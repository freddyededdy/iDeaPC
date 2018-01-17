<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import ="model.*"
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>iDeaPc</title>
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
  <script>
  $(document).ready(function(){
	    // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
	    $('.modal').modal();
	  });
$(document).ready(function(){
    $('.slider').slider();
  });
$('.slider').slider('pause');
//Start slider
$('.slider').slider('start');
//Next slide
$('.slider').slider('next');
//Previous slide
$('.slider').slider('prev');
   </script>
  <script type="text/javascript">

  $( document ).ready(function(){
	  $(".button-collapse").sideNav();
  });
 </script> 

</head>
<body class="body">

<%	
	HttpSession sessione = request.getSession();
Carrello carrello=(Carrello)sessione.getAttribute("carrello");
if(carrello==null){
 
  carrello=new Carrello();
}
	
	Cliente cliente=(Cliente)sessione.getAttribute("cliente");
	
	
	
	%>
      
		<header class="mainheader">
   <div class="parallax-container" style="height:400px">
      <div class="parallax"><img src="pizzeria1.png"></div>
      <div style="	float:right;	background-color: rgba(255,255,255,0.5)  ;   border-radius:5px; 	-moz-border-radius:5px;     -webkit-border-radius:5px;
    padding: 2% 2% 2% 2%;
    margin:3% 4%;
    position:relative;">
    
    
    <%
    
    if (cliente==null){ %>
     <!-- Modal Trigger -->
  <a class="waves-effect waves-light btn" href="#modal1">LOGIN</a>

  <!-- Modal Structure -->
  <div id="modal1" class="modal">
    <div class="modal-content">
      <h4>LOGIN!</h4>
          <FORM class="formlogin" ACTION= "LoginController" METHOD="post" target="_self" style=" margin:2% 2%;">
EMAIL
<INPUT TYPE="email"  placeholder="inserisci l'email" required NAME="email" style="color:black;"><BR>
PASSWORD
<INPUT TYPE="password" placeholder="Inserisci la password" required NAME="pass"><BR>
<span><INPUT class="btn small"   style="vertical-align:middle" TYPE="SUBMIT" VALUE="LOGIN"> </span>

</FORM>
 <a href="Registrati.jsp" style="float:inside; margin:0px 0px; ">
    <button class=" btn" type="submit" >REGISTRATI</button>
</a>
    </div>

  </div>
  <%} else {
		
		%>
<p style=" text-align:center;"><i class="small material-icons">perm_identity</i> Ciao <%=cliente.getNome() %></p>  
<div class="btn-group red">
  <form action= "LogoutController" method = "post" class="btn btn-primary"  > 
  <button type="submit" class="btn btn-primary dropdown-toggle">
  </button>
  </form>
    <span class="caret"></span>
</div>
 <button class="btn btn-primary" onclick = "location.href='carrello.jsp'"><i class="material-icons">shopping_cart</i></button>
    </div>
    </div>

    </div>
        
   <%} %>
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
					<p class="post-info">home</p>
				</footer>

			
				 <p>Bevenuti sul sito di mike's pizza.
				 Sei un nuovo utente?
				 Procedi al login!

			</article>
			<article class="bottoncontent">
				<header>
					<h4>
						Galleria!
					</h4>
				</header>

 <div class="slider">
    <ul class="slides">
      <li>
        <img src="mike's.png"> <!-- random image -->
        <div class="caption center-align">
          <h3>Questo è il nostro ristorante</h3>
          <h5 class="light grey-text text-lighten-3">Vienici a trovare</h5>
        </div>
      </li>
      <li>
        <img src="http://static.salepepe.it/files/2016/04/pizza.jpg"> <!-- random image -->
        <div class="caption left-align">
          <h3>Piatti ottimi....</h3>
          <h5 class="light grey-text text-lighten-3">solo per te!</h5>
        </div>
      </li>
      <li>
        <img src="http://cateringit.altervista.org/wp-content/uploads/2014/10/come-sceglie-unimpresa-di-catering-i-camerieri.jpg"> <!-- random image -->
        <div class="caption right-align">
          <h3>Un servizio!</h3>
          <h5 class="light grey-text text-lighten-3">....che solo in pochi ti possono offrire!</h5>
        </div>
      </li>
      <li>
        <img src="http://2night.s3.amazonaws.com/pics/articles/cropped/1600x800/8de/5656dda1c9f56b4ad66fbd62.jpg"> <!-- random image -->
        <div class="caption center-align">
          <h3>Prodotti DOC</h3>
          <h5 class="light grey-text text-lighten-3">La provenienza fa la differenza!</h5>
        </div>
      </li>
    </ul>
  </div>
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
                  <li><a class="indexloggato.jsp" href="indexLoggato.jsp">HOME</a></li>
                  <li><a class="menuutenteloggato.jsp" href="menuutenteloggato.jsp">MENU</a></li>
                  <li><a class="contattiutente.jsp" href="contattiutente.jsp">CONTATTI</a></li>
                </ul>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            </div>
          </div>
        </footer>

<% 
		if(cliente!=null){	
		sessione.setAttribute("carrello", carrello);
		sessione.setAttribute("cliente", cliente);
		}else{
			
		}
		%>



</body>
</html>