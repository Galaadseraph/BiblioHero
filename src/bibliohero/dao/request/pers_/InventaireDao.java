package bibliohero.dao.request.pers_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.pers_.Inventaire;
import bibliohero.model.pers_.PJPCTemporaire;

public class InventaireDao {

	//Methode pour recuperer les inventaires
	public ArrayList <Inventaire> recupererInventaire() throws DaoException, SQLException, ClassNotFoundException{
		String sql = "Select * from pers_inventaire;";
		ArrayList<Inventaire> listeInventaire = new ArrayList();

		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		System.out.println("Essai d'envoi de donnï¿½es");

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
	
	//Methode pour recuperer l'inventaire d'un personnage
		public ArrayList<Inventaire> recupererInventaireViaIdPersonnage(int idPersonnage) throws DaoException, ClassNotFoundException, SQLException{
			String sql = "SELECT * FROM pers_inventaire where idpersonnage = ?";
			
			PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
			ArrayList<Inventaire> listeInventaires = new ArrayList<Inventaire>();
			ps.setInt(1,idPersonnage);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Inventaire inventaire = new Inventaire();
				inventaire.setNom(rs.getString("nom"));
				inventaire.setNbEmplacement(rs.getInt("nbemplacement"));
				inventaire.setTypeInventaire(rs.getString("typeinventaire"));
				inventaire.setIdInventaire(rs.getInt("idinventaire"));
				inventaire.setIdPersonnage(rs.getInt("idpersonnage"));
				listeInventaires.add(inventaire);
			}
			return listeInventaires;
		}

	/**
	 * Récupère la liste des inventaires d'un personnage (via son nom qui est unique)
 	 * @param nomPersonnage
	 * @return
	 * @throws DaoException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<Inventaire> recupererListeInventaireViaNomPersonnage(String nomPersonnage)throws DaoException, ClassNotFoundException, SQLException
	{
		// TODO :
		ArrayList<Inventaire> inventaire = new ArrayList();

		return inventaire;
	}
}