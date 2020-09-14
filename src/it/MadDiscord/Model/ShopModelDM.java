package it.MadDiscord.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.UUID;

import it.MadDiscord.DBConnectionPool;

public class ShopModelDM{
	
	public ShopBean doRetrieveBy(String id) throws SQLException {
		
		PreparedStatement preparedStatement = null;
		
		ShopBean bean = new ShopBean();
		
		String selectSQL ="SELECT * FROM ShopTable WHERE id=?";
		
		try (Connection connection = DBConnectionPool.getConnection(); ) {
			
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, id);
			
			System.out.println("doRetriveBy:"+preparedStatement.toString());
			ResultSet rs= preparedStatement.executeQuery();
			
            while(rs.next()) {

            	bean.setId(UUID.fromString(rs.getString("id")));
            	bean.setId_prod(Integer.parseInt("id_prod"));
                bean.setNome_oggetto(rs.getString("nome_oggetto"));
                bean.setPrezzo(rs.getInt("prezzo"));

            }
           System.out.println(bean);
			}
			
		return bean;
		
	}
	public ShopBean doRetrieveById(String nome_oggetto) throws SQLException {
		
		PreparedStatement preparedStatement = null;
		
		ShopBean bean = new ShopBean();
		
		String selectSQL ="SELECT * FROM ShopTable WHERE nome_oggetto=?";
		
		try (Connection connection = DBConnectionPool.getConnection(); ) {
			
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, nome_oggetto);
			
			System.out.println("doRetriveById:"+preparedStatement.toString());
			ResultSet rs= preparedStatement.executeQuery();
			
            while(rs.next()) {
            	bean.setId(UUID.fromString(rs.getString("id")));
            	bean.setId_prod(Integer.parseInt("id_prod"));
            
                bean.setNome_oggetto(rs.getString("nome_oggetto"));
                bean.setPrezzo(rs.getInt("prezzo"));

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
				
				products.add(bean);
			}
		}
		
		return products;
	}

	public int doSave(ShopBean product) throws SQLException {
		
		int r=0;
		
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO ShopTable(id, nome_oggetto, prezzo) VALUES(?,?,?)";
		
		try (Connection connection = DBConnectionPool.getConnection(); ) {
			preparedStatement = connection.prepareStatement(insertSQL);
			
			preparedStatement.setString(1, product.getId().toString());
			preparedStatement.setString(2, product.getNome_oggetto());
			preparedStatement.setFloat(3, product.getPrezzo());
			
			preparedStatement.executeUpdate();
			connection.commit();
			
			preparedStatement.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		r=1;
		return r;
		}


	public int doUpdate(ShopBean product) throws SQLException {
		int r=0;
		PreparedStatement preparedStatement = null;
		
		String updateSQL= "UPDATE ShopTable(nome_oggetto, prezzo) SET nome_oggetto=?, prezzo=? WHERE id=?";
		try (Connection connection = DBConnectionPool.getConnection(); ){
			
			preparedStatement = connection.prepareStatement(updateSQL);
			
			preparedStatement.setString(1, product.getNome_oggetto());
			preparedStatement.setFloat(2, product.getPrezzo());
			preparedStatement.setString(3, product.getId().toString());
			
			System.out.println("doUpdate: "+preparedStatement.toString());
		
			preparedStatement.executeUpdate();
			connection.commit();
			preparedStatement.close();
			
		}
		r=1;
		return r;
	}
		
		

	public void doDelete(ShopBean sBean) throws SQLException {
		PreparedStatement preparedStatement = null;
		
		String deleteSQL= "DELETE FROM ShopTable WHERE nome_oggetto=?";
		try (Connection connection = DBConnectionPool.getConnection();){
			
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, sBean.nome_oggetto);
			
			System.out.println("doDelete="+preparedStatement);
			preparedStatement.executeUpdate();	
			connection.commit();
		} 
	}

}

