package it.MadDiscord.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import it.MadDiscord.DBConnectionPool;
import it.MadDiscord.Model.ShopBean;

public class ShopDAO {
	
	/*ADMINISTRATOR*/
	
	public int insertShop(ShopBean sBean) throws ClassNotFoundException{
		
		int result = 0;
		
		try (Connection conn = DBConnectionPool.getConnection(); )
		{
			//eseguiamo la query
			PreparedStatement prepStat = conn.prepareStatement("Insert into ShopTable (id,nome_oggetto,prezzo)values(?,?,?)");
			prepStat.setNString(1, sBean.getId().toString());
			prepStat.setString(2, sBean.getNome_oggetto());
			prepStat.setFloat(3, sBean.getPrezzo());
			
			System.out.println(prepStat);
			result = prepStat.executeUpdate();
			conn.commit();
			
			prepStat.close();
			
		} catch (SQLException e) {
		
			System.out.println(e);
		}
		
		
		
		return result;
		
	}

	public int updateShop(ShopBean sBean)throws ClassNotFoundException{
		int result = 0;
		
		try (Connection conn = DBConnectionPool.getConnection(); )
		{
			//eseguiamo la query
			PreparedStatement prepStat = conn.prepareStatement("Update ShopTable (id,nome_oggetto,prezzo) set nome_oggetto=?, prezzo=? where id=?");
			prepStat.setString(1, sBean.getNome_oggetto());
			prepStat.setFloat(2, sBean.getPrezzo());
			prepStat.setString(3, sBean.getId().toString());
			System.out.println(prepStat);
			result=prepStat.executeUpdate();
			
			prepStat.close();
			
		} catch (SQLException e) {
		
			System.out.println(e);
		}
		
		return result;
	}
	
	public int deleteShop(ShopBean sBean) {
		int result = 0;
		
		try (Connection conn = DBConnectionPool.getConnection(); )
		{
			//eseguiamo la query
			PreparedStatement prepStat = conn.prepareStatement("delete from ShopTable where nome_oggetto=?");
			
			prepStat.setString(1, sBean.getNome_oggetto());
			
			System.out.println(prepStat);
			result = prepStat.executeUpdate();
			
			prepStat.close();
			
		} catch (SQLException e) {
		
			System.out.println(e);
		}
		
		
		
		return result;
		
	}
/*ADMINISTRATOR+USER*/
	public List<ShopBean> allShop() {
		List<ShopBean> all = new ArrayList<>();
		
		try (Connection conn = DBConnectionPool.getConnection(); ) 
		{
			PreparedStatement prepStat = conn.prepareStatement("select * from ShopTable");
			
			ResultSet rs = prepStat.executeQuery();
			
			while (rs.next()) {
				UUID id = UUID.fromString(rs.getString("id"));
				String nome_oggetto=rs.getString("nome_oggetto");
				float prezzo=rs.getFloat("prezzo"); 
				
				ShopBean sBean = new ShopBean();
				sBean.setId(id);
				sBean.setNome_oggetto(nome_oggetto);
				sBean.setPrezzo(prezzo);
				all.add(sBean);
			}
		rs.close();
		prepStat.close();
		
		} catch (SQLException e) {
			
			System.out.println(e);
		}
		return all;
	}
	
/*Maibe for carrello*/
	public ShopBean getShop(float f) {
		ShopBean sBean = null;
		
		try (Connection conn = DBConnectionPool.getConnection(); ) 
		{
			PreparedStatement prepStat = conn.prepareStatement("select nome_oggetto from ShopTable where prezzo=?");
			
			prepStat.setFloat(1, f);
			ResultSet rs = prepStat.executeQuery();
			
			while (rs.next()) {
				
				String nome_oggetto=rs.getString("nome_oggetto");
				
				sBean = new ShopBean();
				
				sBean.setNome_oggetto(nome_oggetto);
			}
		rs.close();
		prepStat.close();
		
		} catch (SQLException e) {
			
			System.out.println(e);
		}
		return sBean;
	}

	public ShopBean doRetrieveBy(int id_prod) {
		// TODO Auto-generated method stub
		return null;
	}
}
	
