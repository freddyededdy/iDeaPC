package gestioneprodotti;

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

import model.Prodotto;
import model.ProdottoDS;

/**
 * Servlet implementation class ModificaProdottoController
 */
@WebServlet("/ModificaProdottoController")
public class ModificaProdottoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdottoDS prodottods = new ProdottoDS();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificaProdottoController() {
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
		
		String nome = request.getParameter("nome");
		String descrizione = request.getParameter("descrizione");
		double prezzo =Double.parseDouble(request.getParameter("prezzo"));
		int id = Integer.parseInt(request.getParameter("id"));
		String immagine = request.getParameter("immagine");
		int quantita = Integer.parseInt(request.getParameter("quantita"));
		if(immagine == ""){ 
			immagine=request.getParameter("immagineO");

		}else { 
			immagine = request.getParameter("immagine");
		}
		Prodotto prod = new Prodotto(id , nome , descrizione , prezzo, immagine, quantita);
		System.out.println(prod.toString());
		try {
			prodottods.update(prod);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		RequestDispatcher view = request.getRequestDispatcher("gestione-prodotto.jsp");
//		view.forward(request, response);
	}
}