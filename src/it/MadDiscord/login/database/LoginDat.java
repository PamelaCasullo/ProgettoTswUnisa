package it.MadDiscord.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import it.MadDiscord.login.bean.LoginBean;

public class LoginDat {
	
	public LoginBean validate(LoginBean loginBean) throws ClassNotFoundException{
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		LoginBean logBean = null;
		try
		{		
		
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Società_di_esports?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false","root","AntonioR99");
			
			//eseguiamo la query
			
			PreparedStatement prepStat = conn.prepareStatement("Select nome_utente, password_utente from UserTable where nome_utente =? and password_utente=?");
			
			prepStat.setString(1, loginBean.getNome_utente());
			prepStat.setString(2, loginBean.getPassword_utente());
			
			System.out.println(prepStat);
			
			ResultSet rs = prepStat.executeQuery();
			
			
			if(rs.next()) {
				logBean = new LoginBean();
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
