/*
* Composizione
* Questa classe modella l'ogetto composizione dato da una relazione n a n sul database
*/
package model;	

public class Composizione {
	private int id_ordne, id_prod, quantita;
	private double prezzo;
	private String nome_p;
	/**
	 * Costruttore vuoto della classe composizione
	 */
public Composizione(){
	
}
/**
 * Costruttore della classe composizone 
 * @param id dell'ordine
 * @param id del prodotto ordinato
 * @param quantita di prodotto acquistato
 * @param il prezzo del prodotto acquistato
 * @param nome del prodotto acquistato
 */
public Composizione(int id_o, int id_p, double p , int q, String nome_p){
	this.id_ordne=id_o;
	this.id_prod=id_p;
	this.quantita = q;
	this.prezzo = p;
	this.nome_p=nome_p;
	
}
public String getNome_p() {
	return nome_p;
}
public void setNome_p(String nome_p) {
	this.nome_p = nome_p;
}
@Override
public String toString() {
	return "Composizione [id_ordne=" + id_ordne + ", id_prod=" + id_prod + ", quantita=" + quantita + ", prezzo="
			+ prezzo + "]";
}
public int getId_ordne() {
	return id_ordne;
}
public void setId_ordne(int id_ordne) {
	this.id_ordne = id_ordne;
}
public int getId_prod() {
	return id_prod;
}
public void setId_prod(int id_prod) {
	this.id_prod = id_prod;
}
public int getQuantita() {
	return quantita;
}
public void setQuantita(int quantita) {
	this.quantita = quantita;
}
public double getPrezzo() {
	return prezzo;
}
public void setPrezzo(double prezzo) {
	this.prezzo = prezzo;
}

}
