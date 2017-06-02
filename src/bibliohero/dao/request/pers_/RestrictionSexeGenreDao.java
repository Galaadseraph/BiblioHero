package bibliohero.dao.request.pers_;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.pers_.RestrictionSexeGenre;


public class RestrictionSexeGenreDao {

	//Methode pour recuperer les lots de sorts
		public ArrayList <RestrictionSexeGenre> recupererRestriction() throws DaoException, SQLException, ClassNotFoundException{
			String sql = "Select * from pers_restrictionsexegenre;";
			ArrayList<RestrictionSexeGenre> listeRestriction = new ArrayList();
			return listeRestriction;
		}
		
	//Methode pour recuperer une liste selon un sexe ou un genre ==> typeEntree (si 0 = sexe, si 1 = genre)
		public ArrayList<RestrictionSexeGenre> recupererRestrictionVia(String code, boolean typeEntree) throws ClassNotFoundException, SQLException, DaoException{
			String sql = "Select * from pers_restrictionsexegenre where ? = ?;";
			
			PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			//A remplir par Arnaud
			return null;
			
		}
}


