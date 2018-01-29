package gestioneutenti;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cliente;
import model.ClienteDS;

/**
 * RegistrazioneController 
 * Servlet per la registrazione di un cliente controlla i capi inserti e crea un nuovo cliente
 */
@WebServlet("/RegistrazioneController")
public class RegistrazioneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static ClienteDS clienteds= new ClienteDS();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrazioneController() {
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
		HttpSession session=request.getSession();
		
		boolean error=false; // se la variabile resta false non ci sono errori nella compilazione della form
		try{
			String nome=request.getParameter("nome");
			String cognome=request.getParameter("cognome");
			String data = request.getParameter("data_nasc");			//prendo la data dalla form jsp
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	//la formatto secondo anno-mese-giorno
			java.util.Date datautil = sdf.parse(data);				
			java.sql.Date dataNasc = new Date(datautil.getTime());		//formato java.sql.date
			
			String città=request.getParameter("citta");
			
			String via=request.getParameter("via");
			String numero_civico=request.getParameter("numero_civico");
			String cellulare=request.getParameter("cellulare");
			if(cellulare.length()!=10) error=true;
			String email =request.getParameter("mail");

			String password=request.getParameter("password");
			if( password.length()<8 || password.length()>16){
				error= true;
			}
			


			Boolean risp=true;

			risp=clienteds.findEmailPresente(email);

			if(!risp && !error){ // sel'email non è presente procedi con la registrazione
				int id=1;
				Cliente current =new Cliente(id, nome, cognome, dataNasc, città, via, numero_civico, cellulare, email, password);
				clienteds.insert(current);
				System.out.println(current.toString());
			} else if(risp){
				response.sendRedirect("errore_mail.jsp");
				return;
			}else if(error){
				response.sendRedirect("errore_generico.jsp");
				return;
			}
		}catch(SQLException | ParseException e){
			e.printStackTrace();

		}
		
		response.sendRedirect("index.html");
	
	}

}
