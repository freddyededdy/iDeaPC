package model;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ComposizioneDsTest {
	Composizione composizione;
	ComposizioneDs ds;
	OrdineDs ordineds;
	Ordine ordine;
	Prodotto pr;
	ProdottoDS prodottods;
	Cliente cliente;
	ClienteDS clienteds;

	@Before
	public void setUp() throws Exception {
		String data = "1994-09-21";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date datautil = sdf.parse(data);				
		java.sql.Date dataNasc = new Date(datautil.getTime());	
		cliente = new Cliente(1,"gianluca", "de luca",dataNasc , "salerno", "appia", "13","1234567898", "q@live.it", "12345678");
		composizione = new Composizione(2 ,2 ,23.3 , 24 , "scheda video"); 
		ds = new ComposizioneDs();
		ordineds = new OrdineDs();
		ordine = new Ordine(2 , "pagato", 3,"ordine effettuato");
		prodottods = new ProdottoDS();
		pr = new Prodotto(2,"scheda video", "scheda video nvida", 23.3, "c:users/aquilino/desktop/immagini", 25, 10);
		clienteds = new  ClienteDS();
		
	}

	@After
	public void tearDown() throws Exception {
		ds = null;
		composizione = null;
		ordineds = null;
		ordine=null;
		pr=null;
		prodottods=null;
		cliente= null;
		clienteds= null;
	}

	@Test
	public void testInsert() throws SQLException {
		clienteds.insert(cliente);
		Cliente current  =clienteds.findByMail("q@live.it");
		int id_cli = current.getId();
		ordine.setId_cli(id_cli);
		ordineds.insert(ordine);
		ds.insert(composizione);
		prodottods.insert(pr);
		Prodotto prr = new Prodotto();
		prr =prodottods.findbyname("scheda video");
		Collection<Composizione> comp = new LinkedList<Composizione>();
		comp = ds.findAll();
		Iterator<?> it2 = comp.iterator();
		while (it2.hasNext()) {
			Composizione c = (Composizione) it2.next();
			int idprod = c.getId_prod();
			ds.remove(idprod);
		}
		assertTrue(comp != null);
	}

	@Test
	public void testFindbyid_ordine() {
		fail("Not yet implemented");
	}

}
