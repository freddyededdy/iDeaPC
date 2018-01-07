<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page
	import="gestioneprodotti.*, model.*, java.util.ArrayList, java.util.Collection, java.util.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>iDeaPC</title>
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
  </script>
<script type="text/javascript">
function dif(index , indexp){
 var newcur;
 var cur=eval(document.getElementById(index).value);
 console.log("valore cur "+cur);
 if(cur > 1){
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
<script type="text/javascript">
function add(index , indexp , indexk){
	var  quant = eval(document.getElementById(indexk).value);
 	var  newcur;
 	var cur=eval(document.getElementById(index).value);
 	if(quant > cur){
 	newcur=cur+1;
 	document.getElementById(indexp).value=newcur;
 	document.getElementById(index).value=newcur;
 	}else{
 	alert("disponibilità in magazzino terminate")	
 	}
 	if(cur<=0){
 		document.getElementById("bottonecarrello").disabled = true;
 		console.log("soono qua");
 	}

}
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
 <%try{   
 HttpSession sessione = request.getSession();
           Carrello carrello=(Carrello)sessione.getAttribute("carrello");
           Cliente cliente=(Cliente)sessione.getAttribute("cliente");
         
       		%> 
		<header class="mainheader">
   <div class="parallax-container" style="height:400px">
      <div class="parallax"><img src="pizzeria1.png"></div>
      <div style="	float:right;	background-color: rgba(255,255,255,0.5)  ;   border-radius:5px; 	-moz-border-radius:5px;     -webkit-border-radius:5px;
    padding: 2% 2% 2% 2%;
    margin:3% 4%;
    position:relative;">
< <p style=" text-align:center;"><i class="small material-icons">perm_identity</i> Ciao <%=cliente.getNome() %></p>   -
<div class="btn-group red">
  <a href="Logout.jsp" class="btn btn-primary">Logout</a>
  <button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu " role="menu">
    <li> <a href ="visualizzadaticliente.jsp"> visualizza dati</a> </li>
  </ul>
</div>
 <button class="btn btn-primary" onclick = "location.href='carrello.jsp'"><i class="material-icons">shopping_cart</i></button>
    </div>
    </div>

    </div>
        
   
	</header>
	  <nav>
    <div class="nav-wrapper">
      <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
      <ul id="nav-mobile" class="left hide-on-med-and-down" style="margin:0px 20px">
        
         <li><a href="index utente loggato.jsp">HOME</a></li>
        <li><a href="menuutenteloggato.jsp">MENU</a></li>
        <li><a href="recensioni utente loggato.jsp">RECENSIONI</a>
        <li><a href="contatti utente loggato.jsp">CONTATTI</a>
        <li><a href="OrdiniEffettuati.jsp">ORDINI EFFETTUATI</a></li>
        
      </ul>
               <ul class="side-nav" id="mobile-demo">
      <li><a href="menuutenteloggato.jsp">MENU</a></li>
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
						<a href="#" title="first post">Lista prodotti menu</a>
					</h2>
				</header>

				<footer>
					<p class="post-info">Prodotti della casa doc.</p>
				</footer>

		
				<div style="overflow-x:auto;">
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
					}
					;%>
          <tr>
              <th>Nome</th>
              <th>Immagine prodotto</th>
              <th>descrizione</th>
              <th>prezzo</th>
              <th> quantita'</th>
              <th> disponibilita'</th>
              <th> aggiungi al carrello </th>
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
            <td> <img class="materialboxed"  width="130" src = "<%=pr.getImmagine() %>"></td>
            <td><%=pr.getDescrizione()%></td>
            <td><%=pr.getPrezzo()%></td>
   	<td >  <div class="quantity-widget"> 
    
<button class="less small waves-effect waves-light btn" onClick="dif(<%=index%> , <%=indexp%> , <%=indexk%> )">-</button> 
<input type="text" disabled   value="1" id="<%=index%>" style="color:black">
 <button class="more small waves-effect waves-light btn" onClick="add(<%=index%> , <%=indexp%> , <%=indexk%>)">+ </button>
   </div>
   </td>
   <td> <input type="text" disabled name= "quantitamagazzino"   value="<%=pr.getQuantità()%>" id="<%=indexk%>" style="color:black"> 
   
   </td>
   
   <td>

   <form action="AggiungialCarrello" method="post">
   <input type="hidden" name="quantita" id="<%=indexp%>" value = "1" />
      <input type="hidden" name="id_prod" value="<%=pr.getId_prod()%>" />
      <button type="submit" id = "bottonecarrello" class="waves-effect waves-light btn">CARRELLO</button> </form></td>
						
       
          </tr>
               <%
               index+=1;
               indexp+=1;
               indexk+=1;
               } %>
              
             
        
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
                  <li><a class="index utente loggato.jsp" href="#!">HOME</a></li>
                  <li><a class="menuutenteloggato.jsp" href="#!">MENU</a></li>
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