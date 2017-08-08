package bibliohero.dao.request.pers_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.pers_.LotEquipement;

public class LotEquipementDao {

	//Methode pour recuperer les lots d'equipements
	public ArrayList <LotEquipement> recupererLotEquipement() throws DaoException, SQLException, ClassNotFoundException{
		String sql = "SELECT * FROM pers_lotequipement;";
		ArrayList<LotEquipement> listeLotEquipement = new ArrayList();

		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();

		while(rs.next()){
			LotEquipement lotEquipement = new LotEquipement();
			lotEquipement.setIdlotequipement(rs.getInt("idlotequipement"));
			lotEquipement.setCodeLot(rs.getString("codelot"));
			lotEquipement.setNom(rs.getString("nom"));

			listeLotEquipement.add(lotEquipement);
		}
		
		rs.close();
		return listeLotEquipement;
	}
	
		//Methode pour recuperer le genre via le codelot
		public String recupererLotEquipementViaCode(String codeLot) throws SQLException, DaoException, ClassNotFoundException{
			String sql = "SELECT nom FROM pers_lotequipement WHERE pers_lotequipement.codelot = ?;";
			
			PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
			ps.setString(1, codeLot);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				return rs.getString(1);
			}
			else{
				return null;
			}
		}
}
