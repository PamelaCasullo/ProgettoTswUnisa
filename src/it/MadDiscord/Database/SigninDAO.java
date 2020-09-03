package it.MadDiscord.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.MadDiscord.DBConnectionPool;
import it.MadDiscord.Model.UtenteBean;

public class SigninDAO {
	
public int registerUser(UtenteBean sigBean) throws ClassNotFoundException{
		
		
		int result = 0;
	
		try(Connection conn = DBConnectionPool.getConnection(); )
		{		
			//eseguiamo la query
			PreparedStatement prepStat = conn.prepareStatement("INSERT into UserTable values (? ,?, ?)");


			prepStat.setString(1, sigBean.getNome_utente());
			prepStat.setString(2, sigBean.getEmail());
			prepStat.setString(3, sigBean.getPassword_utente());
			
			System.out.println(prepStat);
			
			result=prepStat.executeUpdate();
			conn.commit();
			
		} catch (SQLException e) {

			printSQLException(e);
		}
		System.out.println("result set "+result );
		return result;
		
	}

	/**   IO DAO   **/

public int deleteUser(UtenteBean utenteBean) throws ClassNotFoundException{
	
	int result = 0;
	
	try(Connection conn = DBConnectionPool.getConnection(); )
	{
		//eseguiamo la query
		PreparedStatement prepStat = conn.prepareStatement("delete from UserTable where email?");
		
		prepStat.setString(1, utenteBean.getEmail());
		
		System.out.println(prepStat);
		
		result=prepStat.executeUpdate();
		
		prepStat.close();
		
	} catch (SQLException e) {
		printSQLException(e);
	}
	
	return result;
}


public int updateUser(UtenteBean utenteBean) throws ClassNotFoundException{
	
	int result = 0;
	
	try(Connection conn = DBConnectionPool.getConnection(); )
	{
		//eseguo query
		PreparedStatement prepStat = conn.prepareStatement("update UserTable set password_utente=?, where email=?");
		
		prepStat.setString(1, utenteBean.getEmail());

		prepStat.setString(2, utenteBean.getPassword_utente());
		
		System.out.println(prepStat);
		
		result=prepStat.executeUpdate();
		
		prepStat.close();
		
	} catch (SQLException e) {
		printSQLException(e);
	}
	
	return result;
}


public List<UtenteBean> allUser() {
	
	List<UtenteBean> all = new ArrayList<>();
	
	try (Connection conn = DBConnectionPool.getConnection(); )
	{
		//query
		PreparedStatement prepStat = conn.prepareStatement("select * from UserTable");
		
		ResultSet rs = prepStat.executeQuery();
		
		while (rs.next()) {
			String nome_utente = rs.getString("nome_utente");
			String email = rs.getString("email");
			String password_utente = rs.getString("password_utente");
			
			UtenteBean uBean = new UtenteBean();
			uBean.setNome_utente(email);
			uBean.setNome_utente(nome_utente);
			uBean.setPassword_utente(password_utente);
			all.add(uBean);
		}
		
		rs.close();
		prepStat.close();
		
	} catch (SQLException e) {
		printSQLException(e);
	}
	
	return all;
}


// è buono cosi questo????
public UtenteBean getUtente(String nome_utente) {
	
	UtenteBean uBean = null;
	
	try (Connection conn = DBConnectionPool.getConnection(); )
	{
		//query
		PreparedStatement prepStat = conn.prepareStatement("select from UserTable where email=?");
		
		prepStat.setString(1, nome_utente);
		ResultSet rs = prepStat.executeQuery();
		
		while (rs.next()) {
			String email = rs.getString("email");
			
			uBean = new UtenteBean();
			
			uBean.setPassword_utente(email);
		}
		
		rs.close();
		prepStat.close();
		
	} catch (SQLException e) {
		printSQLException(e);
	}
	
	return uBean;
}

	/**   IO DAO   **/

	private void printSQLException(SQLException e) {
		System.out.println("eccezione");
		System.out.println(e);
		
	}
}


