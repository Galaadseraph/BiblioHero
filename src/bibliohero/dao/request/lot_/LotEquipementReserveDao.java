package bibliohero.dao.request.lot_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.lot_.LotEquipementReserve;

public class LotEquipementReserveDao {
	
	//Methode pour recuperer les lots d'equipements
		public ArrayList <LotEquipementReserve> recupererlotEquipementReserve() throws DaoException, SQLException, ClassNotFoundException{
			String sql = "Select * from lot_lotequipement;";
			ArrayList<LotEquipementReserve> listeLotEquipementReserve = new ArrayList();

			PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				LotEquipementReserve lotEquipementReserve = new LotEquipementReserve();
				lotEquipementReserve.setIdlotequipement(rs.getInt("idlotequipement"));
				lotEquipementReserve.setCodeLot(rs.getString("codelot"));
				lotEquipementReserve.setNom(rs.getString("nom"));

				listeLotEquipementReserve.add(lotEquipementReserve);
			}
			
			rs.close();
			return listeLotEquipementReserve;
		}
}
