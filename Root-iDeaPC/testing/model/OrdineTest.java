package model;

import static org.junit.Assert.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OrdineTest {
	Ordine ordine;
	@Before
	public void setUp() throws Exception {
		ordine  = new Ordine();
		String data = "1994-09-21";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
		java.util.Date datautil = sdf.parse(data);				
		Timestamp dataord = new Timestamp(datautil.getTime());
		ordine.setData_ordine(dataord);
		ordine.setDescrizione("ordine andato a buon fine");
		ordine.setId_cli(2);
		ordine.setId_ordine(2);
		ordine.setStato_pagamento("pagato");
	}

	@After
	public void tearDown() throws Exception {
		ordine = null;
	}

	@Test
	public void testGetId_ordine() {
		int id = ordine.getId_ordine();
		assertEquals(2, id);
	}

	@Test
	public void testSetId_ordine() {
		int id = 1;
		ordine.setId_ordine(id);
		assertEquals(1, id);
	}

	@Test
	public void testGetData_ordine() {
		Timestamp data = ordine.getData_ordine();
		assertEquals("1994-09-21 00:00:00.0" , data.toString());
	
	}

	@Test
	public void testSetData_ordine() throws ParseException {
		String data = "1996-10-21";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
		java.util.Date datautil = sdf.parse(data);				
		Timestamp dataord = new Timestamp(datautil.getTime());
		ordine.setData_ordine(dataord);
		assertEquals("1996-10-21 00:00:00.0", dataord.toString());
	}

	@Test
	public void testGetId_cli() {
		int id = ordine.getId_cli();
		assertEquals(2, id);
	}

	@Test
	public void testSetId_cli() {
		int id = 1;
		ordine.setId_cli(id);
		assertEquals(1, id);
	}

	@Test
	public void testGetStato_pagamento() {
		String st= ordine.getStato_pagamento();
		assertEquals("pagato", st);
	}

	@Test
	public void testSetStato_pagamento() {
		String st = "non pagato";
		ordine.setStato_pagamento(st);
		assertEquals("non pagato", st);
	}


	@Test
	public void testGetDescrizione() {
		String de = ordine.getDescrizione();
		assertEquals("ordine andato a buon fine", de);
		
	}

	@Test
	public void testSetDescrizione() {
		String de = "ordine non andato a buon fine";
		ordine.setDescrizione(de);
		assertEquals("ordine non andato a buon fine", de);
	}

}
