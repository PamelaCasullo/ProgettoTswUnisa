package it.MadDiscord.Model;

import java.io.Serializable;
import java.util.UUID;

public class ProdBean implements Bean, Serializable, Cloneable{

	private static final long serialVersionUID = 1L;

	private UUID id_carrello;
	
	private int id_prodotto;

	public UUID getId_carrello() {
		return id_carrello;
	}

	public void setId_carrello(UUID id_carrello) {
		this.id_carrello = id_carrello;
	}

	public int getId_prodotto() {
		return id_prodotto;
	}

	public void setId_prodotto(int id_prodotto) {
		this.id_prodotto = id_prodotto;
	}

	public ProdBean (int uuid, UUID i) {
		this.id_prodotto = uuid;
		this.id_carrello = i;
	}
	
	 public ProdBean() {
	
	}

	 	public ProdBean clone() {
			try {
				ProdBean pBean = (ProdBean) super.clone();
				return pBean;
			} catch (CloneNotSupportedException e) {
				 e.printStackTrace();
		            return null;
			}
		}
	
}
