<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page
	import="gestioneprodotti.*, model.*, java.util.ArrayList, java.util.Collection, java.util.*"%>
    
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
<head>
<body class="body">

      
		<header class="mainheader">
   <div class="parallax-container" style="height:400px">
      <div class="parallax"><img src="pizzeria1.png"></div>
      <div style="	float:right;	background-color: rgba(255,255,255,0.5)  ;   border-radius:5px; 	-moz-border-radius:5px;     -webkit-border-radius:5px;
    padding: 2% 2% 2% 2%;
    margin:3% 4%;
    position:relative;">
 <!-- Modal Trigger -->
  <a class="waves-effect waves-light btn" href="#modal1">LOGIN</a>

  <!-- Modal Structure -->
  <div id="modal1" class="modal">
    <div class="modal-content">
      <h4>LOGIN!</h4>
          <FORM class="formlogin" ACTION= "Login_Logout" METHOD="post" target="_self" style=" margin:2% 2%;">
    <input type ="hidden"  name ="action" value ="effettualogin">
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

</div>
    </div>
        
   
	</header>
	  <nav>
    <div class="nav-wrapper">
     <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
      <ul id="nav-mobile" class="left hide-on-med-and-down" style="margin:0px 20px">
        
        <li><a href="index.html">HOME</a></li>
        <li><a href="menu.jsp">MENU</a></li>
        <li><a href="recensioni.jsp">RECENSIONI</a>
        <li><a href="contatti.jsp">CONTATTI</a>
        </ul>
               <ul class="side-nav" id="mobile-demo">
      <li><a href="index.html">HOME</a></li>
        <li><a href="menu.jsp">MENU</a></li>
        <li><a href="recensioni.jsp">RECENSIONI</a>
        <li><a href="contatti.jsp">CONTATTI</a>
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
					Lista prodotti menu
					</h2>
				</header>

				<footer>
					<p class="post-info">Prodotti della casa doc.</p>
				</footer>

			<%
					
					ProdottoDS prodottoDS = new ProdottoDS();
					Collection<Prodotto> prodotti = new LinkedList<Prodotto>();
					try {
						prodotti = prodottoDS.findAll();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
					;%>
					
					<div style="overflow-x:auto;">
					<input type="text" id="myInput" onkeyup="myFunction()"
				placeholder="Search for names..">
					
				 <table id="myTable" class="bordered" class="responsive-table">
        <thead>
          <tr>
             <th>Nome</th>
              <th>Immagine prodotto</th>
              <th>descrizione</th>
              <th>prezzo</th>
              <th></th>
              </tr>
              
        </thead>

        <tbody >
            
          <%	
        
				ArrayList<Prodotto> listaProdotti = new ArrayList<Prodotto>();
					Iterator<?> it = prodotti.iterator();
					
					while (it.hasNext()) {
						
						Prodotto pr = (Prodotto) it.next();
				%>
          <tr>
         <td><%=pr.getNome()%></td> 
            <td> <img class="materialboxed"  width="130" src = "<%=pr.getImmagine() %>"></td>
            <td ><%=pr.getDescrizione()%></td>
            <td><%=pr.getPrezzo()%></td>
  </tr>
              
             
        </tbody>
        <% } %>
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
                <p class="grey-text text-lighten-4">Link presenti nella barra di navigazione.</p>
              </div>
              <div class="col l4 offset-l2 s12">
                <h5 class="white-text">LINK</h5>
                <ul>
                  <li><a class="grey-text text-lighten-3" href="#!">HOME</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">MENU</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">RECENSIONI</a></li>
                  <li><a class="grey-text text-lighten-3" href="#!">CONTATTI</a></li>
                </ul>
              </div>
            </div>
          </div>
          <div class="footer-copyright">
            <div class="container">
            © 2017 Copyright by I.RICCI, V.DELGAUDIO, A.LEONE.
            <a class="grey-text text-lighten-4 right" href="#!">ALTRI LINK</a>
            </div>
          </div>
        </footer>



</body>
</html>