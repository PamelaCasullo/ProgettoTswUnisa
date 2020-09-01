package it.MadDiscord.Database;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.MadDiscord.DBConnectionPool;
import it.MadDiscord.Model.UtenteBean;

public class UtenteDAO {

	/*ADMIN*/
		public int insertUser(UtenteBean ubean) {
			int r = 0;
			
			try (Connection con = DBConnectionPool.getConnection();)
			{
				PreparedStatement ps = con.prepareStatement("Insert into UserTable value(?,?,?)");
				ps.setString(1, ubean.getNome_utente());
				ps.setString(1, ubean.getEmail());
				ps.setString(1, ubean.getPassword_utente());
				
				System.out.println(ps);
				r = ps.executeUpdate();
				ps.close();
				
			} catch (SQLException e) {
				System.out.println(e);
			}
			
			
			return r;
		}
		
		public int updateUser(UtenteBean uBean)throws ClassNotFoundException{
			int result = 0;
			
			try (Connection conn = DBConnectionPool.getConnection(); )
			{
				//eseguiamo la query
				PreparedStatement prepStat = conn.prepareStatement("Update UserTable set email=?, password=? where nome_utente=?");
				prepStat.setString(1, uBean.getNome_utente());
				prepStat.setString(2, uBean.getEmail());
				prepStat.setString(3, uBean.getPassword_utente());
				
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
				
				prepStat.setString(1, uBean.getPassword_utente());
				
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
				PreparedStatement prepStat = conn.prepareStatement("select * from ShopTable");
				
				ResultSet rs = prepStat.executeQuery();
				
				while (rs.next()) {
					String nome_utente=rs.getString("nome_utente");
					String email=rs.getString("email");
					String password=rs.getString("password"); 
					
					UtenteBean uBean = new UtenteBean();
					uBean.setNome_utente(nome_utente);
					uBean.setEmail(email);
					uBean.setPassword_utente(password);
					all.add(uBean);
				}
				
			rs.close();
			prepStat.close();
			
			} catch (SQLException e) {
				
				System.out.println(e);
			}
			return all;
		}

		public UtenteBean getUtente(String nome_utente) {
			UtenteBean uBean = null;
			
			try (Connection conn = DBConnectionPool.getConnection(); ) 
			{
				PreparedStatement prepStat = conn.prepareStatement("select * from UserTable where nome_utente=?");
				
				prepStat.setString(1, nome_utente);
				ResultSet rs = prepStat.executeQuery();
				
				while (rs.next()) {
					
					String email=rs.getString("nome_utente");
					String password_utente=rs.getString("password_utente"); 
					
					uBean = new UtenteBean();
					
					uBean.setEmail(email);
					uBean.setPassword_utente(password_utente);
				}
			rs.close();
			prepStat.close();
			
			} catch (SQLException e) {
				
				System.out.println(e);
			}
			return uBean;
		}
	}
		


