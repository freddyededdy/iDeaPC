/*
 * ClienteDs
 * Questa classe serve per la connessione sul database relativa all'oggetto cliente
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

public class ClienteDS implements Model_Interface<Cliente>{
	private static final String TABLE_NAME = "cliente";


	/**
	 * metodo che inserisce un cliente nel database
	 * @param un oggetto cliente da inserire 
	 */
	@Override
	public synchronized void insert(Cliente cliente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ClienteDS.TABLE_NAME + 
				" (NOME, COGNOME , DATA_NASCITA, CITT�_RES, VIA, NUM_CIVICO, CELLULARE,  EMAIL, PASS, T_CARTA, N_CARTA) VALUES (?, ?, ? , ?, ?, ?, ?, ?, ?, ?, ? )";


		try {
			connection = DBManager.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);

			preparedStatement.setString(1, cliente.getNome());
			preparedStatement.setString(2, cliente.getCognome());
			preparedStatement.setDate(3, cliente.getDate());
			preparedStatement.setString(4, cliente.getCitta());
			preparedStatement.setString(5, cliente.getVia());
			preparedStatement.setString(6, cliente.getN_civ());
			preparedStatement.setString(7, cliente.getCell());
			preparedStatement.setString(8, cliente.getEmail());
			preparedStatement.setString(9, cliente.getPassword());
			preparedStatement.setString(10,cliente.getTipo_carta());
			preparedStatement.setString(11,cliente.getN_carta());
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
	public synchronized void update(Cliente cliente) throws SQLException {
	}
	
	@Override
	public synchronized boolean remove(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + TABLE_NAME + " WHERE id_cli = ?";

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
	 * Metodo che cerca un cliente tramite la chiave primaria del cliente 
	 * @param id del cliente da cercare
	 * @return cliente , ovvero l'oggetto cliente trovato 
	 */

	@Override
	public synchronized Cliente findByKey(int id) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Cliente cliente = new Cliente();

		String selectSQL = "SELECT * FROM " + TABLE_NAME + " WHERE id_cli = ?";

		try {

			connection = DBManager.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {


				cliente.setId(rs.getInt("id_cli"));
				cliente.setNome(rs.getString("Nome"));
				cliente.setCognome(rs.getString("Cognome"));
				cliente.setDate(rs.getDate("data_nascita"));
				cliente.setCitta(rs.getString("citt�_res"));
				cliente.setVia(rs.getString("via"));
				cliente.setN_civ(rs.getString("num_civico"));
				cliente.setCell(rs.getString("cellulare"));
				cliente.setEmail(rs.getString("email"));
				cliente.setPassword(rs.getString("pass"));
				cliente.setTipo_carta(rs.getString("t_carta"));
				cliente.setN_carta(rs.getString("n_carta"));
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
		return cliente;
	}

	/**
	 * metodo che cerca il cliente per email
	 * @param Stringa email del cliente da cercare
	 * @return cliente , ovvero l'oggetto cliente trovato 
	 */
	public  synchronized Cliente findByMail(String email) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Cliente cliente = new Cliente();

		String selectSQL = "SELECT * FROM " + TABLE_NAME + " WHERE email= ?";

		try {

			connection = DBManager.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {


				cliente.setId(rs.getInt("id_cli"));
				cliente.setNome(rs.getString("Nome"));
				cliente.setCognome(rs.getString("Cognome"));
				cliente.setDate(rs.getDate("data_nascita"));
				cliente.setCitta(rs.getString("citt�_res"));
				cliente.setVia(rs.getString("via"));
				cliente.setN_civ(rs.getString("num_civico"));
				cliente.setCell(rs.getString("cellulare"));
				cliente.setEmail(rs.getString("email"));
				cliente.setPassword(rs.getString("pass"));
				cliente.setTipo_carta(rs.getString("t_carta"));
				cliente.setN_carta(rs.getString("n_carta"));
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
		return cliente;
	}

	/**
	 * Metodo che mi cerca tutti i clienti
	 * @return una collection di clienti 
	 */

	public synchronized Collection<Cliente> findAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<Cliente> cli = new LinkedList<Cliente>();


		String selectSQL = "SELECT * FROM " + TABLE_NAME ;

		try {
			connection = DBManager.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id_cli"));
				cliente.setNome(rs.getString("Nome"));
				cliente.setCognome(rs.getString("Cognome"));
				cliente.setDate(rs.getDate("data_nascita"));
				cliente.setCitta(rs.getString("citt�_res"));
				cliente.setVia(rs.getString("via"));
				cliente.setN_civ(rs.getString("num_civico"));
				cliente.setCell(rs.getString("cellulare"));
				cliente.setEmail(rs.getString("email"));
				cliente.setPassword(rs.getString("pass"));
				cliente.setTipo_carta(rs.getString("t_carta"));
				cliente.setN_carta(rs.getString("n_carta"));
				cli.add(cliente);
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

		return cli;
	}
	/**
	 * Metodo che mi cerca il cliente con quell'username e password
	 * @param una stringa contenente l'username e una stringa contenete la password 
	 * @return boolean true se il cliente con quell'username e password esiste false altrimenti
	 */
	public synchronized boolean findUserEPass(String user, String pass) throws SQLException{

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "SELECT * FROM " + TABLE_NAME + " WHERE email = ? && pass= ?";

		try {
			connection = DBManager.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, user);
			preparedStatement.setString(2, pass);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {

				return true;
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

		return false;

	}
	/**
	 * Metodo che mi cerca se quell'email � gia presente
	 * @param la stringa contente l'email da controllare
	 * @return boolean true se l'email � presente, false altrimenti
	 */
	public synchronized boolean findEmailPresente(String user) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;



		String selectSQL = "SELECT * FROM " + TABLE_NAME + " WHERE email = ?";

		try {

			connection = DBManager.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, user);


			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				return true;
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
		return false;
	}





}

