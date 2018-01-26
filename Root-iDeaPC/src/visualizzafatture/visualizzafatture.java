package visualizzafatture;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrello;
import model.Cliente;
import model.Composizione;
import model.ComposizioneDs;
import model.Fattura;
import model.Ordine;
import model.OrdineDs;
import model.fatturaDS;

/**
 * Visualizzafatture
 * Servlet che visualizza le fatture del cliente che è loggato
 */
@WebServlet("/visualizzafatture")
public class visualizzafatture extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static OrdineDs ordineds= new OrdineDs();


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public visualizzafatture() {
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
		Cliente cliente=((Cliente)session.getAttribute("cliente"));
		if(cliente==null){
			RequestDispatcher view = request.getRequestDispatcher("/indexLoggato.jsp");
			view.forward(request, response);
		}else{
			int id_cli=cliente.getId();
			Collection <Ordine> ordiniCliente = null;
			Collection<Composizione> composizione= null;
			Fattura fattura= null;
			int id_ordine = 0 ;
			try {
				ordiniCliente=ordineds.getOrdiniCliente(id_cli);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("ordine", ordiniCliente);
			RequestDispatcher view = request.getRequestDispatcher("/OrdiniEffettuati.jsp");
			view.forward(request, response);
		}
	}
}


