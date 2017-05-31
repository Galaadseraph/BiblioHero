package bibliohero.dao.request;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.PJPCTemporaire;

public class PJPCTemporaireDao {

	public ArrayList <PJPCTemporaire> recupererpjpcTemporaire() throws DaoException, SQLException, ClassNotFoundException{
		String sql = "SELECT * FROM pers_pjpctempo;";
		ArrayList<PJPCTemporaire> listepjpcTemporaires = new ArrayList();

		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		

		while(rs.next()){
			PJPCTemporaire pjpcTemporaire = new PJPCTemporaire();
			pjpcTemporaire.setIdpersonnage(rs.getInt("idpersonnage"));
			pjpcTemporaire.setBackground(rs.getString("background"));
			
			pjpcTemporaire.setPv(rs.getInt("pv"));
			pjpcTemporaire.setForce(rs.getInt("forcep"));
			pjpcTemporaire.setEndurance(rs.getInt("endurance"));
			pjpcTemporaire.setDexterite(rs.getInt("dexteritep"));
			pjpcTemporaire.setIntelligence(rs.getInt("intelligence"));
			pjpcTemporaire.setMoral(rs.getInt("moral"));
			
			pjpcTemporaire.setRichesse(rs.getDouble("richesse"));
			pjpcTemporaire.setExperience(rs.getDouble("experience"));
		

			listepjpcTemporaires.add(pjpcTemporaire);
			

		}
		return listepjpcTemporaires;
	}
	
}
