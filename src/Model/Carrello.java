package Model;

import java.util.ArrayList;

import Model.Prodotto;

	public class Carrello  {
	     
	    ArrayList<Prodotto> oggetti_carrello;
	     
	    public Carrello() {
	            oggetti_carrello = new ArrayList<Prodotto>();
	    }
	         
	    @Override
		public String toString() {
			return "Carrello [oggetti_carrello=" + oggetti_carrello + "]";
		}

		public void aggiungi(Prodotto prodotto) {
	            oggetti_carrello.add(prodotto);
	    }
	    public void rimuovi(int indice) {
	            oggetti_carrello.remove(indice);
	    }   
	    public ArrayList<Prodotto> getOggettiCarrello() {
	            return oggetti_carrello;
	    }
	    public void rimuovitutto(){
	    	oggetti_carrello.clear();
	    }
	    }

