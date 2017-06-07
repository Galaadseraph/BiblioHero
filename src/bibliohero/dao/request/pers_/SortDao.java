package bibliohero.dao.request.pers_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.pers_.Sort;

public class SortDao {
	
	//Methode pour recuperer un sort
	public ArrayList <Sort> recupererSort() throws DaoException, SQLException, ClassNotFoundException{
		String sql = "Select * from pers_sort;";
		ArrayList<Sort> listeSort = new ArrayList();
		
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
		Sort sort = new Sort();
		
		sort.setIdSort(rs.getInt("idsort"));
		sort.setDuree(rs.getInt("duree"));
		sort.setNomSort(rs.getString("nomsort"));
		sort.setCapacite(rs.getString("capacite"));
		sort.setDescription(rs.getString("description"));
		sort.setEcoleDeMagie(rs.getString("ecoledemagie"));
		
		LotSortDao lotSortD = new LotSortDao();
		sort.setNomSort(lotSortD.recupererLotSorteViaCode(rs.getString("codelot")));
		sort.setCodeLot(rs.getString("codelot"));
		listeSort.add(sort);	
		}
		afficherSort(listeSort);
		rs.close();
		return listeSort;
	}
	
	public void afficherSort(ArrayList <Sort> listeSort){
		for(Sort sort : listeSort){
			System.out.println(sort.toString());
		}
	}
}
