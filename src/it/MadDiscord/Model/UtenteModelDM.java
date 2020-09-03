package it.MadDiscord.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import it.MadDiscord.DBConnectionPool;


public class UtenteModelDM {
	public UtenteBean doRetrieveBy(String nome_utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		UtenteBean bean = new UtenteBean();
		
		String selectSQL ="SELECT * FROM UserTable WHERE nome_utente=?";
		
		try {
			connection = DBConnectionPool.getConnection(); 
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, bean.getNome_utente()); //QUESTA RIGA VA BENE
			
			System.out.println("doRetriveBy:"+preparedStatement.toString());
			ResultSet rs= preparedStatement.executeQuery();
			
            while(rs.next()) {

                bean.setNome_utente(rs.getString("nome_utente"));
                bean.setPassword_utente(rs.getString("password_utente"));
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

	public Collection<UtenteBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		Collection<UtenteBean> users = new LinkedList<UtenteBean>();
		
		String selectSQL = "SELECT * FROM UserTable";
		
		if(order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}
		
		try {
			connection = DBConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			System.out.println("doRetrieveAll:" + preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				UtenteBean bean = new UtenteBean();
				
				bean.setNome_utente(rs.getString("nome_utente"));
                bean.setPassword_utente(rs.getString("password_utente"));
 
                
				users.add(bean);
			}
		} finally {
			try {
				if(preparedStatement != null) 
					preparedStatement.close();
			} finally {
				DBConnectionPool.releaseConnection(connection);
			}
		}
		
		return users;
	}

	public void doSave(UtenteBean user) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO UserTable" +
		"(nome_utente, password_utente)"+"VALUES( ?, ?)";
		
		try {
			connection = DBConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
		
			preparedStatement.setString(1, user.getNome_utente());
			preparedStatement.setString(2, user.getPassword_utente());
			
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


	public void doUpdate(UtenteBean user) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String updateSQL= "UPDATE UserTable SET password_utente=? WHERE nome_utente=?";

		try {
			connection = DBConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			
			preparedStatement.setString(1, user.getNome_utente());
			preparedStatement.setString(2, user.getPassword_utente());
			
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
		
		

	public void doDelete(UtenteBean user) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String deleteSQL= "DELETE FROM UserTable WHERE nome_utente=?";
		try {
			connection = DBConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, user.getNome_utente());
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

