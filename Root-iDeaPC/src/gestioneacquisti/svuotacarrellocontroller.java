package gestioneacquisti;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrello;
import model.ProdottoDS;

/**
 * Servlet implementation class svuotacarrellocontroller
 */
@WebServlet("/svuotacarrellocontroller")
public class svuotacarrellocontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static ProdottoDS prodottods = new ProdottoDS();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public svuotacarrellocontroller() {
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
		carrello.rimuovitutto();
		session.setAttribute("carrello", carrello);
		RequestDispatcher dispatcher;
		dispatcher = getServletContext().getRequestDispatcher("/carrello.jsp");
		dispatcher.forward(request,response);
	}
	}


