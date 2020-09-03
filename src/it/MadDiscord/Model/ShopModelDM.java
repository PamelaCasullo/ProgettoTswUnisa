package it.MadDiscord.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import it.MadDiscord.DBConnectionPool;

public class ShopModelDM implements IntModel<ShopBean,String> {
	
	public ShopBean doRetrieveBy(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ShopBean bean = new ShopBean();
		
		String selectSQL ="SELECT * FROM ShopTable WHERE id=?";
		
		try {
			connection = DBConnectionPool.getConnection(); 
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, Integer.parseInt(id));
			
			System.out.println("doRetriveBy:"+preparedStatement.toString());
			ResultSet rs= preparedStatement.executeQuery();
			
            while(rs.next()) {

                bean.setId(rs.getInt("id"));
                bean.setNome_oggetto(rs.getString("nome_oggetto"));
                bean.setPrezzo(rs.getInt("prezzo"));
                bean.setQuant(rs.getInt("quant"));
            }
           System.out.println(bean);
		} finally {
				try {
					if(preparedStatement != null) 
						preparedStatement.close();
				} finally {
					DBConnectionPool.releaseConnection(connection);
				}
			}
			
		return bean;
		
	}

	public Collection<ShopBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Collection<ShopBean> products = new LinkedList<ShopBean>();
		
		String selectSQL = "SELECT * FROM ShopTable";
		
		if(order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}
		
		try {
			connection = DBConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			System.out.println("doRetrieveAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				ShopBean bean = new ShopBean();
				
				bean.setId(rs.getInt("id"));
				bean.setNome_oggetto(rs.getString("nome_oggetto"));
				bean.setPrezzo(rs.getInt("prezzo"));
				bean.setQuant(rs.getInt("quant"));
				
				products.add(bean);
			}
		} finally {
			try {
				if(preparedStatement != null) 
					preparedStatement.close();
			} finally {
				DBConnectionPool.releaseConnection(connection);
			}
		}
		
		return products;
	}

	public void doSave(ShopBean product) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO ShopTable" +
		"(nome_oggetto, prezzo, quant)"+"VALUES( ?, ?, ?)";
		
		try {
			connection = DBConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
		
			preparedStatement.setString(1, product.getNome_oggetto());
			preparedStatement.setFloat(2, product.getPrezzo());
			preparedStatement.setInt(3, product.getQuant());
			
			System.out.println("doSave "+preparedStatement.toString());
			
			preparedStatement.executeUpdate();
			connection.commit();
			
			} finally {
					try {
						if(preparedStatement != null) 
							preparedStatement.close();
					} finally {
						DBConnectionPool.releaseConnection(connection);
					}
				}
		}


	public void doUpdate(ShopBean product) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String updateSQL= "UPDATE ShopTable SET nome_oggetto=?, prezzo=?, quant=? WHERE id=?";

		try {
			connection = DBConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			
			preparedStatement.setString(1, product.getNome_oggetto());
			preparedStatement.setFloat(2, product.getPrezzo());
			preparedStatement.setInt(3, product.getQuant());
			
			preparedStatement.setInt(4, product.getId());
			
			System.out.println("doUpdate: "+preparedStatement.toString());
		
			preparedStatement.executeUpdate();
			connection.commit();
			
		} finally {
			try {
				if(preparedStatement != null) 
					preparedStatement.close();
			} finally {
				DBConnectionPool.releaseConnection(connection);
			}
		}
	}
		
		

	public void doDelete(ShopBean product) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteSQL= "DELETE FROM ShopTable WHERE id=?";
		try {
			connection = DBConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, product.getId());
			System.out.println("DoDelete "+preparedStatement.toString());
		
			preparedStatement.executeUpdate();
			connection.commit();
		} finally {
			try {
				if(preparedStatement != null) 
					preparedStatement.close();
			} finally {
				DBConnectionPool.releaseConnection(connection);
			}
		}
	}

	@Override
	public void doDelete(String product) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
