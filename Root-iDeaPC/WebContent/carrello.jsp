<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page
	import="gestioneacquisti.*, gestioneprodotti.*, model.*, java.util.ArrayList, java.util.Collection, java.util.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Mike's Pizza</title>
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
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
  

$('.modal').modal({
    dismissible: true, // Modal can be dismissed by clicking outside of the modal
    opacity: .5, // Opacity of modal background
    inDuration: 300, // Transition in duration
    outDuration: 200, // Transition out duration
    startingTop: '4%', // Starting top style attribute
    endingTop: '10%', // Ending top style attribute
   
  }
);
});

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
<script type="text/javascript">
<!--
 
var stile = "top=30, left=150, width=300, height=700, status=no, menubar=no, toolbar=no scrollbars=no";
 
function Popup(apri) 
{
  window.open(apri, "", stile);
}
//-->
</script>
<script type="text/javascript">
function checkvaluecard(){
	var card=document.getElementById("cardnumber").value;
	if(isNaN(card)){ alert ("immettere codice corretto");
	document.getElementById("cardnumber").value="";
	
	}
}</script>
<script type="text/javascript">
function checkvaluepin(){
	var pin= document.getElementById("cod_s").value;
	if(isNaN(pin)){ alert ("immettere codice corretto");
	document.getElementById("cod_s").value="";
	
	}
}</script>
<script type="text/javascript">
function checkq(q){
	if(q==0){
		alert("il carrello è vuoto");
		window.location = "menuutenteloggato.jsp"; } 
	else return;
}</script>

