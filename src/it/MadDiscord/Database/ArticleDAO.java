package it.MadDiscord.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.MadDiscord.DBConnectionPool;
import it.MadDiscord.Model.ArticleBean;

public class ArticleDAO {

public int newArticle(ArticleBean sBean) throws ClassNotFoundException{
		
		int result = 0;
		
		try (Connection conn = DBConnectionPool.getConnection(); )
		{
			//eseguiamo la query
			PreparedStatement prepStat = conn.prepareStatement("Insert into Article(titolo,cont,immagine) values(?,?,?)");
			prepStat.setString(1, sBean.getTitolo());
			prepStat.setString(2, sBean.getCont());
			prepStat.setString(3, sBean.getImmagine());
			
			System.out.println(prepStat);
			result = prepStat.executeUpdate();
			
			prepStat.close();
			
		} catch (SQLException e) {
		
			System.out.println(e);
		}
		
		
		
		return result;
		
	}
	
public ArticleBean singleArticle(ArticleBean articleBean) {
			
			ArticleBean arBean = null;
			try (Connection conn = DBConnectionPool.getConnection(); )
			{		
				//eseguiamo la query
				PreparedStatement prepStat = conn.prepareStatement("Select * from Article where id_articolo = ?");
				prepStat.setInt(1, articleBean.getId_articolo());
				
				System.out.println(prepStat);
				
				ResultSet rs = prepStat.executeQuery();
				
				
				if(rs.next()) {
					arBean = new ArticleBean();
					arBean.setId_articolo(rs.getInt("id_articolo"));
				
				}
				conn.close();
			} catch (SQLException e) {
				System.out.println(e);
			}
			
			return arBean;
			
		}

/*ADMINISTRATOR*/
public int updateArticle(ArticleBean aBean)throws ClassNotFoundException{
	int result = 0;
	
	try (Connection conn = DBConnectionPool.getConnection(); )
	{
		//eseguiamo la query
		PreparedStatement prepStat = conn.prepareStatement("Update Article set titolo=?, cont=?, immagine=? where id_articolo=?");
		prepStat.setString(1, aBean.getTitolo());
		prepStat.setString(2, aBean.getCont());
		prepStat.setString(3, aBean.getImmagine());
		prepStat.setInt(4, aBean.getId_articolo());
		
		System.out.println(prepStat);
		result=prepStat.executeUpdate();
		
		prepStat.close();
		
	} catch (SQLException e) {
	
		System.out.println(e);
	}
	
	return result;
}

public int deleteArticle(ArticleBean aBean) {
	int result = 0;
	
	try (Connection conn = DBConnectionPool.getConnection(); )
	{
		//eseguiamo la query
		PreparedStatement prepStat = conn.prepareStatement("delete from Article where id_articolo=?");
		
		prepStat.setInt(1, aBean.getId_articolo());
		
		System.out.println(prepStat);
		result = prepStat.executeUpdate();
		
		prepStat.close();
		
	} catch (SQLException e) {
	
		System.out.println(e);
	}
	
	
	
	return result;
	
}

public List<ArticleBean> allArticle() {
	List<ArticleBean> all = new ArrayList<>();
	
	try (Connection conn = DBConnectionPool.getConnection(); ) 
	{
		PreparedStatement prepStat = conn.prepareStatement("select * from Article");
		
		ResultSet rs = prepStat.executeQuery();
		
		while (rs.next()) {
			int id=rs.getInt("id_articolo");
			String titolo=rs.getString("titolo");
			String contenuto=rs.getString("cont");
			String image = rs.getString("immagine");
			
			ArticleBean aBean = new ArticleBean();
			aBean.setId_articolo(id);
			aBean.setTitolo(titolo);
			aBean.setCont(contenuto);
			aBean.setImmagine(image);
			all.add(aBean);
		}
	rs.close();
	prepStat.close();
	
	} catch (SQLException e) {
		
		System.out.println(e);
	}
	return all;
}

}