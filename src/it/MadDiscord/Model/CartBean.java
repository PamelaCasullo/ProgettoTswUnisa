package it.MadDiscord.Model;

import java.io.Serializable;

public class CartBean implements Serializable {

	private static final long serialVersionUID = 1L;
	int id;
	int quant;
	float prezzo;
	
	public CartBean () {
		
	}

	public int getId() {
		return id;
	}

	public int getQuant() {
		return quant;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	
	
	
}
