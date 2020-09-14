package it.MadDiscord.Model;

import java.io.Serializable;
import java.util.UUID;


public class ShopBean implements Serializable {
	
	public ShopBean() {
		this.id = UUID.randomUUID();
	}
	public ShopBean(UUID id, String nome_oggetto, float prezzo, int quant,  int id_prod ) {
		
		this.id = id;
		this.nome_oggetto=nome_oggetto;
		this.prezzo=prezzo;
		this.id_prod = id_prod;

		
		
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
	public void setId_prod(int id_prod) {
		this. id_prod = id_prod;
		
	}
	public int getId_prod() {
		return id_prod;
		
	}





	@Override
	public boolean equals(Object other) {
		return(this.getId()==((ShopBean)other).getId());
	}
	@Override
	public String toString() {
		return nome_oggetto+"("+id+")"+prezzo;
	}

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected UUID id;
	protected int id_prod;
	protected String nome_oggetto;
	protected float prezzo;

	
}
