package it.MadDiscord.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;
import java.util.UUID;

import it.MadDiscord.DBConnectionPool;
import it.MadDiscord.Model.IntModel;
import it.MadDiscord.Model.ProdBean;

public class ProdDAO implements IntModel<ProdBean, UUID>  {

	public ProdBean doRetrieveBy(UUID id_prodotto) throws SQLException {
		String sql = "SELECT * FROM ProdCart WHERE id_carrello =?";
		PreparedStatement preparedStatement = null;
		ProdBean bean;
		try (Connection connection = DBConnectionPool.getConnection();) {
				preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setString(1, id_prodotto.toString());
	            ResultSet rs = preparedStatement.executeQuery();
	            bean = mapFromResultSet(rs);
		}
		return bean;
	}
	public ProdBean doRetrieveBy(int id_prodotto) throws SQLException {
		String sql = "SELECT * FROM ProdCart WHERE id_carrello =?";
		PreparedStatement preparedStatement = null;
		ProdBean bean;
		try (Connection connection = DBConnectionPool.getConnection();) {
				preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.setInt(1, id_prodotto);
	            ResultSet rs = preparedStatement.executeQuery();
	            bean = mapFromResultSet(rs);
		}
		return bean;
	}

	@Override
	public List<ProdBean> doRetrieveAll(String order) throws SQLException {
		String sql= "SELECT * FROM ProdCart";
		PreparedStatement preparedStatement = null;
		List<ProdBean> beans = new ArrayList<>();
		
		try(Connection connection = DBConnectionPool.getConnection();) {
			 preparedStatement = connection.prepareStatement(sql);
	            ResultSet rs = preparedStatement.executeQuery();
	            mapFromResultSet(beans, rs);
		}
				
		return beans;
	}

	@Override
	public void doSave(ProdBean product) throws SQLException {
		
		
	}

	@Override
	public void doUpdate(ProdBean product) throws SQLException {
	
		
	}
	
	public void doDelete(UUID product) throws SQLException {
		
	}
	
	
	public void doDelete(ProdBean product) throws SQLException {
		String sql= "DELETE FROM ProdCart WHERE id_carrello = ?";
		PreparedStatement preparedStatement = null;
		try (Connection connection = DBConnectionPool.getConnection();) {
			preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, product.getId_carrello().toString());

            preparedStatement.executeUpdate();
            connection.commit();
		}
		
	}
	
	 private ProdBean mapFromResultSet(ResultSet rs) throws SQLException {
	        if (rs.next()) {
	            return new ProdBean(
	                   rs.getInt("id_prodotto"),
	                   UUID.fromString(rs.getString("id_carrello"))     
	            );
	        }
	        return new ProdBean();
	    }

	    private void mapFromResultSet(List<ProdBean> beans, ResultSet rs) throws SQLException {
	        while (rs.next()) {
	            beans.add(new ProdBean(
		                   rs.getInt("id_prodotto"),
		                   UUID.fromString(rs.getString("id_carrello"))     
		            ));
	        }
	    }

		@Override
		public ProdBean doRetrieveBy(String id) throws SQLException {
			
			return null;
		}

}
