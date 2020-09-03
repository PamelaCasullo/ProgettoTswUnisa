package it.MadDiscord.Model;

import java.sql.SQLException;
import java.util.Collection;

public interface ArticleModel <T>{

	public T doRetrieveBy(String id_articolo) throws SQLException;
	
	public Collection<T> doRetrieveAll(String all) throws SQLException;
	
	public void doSave(T product)  throws SQLException;
	
	public void doUpdate(T product)  throws SQLException;
	
	public void doDelete(T product)  throws SQLException;
}
