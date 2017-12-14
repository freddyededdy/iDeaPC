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
 * Servlet implementation class Prova
 */
@WebServlet("/Prova")
public class Prova extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdottoDS prodottods = new ProdottoDS();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Prova() {
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
		int quantita = 25;
		String action=request.getParameter("action");

		if(action!=null){
			if(action.equalsIgnoreCase("inserisciprodotto")){
				String nome = request.getParameter("nome");
				String descrizione = request.getParameter("descrizione");
				double prezzo =Double.parseDouble(request.getParameter("prezzo"));
				String path = request.getParameter("immagine");
			
				Prodotto prod = new Prodotto(1, nome , descrizione , prezzo, path , quantita);
				try {
					prodottods.insert(prod);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				RequestDispatcher view = request.getRequestDispatcher("gestione-prodotto.jsp");
				view.forward(request, response);
			}else if(action.equalsIgnoreCase("rimuoviprodotto")){
				int id=Integer.parseInt(request.getParameter("id"));
				try{
					prodottods.remove(id);
				}catch(SQLException e){

					e.printStackTrace();
				};
				RequestDispatcher view = request.getRequestDispatcher("gestione-prodotto.jsp");
				view.forward(request, response);

			}else if(action.equalsIgnoreCase("aggiornaprodotto")){
				String nome = request.getParameter("nome");
				String descrizione = request.getParameter("descrizione");
				double prezzo =Double.parseDouble(request.getParameter("prezzo"));
				int id = Integer.parseInt(request.getParameter("id"));
				String immagine = request.getParameter("immagine");
				if(immagine == ""){ 
					immagine=request.getParameter("immagineO");

				}else { 
					immagine = request.getParameter("immagine");
				}
				Prodotto prod = new Prodotto(id , nome , descrizione , prezzo, immagine, quantita);
				try {
					prodottods.update(prod);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				RequestDispatcher view = request.getRequestDispatcher("gestione-prodotto.jsp");
				view.forward(request, response);

			}else if(action.equalsIgnoreCase("ricercaprodotto")){
				int id=Integer.parseInt(request.getParameter("id"));

				try{
					prodottods.findByKey(id);
				}catch(SQLException e){

					e.printStackTrace();
				};
			}else if (action.equalsIgnoreCase("visualizzatabella")){
				try {
					ArrayList<Prodotto> prodotto = new ArrayList<Prodotto>(	prodottods.findAll());
					request.setAttribute("prodotti", prodotto);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}else{
			System.out.println("nessuna operazione eseguibile!");
		}
	}
	}


