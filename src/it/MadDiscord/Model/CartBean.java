package it.MadDiscord.Model;





public class CartBean  { 
	
	public CartBean (String id_cart, float totale) {
		this.id_cart = id_cart;
		this.totale = totale;
	}
		
	

	private float totale;
	
	private String id_cart;
	
	public float getTotale() {
		return totale;
	}

	public void setTotale(float totale) {
		this.totale = totale;
	}

	public String getId_cart() {
		return id_cart;
	}

	public void setId_cart(String id_cart) {
		this.id_cart = id_cart;
	}
	
	@Override
	public String toString() {
		return "CartBean [totale=" + totale + ", id_cart=" + id_cart + ", getClass()=" + getClass() + "]";
	}
	
	public boolean equals (Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		CartBean that = (CartBean) o;
		return id_cart.equals(that.id_cart);
	}

	
	
	public CartBean () {
		
	}

	
	
	
	
}
