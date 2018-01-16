package visualizzafatture;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrello;
import model.Cliente;
import model.Ordine;
import model.OrdineDs;

/**
 * Servlet implementation class visualizzatuttelefattureA
 */
@WebServlet("/visualizzatuttelefattureA")
public class visualizzatuttelefattureA extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static OrdineDs ordineds= new OrdineDs();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public visualizzatuttelefattureA() {
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
		Collection <Ordine> ordiniTutti = null;
		try {
			ordiniTutti=ordineds.findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
					}
			session.setAttribute("ordine", ordiniTutti);
			RequestDispatcher view = request.getRequestDispatcher("/OrdiniEffettuati.jsp");
			view.forward(request, response);
		}
	}


