package bibliohero.dao.request.avt_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.avt_.Series;

public class SeriesDao {

			//Methode pour recuperer les Series
			public ArrayList <Series> recupererSeries() throws DaoException, SQLException, ClassNotFoundException{
				String sql = "SELECT * FROM avt_series;";
				ArrayList <Series> listeSeries = new ArrayList();
				
				PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				
				while(rs.next()){
				Series series = new Series();
				
				series.setIdSeries(rs.getInt("idseries"));
				series.setIsbnSerie(rs.getString("isbnserie"));
				series.setNomSerie(rs.getString("nomserie"));
				
				listeSeries.add(series);	
				}
				return listeSeries;
			}
			
			public String recupererSeriesViaISBN(String codeSeries) throws SQLException, DaoException, ClassNotFoundException{
				String sql = "SELECT nomserie FROM avt_series WHERE avt_series.isbnserie = ?;";
				
				PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
				ps.setString(1, codeSeries);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()){
					return rs.getString(1);
				}
				else{
					return null;
				}
			}
		
	
	
}
