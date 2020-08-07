package it.MadDiscord.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import it.MadDiscord.login.bean.LoginBean;

public class LoginDat {
	
	public boolean validate(LoginBean loginBean) throws ClassNotFoundException{
		
		boolean status = false;
		Class.forName("com.mysql.jdbc.Driver");
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?useSSL=false","root","AntonioR99");
				
				//eseguiamo la query
				
		PreparedStatement prepStat = conn.prepareStatement("Select * from login where nome_utente = ? and password_utente=?"))
		{		
		
			
			prepStat.setString(1, loginBean.getNome_utente());
			prepStat.setString(2, loginBean.getPassword_utente());
			prepStat.setInt(3, 0);
			System.out.println(prepStat);
			
			ResultSet rs = prepStat.executeQuery();
			status=rs.next();
		} catch (SQLException e) {
			printSQLException(e);
		}
		return status;
		
	}

	private void printSQLException(SQLException e) {
		// TODO Auto-generated method stub
		System.out.println(e);
		
	}
}
