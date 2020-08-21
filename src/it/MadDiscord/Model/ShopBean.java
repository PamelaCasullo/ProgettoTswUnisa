package it.MadDiscord.Model;

import java.io.Serializable;

public class ShopBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String nome_oggetto;
	protected float prezzo;
	
	public int getId() {
		return id;
	}

	public String getNome_oggetto() {
		return nome_oggetto;
	}

	public void setNome_oggetto(String nome_oggetto) {
		this.nome_oggetto = nome_oggetto;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
