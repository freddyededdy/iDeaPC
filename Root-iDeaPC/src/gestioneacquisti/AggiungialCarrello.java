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
 * AggiungialCarrello
 * Servlet che aggiunge i prodotti al carrello
 */
@WebServlet("/AggiungialCarrello")
public class AggiungialCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProdottoDS prodottods = new ProdottoDS();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungialCarrello() {
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
		
		boolean presente=false;  //diventerà true quando il carrello conterrà già prodotti con quell'id
		int id_prod	= Integer.parseInt(request.getParameter("id_prod"));
		int quantita=Integer.parseInt(request.getParameter("quantita"));	//quantita ordinata nello store
		if(quantita != 0){
		ArrayList<Prodotto>prodotticarrello=carrello.getOggettiCarrello();
		Prodotto pr = new Prodotto();
		try {
			pr = prodottods.findByKey(id_prod);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pr.setQuantità(pr.getQuantità()-quantita);
		try {
			prodottods.update(pr);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i<prodotticarrello.size(); i++){
			if(id_prod==prodotticarrello.get(i).getId_prod()){
				int vq=prodotticarrello.get(i).getQuantitaCarrello();
				prodotticarrello.get(i).setQuantitaCarrello(quantita+vq);
				presente=true;
			}
		}

		if(!presente){
			Prodotto prodotto = null;
			try {
				prodotto = prodottods.findByKey(id_prod);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			prodotto.setQuantitaCarrello(quantita);
			

			carrello.aggiungi(prodotto);
			
		}
		}
		session.setAttribute("carrello", carrello);
		RequestDispatcher dispatcher;
		dispatcher = getServletContext().getRequestDispatcher("/menuutenteloggato.jsp");
		dispatcher.forward(request,response);
	}

}
