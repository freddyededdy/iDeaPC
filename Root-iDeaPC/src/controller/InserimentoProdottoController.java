package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Prodotto;
import model.ProdottoDS;

/**
 * Servlet implementation class InserimentoProdottoController
 */
@WebServlet("/InserimentoProdottoController")
public class InserimentoProdottoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdottoDS prodottods = new ProdottoDS();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InserimentoProdottoController() {
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
				String path = request.getParameter("immagine");
				int quantita =Integer.parseInt(request.getParameter("quantita"));
				Prodotto prod = new Prodotto(1, nome , descrizione , prezzo, path , quantita);
				try {
					prodottods.insert(prod);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
	}
	}


