package it.MadDiscord.Model;

import java.sql.SQLException;
import java.util.Collection;

public interface IntModel <T,U> {
	
	public T doRetrieveBy(String id) throws SQLException;
	
	public Collection<T> doRetrieveAll(String order) throws SQLException;
	
	public void doSave(T product)  throws SQLException;
	
	public void doUpdate(T product)  throws SQLException;
	
	public void doDelete(U product)  throws SQLException;

	
	
}
