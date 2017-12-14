package model;
public class Prodotto {
private int id_prod;
private String nome, descrizione;
private double prezzo;
private int quantita;
private String immagine;
public Prodotto( int id, String n, String d, double p, String im, int q){
	this.id_prod = id;
	this.nome = n;
	this.descrizione = d;
	this.prezzo = p;
	this.quantita= q;
	this.immagine=im;
	}
public Prodotto() {
	// TODO Auto-generated constructor stub
}
public String getImmagine() {
	return immagine;
}
public void setImmagine(String immagine) {
	this.immagine = immagine;
}
public int getId_prod() {
	return id_prod;
}
public void setId_prod(int id_prod) {
	this.id_prod = id_prod;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getDescrizione() {
	return descrizione;
}
public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
}
public double getPrezzo() {
	return prezzo;
}
public void setPrezzo(double prezzo) {
	this.prezzo = prezzo;
}

public int getQuantità() {
	return quantita;
}
public void setQuantità(int quantità) {
	this.quantita = quantità;
}
@Override
public String toString() {
	return "Prodotto [id_prod=" + id_prod + ", nome=" + nome + ", descrizione=" + descrizione + ", prezzo=" + prezzo
			+ ", quantità=" + quantita + "]";
}


}
