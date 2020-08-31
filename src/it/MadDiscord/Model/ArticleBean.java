package it.MadDiscord.Model;

public class ArticleBean {

		private int id_articolo;
		private String titolo;
		private String cont;
		private String immagine;
		
		public ArticleBean() {
			
		}
		
		public ArticleBean(String titolo, String immagine, String cont ) {
			this.cont = cont;
			this.immagine = immagine;
			this.titolo = titolo;
		}
		
		public int getId_articolo() {
			return id_articolo;
		}
		public void setId_articolo(int id_articolo) {
			this.id_articolo = id_articolo;
		}
		public String getTitolo() {
			return titolo;
		}
		public void setTitolo(String titolo) {
			this.titolo = titolo;
		}
		public String getCont() {
			return cont;
		}
		public void setCont(String cont) {
			this.cont = cont;
		}
		public String getImmagine() {
			return immagine;
		}
		public void setImmagine(String immagine) {
			this.immagine = immagine;
		}
}
