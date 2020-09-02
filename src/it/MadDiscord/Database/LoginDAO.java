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
			PreparedStatement prepStat = conn.prepareStatement("Select email, password_utente from UserTable where email =? ");
			prepStat.setString(1, utenteBean.getEmail());
			
			System.out.println(prepStat);
			
			ResultSet rs = prepStat.executeQuery();
			
			
			if(rs.next()) {
				System.out.println("rs.next funziona in validate");
				logBean = new UtenteBean();
				logBean.setEmail(rs.getString("email"));
				
				
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
