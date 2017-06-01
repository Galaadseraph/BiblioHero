package bibliohero.dao.request.lot_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.dao.request.pers_.LotSortDao;
import bibliohero.exceptions.DaoException;
import bibliohero.model.lot_.SortReserve;


public class SortReserveDao {
		
	    //Methode pour recuperer un sortReserve
		public ArrayList <SortReserve> recupererSortReserve() throws DaoException, SQLException, ClassNotFoundException{
			String sql = "SELECT * FROM lot_sort;";
			ArrayList<SortReserve> listeSort = new ArrayList();
			
			PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
			SortReserve sortReserve = new SortReserve();
			
			sortReserve.setIdSort(rs.getInt("idsort"));
			sortReserve.setDuree(rs.getInt("duree"));
			sortReserve.setNomSort(rs.getString("nomsort"));
			sortReserve.setCapacite(rs.getString("capacite"));
			sortReserve.setDescription(rs.getString("description"));
			sortReserve.setEcoleDeMagie(rs.getString("ecoledemagie"));
			
			LotSortDao lotSortD = new LotSortDao();
			sortReserve.setNomSort(lotSortD.recupererLotSorteViaCode(rs.getString("codelot")));
			sortReserve.setCodeLot(rs.getString("codelot"));
			listeSort.add(sortReserve);	
			}
			afficherSortReserve(listeSort);
			rs.close();
			return listeSort;
		}
		
		public void afficherSortReserve(ArrayList <SortReserve> listeSortReserve){
			for(SortReserve sort : listeSortReserve){
				System.out.println(sort.toString());
			}
		}
}
