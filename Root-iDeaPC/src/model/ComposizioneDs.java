/*
* Composizione
* Questa classe serve per la connessione sul database relativa all'oggetto composizione 
*/
package model;
import com.mysql.jdbc.Driver;
import com.mysql.fabric.jdbc.FabricMySQLDriver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ComposizioneDs implements Model_Interface<Composizione>{

	private static DataSource ds;

	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/ideapc");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	private static final String TABLE_NAME = "composizione";
	/**
	 * Metodo che inserisce la composizione (realzione n a n tra ordine e prodotto )
	 * @param un Composizione
	 */
	@Override
	public synchronized void insert(Composizione composizione) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + TABLE_NAME + 
				" (ID_ORDINE, ID_PROD , QUANTITà, PREZZO , NOME_PRODOTTO) VALUES (?, ?, ? , ? , ?)";


		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setInt(1,	composizione.getId_ordne());
			preparedStatement.setInt(2,	composizione.getId_prod());
			preparedStatement.setInt(3,	composizione.getQuantita());
			preparedStatement.setDouble(4,	composizione.getPrezzo());
			preparedStatement.setString(5, composizione.getNome_p());
			preparedStatement.executeUpdate();
			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}	

	}
	
	@Override
	public synchronized void update(Composizione entity) throws SQLException {
		// TODO Auto-generated method stub

	}
	
	@Override
	public synchronized boolean remove(int id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public synchronized Composizione findByKey(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public synchronized Collection<Composizione> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Metodo che mi ritorna tutte le con uno specifico id prodotto
	 * @param id del prodotto
	 * @return Collection di composizone
	 */
	public synchronized Collection<Composizione> findbyid_ordine(int id_ordine) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<Composizione> composizioneOrdine = new LinkedList<Composizione>();
		
		
		String selectSQL = "SELECT * FROM " + TABLE_NAME + " where id_ordine=?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id_ordine);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Composizione compos = new Composizione();
				compos.setId_ordne(rs.getInt("id_ordine"));
				compos.setId_prod(rs.getInt("id_prod"));				
				compos.setQuantita(rs.getInt("quantità"));
				compos.setPrezzo(rs.getDouble("prezzo"));
				compos.setNome_p(rs.getString("nome_prodotto"));
				composizioneOrdine.add(compos);
			}
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return composizioneOrdine;
	}
	
	
}
