package bibliohero.dao.request.lot_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.lot_.LotSortReserve;

public class LotSortReserveDao {
	
	
	//Methode pour recuperer les lots de sorts
		public ArrayList <LotSortReserve> recupererLotSortReserve() throws DaoException, SQLException, ClassNotFoundException{
			String sql = "SELECT * FROM lot_typelotsort;";
			ArrayList<LotSortReserve> listeLotSortReserve = new ArrayList();
			
			PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()){
			LotSortReserve lotSortReserve = new LotSortReserve();
			
			lotSortReserve.setIdLotSort(rs.getInt("idlotsort"));
			lotSortReserve.setCodeLot(rs.getString("codelot"));
			lotSortReserve.setNom(rs.getString("nom"));
			
			listeLotSortReserve.add(lotSortReserve);	
			}
			return listeLotSortReserve;
		}
		
		public String recupererLotSorteReserveViaCode(String codeLotSort) throws SQLException, DaoException, ClassNotFoundException{
			String sql = "SELECT nom FROM lot_lotsort where pers_lotsort.codelot = ?;";
			
			PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
			ps.setString(1, codeLotSort);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				return rs.getString(1);
			}
			else{
				return null;
			}
		}
}
