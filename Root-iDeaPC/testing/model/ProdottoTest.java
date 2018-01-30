package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProdottoTest {
	Prodotto prodotto;
	@Before
	public void setUp() throws Exception {
		prodotto = new Prodotto();
		prodotto.setDescrizione("scheda video");
		prodotto.setId_prod(1);
		prodotto.setImmagine("C:/Users/Aquilino/Desktop/Ingenieria del software");
		prodotto.setNome("Realteck");
		prodotto.setPrezzo(21.5);
		prodotto.setQuantitaCarrello(34);
		prodotto.setQuantit�(22);
	}

	@After
	public void tearDown() throws Exception {
		prodotto = null;
	}

	@Test
	public void testGetImmagine() {
		String im = prodotto.getImmagine();
		assertEquals("C:/Users/Aquilino/Desktop/Ingenieria del software", im);
	}

	@Test
	public void testSetImmagine() {
		String im =  "C:/Users/Domenico/Desktop/Base di dati";
		prodotto.setImmagine(im);
		assertEquals("C:/Users/Domenico/Desktop/Base di dati", im);
	}

	@Test
	public void testGetId_prod() {
		int di =  prodotto.getId_prod();
		assertEquals(1, di);
	}

	@Test
	public void testSetId_prod() {
		int id = 2;
		prodotto.setId_prod(id);
		assertEquals(2, id);
	}

	@Test
	public void testGetNome() {
		String nome = prodotto.getNome();
		assertEquals("Realteck", nome);
	}

	@Test
	public void testSetNome() {
		String nome = "nvidia";
		prodotto.setNome(nome);
		assertEquals("nvidia", nome);
	}

	@Test
	public void testGetDescrizione() {
		String des = prodotto.getDescrizione();
		assertEquals("scheda video", des);
	}

	@Test
	public void testSetDescrizione() {
		String des = "scheda audio";
		prodotto.setDescrizione(des);
		assertEquals("scheda audio", des);
	}

	@Test
	public void testGetPrezzo() {
		double prezzo = prodotto.getPrezzo();
		assertEquals(21.5+"", prezzo+"");
	}

	@Test
	public void testSetPrezzo() {
		double prezzo = 22.9;
		prodotto.setPrezzo(prezzo);
		assertEquals(22.9+"" , prezzo+"");
	}

	@Test
	public void testGetQuantit�() {
		int q = prodotto.getQuantit�();
		assertEquals(q , 22);
	}

	@Test
	public void testSetQuantit�() {
		int q = 35;
		prodotto.setQuantit�(q);
		assertEquals(35, q);
	}

	@Test
	public void testGetQuantitaCarrello() {
		int quant = prodotto.getQuantitaCarrello();
		assertEquals(quant, 34);
	}

	@Test
	public void testSetQuantitaCarrello() {
		int quant= 90;
		prodotto.setQuantitaCarrello(quant);
		assertEquals(quant, 90);
	}

}
