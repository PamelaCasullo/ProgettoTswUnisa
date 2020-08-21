package it.MadDiscord.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.MadDiscord.DBConnectionPool;
import it.MadDiscord.Model.ShopBean;
import it.MadDiscord.Model.UtenteBean;

public class ShopDAO {
	public ShopBean insertProduct(ShopBean shopBean) throws SQLException {
		
		
		UtenteBean logBean = null;
		try (Connection conn = DBConnectionPool.getConnection(); )
		{		

			
			//eseguiamo la query
			
			PreparedStatement prepStat = conn.prepareStatement("Select * from ShopTable");
			
			ResultSet rs = prepStat.executeQuery();
			
			
			if(rs.next()) {
				logBean = new UtenteBean();
				logBean.setNome_utente(rs.getString("nome_utente"));
				logBean.setPassword_utente(rs.getString("password_utente"));
			}
			conn.close();
		} catch (SQLException e) {
			printSQLException(e);
		}
		
		return logBean;
		
	}

}
