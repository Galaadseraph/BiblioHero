package bibliohero.dao.request;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.model.Personnage;
import exceptions.DaoException;

public class PersonnageDao{


	public ArrayList <Personnage> recupererPersonnage() throws DaoException, SQLException, ClassNotFoundException{
		String sql = "Select * from pers_personnage;";
		ArrayList<Personnage> listePersonnages = new ArrayList();

		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		

		while(rs.next()){
			Personnage personnage = new Personnage();
			personnage.setIdPersonnage(rs.getInt("idpersonnage"));
			personnage.setNom(rs.getString("nom"));

			//-----------
			//Competences
			//------------
			personnage.setPvMax(rs.getShort("pv"));
			personnage.setForce(rs.getShort("forcep"));
			personnage.setDexterite(rs.getShort("dexteritep"));
			personnage.setEndurance(rs.getShort("endurance"));
			personnage.setIntelligence(rs.getShort("intelligence"));
			personnage.setMoral(rs.getShort("moral"));
			//-----------
			//Les doubles et byte
			//-----------
			personnage.setRichesse(rs.getDouble("richesse"));
			personnage.setExperience(rs.getDouble("experience"));
			personnage.setNiveau(rs.getByte("niveau"));
			//-----------
			//Les booleens
			//-----------
			personnage.setEstActif(rs.getBoolean("estactif"));
			personnage.setPermadeath(rs.getBoolean("permadeath"));
			personnage.setHommedefer(rs.getBoolean("hommeDeFer"));
			personnage.setEstJoueur(rs.getBoolean("estJoueur"));
			//------------
			//Code a aller chercher en base
			//------------
			TypeRaceDao typeRD = new TypeRaceDao();
			personnage.setRace(typeRD.recupererRaceViaCode(rs.getString("coderace")));

			TypeClasseDao typeClasseD = new TypeClasseDao();
			personnage.setClasse(typeClasseD.recupererClasseeViaCode(rs.getString("codeclasse")));

			TypeSexeDao typeSexeD = new TypeSexeDao();
			personnage.setSexe(typeSexeD.recupererSexeViaCode(rs.getString("codesexe")));

			TypeGenreDao typeGenreD = new TypeGenreDao();
			personnage.setGenre(typeGenreD.recupererGenreViaCode(rs.getString("codegenre")));

			EquipeDao equipeD = new EquipeDao();
			personnage.setEquipe(equipeD.recupererEquipeViaCode(rs.getString("codeequipe")));


			listePersonnages.add(personnage);

		}
		afficherPersonnage(listePersonnages);
		rs.close();
		return listePersonnages;
	}

	public void afficherPersonnage(ArrayList <Personnage> listePersonnages){
		for(Personnage pers : listePersonnages){
			System.out.println(pers.toString());
		}
	}
	
	//--------------
	//Insert en cours
	//--------------
	
	/*public void insererPersonnage() throws DaoException, ClassNotFoundException, SQLException{
		String sql = "INSERT INTO pers_personnage (permadeath, hommeDeFer, estactif, "
				+ "estJoueur, nom, niveau, richesse, experience, pv, forcep, dexteritep, "
				+ "endurance, intelligence, moral, codeequipe, coderace, codeclasse, "
				+ "codesexe, codegenre)"+
				"VALUES (false, false, true, true,?, 1, 0, 0, 20, 10, 10, 10, 100,?, ?, ?, ?, ?);";
	}*/

}
