package it.MadDiscord.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import it.MadDiscord.DBConnectionPool;

public class ArticleModelDM {

	
	public ArticleBean doRetrieveBy(String id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArticleBean bean = new ArticleBean();
		
		String selectSQL ="SELECT * FROM Article WHERE id_articolo=?";
		
		try {
			connection = DBConnectionPool.getConnection(); 
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, Integer.parseInt("id"));
			
			System.out.println("doRetriveBy:"+preparedStatement.toString());
			ResultSet rs= preparedStatement.executeQuery();
			
            while(rs.next()) {

                bean.setId_articolo(rs.getInt("id_articolo"));
                bean.setCont(rs.getString("cont"));
                bean.setImmagine(rs.getString("immagine"));
                bean.setTitolo(rs.getString("titolo"));
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

	public Collection<ArticleBean> doRetrieveAll(String all) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Collection<ArticleBean> products = new LinkedList<ArticleBean>();
		
		String selectSQL = "SELECT * FROM Article";
		
		if(all != null && !all.equals("")) {
			selectSQL += " all BY " + all;
		}
		
		try {
			connection = DBConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			System.out.println("doRetrieveAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				ArticleBean bean = new ArticleBean();
				
				bean.setId_articolo(rs.getInt("id"));
				bean.setCont(rs.getString("cont"));
				bean.setTitolo(rs.getString("titolo"));
				bean.setImmagine(rs.getString("immagine"));
				
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

	public void doSave(ArticleBean aBean) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO Article" +
		"(titolo, cont, immagine)"+"VALUES( ?, ?, ?)";
		
		try {
			connection = DBConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
		
			preparedStatement.setString(1, aBean.getTitolo());
			preparedStatement.setString(2, aBean.getCont());
			preparedStatement.setString(3, aBean.getImmagine());
			
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


	public void doUpdate(ArticleBean aBean) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String updateSQL= "UPDATE Article SET titolo=?, cont=?, immagine=? WHERE id_articolo=?";

		try {
			connection = DBConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			
			preparedStatement.setString(3, aBean.getTitolo());
			preparedStatement.setString(1, aBean.getCont());
			preparedStatement.setString(2, aBean.getImmagine());
			
			preparedStatement.setInt(4, aBean.getId_articolo());
			
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
		
		

	public void doDelete(ArticleBean aBean) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteSQL= "DELETE FROM Article WHERE id_articolo=?";
		try {
			connection = DBConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, aBean.getId_articolo());
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
}


