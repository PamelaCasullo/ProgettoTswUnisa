package it.MadDiscord.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import it.MadDiscord.DBConnectionPool;
import it.MadDiscord.Model.CartBean;
import it.MadDiscord.Model.IntModel;
import it.MadDiscord.Model.ProdBean;
import java.util.UUID;

public class CartDAO implements IntModel<CartBean, String> {
    

    

	@Override
	public CartBean doRetrieveBy(String id) throws SQLException {
		String sql ="SELECT * FROM CartTable WHERE id_cart=?";
		PreparedStatement preparedStatement = null;
		CartBean carrello;
		try (Connection connection = DBConnectionPool.getConnection();) {
			 preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1,id);
	            ResultSet rs = preparedStatement.executeQuery();

	            carrello = mapFromResultSet(rs);
		}
		return carrello;
	}

	@Override
	public Collection<CartBean> doRetrieveAll(String order) throws SQLException {
		String sql="SELECT * FROM CartTable";
		 PreparedStatement preparedStatement = null;
	     List<CartBean> carrelloBeans = new ArrayList<>();
	     try (Connection connection = DBConnectionPool.getConnection();) {
	    	 preparedStatement = connection.prepareStatement(sql);
	            ResultSet rs = preparedStatement.executeQuery();
	            mapFromResultSet(carrelloBeans, rs);
	     }
		return carrelloBeans;
	}

	@Override
	public void doSave(CartBean product) throws SQLException {
		String sql = "INSER INTO CartTable (id_cart, totale) VALUES (?, 0)";
		PreparedStatement preparedStatement = null;
		try (Connection connection = DBConnectionPool.getConnection();) {
			 preparedStatement = connection.prepareStatement(sql);
	         preparedStatement.setString(1, product.getId_cart());
	         preparedStatement.executeUpdate();
	         connection.commit();
		}
		
	}

	@Override
	public void doUpdate(CartBean product) throws SQLException {
	
		
	}

	@Override
	public void doDelete(String product) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	
	 private CartBean mapFromResultSet(ResultSet rs) throws SQLException {
	        if (rs.next()) {
	            return new CartBean(
	              rs.getString("id_cart"),
	              rs.getFloat("totale")
	            );
	        }
	        return new CartBean();
	}

	    private void mapFromResultSet(List<CartBean> carrelloBeans, ResultSet rs) throws SQLException {
	        while (rs.next()) {
	            carrelloBeans.add(new CartBean(rs.getString("id_cart"),
	                    rs.getFloat("totale")));
	       }
	 }
	    
	 public void addCarrello (CartBean carrello, ProdBean prodotto ) throws SQLException {
		 String sql = "insert into ProdCart values (?, ?)";
		 String sql2= "update CartTable set totale = totale + (select prezzo from ShopTable where id = ?) where id_cart = ?";
		 PreparedStatement preparedStatement = null;
		 try (Connection connection = DBConnectionPool.getConnection();) {
			  preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, carrello.getId_cart());
	            preparedStatement.setString(2, prodotto.getId_carrello().toString());
	            preparedStatement.executeUpdate();
	            connection.commit();
	            preparedStatement = connection.prepareStatement(sql2);
	            preparedStatement.setString(1, prodotto.getId_carrello().toString());
	            preparedStatement.setString(2, carrello.getId_cart());
	            preparedStatement.executeUpdate();
	            connection.commit();
		 }
	 }

	 public void removeCarrello(CartBean carrello, ProdBean prodotto) throws SQLException {
		 String sql = "delete from ProdCart where id_carrello = ? and id_prodotto = ?";
		 String sql2 = "update CartTable set totale = totale - (select prezzo from ShopTable where id = ?) where id_cart = ?";
		 PreparedStatement preparedStatement = null;
		 
		 try(Connection connection = DBConnectionPool.getConnection();) {
			 	preparedStatement = connection.prepareStatement(sql2);
	            preparedStatement.setString(1, prodotto.getId_carrello().toString());
	            preparedStatement.setString(2, carrello.getId_cart());
	            preparedStatement.executeUpdate();

	            preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, carrello.getId_cart());
	            preparedStatement.setString(2, prodotto.getId_carrello().toString());
	            preparedStatement.executeUpdate();
	            connection.commit();
		 }
	 }
	 
	 public ArrayList<UUID> vediCarrello (CartBean carrello) throws SQLException {
		 ArrayList<UUID> prodotti = new ArrayList<>();
		 String sql = "SELECT id_prodotto FROM ProdCart where id_carrello = ?";
		 PreparedStatement preparedStatement = null;
		 
		 try(Connection connection = DBConnectionPool.getConnection();) {
			 	preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, carrello.getId_cart());
	            ResultSet rs = preparedStatement.executeQuery();
	            while (rs.next()) {
	                prodotti.add((UUID.fromString(rs.getString("id_prodotto"))));
	            }
	            return prodotti;
		 }
	 }
	  
	 
}

