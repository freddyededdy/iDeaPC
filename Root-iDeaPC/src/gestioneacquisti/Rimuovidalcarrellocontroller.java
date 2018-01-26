package gestioneacquisti;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrello;
import model.Prodotto;
import model.ProdottoDS;

/**
 * RimuovidalCarrellocontroller
 * Servlet che rimuove l'oggetto selezionato dal carello
 */
@WebServlet("/Rimuovidalcarrellocontroller")
public class Rimuovidalcarrellocontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProdottoDS prodottods = new ProdottoDS();


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Rimuovidalcarrellocontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		HttpSession session = request.getSession();
		Carrello carrello =((Carrello)session.getAttribute("carrello"));
		int idprod=Integer.parseInt(request.getParameter("id_prod"));
		Prodotto pr =  new Prodotto();
		try {
			pr = prodottods.findByKey(idprod);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pr.setQuantità(pr.getQuantità()+1);
		try {
			prodottods.update(pr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Prodotto>prodcarrello=carrello.getOggettiCarrello();
		for(int i=0; i<prodcarrello.size(); i++){
			if(idprod==prodcarrello.get(i).getId_prod()){
				if(prodcarrello.get(i).getQuantitaCarrello()>1){
					int q=prodcarrello.get(i).getQuantitaCarrello();
					prodcarrello.get(i).setQuantitaCarrello(q-1);
				}else{
					carrello.rimuovi(i);
				}
			}



		}
		session.setAttribute("carrello", carrello);
		RequestDispatcher dispatcher;
		dispatcher = getServletContext().getRequestDispatcher("/carrello.jsp");
		dispatcher.forward(request,response);


	}
}