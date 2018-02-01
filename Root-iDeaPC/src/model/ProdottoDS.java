/*
* Composizione
* Questa classe serve per la connessione sul database relativa all'oggetto prodotto
*/
package model;
import java.sql.Driver;
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



public class ProdottoDS implements Model_Interface <Prodotto> {

private static final String TABLE_NAME = "prodotto";
/**
 * Metodo che inserisce un prodotto nel database
 * @param Il prodotto da inserire 
 */
	@Override
	public synchronized void  insert(Prodotto prodotto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + TABLE_NAME + 
				" (NOME , DESCRIZIONE, PREZZO , PATH_IMMAGINE, QUANTITA) VALUES (?, ?, ? , ? ,? )";


		try {
			connection = DBManager.getInstance().getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, prodotto.getNome());
			preparedStatement.setString(2, prodotto.getDescrizione());
			preparedStatement.setDouble(3, prodotto.getPrezzo());
			preparedStatement.setString(4, prodotto.getImmagine());
			preparedStatement.setInt(5, prodotto.getQuantità());
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
	 * Metodo che rimuove un prodotto dal database
	 * @param l'id del prodotto da rimuovere
	 * @return una variabile booleana result (0 se non ha eseguito niente, altro altrimenti)
	 */
	@Override
	public synchronized boolean remove(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + TABLE_NAME + " WHERE id_prod = ?";

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
	 * Metodo che cerca nel database un prodotto per id 
	 * @param l'id del prodotto da cercare
	 * @return il prodotto trovato
	 */
	@Override
	public synchronized Prodotto findByKey(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Prodotto prodotto = new Prodotto();

		String selectSQL = "SELECT * FROM " + TABLE_NAME + " WHERE id_prod = ?";

		try {
			connection = DBManager.getInstance().getConnection();
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
	/**
	 * Metodo che ritorna tutti i prodotti nel database 
	 * @return una collection di prodotti
	 */
	@Override
	public synchronized Collection<Prodotto> findAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<Prodotto> prodotto = new LinkedList<Prodotto>();
		
		
		String selectSQL = "SELECT * FROM " + TABLE_NAME ;
		
		try {
			connection = DBManager.getInstance().getConnection();
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
	/**
	 * Metodo che aggiorna un prodotto nel database
	 * @param il prodotto da aggiornare
	 */
		@Override
		public synchronized void update(Prodotto prodotto) throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			String selectSQL = "SELECT * FROM " + TABLE_NAME + " WHERE id_prod = ?";

			try {
				connection = DBManager.getInstance().getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);

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
		 * 
		 * @param nome_P
		 * nome del prodotto da cercare
		 */
		public synchronized Prodotto findbyname(String nome_P) throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			Prodotto prodotto = new Prodotto();

			String selectSQL = "SELECT * FROM " + TABLE_NAME + " WHERE nome_prodotto = ?";

			try {
				connection = DBManager.getInstance().getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setString(1, nome_P);

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
}

		



