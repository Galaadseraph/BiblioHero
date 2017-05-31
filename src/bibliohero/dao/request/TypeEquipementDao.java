package bibliohero.dao.request;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.model.TypeEquipement;
import exceptions.DaoException;

public class TypeEquipementDao {
	
	//Methode pour recueprer un type d'�quipement
	public ArrayList <TypeEquipement> recupererTypeEquipement() throws DaoException, SQLException, ClassNotFoundException{
		
		String sql = "Select * from pers_typeequipement;";
		ArrayList<TypeEquipement> listeTypeEquipement = new ArrayList();

		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		

		while(rs.next()){
			TypeEquipement typeEquipement = new TypeEquipement();
			
			typeEquipement.setIdTypeEquipement(rs.getInt("idtypeequipement"));
			typeEquipement.setNom(rs.getString("nom"));
			typeEquipement.setCodeEquipement(rs.getString("codeequipement"));

			//Li� le code de typeEquipement avec la table Equipement via le nom
		
			listeTypeEquipement.add(typeEquipement);
		}
		
		rs.close();
		return listeTypeEquipement;
	}
}
