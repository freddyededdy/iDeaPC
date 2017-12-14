package model;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Cliente {
	private String nome , cognome, citta, via , n_civ, email, password,  cell;
	private Date date;
	private int id;
	private String n_carta=null;
	private String tipo_carta=null;
	public Cliente(){}
	public Cliente(int i, String n, String c , Date d, String ci,  String v, String nc, String ce, String em, String pass){
		this.id = i;
		this.nome = n;
		this.cognome = c;
		this.citta = ci;
		this.via = v;
		this.n_civ =nc;
		this.email = em;
		this.password = pass;
		this.cell = ce;
		this.date = d;
	}
	public String getNome() {
		return nome;
	}
	public String getCognome() {
		return cognome;
	}
	public String getCitta() {
		return citta;
	}
	public String getVia() {
		return via;
	}
	public String getN_civ() {
		return n_civ;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}

	public String getCell() {
		return cell;
	}
	public Date getDate() {
		return date;
	}
	
	public int getId() {
		return id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public void setCitta(String citta) {
		this.citta = citta;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public void setN_civ(String n_civ) {
		this.n_civ = n_civ;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getN_carta() {
		return n_carta;
	}
	public void setN_carta(String n_carta) {
		this.n_carta = n_carta;
	}
	public String getTipo_carta() {
		return tipo_carta;
	}
	public void setTipo_carta(String tipo_carta) {
		this.tipo_carta = tipo_carta;
	}

	
	public void setCell(String cell) {
		this.cell = cell;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cognome=" + cognome + ", citta=" + citta + ", via=" + via + ", n_civ="
				+ n_civ + ", email=" + email + ", password=" + password + ", cell=" + cell + ", date=" + date + ", id="
				+ id + ", n_carta=" + n_carta + ", tipo_carta=" + tipo_carta + "]";
	}
	
	
}
