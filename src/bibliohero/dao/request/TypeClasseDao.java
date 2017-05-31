package bibliohero.dao.request;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.TypeClasse;
import bibliohero.model.TypeRace;

public class TypeClasseDao {
	
	//Methode pour recuperer une classe
	public ArrayList <TypeClasse> recupererClasse() throws DaoException, SQLException, ClassNotFoundException{
		String sql = "Select * from pers_typeclasse;";
		ArrayList<TypeClasse> listeTypeClasse = new ArrayList();
		
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()){
		TypeClasse typeClasse = new TypeClasse();
		
		typeClasse.setCodeClasse(rs.getString("codeclasse"));
		typeClasse.setNomClasse(rs.getString("nom"));
		listeTypeClasse.add(typeClasse);	
		}
		return listeTypeClasse;
	}
	
	public String recupererClasseeViaCode(String codeClasse) throws SQLException, DaoException, ClassNotFoundException{
		String sql = "Select nom from pers_typeclasse where pers_typeclasse.codeclasse = ?;";
		
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
