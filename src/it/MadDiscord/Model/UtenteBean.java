package it.MadDiscord.Model;

import java.io.Serializable;
import java.security.MessageDigest;

import com.google.gson.Gson;

public class UtenteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nome_utente;
	private byte[] password_utente;
	private String email;
	private Tipo tipo;
	public enum Tipo {utente, admin}
	
	
public UtenteBean() {
		
		this.nome_utente = "";
		this.email = "";
		this.password_utente =new byte[32];
		
	}
	
	public String getNome_utente() {
		return nome_utente;
	}
	
	public void setNome_utente(String nome_utente) {
		this.nome_utente= nome_utente;
	}
	public byte[] getPassword_utente() {
		return password_utente;
	}
	public void setPassword_utente(String password) {
		
		try {
			MessageDigest mess;
			mess = MessageDigest.getInstance("SHA-256");
			byte arr[] = mess.digest(password.getBytes());
			this.password_utente = arr;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public String getTipo() {
		Gson g = new Gson();
		//turn g.toJson(this);
		return tipo.name();
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
		

	}
	public boolean isEmpty() {
		if(email==null||email=="") 
			return true;
		else return false;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String toString() {
		return nome_utente+","+password_utente+","+email;
	}
	

	public boolean equals(Object other) {
		return(this.getNome_utente()==((UtenteBean)other).getNome_utente());
	}

	
	
}
