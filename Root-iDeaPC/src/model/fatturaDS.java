/*
 * Composizione
 * Questa classe serve per la connessione sul database relativa all'oggetto fattura
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

public class fatturaDS implements Model_Interface<Fattura> {


	private static final String TABLE_NAME = "fattura";

	/**
	 *meotodo che inserisce nel database una fattura
	 * @param fattura da inserire
	 */
	@Override
	public synchronized void insert(Fattura fattura) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + TABLE_NAME + 
				" (ID_FATTURA, ID_ORDINE, IVA, TOTALE_IMPONIBILE, TOTALE_FATTURA) VALUES (?, ?, ? , ? , ?)";


		try {
			connection = DBManager.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setInt(1, fattura.getId_fattura());
			preparedStatement.setInt(2, fattura.getId_ordine());
			preparedStatement.setInt(3, fattura.getIva());
			preparedStatement.setFloat(4, fattura.getImponibile());
			preparedStatement.setFloat(5, fattura.getTotale());
			preparedStatement.executeUpdate();
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
	public synchronized void update(Fattura fattura) throws SQLException {
		return;
	}

	@Override
	public synchronized boolean remove(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + TABLE_NAME + " WHERE id_fattura = ?";

		try {
			connection = DBManager.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, id);

			result = preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return (result != 0);
	}

	/**
	 * Metodo che cerca una fattura con uno specifico id
	 * @param id della fattura da cercare
	 */

	@Override
	public synchronized Fattura findByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Fattura fattura = new Fattura();

		String selectSQL = "SELECT * FROM " + TABLE_NAME + " WHERE id_fattura = ?";

		try {
			connection = DBManager.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				fattura.setId_fattura(rs.getInt("id_fattura"));
				fattura.setId_ordine(rs.getInt("id_ordine"));
				fattura.setImponibile(rs.getFloat("totale_imponibile"));
				fattura.setTotale(rs.getFloat("totale_fattura"));
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
		return fattura;
	}


	public synchronized ArrayList<Fattura> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * metodo che cerca la fattura con l'id massimo
	 */
	public synchronized int findMaxID() throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int id_fattura=0;
		String selectSQL = "SELECT id_fattura FROM " + TABLE_NAME + " WHERE id_fattura =( SELECT max(id_fattura) FROM " + TABLE_NAME + ")";
		try {
			connection = DBManager.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);


			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				id_fattura=rs.getInt("id_fattura");
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

		return id_fattura;

	}

	/**
	 * Metodo che cerca la fattura con l'id dell'ordine 
	 * @param id dell'ordine 
	 */
	public synchronized Fattura findbyid_ordine(int id_ordine) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Fattura fattura= new Fattura();


		String selectSQL = "SELECT * FROM " + TABLE_NAME + " where id_ordine=?";

		try {
			connection = DBManager.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id_ordine);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				fattura.setId_fattura(rs.getInt("id_fattura"));
				fattura.setId_ordine(rs.getInt("id_ordine"));
				fattura.setImponibile(rs.getFloat("totale_imponibile"));
				fattura.setTotale(rs.getFloat("totale_fattura"));
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

		return fattura;
	}




}
