package model;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrdineDsTest {
	OrdineDs ordineds;
	Ordine ordine;
	Cliente cliente;
	ClienteDS clienteds;
	
	@Before
	public void setUp() throws Exception {
		ordineds = new OrdineDs();
		ordine = new Ordine(2 , "pagato", 3,"ordine effettuato");
		String data = "1994-09-21";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date datautil = sdf.parse(data);				
		java.sql.Date dataNasc = new Date(datautil.getTime());	
		cliente = new Cliente(1,"gianluca", "de luca",dataNasc , "salerno", "appia", "13","1234567898", "q@live.it", "12345678");
		clienteds = new ClienteDS();
	}

	@After
	public void tearDown() throws Exception {
		clienteds = null;
		cliente= null;
		ordine = null;
		ordineds=null;
	}

	@Test
	public void testInsert() throws SQLException {
		clienteds.insert(cliente);
		Cliente current  =clienteds.findByMail("q@live.it");
		int id_cli = current.getId();
		
		ordine.setId_cli(id_cli);
		ordineds.insert(ordine);
		
		Ordine or = ordineds.findByKey(2);
		
		ordineds.remove(2);
		clienteds.remove(id_cli);
		
		assertTrue(or != null);
	}

	@Test
	public void testRemove() throws SQLException {
		clienteds.insert(cliente);
		Cliente current  =clienteds.findByMail("q@live.it");
		int id_cli = current.getId();
		
		ordine.setId_cli(id_cli);
		ordineds.insert(ordine);
		
		
		boolean trovato =ordineds.remove(2);
		clienteds.remove(id_cli);
		
		assertTrue(trovato);
		

	}

	@Test
	public void testFindByKey() throws SQLException {
		clienteds.insert(cliente);
		Cliente current  =clienteds.findByMail("q@live.it");
		int id_cli = current.getId();
		
		ordine.setId_cli(id_cli);
		ordineds.insert(ordine);
		
		Ordine or = ordineds.findByKey(2);
		
		ordineds.remove(2);
		clienteds.remove(id_cli);
		
		assertTrue(or!= null);
	}

	@Test
	public void testFindAll() throws SQLException {
		clienteds.insert(cliente);
		Cliente current  =clienteds.findByMail("q@live.it");
		int id_cli = current.getId();
		
		ordine.setId_cli(id_cli);
		ordineds.insert(ordine);
		
		Collection<Ordine>or= new ArrayList<Ordine>();
		
		or = ordineds.findAll();
		
		ordineds.remove(2);
		clienteds.remove(id_cli);
		
		assertTrue(or!= null);
		
	}

	@Test
	public void testFindMaxID() throws SQLException {
		clienteds.insert(cliente);
		Cliente current  =clienteds.findByMail("q@live.it");
		int id_cli = current.getId();
		
		ordine.setId_cli(id_cli);
		ordineds.insert(ordine);
		
		
		int id =ordineds.findMaxID();
		id = id +1;
		
		ordineds.remove(2);
		clienteds.remove(id_cli);
		
		assertEquals(3,id);
	}

	@Test
	public void testGetOrdiniCliente() throws SQLException {
		clienteds.insert(cliente);
		Cliente current  =clienteds.findByMail("q@live.it");
		int id_cli = current.getId();
		
		ordine.setId_cli(id_cli);
		ordineds.insert(ordine);
		
		Collection<Ordine>or= new ArrayList<Ordine>();
		or = ordineds.getOrdiniCliente(id_cli);
		
		ordineds.remove(2);
		clienteds.remove(id_cli);
		
		assertTrue(or!= null);
	}


}
