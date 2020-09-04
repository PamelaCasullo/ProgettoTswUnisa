package it.MadDiscord.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import it.MadDiscord.DBConnectionPool;
import it.MadDiscord.Model.UtenteBean.Tipo;


public class UtenteModelDM implements IntModel<UtenteBean,String> {
	public UtenteBean doRetrieveBy(String nome_utente) throws SQLException {
		
		PreparedStatement preparedStatement = null;
		
		UtenteBean bean = new UtenteBean();
		
		String selectSQL ="SELECT * FROM UserTable WHERE email=?";
		
		try (Connection con = DBConnectionPool.getConnection()) {
			
			preparedStatement = con.prepareStatement(selectSQL);
			preparedStatement.setString(1, nome_utente);
			
			System.out.println("doRetriveBy:"+preparedStatement.toString());
			ResultSet rs= preparedStatement.executeQuery();
			
            while(rs.next()) {

                bean.setNome_utente(rs.getString("nome_utente"));
                bean.setEmail(rs.getString("email"));
                bean.setPassword_utente(rs.getString("password_utente"));
                System.out.println("-"+rs.getString("idAdmin")+"-");
                switch (rs.getString("idAdmin")) {
                
				case "utente": 
					System.out.println("sono un utente");
					bean.setTipo(Tipo.utente);
					break;
				case "admin": 
					System.out.println("sono un admin");
					bean.setTipo(Tipo.admin);
					break;

				}
                
                
            }
		} 
		
		if(bean.isEmpty())
			return null;
		else
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

		
		String insertSQL = "INSERT INTO UserTable VALUES(?,?,?,?)";
		
		try (Connection connection = DBConnectionPool.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);){
			
		
		
			preparedStatement.setString(1, user.getNome_utente());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, user.getTipo());
			preparedStatement.setBytes(4, user.getPassword_utente());
			
			System.out.println("doSave "+preparedStatement.toString());
			
			preparedStatement.executeUpdate();
			connection.commit();
			
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
			preparedStatement.setBytes(2, user.getPassword_utente());
			
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
		


	public void doDelete(String email) throws SQLException {
			String sql="DELETE FROM UserTable WHERE email = ?";
		
		try (Connection con = DBConnectionPool.getConnection();PreparedStatement statement=con.prepareStatement(sql);) {
			
			statement.setString(1,email);
			System.out.println("DoDelete=" + statement.toString());
			statement.executeUpdate();
			con.commit();
		
	}
		
	}
}

