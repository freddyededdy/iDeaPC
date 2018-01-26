/*
* Fattura
* Questa classe modella l'ogetto Fattura
*/
package model;
public class Fattura {
	private int id_fattura;
	private final int iva = 22;
	private float imponibile, totale;
	private int id_ordine;
	/**
	 * Costruttore della fattura
	 * @param id fattura
	 * @param imponibile 
	 * @param totale fattura
	 * @param id ordine
	 */
public Fattura (int id_f, float imp, float tot, int id_ordine){
	this.id_fattura= id_f;
	this.imponibile = imp;
	this.totale = tot;
	this.id_ordine=id_ordine;
}
/**
 * Costruttore vuoto della fattura
 */
public Fattura() {
	// TODO Auto-generated constructor stub
}
public int getId_ordine() {
	return id_ordine;
}
public void setId_ordine(int id_ordine) {
	this.id_ordine = id_ordine;
}
public int getId_fattura() {
	return id_fattura;
}
public void setId_fattura(int id_fattura) {
	this.id_fattura = id_fattura;
}
public float getImponibile() {
	return imponibile;
}
public void setImponibile(float imponibile) {
	this.imponibile = imponibile;
}
public float getTotale() {
	return totale;
}
public void setTotale(float totale) {
	this.totale = totale;
}
public int getIva() {
	return iva;
}
@Override
public String toString() {
	return "Fattura [id_fattura=" + id_fattura + ", iva=" + iva + ", imponibile=" + imponibile + ", totale=" + totale
			+ "]";
}

}
