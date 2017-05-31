package bibliohero.dao.request;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.LotSort;
import bibliohero.model.LotSort;

public class LotSortDao {

	//Methode pour recuperer les lots de sorts
	public ArrayList <LotSort> recupererLotSort() throws DaoException, SQLException, ClassNotFoundException{
		String sql = "Select * from pers_typeLotSort;";
		ArrayList<LotSort> listeLotSort = new ArrayList();
		
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()){
		LotSort lotSort = new LotSort();
		
		lotSort.setIdLotSort(rs.getInt("idlotsort"));
		lotSort.setCodeLot(rs.getString("codelot"));
		lotSort.setNom(rs.getString("nom"));
		
		listeLotSort.add(lotSort);	
		}
		return listeLotSort;
	}
	
	public String recupererLotSorteViaCode(String codeLotSort) throws SQLException, DaoException, ClassNotFoundException{
		String sql = "Select nom from pers_lotsort where pers_lotsort.codelot = ?;";
		
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
