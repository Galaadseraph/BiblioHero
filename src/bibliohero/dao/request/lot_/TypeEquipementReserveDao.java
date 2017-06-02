package bibliohero.dao.request.lot_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.lot_.TypeEquipementReserve;

public class TypeEquipementReserveDao {

	//Methode pour recueprer un type d'equipement
		public ArrayList <TypeEquipementReserve> recupererTypeEquipementReserve() throws DaoException, SQLException, ClassNotFoundException{
			
			String sql = "SELECT * FROM pers_typeequipement;";
			ArrayList<TypeEquipementReserve> listeTypeEquipementReserve = new ArrayList();

			PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			

			while(rs.next()){
				TypeEquipementReserve typeEquipementReserve = new TypeEquipementReserve();
				
				typeEquipementReserve.setIdTypeEquipement(rs.getInt("idtypeequipement"));
				typeEquipementReserve.setNom(rs.getString("nom"));
				typeEquipementReserve.setCodeEquipement(rs.getString("codeequipement"));

				//Lie le code de typeEquipement avec la table Equipement via le nom
			
				listeTypeEquipementReserve.add(typeEquipementReserve);
			}
			afficherTypeEquipementReserve(listeTypeEquipementReserve);
			rs.close();
			return listeTypeEquipementReserve;
		}
		
		//Methode pour afficher les types equipements avec la methode toString
			public void afficherTypeEquipementReserve(ArrayList <TypeEquipementReserve> listeTypeEquipementReserve){
				for(TypeEquipementReserve typeEquipReserve : listeTypeEquipementReserve){
					System.out.println(typeEquipReserve.toString());
				}
			}
}
