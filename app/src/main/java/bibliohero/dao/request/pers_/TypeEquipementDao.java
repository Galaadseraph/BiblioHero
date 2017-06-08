package bibliohero.dao.request.pers_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.pers_.TypeEquipement;

public class TypeEquipementDao {
	
	//Methode pour recueprer un type d'equipement
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

			//Lie le code de typeEquipement avec la table Equipement via le nom
		
			listeTypeEquipement.add(typeEquipement);
		}
		afficherTypeEquipement(listeTypeEquipement);
		rs.close();
		return listeTypeEquipement;
	}

	//Methode pour recuperer le genre via le codeEquipement
	public String recupererTypeEquipementViaCode(String codeEquipement) throws SQLException, DaoException, ClassNotFoundException{
		String sql = "SELECT nom FROM pers_typeequipement WHERE pers_typeequipement.codeequipement = ?;";

		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ps.setString(1, codeEquipement);
		ResultSet rs = ps.executeQuery();

		if(rs.next()){
			return rs.getString(1);
		}
		else{
			return null;
		}
	}

	//Methode pour afficher les types equipements avec la methode toString
	public void afficherTypeEquipement(ArrayList <TypeEquipement> listeTypeEquipement){
		for(TypeEquipement typeEquip : listeTypeEquipement){
			System.out.println(typeEquip.toString());
		}
	}
}
