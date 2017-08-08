package bibliohero.dao.request.pers_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.pers_.PJPCTemporaire;
import bibliohero.model.pers_.Personnage;

public class PersonnageDao{

	//Methodes pour recuperer un personnage
	public ArrayList <Personnage> recupererPersonnage() throws DaoException, SQLException, ClassNotFoundException{
		String sql = "SELECT * FROM pers_personnage;";
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
	
	//Methode pour recuperer un id de personnage grace a un nom
	private int recupererIdPersonnageViaNom(String nom) throws DaoException, SQLException, ClassNotFoundException {
		String sql = "SELECT idpersonnage FROM pers_personnage WHERE nom = ? ;";
		int id = -128;

		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()){
			id = rs.getInt("idpersonnage");
		}
		return id;
	}
	
	//Methode pour afficher les personnages avec la methode toString
	public void afficherPersonnage(ArrayList <Personnage> listePersonnages){
		for(Personnage pers : listePersonnages){
			System.out.println(pers.toString());
		}
	}
	
	//Methode pour inserer un personnage
	public int insererPersonnage(Personnage pers) throws DaoException, ClassNotFoundException, SQLException{
		//Verifier si le nom existe
		String sql = "INSERT INTO pers_personnage ("
				+ "niveau, experience, richesse, estactif, estjoueur, permadeath, hommeDeFer,"
				+ " nom,  codeequipe, coderace, codeclasse, codesexe, codegenre,"
				+ " forcep, dexteritep, endurance, intelligence, pv, pvmax,  moral)"
				+ "VALUES ("
				+ "1, 0, 0, 1, 1, ?, ?, "
				+ "?, ?, ?, ?, ?, ?, "
				+ "?, ?, ?, ?, ?, ?, 100)";
	
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ps.setBoolean(1, pers.isPermadeath());
		ps.setBoolean(2, pers.isHommedefer());
		
		ps.setString(3, pers.getNom().toLowerCase());
		ps.setString(4, pers.getEquipe());
		ps.setString(5, pers.getRace());
		ps.setString(6, pers.getClasse());
		ps.setString(7, pers.getSexe());
		ps.setString(8, pers.getGenre());
		
		ps.setShort(9, pers.getForce());
		ps.setShort(10, pers.getDexterite());
		ps.setShort(11, pers.getEndurance());
		ps.setShort(12, pers.getIntelligence());
		ps.setShort(13, pers.getPvActu());
		ps.setShort(14,  pers.getPvMAx());
		ps.executeUpdate();
		
		PJPCTemporaireDao persoTemporaire = new PJPCTemporaireDao();
		pers.setIdPersonnage(recupererIdPersonnageViaNom(pers.getNom()));
		
		persoTemporaire.insererPersonnagePJPCTemporaire(pers);
		
		
		
		return pers.getIdPersonnage();
	
	}
	
	//Methode pour supprimer un personnage
	public void supprimerPersonnage(Personnage pers) throws DaoException, ClassNotFoundException, SQLException{
		String sql = "DELETE FROM pers_personnage WHERE idpersonnage = ? AND estactif = false;";
		
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ps.setInt(1, pers.getIdPersonnage());
		ps.executeUpdate();
	}
	
	//Methode pour desactiver un personnage
	public void desactiverPersonnage(Personnage pers) throws DaoException, ClassNotFoundException, SQLException{
		String sql = "UPDATE pers_personnageset SET estactif = false WHERE idpersonnage = ?;";
		
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ps.setInt(1, pers.getIdPersonnage());
		ps.executeUpdate();
	}
	
