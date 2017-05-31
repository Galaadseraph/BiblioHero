package bibliohero.dao.request;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.model.TypeGenre;
import exceptions.DaoException;

public class TypeGenreDao {

	public ArrayList <TypeGenre> recupererGenre() throws DaoException, SQLException, ClassNotFoundException{
		String sql = "Select * from pers_typegenre;";
		ArrayList<TypeGenre> listeTypeGenre = new ArrayList();
		
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()){
		TypeGenre typeGenre = new TypeGenre();
		
		typeGenre.setCodeGenre(rs.getString("codeGenre"));
		typeGenre.setNomGenre(rs.getString("nom"));
		listeTypeGenre.add(typeGenre);	
		}
		return listeTypeGenre;
	}
	
	public String recupererGenreViaCode(String codeGenre) throws SQLException, DaoException, ClassNotFoundException{
		String sql = "Select nom from pers_typegenre where pers_typegenre.codegenre = ?;";
		
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ps.setString(1, codeGenre);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			return rs.getString(1);
		}
		else{
			return null;
		}
	}
}
