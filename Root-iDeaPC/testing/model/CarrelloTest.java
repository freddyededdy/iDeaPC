package model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CarrelloTest {
	private Carrello carrello;
	@Before
	public void setUp() throws Exception {
		carrello = new Carrello();
		carrello.aggiungi(new Prodotto());
		carrello.getOggettiCarrello();
		carrello.rimuovi(0);
		carrello.aggiungi(new Prodotto());
		carrello.rimuovitutto();
		assertNotNull(carrello);
	}

	@After
	public void tearDown() throws Exception {
		carrello = null;
	}

	@Test
	public void testAggiungi() {
		carrello.aggiungi(new Prodotto());
		int size = carrello.getOggettiCarrello().size();
		assertEquals (size , 1); 
	}

	@Test
	public void testRimuovi() {
		carrello.aggiungi(new Prodotto());
		carrello.aggiungi(new Prodotto());
		carrello.rimuovi(0);
		int size = carrello.getOggettiCarrello().size();
		assertEquals (size , 1); 
		
	}

	@Test
	public void testGetOggettiCarrello() {
		carrello.aggiungi(new Prodotto());
		ArrayList<Prodotto> prodotti = carrello.getOggettiCarrello();
		assertEquals(1 , prodotti.size());
		carrello.rimuovi(0);
		
	}

	@Test
	public void testRimuovitutto() {
		carrello.aggiungi(new Prodotto());
		carrello.aggiungi(new Prodotto());
		carrello.rimuovitutto();
		int size = carrello.getOggettiCarrello().size();
		assertEquals (size , 0); 
		
	}

}
