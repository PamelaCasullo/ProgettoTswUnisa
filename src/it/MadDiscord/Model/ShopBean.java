package it.MadDiscord.Model;

import java.io.Serializable;
import java.util.UUID;


public class ShopBean implements Serializable {
	
	public ShopBean() {
		id= UUID.randomUUID();
		nome_oggetto = "";
		prezzo = 0;
		quant = 0;
	}
	public ShopBean(UUID id, String nome_oggetto, float prezzo, int quant ) {
		
		this.id = id;
		this.nome_oggetto=nome_oggetto;
		this.prezzo=prezzo;
		this.quant=quant;
		
		
	}

	public UUID getId() {
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

	public void setId(UUID id) {
		this.id = id;
	}

	public int getQuant() {
		return quant;
	}

	public void setQuant(int quant) {
		this.quant = quant;
	}

	@Override
	public boolean equals(Object other) {
		return(this.getId()==((ShopBean)other).getId());
	}
	@Override
	public String toString() {
		return nome_oggetto+"("+id+")"+prezzo+","+quant;
	}

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected UUID id;
	protected String nome_oggetto;
	protected float prezzo;
	protected int quant;

	
}
