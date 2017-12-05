package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ProdottoDs implements Model_Interface <Prodotto> {
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
private static final String TABLE_NAME = "prodotto";
	@Override
	public synchronized void  insert(Prodotto prodotto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + TABLE_NAME + 
				" (NOME , DESCRIZIONE, PREZZO , PATH_IMMAGINE , QUANTITA) VALUES (?, ?, ? , ? , ? )";


		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, prodotto.getNome());
			preparedStatement.setString(2, prodotto.getDescrizione());
			preparedStatement.setDouble(3, prodotto.getPrezzo());
			preparedStatement.setString(4, prodotto.getImmagine());
			preparedStatement.setInt(4, prodotto.getQuantità());
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
	public synchronized boolean remove(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + TABLE_NAME + " WHERE id_prod = ?";

		try {
			connection = ds.getConnection();
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

	@Override
	public synchronized Prodotto findByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Prodotto prodotto = new Prodotto();

		String selectSQL = "SELECT * FROM " + TABLE_NAME + " WHERE id_prod = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				prodotto.setId_prod(rs.getInt("id_prod"));
				prodotto.setNome(rs.getString("Nome"));
				prodotto.setDescrizione(rs.getString("descrizione"));
				prodotto.setPrezzo(rs.getDouble("prezzo"));
				prodotto.setImmagine(rs.getString("path_immagine"));
				prodotto.setQuantità(rs.getInt("quantita"));
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
		return prodotto;
	}

	@Override
	public synchronized Collection<Prodotto> findAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<Prodotto> prodotto = new LinkedList<Prodotto>();
		
		
		String selectSQL = "SELECT * FROM " + TABLE_NAME ;
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				Prodotto pr = new Prodotto();
				pr.setId_prod(rs.getInt("id_prod"));
				pr.setNome(rs.getString("Nome"));
				pr.setDescrizione(rs.getString("descrizione"));
				pr.setPrezzo(rs.getDouble("prezzo"));
				pr.setImmagine(rs.getString("path_immagine"));
				pr.setQuantità(rs.getInt("quantita"));
				
				prodotto.add(pr);
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
		Iterator<?> it = prodotto.iterator();
		while (it.hasNext()) {
			Prodotto prod = (Prodotto) it.next();
			
		}
		return prodotto;
	}

		@Override
		public synchronized void update(Prodotto prodotto) throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			String updateSql = "UPDATE " + TABLE_NAME + " SET NOME= ?, DESCRIZIONE= ? , PREZZO = ?, PATH_IMMAGINE = ? , QUANTITA = ? , WHERE id_prod = ? ";


			try {
				connection = ds.getConnection();
				preparedStatement = connection.prepareStatement(updateSql);
				preparedStatement.setInt(5, prodotto.getId_prod());
				preparedStatement.setString(1, prodotto.getNome());
				preparedStatement.setString(2, prodotto.getDescrizione());
				preparedStatement.setDouble(3,prodotto.getPrezzo());
				preparedStatement.setString(4, prodotto.getImmagine());
				preparedStatement.setInt(5, prodotto.getQuantità());
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

		
	}



