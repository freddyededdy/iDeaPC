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
 * EliminaProdottoController
 * Servlet che elimina il prodotto dal database 
 */
@WebServlet("/EliminaProdottoController")
public class EliminaProdottoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdottoDS prodottods = new ProdottoDS();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminaProdottoController() {
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
		
		int id=Integer.parseInt(request.getParameter("id"));
		try{
			prodottods.remove(id);
		}catch(SQLException e){

			e.printStackTrace();
		};
		RequestDispatcher view = request.getRequestDispatcher("gestione-prodotto.jsp");
		view.forward(request, response);
	}
}