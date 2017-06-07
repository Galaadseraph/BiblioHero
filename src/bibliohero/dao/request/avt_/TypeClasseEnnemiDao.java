package bibliohero.dao.request.avt_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.avt_.TypeClasseEnnemi;

public class TypeClasseEnnemiDao {

	//Methode pour recuperer les races
			public ArrayList <TypeClasseEnnemi> recupererTypeClasse() throws DaoException, SQLException, ClassNotFoundException{
				String sql = "Select * from avt_typeclasse;";
				ArrayList<TypeClasseEnnemi> listeTypeClasseEnnemi = new ArrayList();
				
				PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				
				while(rs.next()){
				TypeClasseEnnemi typeClasseEnnemi = new TypeClasseEnnemi();
				
				typeClasseEnnemi.setIdTypeClasseEnnemi(rs.getInt("idtypeclasse"));
				typeClasseEnnemi.setNomClasse(rs.getString("nom"));
				typeClasseEnnemi.setCodeClasse(rs.getString("codeclasse"));
				
				listeTypeClasseEnnemi.add(typeClasseEnnemi);	
				}
				return listeTypeClasseEnnemi;
			}
			
			public String recupererTypeClasseEnnemiViaCode(String codeClasse) throws SQLException, DaoException, ClassNotFoundException{
				String sql = "SELECT nom FROM avt_typeclasse WHERE avt_typeclasse.codeclasse = ?;";
				
				PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
				ps.setString(1, codeClasse);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()){
					return rs.getString(1);
				}
				else{
					return null;
				}
			}
}
