package bibliohero.dao.request.avt_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.avt_.Paragraphe;

public class ParagrapheDao {

	//Methodes pour recuperer un Paragraphe
	public ArrayList<Paragraphe> recupererParagraphe() throws DaoException, SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM avt_paragraphe;";
		ArrayList<Paragraphe> listeParagraphes = new ArrayList();

		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();


		while (rs.next()) {
			Paragraphe paragraphe = new Paragraphe();
			paragraphe.setIdParagraphe(rs.getInt("idparagraphe"));

			paragraphe.setTexte(rs.getString("texte"));

			paragraphe.setNbEvenement(rs.getInt("nbevenement"));
			paragraphe.setNumParagraphe(rs.getInt("numparagraphe"));
			paragraphe.setIdAventure(rs.getInt("idaventure"));


			listeParagraphes.add(paragraphe);

		}
		afficherParagraphe(listeParagraphes);
		rs.close();
		return listeParagraphes;
	}

	//Methode pour afficher les Paragraphes avec la methode toString
	public void afficherParagraphe(ArrayList<Paragraphe> listeParagraphes) {
		for (Paragraphe paragraphe : listeParagraphes) {
			System.out.println(paragraphe.toString());
		}
	}

	//Methodes pour recuperer un Paragraphe via un id
	public ArrayList<Paragraphe> recupererParagrapheViaIdAventure(int idAventure) throws DaoException, SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM avt_paragraphe WHERE idaventure = ?;";
		ArrayList<Paragraphe> listeParagraphes = new ArrayList();

		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ps.setInt(1, idAventure);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Paragraphe paragraphe = new Paragraphe();
			paragraphe.setIdParagraphe(rs.getInt("idparagraphe"));

			paragraphe.setTexte(rs.getString("texte"));

			paragraphe.setNbEvenement(rs.getInt("nbevenement"));
			paragraphe.setNumParagraphe(rs.getInt("numparagraphe"));
			paragraphe.setIdAventure(rs.getInt("idaventure"));


			listeParagraphes.add(paragraphe);

		}
		afficherParagraphe(listeParagraphes);
		rs.close();
		return listeParagraphes;
	}

	/**
	 * Methodes pour recuperer un Paragraphe via un id
	 * @param isbn
	 * @return
	 * @throws DaoException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public ArrayList<Paragraphe> recupererListeParagrapheViaIsbnAventure(int isbn) throws DaoException, SQLException, ClassNotFoundException {
		String sql = "SELECT * FROM avt_paragraphe WHERE idaventure = (SELECT idaventure FROM avt_aventure WHERE isbnaventure = ?);";
		ArrayList<Paragraphe> listeParagraphes = new ArrayList();

		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ps.setInt(1, isbn);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Paragraphe paragraphe = new Paragraphe();
			paragraphe.setIdParagraphe(rs.getInt("idparagraphe"));

			paragraphe.setTexte(rs.getString("texte"));

			paragraphe.setNbEvenement(rs.getInt("nbevenement"));
			paragraphe.setNumParagraphe(rs.getInt("numparagraphe"));
			paragraphe.setIdAventure(rs.getInt("idaventure"));


			listeParagraphes.add(paragraphe);

		}
		afficherParagraphe(listeParagraphes);
		rs.close();
		return listeParagraphes;
	}

	//Methode pour recuperer un Paragraphe via NumParagraphe et IdAventure
	public int recupererIdParagrapheViaNumParagraphe(int idAventure, int numParagraphe) throws DaoException, SQLException, ClassNotFoundException {
		String sql = "SELECT idparagraphe FROM avt_paragraphe WHERE idaventure = ? AND numparagraphe = ?;";
		int idParagraphe;

		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ps.setInt(1, idAventure);
		ps.setInt(2, numParagraphe);
		ResultSet rs = ps.executeQuery();

		idParagraphe = rs.getInt("idparagraphe");

		rs.close();
		return idParagraphe;
	}


	//Methode pour recuperer le texte et le nb d'evenement des paragraphes
	public Paragraphe recupererTexteEtNbEvenementVia(int idParagraphe) throws DaoException, SQLException, ClassNotFoundException {
		String sql = "SELECT texte, nbevenement FROM avt_paragraphe WHERE idparagraphe = ?;";
		Paragraphe paragraphe = new Paragraphe();

		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ps.setInt(1, idParagraphe);
		ResultSet rs = ps.executeQuery();

		paragraphe.setIdParagraphe(idParagraphe);
		paragraphe.setTexte(rs.getString("texte"));
		paragraphe.setNbEvenement(rs.getInt("nbevenement"));

		rs.close();

		return paragraphe;

	}

}