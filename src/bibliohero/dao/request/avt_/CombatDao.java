package bibliohero.dao.request.avt_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.avt_.Combat;

public class CombatDao {

//Methodes pour recuperer un Combat
	public ArrayList <Combat> recupererCombat() throws DaoException, SQLException, ClassNotFoundException{
		String sql = "SELECT * FROM avt_combat;";
		ArrayList<Combat> listeCombats = new ArrayList();

		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		

		while(rs.next()){
			Combat combat = new Combat();
			
			combat.setIdCombat(rs.getInt("idCombat"));
			combat.setCodeCombat(rs.getString("codecombat"));
			

			listeCombats.add(combat);

		}
		afficherCombat(listeCombats);
		rs.close();
		return listeCombats;
	}
	
	//Methode pour afficher les Combats avec la methode toString
	public void afficherCombat(ArrayList <Combat> listeCombats){
		for(Combat combat : listeCombats){
			System.out.println(combat.toString());
		}
	}
	
}