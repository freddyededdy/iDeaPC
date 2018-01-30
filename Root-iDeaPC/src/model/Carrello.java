/*
 * Carrello
 * Questa classe modella l'oggetto carrello
 */

package model;

import java.util.ArrayList;

/**
 * @author Aquilino
 *
 */
public class Carrello  {

	ArrayList<Prodotto> oggetti_carrello;
	/**
	 * Costruttore vuoto della classe carrello
	 */

	public Carrello() {
		oggetti_carrello = new ArrayList<Prodotto>();
	}
	/**
	 * metodo che stampa gli oggetti del carrello
	 * @return la stringa degli oggetti nel carrello
	 */
	@Override
	public String toString() {
		return "Carrello [oggetti_carrello=" + oggetti_carrello + "]";
	}
	/**
	 *metodo che aggiunge un prodotto al carrello
	 * @param prodotto da aggiungere
	 */
	public void aggiungi(Prodotto prodotto) {
		oggetti_carrello.add(prodotto);
	}
	/**
	 * metodo che rimuove l'oggetto desiderato dall'Arraylist
	 * @param indice da rimuovere
	 */
	public void rimuovi(int indice) {
		oggetti_carrello.remove(indice);
	}   
	/**
	 * metodo che ritorna l'arrayList del carrello
	 * @return arrayList oggetti_carrello di tipo prodotto
	 */
	public ArrayList<Prodotto> getOggettiCarrello() {
		return oggetti_carrello;
	}
	/**
	 * metodo che rimuove tutti gli oggetti dall'arraylist del carrello 
	 */
	public void rimuovitutto(){
		oggetti_carrello.clear();
	}
}