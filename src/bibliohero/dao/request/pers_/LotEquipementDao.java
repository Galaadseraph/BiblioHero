package bibliohero.dao.request.pers_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.pers_.LotEquipement;

public class LotEquipementDao {

	//Methode pour recuperer les lots d'équipements
	public ArrayList <LotEquipement> recupererlotEquipement() throws DaoException, SQLException, ClassNotFoundException{
		String sql = "Select * from pers_lotequipement;";
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
}
