package model;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ClienteDSTest {
	private Cliente cliente ;
	static ClienteDS ds ;

	@Before
	public void setUp() throws Exception {
		ds = new ClienteDS();
		String data = "1994-09-21";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date datautil = sdf.parse(data);				
		java.sql.Date dataNasc = new Date(datautil.getTime());	
		cliente = new Cliente(1,"gianluca", "de luca",dataNasc , "salerno", "appia", "13","1234567898", "q@live.it", "12345678");
	}

	@After
	public void tearDown() throws Exception {
		cliente = null;
		ds = null;
	}

	@Test
	public void testInsert() throws SQLException {
		ds.insert(cliente);
		Cliente current  = ds.findByMail("q@live.it");
		int id= current.getId();
		System.out.println(id);
		ds.remove(id);
		assertTrue(current!= null);
	}

	@Test
	public void testFindByKey() throws SQLException {
		ds.insert(cliente);
		Cliente current  =ds.findByMail("q@live.it");
		int id = current.getId();
		ds.remove(id);
		assertTrue(current != null);
	}

	@Test
	public void testFindByMail() throws SQLException {
		ds.insert(cliente);
		String email = cliente.getEmail();
		Cliente current= ds.findByMail(email);
		int id= current.getId();
		ds.remove(id);
		assertTrue(current!= null);
	}

	@Test
	public void testFindAll() throws SQLException, ParseException {
		ds.insert(cliente);
		String data = "1995-10-10";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date datautil = sdf.parse(data);				
		java.sql.Date dataNasc = new Date(datautil.getTime());	
		Cliente cliente2 = new Cliente(1,"luca", "nappo",dataNasc , "atripalda", "appia", "13","1234567898", "po@live.it", "1234569856");
		ds.insert(cliente2);
		Collection<Cliente> cli = new LinkedList<Cliente>();
		cli =ds.findAll();
		Cliente current = ds.findByMail("q@live.it");
		Cliente current2 =ds.findByMail("po@live.it");
		int id2= current2.getId();
		int id1 = current.getId();
		ds.remove(id1);
		ds.remove(id2);
		assertTrue(cli != null);
	}

	@Test
	public void testFindUserEPass() throws SQLException {
		Boolean trovato = false;
		ds.insert(cliente);
		Cliente current = ds.findByMail("q@live.it");
		int id =current.getId();
		trovato = ds.findUserEPass(cliente.getEmail(), cliente.getPassword());
		ds.remove(id);
		assertTrue(trovato);
	}

	@Test
	public void testFindEmailPresente() throws SQLException {
		boolean trovato = false;
		ds.insert(cliente);
		Cliente current = ds.findByMail("q@live.it");
		trovato = ds.findEmailPresente("q@live.it");
		int id =current.getId();
		ds.remove(id);
		assertTrue(trovato);

	}

}
