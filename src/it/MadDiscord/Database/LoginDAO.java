package it.MadDiscord.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.MadDiscord.DBConnectionPool;
import it.MadDiscord.Model.UtenteBean;

public class LoginDAO {
	
	public UtenteBean validate(UtenteBean utenteBean) throws ClassNotFoundException{
		
	
		UtenteBean logBean = null;
		try (Connection conn = DBConnectionPool.getConnection(); )
		{		
			//eseguiamo la query
			PreparedStatement prepStat = conn.prepareStatement("Select nome_utente, password_utente from UserTable where nome_utente =? and password_utente=?");
			prepStat.setString(1, utenteBean.getNome_utente());
			prepStat.setString(2, utenteBean.getPassword_utente());
			
			System.out.println(prepStat);
			
			ResultSet rs = prepStat.executeQuery();
			
			
			if(rs.next()) {
				System.out.println("rs.next funziona in validate");
				logBean = new UtenteBean();
				logBean.setNome_utente(rs.getString("nome_utente"));
				
				
			logBean.setNome_utente(rs.getString("nome_utente"));
				logBean.setPassword_utente(rs.getString("password_utente"));
			}
			conn.close();
		} catch (SQLException e) {
			printSQLException(e);
		}
		
		return logBean;
		
	}
	
	
	private void printSQLException(SQLException e) {

		System.out.println(e);
		
	}
}
