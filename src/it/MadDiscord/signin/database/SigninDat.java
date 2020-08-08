package it.MadDiscord.signin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import it.MadDiscord.signin.bean.SigninBean;

public class SigninDat {
	
public int registerUser(SigninBean sigBean) throws ClassNotFoundException{
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		int result = 0;
	//	SigninBean SigBean = null;
		try
		{		
		
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Società_di_esports?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false","root","AntonioR99");
			
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

		System.out.println(e);
		
	}
}


