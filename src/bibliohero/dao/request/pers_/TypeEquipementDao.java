package bibliohero.dao.request.pers_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.pers_.Personnage;
import bibliohero.model.pers_.TypeEquipement;

public class TypeEquipementDao {
	
	//Methode pour recueprer un type d'équipement
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

			//Lié le code de typeEquipement avec la table Equipement via le nom
		
			listeTypeEquipement.add(typeEquipement);
		}
		afficherTypeEquipement(listeTypeEquipement);
		rs.close();
		return listeTypeEquipement;
	}
	
	//Methode pour afficher les types equipements avec la methode toString
		public void afficherTypeEquipement(ArrayList <TypeEquipement> listeTypeEquipement){
			for(TypeEquipement typeEquip : listeTypeEquipement){
				System.out.println(typeEquip.toString());
			}
		}
}
