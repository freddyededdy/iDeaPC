package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ComposizioneTest {
	private Composizione composizione;
	@Before
	public void setUp() throws Exception {
		composizione = new Composizione();
		composizione.setId_ordne(1);
		composizione.setId_prod(1);
		composizione.setNome_p("schedaVideo");
		composizione.setPrezzo(34.5);
		composizione.setQuantita(10);
		assertNotNull(composizione);
	}

	@After
	public void tearDown() throws Exception {
		composizione = null;
	}

	@Test
	public void testGetNome_p() {
		String nome = composizione.getNome_p();
		assertEquals("schedaVideo", nome);
	}

	@Test
	public void testSetNome_p() {
		String nome = "schedaAudio";
		composizione.setNome_p(nome);
		assertEquals("schedaAudio", nome);
	}

	@Test
	public void testGetId_ordne() {
		int id = composizione.getId_ordne();
		assertEquals(1, id);
		
	}

	@Test
	public void testSetId_ordne() {
		int id = 2;
		composizione.setId_ordne(id);
		assertEquals(2, id);
	}

	@Test
	public void testGetId_prod() {
		int idp =composizione.getId_prod();
		assertEquals (1, idp);
	}

	@Test
	public void testSetId_prod() {
		int idp = 2;
		composizione.setId_prod(2);
		assertEquals(2, idp);
	}

	@Test
	public void testGetQuantita() {
		int q = composizione.getQuantita();
		assertEquals(10, q);
	}

	@Test
	public void testSetQuantita() {
		int q = 20;
		composizione.setQuantita(q);
		assertEquals(20, q);
	}

	@Test
	public void testGetPrezzo() {
		double p = composizione.getPrezzo();
		assertEquals(34,5 , p);
	}

	@Test
	public void testSetPrezzo() {
		double p = 20.7;
		composizione.setPrezzo(p);
		assertEquals(20,7, p);
		
	}

}
