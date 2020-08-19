package it.MadDiscord.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.MadDiscord.DBConnectionPool;
import it.MadDiscord.Model.UtenteBean;

public class SigninDAO {
	
public int registerUser(UtenteBean sigBean) throws ClassNotFoundException{
		
		
		int result = 0;
	//	UtenteBean SigBean = null;
		try(Connection conn = DBConnectionPool.getConnection(); )
		{		
			
			//e la query
			
			PreparedStatement prepStat = conn.prepareStatement("INSERT into UserTable values (? ,?, 0)");
			
			prepStat.setString(1, sigBean.getNome_utente());
			prepStat.setString(2, sigBean.getPassword_utente());
			
			System.out.println(prepStat);
			
			result=prepStat.executeUpdate();
			
		} catch (SQLException e) {

			printSQLException(e);
		}
		
		return result;
		
	}

	private void printSQLException(SQLException e) {
		System.out.println("eccezione");
		System.out.println(e);
		
	}
}