	//Methode pour la montee de niveau
	public void updateMonterNiveau(Personnage pers) throws DaoException, ClassNotFoundException, SQLException{
		String sql = "UPDATE pers_personnage SET niveau = ? WHERE idpersonnage = ? ;";
		
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);	
		ps.setInt(1, pers.getNiveau());
		ps.setInt(2, pers.getIdPersonnage());
		ps.executeUpdate();
	}
	
	//Methode pour modifier la richesse, l'experience et le moral d'un personnage en sortie d'aventure.
	public void mettreAJourPersonnage(PJPCTemporaire persoTemporaire) throws ClassNotFoundException, SQLException, DaoException{
		//pjpcdao donne les donnees
		
		String sql = "UPDATE pers_personnage SET richesse = ?, experience = ?, moral = ? WHERE idpersonnage = ? ";
		
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ps.setDouble(1, persoTemporaire.getRichesse());
		ps.setDouble(2, persoTemporaire.getExperience());
		ps.setDouble(3, persoTemporaire.getMoral());
		ps.setDouble(4, persoTemporaire.getIdpersonnage());
		ps.executeUpdate();
		
	}
	
	//Methode pour recuperer un personnage via son idEquipe
	public ArrayList<Personnage> recupererPersonnageViaIdEquipe(int idequipe)throws DaoException, ClassNotFoundException, SQLException{
		String sql = "SELECT * FROM pers_personnage WHERE codeequipe =(SELECT codeequipe FROM pers_equipe WHERE idequipe = ?);";
					
		ArrayList<Personnage> listePersonnages = new ArrayList();
		
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ps.setInt(1, idequipe);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			Personnage personnage = new Personnage();
			personnage.setIdPersonnage(rs.getInt("idpersonnage"));
			personnage.setNom(rs.getString("nom"));

			personnage.setPvMax(rs.getShort("pv"));
			personnage.setForce(rs.getShort("forcep"));
			personnage.setDexterite(rs.getShort("dexteritep"));
			personnage.setEndurance(rs.getShort("endurance"));
			personnage.setIntelligence(rs.getShort("intelligence"));
			personnage.setMoral(rs.getShort("moral"));
			
			personnage.setRichesse(rs.getDouble("richesse"));
			personnage.setExperience(rs.getDouble("experience"));
			personnage.setNiveau(rs.getByte("niveau"));
			
			personnage.setEstActif(rs.getBoolean("estactif"));
			personnage.setPermadeath(rs.getBoolean("permadeath"));
			personnage.setHommedefer(rs.getBoolean("hommeDeFer"));
			personnage.setEstJoueur(rs.getBoolean("estJoueur"));
		
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
		}
		rs.close();
		return listePersonnages;
	}
	
	//Methode pour recuperer un personnage via son nom d'equipe
		public ArrayList<Personnage> recupererPersonnageViaNomEquipe(String nomEquipe)throws DaoException, ClassNotFoundException, SQLException{
			String sql = "SELECT * FROM pers_personnage WHERE codeequipe =(SELECT codeequipe FROM pers_equipe WHERE nom = ?);";
						
			ArrayList<Personnage> listePersonnages = new ArrayList();
			
			PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
			ps.setString(1, nomEquipe);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				Personnage personnage = new Personnage();
				personnage.setIdPersonnage(rs.getInt("idpersonnage"));
				personnage.setNom(rs.getString("nom"));

				personnage.setPvMax(rs.getShort("pv"));
				personnage.setForce(rs.getShort("forcep"));
				personnage.setDexterite(rs.getShort("dexteritep"));
				personnage.setEndurance(rs.getShort("endurance"));
				personnage.setIntelligence(rs.getShort("intelligence"));
				personnage.setMoral(rs.getShort("moral"));
				
				personnage.setRichesse(rs.getDouble("richesse"));
				personnage.setExperience(rs.getDouble("experience"));
				personnage.setNiveau(rs.getByte("niveau"));
				
				personnage.setEstActif(rs.getBoolean("estactif"));
				personnage.setPermadeath(rs.getBoolean("permadeath"));
				personnage.setHommedefer(rs.getBoolean("hommeDeFer"));
				personnage.setEstJoueur(rs.getBoolean("estJoueur"));
			
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
			}
			rs.close();
			return listePersonnages;
		}

	/**
	 * Récupère un personnage (via son nom qui est unique)
 	 * @param nomPersonnage
	 * @return
	 * @throws DaoException
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public Personnage recupererPersonnageViaNomPersonnage(String nomPersonnage)throws DaoException, ClassNotFoundException, SQLException{
		String sql = "SELECT * FROM pers_personnage WHERE nom = ?;";
		

		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ps.setString(1, nomPersonnage);
		ResultSet rs = ps.executeQuery();
		rs.next();

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

		return personnage;
	}
}
