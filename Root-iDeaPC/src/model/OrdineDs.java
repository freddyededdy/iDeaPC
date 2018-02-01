/*
* Composizione
* Questa classe serve per la connessione sul database relativa all'oggetto ordine
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
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class OrdineDs implements Model_Interface<Ordine> {

	private static final String TABLE_NAME = "ordine";
	@Override
	/**
	 * Metodo che inserisce un ordine nel database
	 * @param l'ordine da inserire
	 */
	public synchronized void insert(Ordine ordine) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + TABLE_NAME + 
				" (ID_ORDINE, STATO_PAGAMENTO , DESCRIZIONE, ID_CLI , DATA_ORDINE) VALUES (?, ?, ? , ? , ?)";


		try {
			connection = DBManager.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setInt(1, ordine.getId_ordine());
			preparedStatement.setString(2, ordine.getStato_pagamento());
			preparedStatement.setString(3,ordine.getDescrizione() );
			preparedStatement.setInt(4, ordine.getId_cli());
			preparedStatement.setTimestamp(5, ordine.getData_ordine());
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
	/**
	 * Metodo che mi aggiorna un ordine 
	 * @param l'ordine da aggiornare
	 */

	@Override
	public synchronized void update(Ordine ordine) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String updateSql = "UPDATE " + TABLE_NAME + " SET STATO_PAGAMENTO= ?, DESCRIZIONE= ?  WHERE ID_ORDINE = ? ";


		try {
			connection = DBManager.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(updateSql);
			preparedStatement.setString(1, ordine.getStato_pagamento());
			preparedStatement.setString(2, ordine.getDescrizione());
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
	/**
	 * Metodo che mi rimuove un ordine 
	 * @param id dell'ordine da rimuovere
	 */

	@Override
	public synchronized boolean remove(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + TABLE_NAME + " WHERE id_ordine = ?";

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
	 * Metodo che cerca un ordine in abse all'id
	 * @param id dell'ordine da cercare
	 */
	@Override
	public synchronized Ordine findByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Ordine ordine = new Ordine();

		String selectSQL = "SELECT * FROM " + TABLE_NAME + " WHERE id_ordine = ?";

		try {
			connection = DBManager.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ordine.setId_ordine(rs.getInt("id_ordine"));
				ordine.setStato_pagamento(rs.getString("stato_pagamento"));
				ordine.setDescrizione(rs.getString("descrizione"));
				ordine.setId_cli(rs.getInt("id_cli"));
				ordine.setData_ordine(rs.getTimestamp("data_ordine"));
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
		return ordine;
	}

	/**
	 * Metodo che mi torna un collection di tutti gli ordini 
	 * @return collection ordine
	 */
	public synchronized Collection<Ordine> findAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<Ordine>ordiniTutti= new ArrayList<Ordine>();
		String selectSQL = "SELECT * FROM " + TABLE_NAME + "";
		try {
			connection = DBManager.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);


			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Ordine ordine = new Ordine();
				ordine.setId_ordine(rs.getInt("id_ordine"));
				ordine.setStato_pagamento(rs.getString("stato_pagamento"));
				ordine.setDescrizione(rs.getString("descrizione"));
				ordine.setId_cli(rs.getInt("id_cli"));
				ordine.setData_ordine(rs.getTimestamp("data_ordine"));

				ordiniTutti.add(ordine);
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

		return ordiniTutti;
	}
	/**
	 * Metodo che mi cerca l'id dell l'ordine con id massimo
	 * @return id massimo dell'ordine 
	 */
	public synchronized int findMaxID() throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int id_ordine=0;
		String selectSQL = "SELECT id_ordine FROM " + TABLE_NAME + " WHERE id_ordine =( SELECT max(id_ordine) FROM " + TABLE_NAME + ")";
		try {
			connection = DBManager.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);


			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				id_ordine=rs.getInt("id_ordine");
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
		
		return id_ordine;

	}
	
	/**
	 * Metodo che mi torna una collection di ordini con uno specifico id cliente 
	 * @param id del cliente 
	 * @return collection di ordine 
	 */
	public synchronized Collection<Ordine> getOrdiniCliente(int id_cliente) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<Ordine>ordiniCliente= new ArrayList<Ordine>();
		String selectSQL = "SELECT * FROM " + TABLE_NAME + " WHERE id_cli = ?";
		try {
			connection = DBManager.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id_cliente);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Ordine ordine = new Ordine();
				ordine.setId_ordine(rs.getInt("id_ordine"));
				ordine.setStato_pagamento(rs.getString("stato_pagamento"));
				ordine.setDescrizione(rs.getString("descrizione"));
				ordine.setId_cli(rs.getInt("id_cli"));
				ordine.setData_ordine(rs.getTimestamp("data_ordine"));

				ordiniCliente.add(ordine);
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
		return ordiniCliente;
	}
	public synchronized Ordine findbydesc(String des) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Ordine ordine = new Ordine();

		String selectSQL = "SELECT * FROM " + TABLE_NAME + " WHERE id_ordine = ?";

		try {
			connection = DBManager.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1,des );

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ordine.setId_ordine(rs.getInt("id_ordine"));
				ordine.setStato_pagamento(rs.getString("stato_pagamento"));
				ordine.setDescrizione(rs.getString("descrizione"));
				ordine.setId_cli(rs.getInt("id_cli"));
				ordine.setData_ordine(rs.getTimestamp("data_ordine"));
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
		return ordine;
	}


}
