package bibliohero.dao.request.pers_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.pers_.Equipement;
import bibliohero.model.pers_.Personnage;

public class EquipementDao {

	//Methode pour recuperer les equipements
	public ArrayList <Equipement> recupererEquipement() throws DaoException, SQLException, ClassNotFoundException{
		String sql = "Select * from pers_equipement;";
		ArrayList<Equipement> listeEquipement = new ArrayList();

		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		

		while(rs.next()){
			Equipement equipement = new Equipement();
			equipement.setIdEquipement(rs.getInt("idequipement"));
			equipement.setNomEquipement(rs.getString("nomequipement"));
			equipement.setClasseEquipement(rs.getString("classeequipement"));
			equipement.setDescription(rs.getString("equipement"));
			equipement.setClasseRequise(rs.getString("classerequise"));
			equipement.setCodeLot(rs.getString("codelot"));
			equipement.setAttribut1(rs.getString("attribut1"));
			equipement.setAttribut2(rs.getString("attribut2"));
			equipement.setAttribut3(rs.getString("attribut3"));
			equipement.setNiveau(rs.getInt("niveau"));

			listeEquipement.add(equipement);
		}
		afficherEquipement(listeEquipement);
		rs.close();
		return listeEquipement;
	}
	
		//Methode pour afficher les equipements avec la methode toString
		public void afficherEquipement(ArrayList <Equipement> listeEquipement){
			for(Equipement equip : listeEquipement){
				System.out.println(equip.toString());
			}
		}
}
