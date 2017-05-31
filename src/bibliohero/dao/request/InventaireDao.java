package bibliohero.dao.request;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.model.Inventaire;
import exceptions.DaoException;

public class InventaireDao {

	//Methode pour recuperer les inventaires
	public ArrayList <Inventaire> recupererInventaire() throws DaoException, SQLException, ClassNotFoundException{
		String sql = "Select * from pers_inventaire;";
		ArrayList<Inventaire> listeInventaire = new ArrayList();

		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		System.out.println("Essai d'envoi de donn�es");

		while(rs.next()){
			Inventaire inventaire = new Inventaire();
			inventaire.setIdInventaire(rs.getInt("idinventaire"));
			inventaire.setNom(rs.getString("nom"));
			inventaire.setTypeInventaire(rs.getString("typeinventaire"));
			inventaire.setNbEmplacement(rs.getInt("nbemplacement"));
			inventaire.setIdPersonnage(rs.getInt("idpersonnage"));

			listeInventaire.add(inventaire);
		}
		
		rs.close();
		return listeInventaire;
	}
}