</head>
<%
try{
HttpSession sessione = request.getSession();
          Carrello carrello=(Carrello)sessione.getAttribute("carrello");
          Cliente cliente=(Cliente)sessione.getAttribute("cliente");
          int quantità=carrello.getOggettiCarrello().size();
      		%>
<body class="body" onLoad="checkq(<%=quantità%>)">



      
		<header class="mainheader">
     <div class="parallax-container" style="height:400px">
      <div class="parallax"><img src="pizzeria1.png"></div>
      <div style="	float:right;	background-color: rgba(255,255,255,0.5)  ;   border-radius:5px; 	-moz-border-radius:5px;     -webkit-border-radius:5px;
    padding: 2% 2% 2% 2%;
    margin:3% 4%;
    position:relative;">
<p style=" text-align:center;"><i class="small material-icons">perm_identity</i> Ciao <%=cliente.getNome() %></p>  
<div class="btn-group red">
  <a href="Logout.jsp" class="btn btn-primary">Logout</a>
  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu " role="menu">
    <li> <a href ="visualizzadaticliente.jsp"> visualizza dati</a> </li>
  </ul>
</div>
 <button class="btn btn-primary" onclick ="location.href='carrello.jsp'"><i class="material-icons" >shopping_cart</i></button>
    </div>
    </div>
        
   
	</header>
	  <nav>
    <div class="nav-wrapper">
      <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
      <ul id="nav-mobile" class="left hide-on-med-and-down" style="margin:0px 20px">
        
       <li><a href="index utente loggato.jsp">HOME</a></li>
        <li><a href="menu utente loggato.jsp">MENU</a></li>
        <li><a href="recensioni utente loggato.jsp">RECENSIONI</a>
        <li><a href="contatti utente loggato.jsp">CONTATTI</a>
        <li><a href="OrdiniEffettuati.jsp">ORDINI EFFETTUATI</a></li>
        
      </ul>
              <ul class="side-nav" id="mobile-demo">
      <li><a href="menu utente loggato.jsp">MENU</a></li>
        <li><a href="recensioni utente loggato.jsp">RECENSIONI</a>
        <li><a href="contatti utente loggato.jsp">CONTATTI</a>
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
						<h1>Lista prodotti carrello</h1>
					</h2>
				</header>

				<footer>
					<p class="post-info">Prodotti della casa doc.</p>
				</footer>

			<% 
	          ArrayList <Prodotto> prodotticarrello = carrello.getOggettiCarrello();
					%>
				 <table class="bordered" class="responsive-table">
        <thead>
          <tr>
              <th>Immagine prodotto</th>
              <th>Nome</th>
              <th>descrizione</th>
              <th>prezzo</th>
              <th> quantità</th>
              <th> rimuovi dal carrello</th>
              <th></th>
             
          </tr>
        </thead>

        <tbody>
            
          <%	
					Iterator<?> it = prodotticarrello.iterator();
					while (it.hasNext()) {
						Prodotto pr = (Prodotto) it.next();
				%>
          <tr> 
         <td> <img class="materialboxed"  width="250" src = "<%=pr.getImmagine() %>"></td>
           <td><%=pr.getNome()%></td>
           <td><%=pr.getDescrizione()%></td>
            <td><%=pr.getPrezzo()%></td>
            <td><%=pr.getQuantitaCarrello() %></td> 
            
            <form action="CarrelloController" method="post">
			  <input type="hidden" name="action" value="rimuoviDalCarrello"/>
			    <input type="hidden" name="id_prod" value="<%=pr.getId_prod()%>" />
			<td><button type="submit" class="waves-effect waves-light btn">  
			<i class="tiny material-icons">delete</i></button></td> 
			</form>
       
          </tr>
               <%} %>
              
             
        </tbody>
      </table>
       <form action = "CarrelloController"  method = "post">    
<button type="submit" class="waves-effect waves-light btn"> SVUOTA CARRELLO <i class="tiny material-icons">delete</i></button>
  <input type="hidden" name="action" value="rimuovitutto"/>
  </form> 
  <form action = "OrdineController" method ="post">
<a class="waves-effect waves-light btn" href="#modal"> CONFERMA ORDINE <i class="tiny material-icons">done</i></a>
<div id="modal" class="modal">
    <div class="modal-content">
      <h4>Inserire coordinate pagamento:</h4>
     <form method="post">
<fieldset>
  <legend>Dettagli carta:</legend>
  <ol>
    <li>
      <fieldset>
        <legend>Tipo carta:</legend>
        <ol>
          <li>
            <input id=visa name=cardtype value="visa" type=radio required>
            <label for=visa>VISA</label>
          </li>
          <li>
            <input id=amex name=cardtype value="PostePay" type=radio required>
            <label for=amex>PostePay</label>
          </li>
          <li>
            <input id=mastercard name=cardtype value="MasterCard" type=radio required>
            <label for=mastercard>Mastercard</label>
          </li>
        </ol>
      </fieldset>
    </li>
    <li>
      <label for=cardnumber>Coordinate bancarie:</label>
      <input id="cardnumber" name=cardnumber type="text" required pattern=".{16,}" maxlength="16" onChange="checkvaluecard()">
    </li>
    <li>
      <label for=secure>Codice sicurezza:</label>
      <input id="cod_s" name=secure type="text" required pattern=".{4,}" maxlength="4" onChange="checkvaluepin()">
    </li>
    
  </ol>
</fieldset>
 


    </div>
    <div class="modal-footer">
     <form></form>
     
  <button type="submit" class="waves-effect waves-light btn" >Paga adesso!</button>
</form>
    </div>
    </form>
  </div>




</form>
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
                  <li><a class="index utente loggato.jsp" href="#!">HOME</a></li>
                  <li><a class="menu utente loggato.jsp" href="#!">MENU</a></li>
                  <li><a class="recensioni utente loggato.jsp" href="#!">RECENSIONI</a></li>
                  <li><a class="contatti utente loggato.jsp" href="#!">CONTATTI</a></li>
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



        <% 
sessione.setAttribute("cliente", cliente);
               sessione.setAttribute("carrello", carrello);
               }catch(Exception e){
		response.sendRedirect("erroreaccesso.jsp");
		}%>



</body>
</html>