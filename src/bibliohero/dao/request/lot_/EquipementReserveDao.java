package bibliohero.dao.request.lot_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.lot_.EquipementReserve;
import bibliohero.model.pers_.Equipement;

public class EquipementReserveDao {

	//Methode pour recuperer les equipements
		public ArrayList <EquipementReserve> recupererEquipementReserve() throws DaoException, SQLException, ClassNotFoundException{
			String sql = "Select * from lot_equipement;";
			ArrayList<EquipementReserve> listeEquipementReserve = new ArrayList();

			PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			

			while(rs.next()){
				EquipementReserve equipement = new EquipementReserve();
				equipement.setIdEquipement(rs.getInt("idequipement"));
				equipement.setNomEquipement(rs.getString("nomequipement"));
				equipement.setClasseEquipement(rs.getString("classeequipement"));
				equipement.setDescription(rs.getString("equipement"));
				equipement.setClasseRequise(rs.getString("classerequise"));
				
				LotEquipementReserveDao eq = new LotEquipementReserveDao();
				equipement.setCodeLot(rs.getString("codelot"));
				equipement.setAttribut1(rs.getString("attribut1"));
				equipement.setAttribut2(rs.getString("attribut2"));
				equipement.setAttribut3(rs.getString("attribut3"));
				equipement.setNiveau(rs.getInt("niveau"));

				listeEquipementReserve.add(equipement);
			}
			afficherEquipement(listeEquipementReserve);
			rs.close();
			return listeEquipementReserve;
		}
		
			//Methode pour afficher les equipements avec la methode toString
			public void afficherEquipement(ArrayList <EquipementReserve> listeEquipementReserve){
				for(EquipementReserve equip : listeEquipementReserve){
					System.out.println(equip.toString());
				}
			}
	
	
	
}
