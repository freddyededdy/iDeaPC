package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FatturaTest {
	private Fattura fattura;
	@Before
	public void setUp() throws Exception {
	fattura= new Fattura();
	fattura.setId_fattura(2);
	fattura.setId_ordine(2);
	fattura.setImponibile(Float.parseFloat("245.7"));
	fattura.setTotale(Float.parseFloat("5689.6"));
	assertNotNull(fattura);
	}

	@After
	public void tearDown() throws Exception {
		fattura = null;
	}

	@Test
	public void testGetId_ordine() {
		int id = fattura.getId_ordine();
		assertEquals(2, id);
	}

	@Test
	public void testSetId_ordine() {
		int id = 3;
		fattura.setId_ordine(id);
		assertEquals(3,id);
	}

	@Test
	public void testGetId_fattura() {
		int id = fattura.getId_fattura();
		assertEquals(2, id);
	}

	@Test
	public void testSetId_fattura() {
		int id = 4;
		fattura.setId_fattura(id);
		assertEquals(4, id);
	}


	@Test
	public void testGetImponibile() {
		float impo = fattura.getImponibile();
		assertEquals(245.7+"" , impo+"");
	}

	@Test
	public void testSetImponibile() {
		float impo =Float.parseFloat("280.6");
		fattura.setImponibile(impo);
		assertEquals(280.6+"", impo+"");
	}

	@Test
	public void testGetTotale() {
		float tot = fattura.getTotale();
		assertEquals(5689.6+"" , tot+"");
	}

	@Test
	public void testSetTotale() {
		float tot =Float.parseFloat("262.6");
		fattura.setImponibile(tot);
		assertEquals(262.6+"", tot+"");
	}

	@Test
	public void testGetIva() {
		int iva =fattura.getIva();
		assertEquals(22, iva);
	}

}
