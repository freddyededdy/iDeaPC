package GestioneUtenti;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;
import model.ClienteDS;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ClienteDS clienteds= new ClienteDS();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
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
		HttpSession sessione = request.getSession();
		Cliente current = null;

		String user=request.getParameter("email");
		String pass=request.getParameter("pass");
		
		Boolean risp = false; 
		try {
			risp = clienteds.findUserEPass(user , pass);  // find user e pass torna un boolean : true se vengono trovati user e pass nel db 
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(risp == false){
			response.sendRedirect("erroreaccesso.jsp");
			
			return;
		}
		if(risp == true){ // se è presente un cliente con le credenziali corrette
			
			 	try {
					current = clienteds.findByMail(user);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sessione.setAttribute("cliente", current);
				RequestDispatcher view = request.getRequestDispatcher("/indexLoggato.jsp");
				view.forward(request, response);

			}

		}
	}
