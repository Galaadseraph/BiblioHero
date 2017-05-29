package bibliohero.dao.request;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.model.Personnage;
import bibliohero.model.TypeRace;
import exceptions.DaoException;

public class TypeRaceDao {

	public ArrayList <TypeRace> recupererRaces() throws DaoException, SQLException, ClassNotFoundException{
		String sql = "Select * from pers_typerace;";
		ArrayList<TypeRace> listeTypeRace = new ArrayList();
		
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()){
		TypeRace typeRace = new TypeRace();
		
		typeRace.setCodeRace(rs.getString("coderace"));
		typeRace.setNomRace(rs.getString("nom"));
		listeTypeRace.add(typeRace);	
		}
		return listeTypeRace;
	}
	
	public String recupererRaceViaCode(String codeRace) throws SQLException, DaoException, ClassNotFoundException{
		String sql = "Select nom from pers_typerace where pers_typerace.coderace = ?;";
		
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ps.setString(1, codeRace);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			return rs.getString(1);
		}
		else{
			return null;
		}
	}
}
