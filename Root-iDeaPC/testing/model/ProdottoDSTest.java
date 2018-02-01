package model;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProdottoDSTest {
	Prodotto pr;
	ProdottoDS prodottods;
	@Before
	public void setUp() throws Exception {
		prodottods = new ProdottoDS();
		pr = new Prodotto(2,"scheda video", "scheda video nvida", 23.3, "c:users/aquilino/desktop/immagini", 25, 10);
	}

	@After
	public void tearDown() throws Exception {
		prodottods = null;
		pr =null;
	}

	@Test
	public void testInsert() throws SQLException {
		prodottods.insert(pr);
		Prodotto prod ;
		
		prod = prodottods.findbyname("scheda video");
		
		int id = prod.getId_prod();
		
		prodottods.remove(id);
		assertTrue(prod!=null);
	}

	@Test
	public void testRemove() throws SQLException {
		prodottods.insert(pr);
		Prodotto prod ;
		
		prod = prodottods.findbyname("scheda video");
		
		int id = prod.getId_prod();
		
		
		assertTrue(prodottods.remove(id));
		
	}

	@Test
	public void testFindByKey() throws SQLException {
		prodottods.insert(pr);
		Prodotto prod ;
		
		prod = prodottods.findbyname("scheda video");
		
		int id = prod.getId_prod();
		
		prod =prodottods.findByKey(id);
		
		prodottods.remove(id);
		
		assertTrue(prod!=null);
		
	}

	@Test
	public void testFindAll() throws SQLException {
		Collection<Prodotto> p = new LinkedList<Prodotto>();
		
		prodottods.insert(pr);
		p = prodottods.findAll();
		Prodotto prod ;
		
		prod = prodottods.findbyname("scheda video");
		
		int id = prod.getId_prod();
		
		prod =prodottods.findByKey(id);
		
		prodottods.remove(id);
		
		assertTrue(p != null);
		
		
	}

	@Test
	public void testUpdate() throws SQLException {
		prodottods.insert(pr);
		Prodotto prod ;
		
		prod = prodottods.findbyname("scheda video");
		int id = prod.getId_prod();
		
		Prodotto p = new Prodotto(id,"scheda", "nvida", 23.3, "c:users/aquilino/desktop/immagini", 25, 10);
		prodottods.update(p);
		
		
		String nomenuovo = p.getNome();
		
		prodottods.remove(id);
		
		assertEquals(nomenuovo, "scheda");
	}

	@Test
	public void testFindbyname() throws SQLException {
		prodottods.insert(pr);
		Prodotto prod ;
		
		prod = prodottods.findbyname("scheda video");
		
		int id = prod.getId_prod();
		
		prodottods.remove(id);
		assertTrue(prod!=null);
	}

}
