package bibliohero.dao.request.avt_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.avt_.Ennemi;

public class EnnemiDao {

		
			//Methodes pour recuperer un Ennemi
			public ArrayList <Ennemi> recupererEnnemi() throws DaoException, SQLException, ClassNotFoundException{
				String sql = "SELECT * FROM avt_Ennemi;";
				ArrayList<Ennemi> listeEnnemis = new ArrayList();

				PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				

				while(rs.next()){
					Ennemi ennemi = new Ennemi();
					ennemi.setIdennemi(rs.getInt("idEnnemi"));
					
					ennemi.setNiveau(rs.getShort("niveau"));
					ennemi.setPv(rs.getShort("pv"));
					ennemi.setForcep(rs.getShort("forcep"));
					ennemi.setDexteritep(rs.getShort("dexteritep"));
					ennemi.setEndurance(rs.getShort("endurance"));
					ennemi.setIntelligence(rs.getShort("intelligence"));
					
					TypeClasseEnnemiDao typeClasse = new TypeClasseEnnemiDao();
					ennemi.setClasse(typeClasse.recupererTypeClasseEnnemiViaCode(rs.getString("classe")));
					TypeRaceEnnemiDao typeRace = new TypeRaceEnnemiDao();
					ennemi.setRace(typeRace.recupererTypeRaceEnnemiViaCode(rs.getString("race")));
					

					listeEnnemis.add(ennemi);

				}
				afficherEnnemi(listeEnnemis);
				rs.close();
				return listeEnnemis;
			}
			
			//Methode pour afficher les Ennemis avec la methode toString
			public void afficherEnnemi(ArrayList <Ennemi> listeEnnemis){
				for(Ennemi ennemi : listeEnnemis){
					System.out.println(ennemi.toString());
				}
			}
}
