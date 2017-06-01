package bibliohero.dao.request.avt_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.avt_.ParametreAventure;

public class ParametreAventureDao {

	//Methodes pour recuperer un ParametreAventure
			public ArrayList <ParametreAventure> recupererParametreAventure() throws DaoException, SQLException, ClassNotFoundException{
				String sql = "SELECT * FROM avt_ParametreAventure;";
				ArrayList<ParametreAventure> listeParametreAventures = new ArrayList();

				PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				

				while(rs.next()){
					ParametreAventure parametreAventure = new ParametreAventure();
					
					parametreAventure.setIdParametreAventure(rs.getInt("idParametreAventure"));
					parametreAventure.setNomVariable(rs.getString("nomvariable"));
					parametreAventure.setValeur(rs.getString("valeur"));
					

					listeParametreAventures.add(parametreAventure);

				}
				afficherParametreAventure(listeParametreAventures);
				rs.close();
				return listeParametreAventures;
			}
			
			//Methode pour afficher les ParametreAventures avec la methode toString
			public void afficherParametreAventure(ArrayList <ParametreAventure> listeParametreAventures){
				for(ParametreAventure paramAvt : listeParametreAventures){
					System.out.println(paramAvt.toString());
				}
			}
}
