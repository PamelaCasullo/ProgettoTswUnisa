package it.MadDiscord.Database;



import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import it.MadDiscord.DBConnectionPool;
import it.MadDiscord.Model.UtenteBean;

public class UtenteDAO {

		public int insertUser(UtenteBean uBean) {
			
			int r = 0;
			System.out.println("Prima della connessione" + uBean.getNome_utente());
			try (Connection con = DBConnectionPool.getConnection();)
			{
				PreparedStatement ps = con.prepareStatement("Insert into UserTable(nome_utente,email,password_utente) values(?,?,?)");
				ps.setString(1, uBean.getNome_utente());
				ps.setString(2, uBean.getEmail());
				ps.setBytes(3, uBean.getPassword_utente());

				ps.executeUpdate();
				con.commit();
				System.out.println("Nome utente" + uBean.getNome_utente());
				
				ps.close();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			r=1;
			return r;
		}
		
		public int updateUser(UtenteBean uBean)throws ClassNotFoundException{
			int result = 0;
			
			try (Connection conn = DBConnectionPool.getConnection(); )
			{
				//eseguiamo la query
				PreparedStatement prepStat = conn.prepareStatement("Update UserTable set email=?, password_utente=? where nome_utente=?");
				prepStat.setString(1, uBean.getNome_utente());
				prepStat.setString(2, uBean.getEmail());
				prepStat.setBytes(3, uBean.getPassword_utente());
				
				System.out.println(prepStat);
				result=prepStat.executeUpdate();
				
				prepStat.close();
				
			} catch (SQLException e) {
			
				System.out.println(e);
			}
			
			return result;
		}
		
		public int deleteUser(UtenteBean uBean) {
			
			int result = 0;
			
			try (Connection conn = DBConnectionPool.getConnection(); )
			{
				//eseguiamo la query
				PreparedStatement prepStat = conn.prepareStatement("delete from UserTable where nome_utente=?");
				
				prepStat.setString(1, uBean.getNome_utente());
				
				System.out.println(prepStat);
				result = prepStat.executeUpdate();
				
				prepStat.close();
				
			} catch (SQLException e) {
			
				System.out.println(e);
			}
			
			
			
			return result;
			
		}
	/*ADMINISTRATOR+USER*/
		public List<UtenteBean> allUtente() {
			List<UtenteBean> all = new ArrayList<>();
			
			try (Connection conn = DBConnectionPool.getConnection(); ) 
			{
				PreparedStatement prepStat = conn.prepareStatement("select nome_utente, email from UserTable");
				
				ResultSet rs = prepStat.executeQuery();
				
				while (rs.next()) {
					String nome_utente=rs.getString("nome_utente");
					String email=rs.getString("email");
					
					UtenteBean uBean = new UtenteBean();
					uBean.setNome_utente(nome_utente);
					uBean.setEmail(email);
					all.add(uBean);
				}
				
			rs.close();
			prepStat.close();
			
			} catch (SQLException e) {
				
				System.out.println(e);
			}
			return all;
		}
	
		
public boolean cambiaPassword(String email,String nuovaPassword,String vecchiaPassword) throws SQLException {
	
	
	if(email!=null && nuovaPassword!=null) { 
			try {
				MessageDigest md;
				md = MessageDigest.getInstance("SHA-256");
				byte nuova[]=md.digest(nuovaPassword.getBytes());
				byte vecchia[]=md.digest(vecchiaPassword.getBytes());

				if(Arrays.compare(vecchia, this.getUserPassword("email"))==0) {
					
					String sql="UPDATE UserTable SET password_utente=? WHERE email=?";
					try (Connection con = DBConnectionPool.getConnection(); PreparedStatement stat=con.prepareStatement(sql)){
						stat.setBytes(1, nuova);
						stat.setString(2, email);
						stat.executeUpdate();
						con.commit(); 
						return true;
					}
				}
				else
					return false;
			}
				 catch (NoSuchAlgorithmException e) {
					 e.printStackTrace();
					 return false;
			}
		
	}
	
	else 
		return false; 
	
}
public byte[] getUserPassword(String email) throws SQLException {
	PreparedStatement stat= null;
	String sql="SELECT * FROM UserTable WHERE email= ? ";
	
	try (Connection con = DBConnectionPool.getConnection()) {
		stat = con.prepareStatement(sql);
		stat.setString(1,email);
		
		System.out.println("getUserPassword=" + stat.toString());
		ResultSet rs = stat.executeQuery();
		
		while(rs.next()) {
			return rs.getBytes("password_utente");
		}
		
		return null;
		
	
}
}
}
