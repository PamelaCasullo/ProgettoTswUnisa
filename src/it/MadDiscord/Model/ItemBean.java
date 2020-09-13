package it.MadDiscord.Model;


public class ItemBean {

	private ProdBean pBean;
	private ShopBean sBean;

	public ProdBean getpBean() {
		return pBean;
	}

	public void setpBean(ProdBean pBean) {
		this.pBean = pBean;
	}
	
	@Override
	public String toString() {
		return "ItemBean{"+pBean+'}';
	}

	public ShopBean getsBean() {
		return sBean;
	}

	public void setsBean(ShopBean sBean) {
		this.sBean = sBean;
	}
	
	
}
