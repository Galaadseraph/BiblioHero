package bibliohero.dao.request;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.model.TypeInventaire;
import exceptions.DaoException;

public class TypeInventaireDao {

	//Methode pour récuprer le type des inventaires
	public ArrayList <TypeInventaire> recupererTypeInventaire() throws DaoException, SQLException, ClassNotFoundException{
		
		String sql = "Select * from pers_Typeinventaire;";
		ArrayList<TypeInventaire> listeTypeInventaire = new ArrayList();

		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		

		while(rs.next()){
			TypeInventaire typeInventaire = new TypeInventaire();
			
			typeInventaire.setIdTypeInventaire(rs.getInt("idtypeinventaire"));
			typeInventaire.setNom(rs.getString("nom"));
			typeInventaire.setCode(rs.getString("code"));
			
			//Je crois qu'il faudra lié le code de typeInventaire avec la table inventaire via le nom
		

			listeTypeInventaire.add(typeInventaire);
		}
		
		rs.close();
		return listeTypeInventaire;
	}
}
