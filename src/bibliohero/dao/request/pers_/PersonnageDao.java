package bibliohero.dao.request.pers_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
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
	
	//Methode pour recuperer un id de personnage grace à un nom
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
		
		ps.setString(3, pers.getNom());
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
		
		return recupererIdPersonnageViaNom(pers.getNom());
	}
	
	//Methode pour supprimer un personnage
	public void supprimerPersonnage(int idPersonnage) throws DaoException, ClassNotFoundException, SQLException{
		String sql = "DELETE FROM pers_personnage WHERE idpersonnage = ? AND estactif = false;";
		
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ps.setInt(1, idPersonnage);
		ps.executeUpdate();
	}
	
	//Methode pour desactiver un personnage
	public void desactiverPersonnage(int idpersonnage) throws DaoException, ClassNotFoundException, SQLException{
		String sql = "UPDATE pers_personnageset SET estactif = false WHERE idpersonnage = ?;";
		
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ps.setInt(1, idpersonnage);
		ps.executeUpdate();
	}
	
	//Methode pour la montee de niveau
	public void updateMonterNiveau(Personnage pers) throws DaoException, ClassNotFoundException, SQLException{
		String sql = "UPDATE pers_personnage SET column1 = value1, column2 = value2...., columnN = valuesN WHERE [condition];";
		
		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);	
	}
	
	

}
