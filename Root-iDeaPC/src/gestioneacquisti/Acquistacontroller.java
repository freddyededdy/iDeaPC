package gestioneacquisti;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrello;
import model.Cliente;
import model.ClienteDS;
import model.Composizione;
import model.ComposizioneDs;
import model.Fattura;
import model.Ordine;
import model.OrdineDs;
import model.Prodotto;
import model.ProdottoDS;
import model.fatturaDS;

/**
 * Servlet implementation class Acquistacontroller
 */
@WebServlet("/Acquistacontroller")
public class Acquistacontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private OrdineDs ordineds = new OrdineDs();
	private ComposizioneDs composizioneDs= new ComposizioneDs();
	private fatturaDS fatturads= new fatturaDS();
	private ClienteDS clienteds= new ClienteDS();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Acquistacontroller() {
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
		int maxid=0;
		int id_ordine=0;
		float totale_imponibile=0;
		HttpSession session = request.getSession();
		Carrello carrello =((Carrello)session.getAttribute("carrello"));
		Cliente cliente=((Cliente)session.getAttribute("cliente"));

		if(carrello.getOggettiCarrello().size()== 0){
			RequestDispatcher dispatcher;
			dispatcher = getServletContext().getRequestDispatcher("/carrello.jsp");
			dispatcher.forward(request,response);
			return;
		}else{
			try {
				maxid=ordineds.findMaxID();

			} catch (SQLException e) {
				e.printStackTrace();
			}

			Ordine ordine = new Ordine();
			int id_cliente= cliente.getId();
			String t_carta=request.getParameter("cardtype");

			String n_carta=request.getParameter("cardnumber");

			cliente.setN_carta(n_carta);
			cliente.setTipo_carta(t_carta);
			try {
				clienteds.update(cliente);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ordine.setId_cli(id_cliente);
			ordine.setDescrizione("inserire una descrizione");
			ordine.setStato_pagamento("pagato");
			id_ordine=maxid+1;

			java.util.Date now = new java.util.Date();
			Timestamp date = new Timestamp(now.getTime());

			ordine.setData_ordine(date);
			ordine.setId_ordine(id_ordine);
			try {
				ordineds.insert(ordine);

			} catch (SQLException e) {
				e.printStackTrace();
			}
			ArrayList<Prodotto>prodottiCarrello=carrello.getOggettiCarrello();
			int id_prod=0;
			int quantita=0;
			double prezzo=0;
			String nome_prodotto="";


			for(int i=0; i<prodottiCarrello.size(); i++){
				id_prod=prodottiCarrello.get(i).getId_prod();
				nome_prodotto=prodottiCarrello.get(i).getNome();
				quantita=prodottiCarrello.get(i).getQuantitaCarrello();
				prezzo=prodottiCarrello.get(i).getPrezzo();
				totale_imponibile+=prezzo*quantita;
				Composizione composizione= new Composizione(id_ordine, id_prod, prezzo, quantita, nome_prodotto);

				try {
					composizioneDs.insert(composizione);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		Fattura fattura= new Fattura();
		int id_fatturamax=0;
		try {
			id_fatturamax= fatturads.findMaxID();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int id_fattura=id_fatturamax+1;
		fattura.setId_fattura(id_fattura);
		fattura.setId_ordine(id_ordine);
		float totale_fattura=0;
		int ivaF= fattura.getIva();

		double iva=(float) ((totale_imponibile*ivaF)/100);

		totale_fattura=(float) (totale_imponibile+iva);

		fattura.setImponibile(totale_imponibile);
		fattura.setTotale(totale_fattura);

		try {
			fatturads.insert(fattura);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		carrello.rimuovitutto();
		session.setAttribute("carrello", carrello);
		session.setAttribute("cliente", cliente);
		RequestDispatcher dispatcher;
		dispatcher = getServletContext().getRequestDispatcher("/indexLoggato.jsp");
		dispatcher.forward(request,response);
	}
}




