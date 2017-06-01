package bibliohero.dao.request.avt_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.avt_.TypeRaceEnnemi;

public class TypeRaceEnnemiDao {
	
	//Methode pour recuperer les races
	public ArrayList <TypeRaceEnnemi> recupererTypeRaces() throws DaoException, SQLException, ClassNotFoundException{
		String sql = "Select * from avt_typeRace;";
		ArrayList<TypeRaceEnnemi> listeTypeRaceEnnemi = new ArrayList();
		
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()){
		TypeRaceEnnemi typeRaceEnnemi = new TypeRaceEnnemi();
		
		typeRaceEnnemi.setIdTypeRace(rs.getInt("idtyperace"));
		typeRaceEnnemi.setNom(rs.getString("nom"));
		typeRaceEnnemi.setCodeRace(rs.getString("coderace"));
		
		listeTypeRaceEnnemi.add(typeRaceEnnemi);	
		}
		return listeTypeRaceEnnemi;
	}
	
	public String recupererTypeRaceEnnemiViaCode(String codeRace) throws SQLException, DaoException, ClassNotFoundException{
		String sql = "SELECT nom FROM avt_typerace WHERE avt_typerace.coderace = ?;";
		
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
