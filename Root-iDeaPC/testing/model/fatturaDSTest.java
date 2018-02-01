package model;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class fatturaDSTest {
	Fattura fattura;
	fatturaDS fatturads;
	OrdineDs ordineds;
	Ordine ordine;
	Cliente cliente;
	ClienteDS clienteds;
	
	@Before
	public void setUp() throws Exception {
		String data = "1994-09-21";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date datautil = sdf.parse(data);				
		java.sql.Date dataNasc = new Date(datautil.getTime());	
		cliente = new Cliente(1,"gianluca", "de luca",dataNasc , "salerno", "appia", "13","1234567898", "q@live.it", "12345678");
		ordine = new Ordine(2 , "pagato", 3,"ordine effettuato");
		fattura = new Fattura(2,234,2565,2);
		ordineds= new OrdineDs();
		fatturads = new fatturaDS();
		clienteds =  new ClienteDS();
		
	}

	@After
	public void tearDown() throws Exception {
		fatturads = null;
		ordineds=null;
		fattura=null;
		ordine = null;
	}

	@Test
	public void testInsert() throws SQLException {
		clienteds.insert(cliente);
		Cliente current  =clienteds.findByMail("q@live.it");
		int id_cli = current.getId();
		
		ordine.setId_cli(id_cli);
		ordineds.insert(ordine);

		fatturads.insert(fattura);
		
		Fattura fatturaprova = fatturads.findByKey(2);

		fatturads.remove(2);
		ordineds.remove(2);
		clienteds.remove(id_cli);
		
		assertTrue(fatturaprova != null);
		
	}

	@Test
	public void testFindByKey() throws SQLException {
		clienteds.insert(cliente);
		Cliente current  =clienteds.findByMail("q@live.it");
		int id_cli = current.getId();
		
		ordine.setId_cli(id_cli);
		ordineds.insert(ordine);

		fatturads.insert(fattura);
		
		Fattura fatturaprova = fatturads.findByKey(2);

		fatturads.remove(2);
		ordineds.remove(2);
		clienteds.remove(id_cli);
		
		assertTrue(fatturaprova != null);
	
	}

	@Test
	public void testFindMaxID() throws SQLException {
		clienteds.insert(cliente);
		Cliente current  =clienteds.findByMail("q@live.it");
		int id_cli = current.getId();
		
		ordine.setId_cli(id_cli);
		ordineds.insert(ordine);

		fatturads.insert(fattura);
		
		Fattura fatturaprova = fatturads.findByKey(2);
		
		int id =fatturaprova.getId_fattura();
		id = id +1;
		fatturads.remove(2);
		ordineds.remove(2);
		clienteds.remove(id_cli);
		
		assertEquals(3,id);
	}

	@Test
	public void testFindbyid_ordine() throws SQLException {
		clienteds.insert(cliente);
		Cliente current  =clienteds.findByMail("q@live.it");
		int id_cli = current.getId();
		
		ordine.setId_cli(id_cli);
		ordineds.insert(ordine);

		fatturads.insert(fattura);
		
		Fattura fatturaprova = fatturads.findbyid_ordine(2);

		fatturads.remove(2);
		ordineds.remove(2);
		clienteds.remove(id_cli);
		
		assertTrue(fatturaprova != null);
	}

}
