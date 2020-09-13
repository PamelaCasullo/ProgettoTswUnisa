package it.MadDiscord.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.UUID;

import it.MadDiscord.DBConnectionPool;

public class ShopModelDM implements IntModel<ShopBean,String> {
	
	public ShopBean doRetrieveBy(String id) throws SQLException {
		
		PreparedStatement preparedStatement = null;
		
		ShopBean bean = new ShopBean();
		
		String selectSQL ="SELECT * FROM ShopTable WHERE id=?";
		
		try (Connection connection = DBConnectionPool.getConnection(); ) {
			
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, Integer.parseInt(id));
			
			System.out.println("doRetriveBy:"+preparedStatement.toString());
			ResultSet rs= preparedStatement.executeQuery();
			
            while(rs.next()) {

            	bean.setId(UUID.fromString(rs.getString("id")));
                bean.setNome_oggetto(rs.getString("nome_oggetto"));
                bean.setPrezzo(rs.getInt("prezzo"));
                bean.setQuant(rs.getInt("quant"));
            }
           System.out.println(bean);
			}
			
		return bean;
		
	}

	public Collection<ShopBean> doRetrieveAll(String order) throws SQLException {
		PreparedStatement preparedStatement = null;
		
		Collection<ShopBean> products = new LinkedList<ShopBean>();
		
		String selectSQL = "SELECT * FROM ShopTable";
		
		if(order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}
		
		try (Connection connection = DBConnectionPool.getConnection(); ) {
			
			preparedStatement = connection.prepareStatement(selectSQL);
			
			System.out.println("doRetrieveAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				ShopBean bean = new ShopBean();
				
				bean.setId(UUID.fromString(rs.getString("id")));
				bean.setNome_oggetto(rs.getString("nome_oggetto"));
				bean.setPrezzo(rs.getInt("prezzo"));
				bean.setQuant(rs.getInt("quant"));
				
				products.add(bean);
			}
		}
		
		return products;
	}

	public void doSave(ShopBean product) throws SQLException {
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO ShopTable" +
		"(nome_oggetto, prezzo, quant)"+"VALUES( ?, ?, ?)";
		
		try (Connection connection = DBConnectionPool.getConnection(); ) {
			preparedStatement = connection.prepareStatement(insertSQL);
		
			preparedStatement.setString(1, product.getNome_oggetto());
			preparedStatement.setFloat(2, product.getPrezzo());
			preparedStatement.setInt(3, product.getQuant());
			
			System.out.println("doSave "+preparedStatement.toString());
			
			preparedStatement.executeUpdate();
			connection.commit();
			
			}
		}


	public void doUpdate(ShopBean product) throws SQLException {
		PreparedStatement preparedStatement = null;
		
		String updateSQL= "UPDATE ShopTable(id,nome_oggetto, prezzo, quant) SET nome_oggetto=?, prezzo=?, quant=? WHERE id=?";
		try (Connection connection = DBConnectionPool.getConnection(); ){
			
			preparedStatement = connection.prepareStatement(updateSQL);
			
			preparedStatement.setString(1, product.getNome_oggetto());
			preparedStatement.setFloat(2, product.getPrezzo());
			preparedStatement.setInt(3, product.getQuant());
			preparedStatement.setString(4, product.getId().toString());
			System.out.println("doUpdate: "+preparedStatement.toString());
		
			preparedStatement.executeUpdate();
			connection.commit();
			
		}
	}
		
		

	public void doDelete(ShopBean product) throws SQLException {
		PreparedStatement preparedStatement = null;
		
		String deleteSQL= "DELETE FROM ShopTable WHERE id=?";
		try (Connection connection = DBConnectionPool.getConnection(); ){
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, product.getId().toString());
			System.out.println("DoDelete "+preparedStatement.toString());
		
			preparedStatement.executeUpdate();
			connection.commit();
		} 
	}

	@Override
	public void doDelete(String product) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
