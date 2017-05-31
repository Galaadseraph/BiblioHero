package bibliohero.dao.request;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.model.Equipe;
import exceptions.DaoException;

public class EquipeDao {

	//Methode pour selectionner toutes les equipes
	
	public ArrayList <Equipe> recupererEquipe() throws DaoException, SQLException, ClassNotFoundException{
		String sql = "Select * from pers_equipe;";
		ArrayList<Equipe> listeEquipe = new ArrayList();
		
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		
		while(rs.next()){
		Equipe Equipe = new Equipe();
		
		Equipe.setCodeEquipe(rs.getString("codeEquipe"));
		Equipe.setNomEquipe(rs.getString("nom"));
		listeEquipe.add(Equipe);	
		}
		return listeEquipe;
	}
	
	public String recupererEquipeViaCode(String codeEquipe) throws SQLException, DaoException, ClassNotFoundException{
		String sql = "Select nom from pers_Equipe where pers_Equipe.codeEquipe = ?;";
		
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ps.setString(1, codeEquipe);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			return rs.getString(1);
		}
		else{
			return null;
		}
	}
}
