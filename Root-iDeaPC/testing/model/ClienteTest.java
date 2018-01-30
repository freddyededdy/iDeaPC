package model;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {
private Cliente cliente;
	@Before
	public void setUp() throws Exception {
	cliente = new Cliente();
	cliente.setNome("aquilino");
	cliente.setCognome("leone");
	cliente.setCell("34821091994");
	cliente.setCitta("atripalda");
	String data = "1994-09-21";
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	//la formatto secondo anno-mese-giorno
	java.util.Date datautil = sdf.parse(data);				
	java.sql.Date dataNasc = new Date(datautil.getTime());		//formato java.sql.date
	cliente.setDate(dataNasc);
	cliente.setEmail("aquilino@gmail.com");
	cliente.setN_carta("1234567890987654");
	cliente.setN_civ("23");
	cliente.setPassword("02316547");
	cliente.setTipo_carta("visa");
	cliente.setVia("appia");
	assertNotNull(cliente);
	}

	@After
	public void tearDown() throws Exception {
		cliente = null;
	}

	@Test
	public void testGetNome() {
		String nome = cliente.getNome();
		assertEquals("aquilino", nome);
	}

	@Test
	public void testGetCognome() {
	String cognome = cliente.getCognome();
	assertEquals("leone" , cognome);
	}

	@Test
	public void testGetCitta() {
		String citta = cliente.getCitta();
		assertEquals("atripalda", citta);
	}

	@Test
	public void testGetVia() {
	String via  =  cliente.getVia();
	assertEquals("appia", via);
	}

	@Test
	public void testGetN_civ() {
		String nciv = cliente.getN_civ();
		assertEquals("23", nciv);
	}

	@Test
	public void testGetEmail() {
		String email = cliente.getEmail();
		assertEquals("aquilino@gmail.com", email);
	}

	@Test
	public void testGetPassword() {
		String pass = cliente.getPassword();
		assertEquals("02316547", pass);
	}

	@Test
	public void testGetCell() {
		String cell = cliente.getCell();
		assertEquals("34821091994", cell);
	}

	@Test
	public void testGetDate() {
		Date data = cliente.getDate();
		assertEquals ("1994-09-21", data.toString());
	}


	@Test
	public void testSetNome() {
		String nome = "domenico";
		cliente.setNome(nome);
		assertEquals("domenico", nome);
	}

	@Test
	public void testSetCognome() {
		String cognome = "capasso";
		cliente.setCognome(cognome);
		assertEquals("capasso", cognome);
	}

	@Test
	public void testSetCitta() {
		String citta = "salerno";
		cliente.setCitta(citta);
		assertEquals("salerno", citta);
	}

	@Test
	public void testSetVia() {
		String via = "roma";
		cliente.setVia(via);
		assertEquals("roma", via);
	}

	@Test
	public void testSetN_civ() {
		String civ ="44";
		cliente.setN_civ(civ);
		assertEquals("44", civ);
	}

	@Test
	public void testSetEmail() {
	String email = "domenico@gmail.com";
	cliente.setEmail(email);
	assertEquals("domenico@gmail.com", email);
	}

	@Test
	public void testSetPassword() {
		String password = "11111111";
		cliente.setPassword(password);
		assertEquals("11111111", password);
	}

	@Test
	public void testGetN_carta() {
	 String carta =  cliente.getN_carta();
	 assertEquals("1234567890987654", carta);
	}

	@Test
	public void testSetN_carta() {
		String ncarta = "1236636356989653";
		cliente.setN_carta(ncarta);
		assertEquals("1236636356989653", ncarta);
	}

	@Test
	public void testGetTipo_carta() {
	String	carta = cliente.getTipo_carta();
	assertEquals("visa", carta);
	}

	@Test
	public void testSetTipo_carta() {
		String carta = "paypal";
		cliente.setTipo_carta(carta);
		assertEquals("paypal", carta);
	}

	@Test
	public void testSetCell() {
		String cell = "0825623019";
		cliente.setCell(cell);
		assertEquals("0825623019", cell);
	}

	@Test
	public void testSetDate() throws ParseException {
		String data = "1995-11-20";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	//la formatto secondo anno-mese-giorno
		java.util.Date datautil = sdf.parse(data);				
		java.sql.Date dataNasc = new Date(datautil.getTime());		//formato java.sql.date
		cliente.setDate(dataNasc);
	assertEquals("1995-11-20",dataNasc.toString());
	}


}
