package bibliohero.dao.request;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.model.TypeSexe;
import exceptions.DaoException;

public class TypeSexeDao {
	
	public ArrayList <TypeSexe> recupererSexe() throws DaoException, SQLException, ClassNotFoundException{
		String sql = "Select * from pers_typesexe;";
		ArrayList<TypeSexe> listeTypeSexe = new ArrayList();
		
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()){
		TypeSexe typeSexe = new TypeSexe();
		
		typeSexe.setCodeSexe(rs.getString("codeSexe"));
		typeSexe.setNomSexe(rs.getString("nom"));
		listeTypeSexe.add(typeSexe);	
		}
		return listeTypeSexe;
	}
	
	public String recupererSexeViaCode(String codeSexe) throws SQLException, DaoException, ClassNotFoundException{
		String sql = "Select nom from pers_typeSexe where pers_typeSexe.codeSexe = ?;";
		
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ps.setString(1, codeSexe);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			return rs.getString(1);
		}
		else{
			return null;
		}
	}

}
