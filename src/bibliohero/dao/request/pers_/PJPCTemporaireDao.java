package bibliohero.dao.request.pers_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.pers_.PJPCTemporaire;
import bibliohero.model.pers_.Personnage;

public class PJPCTemporaireDao {

	public ArrayList <PJPCTemporaire> recupererPJPCTemporaire() throws DaoException, SQLException, ClassNotFoundException{
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
	
	//Insertion de donnees dans la table PJPCTemporaire via la table pers_personnage
	public void insererPersonnagePJPCTemporaire(Personnage pers) throws DaoException, ClassNotFoundException, SQLException{
		String sql = "INSERT INTO pers_pjpctemp ("
				+ "experience, richesse, moral "
				+ " forcep, dexteritep, endurance, intelligence, pv, idpersonnage)"
				+ "VALUES ("
				+ "?, ?, ?, ? "
				+ "?, ?, ?, ?, ?, ?)";
	
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
	
		ps.setDouble(1, pers.getExperience());
		ps.setDouble(2, pers.getRichesse());
		ps.setShort(3, pers.getMoral());
		
		ps.setShort(4, pers.getForce());
		ps.setShort(5, pers.getDexterite());
		ps.setShort(6, pers.getEndurance());
		ps.setShort(7, pers.getIntelligence());
		ps.setShort(8, pers.getPvActu());
		
		ps.setInt(9, pers.getIdPersonnage());
		ps.executeUpdate();
	}
	
	//Recuperer un personnage via son id
	public PJPCTemporaire retrouverPJPCPersonnageViaId(int idPersonnage) throws DaoException, ClassNotFoundException, SQLException{
		String sql = "SELECT * FROM pers_pjpctempo WHERE id = ?;";
		
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		
		ps.setInt(1,idPersonnage);
		
		ResultSet rs = ps.executeQuery();
		PJPCTemporaire pjpcTemp = new PJPCTemporaire();
		pjpcTemp.setForce(rs.getShort("forcep"));
		pjpcTemp.setDexterite(rs.getShort("dexteritep"));
		pjpcTemp.setEndurance(rs.getShort("endurance"));
		pjpcTemp.setIntelligence(rs.getShort("intelligence"));
		pjpcTemp.setPv(rs.getShort("pv"));
		
		pjpcTemp.setRichesse(rs.getDouble("richesse"));
		pjpcTemp.setExperience(rs.getDouble("experience"));
		
		pjpcTemp.setBackground(rs.getString("background"));
		pjpcTemp.setIdpersonnage(idPersonnage);
		return pjpcTemp;
	}
}
