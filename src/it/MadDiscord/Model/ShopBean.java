package it.MadDiscord.Model;

import java.io.Serializable;

public class ShopBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int id;
	protected String nome_oggetto;
	protected float price;
	
	public int getId() {
		return id;
	}

	public String getNome_oggetto() {
		return nome_oggetto;
	}

	public void setNome_oggetto(String nome_oggetto) {
		this.nome_oggetto = nome_oggetto;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
