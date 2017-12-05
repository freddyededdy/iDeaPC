package Model;
public class Ordine {
private int id_ordine,id_cli;		
private String Stato_pagamento, descrizione;
private java.sql.Timestamp data_ordine;
public Ordine(int id_ord, String stato_p , int id_c,String des){
	this.id_cli = id_c;
	this.id_ordine = id_ord;
	
	this.Stato_pagamento = stato_p;	
	this.descrizione = des;
	this.data_ordine=null;
	}
public Ordine(){	
}
public int getId_ordine() {
	return id_ordine;
}
public void setId_ordine(int id_ordine) {
	this.id_ordine = id_ordine;
}
public java.sql.Timestamp getData_ordine() {
	return data_ordine;
}
public void setData_ordine(java.sql.Timestamp data_ordine) {
	this.data_ordine = data_ordine;
}
public int getId_cli() {
	return id_cli;
}
public void setId_cli(int id_cli) {
	this.id_cli = id_cli;
}

public String getStato_pagamento() {
	return Stato_pagamento;
}
public void setStato_pagamento(String stato_pagamento) {
	Stato_pagamento = stato_pagamento;
}
@Override
public String toString() {
	return "Ordine [id_ordine=" + id_ordine + ", id_cli=" + id_cli +", Stato_pagamento="
			+ Stato_pagamento + ", descrizione=" + descrizione + "]";
}
public String getDescrizione() {
	return descrizione;
}
public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
}


}
