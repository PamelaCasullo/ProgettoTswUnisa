package it.MadDiscord.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.MadDiscord.DBConnectionPool;
import it.MadDiscord.Model.CartBean;

public class CartDAO {

	public int inserCart(CartBean cBean) throws ClassNotFoundException {
		
		int result = 0;
		
		try (Connection conn = DBConnectionPool.getConnection(); ) {
			//query
			PreparedStatement prepStat = conn.prepareStatement("Insert into CartTable(id, prezzo) values(?,?)");
			prepStat.setInt(1, cBean.getId());
			prepStat.setFloat(2, cBean.getPrezzo());
			
			System.out.println(prepStat);
			result = prepStat.executeUpdate();
			
			prepStat.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return result;
	}
	
	public int deleteCart(CartBean cBean) {
		
		int result = 0;
		
		try (Connection conn = DBConnectionPool.getConnection(); ) {
			//eseguo query
			PreparedStatement prepStat = conn.prepareStatement("delete from CartTable where id=?");
			prepStat.setInt(1, cBean.getId());
			
			System.out.println(prepStat);
			result = prepStat.executeUpdate();
			
			prepStat.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return result;
	}
	
	public List<CartBean> allCart() {
		List<CartBean> all = new ArrayList<>();
		
		try (Connection conn = DBConnectionPool.getConnection(); ) {
			
			PreparedStatement preparedStatement = conn.prepareStatement("select * from ShopTable");
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				int quant = rs.getInt("quant");
				float prezzo = rs.getFloat("prezzo");
				
				CartBean cBean = new CartBean();
				cBean.setId(id);
				cBean.setQuant(quant);
				cBean.setPrezzo(prezzo);
				all.add(cBean);
			}
			rs.close();
			preparedStatement.close();
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		return all;
	}
	
}
