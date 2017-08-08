package bibliohero.dao.request.avt_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.avt_.Aventure;


public class AventureDao {

	
		//Methodes pour recuperer un aventure
		public ArrayList <Aventure> recupererAventure() throws DaoException, SQLException, ClassNotFoundException{
			String sql = "SELECT * FROM avt_aventure;";
			ArrayList<Aventure> listeaventures = new ArrayList();

			PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			

			while(rs.next()){
				Aventure aventure = new Aventure();
				aventure.setIdaventure(rs.getInt("idaventure"));
				
				aventure.setNom(rs.getString("nom"));
				aventure.setAuteur(rs.getString("auteur"));
				aventure.setIsbnAventure(rs.getString("isbnaventure"));
				aventure.setClasseRequise(rs.getString("classerequise"));
				aventure.setSynopsis(rs.getString("synopsis"));
				aventure.setVersion(rs.getString("version"));
				aventure.setIsbnseries(rs.getString("isbnserie"));
				
				SeriesDao seriesDao = new SeriesDao();
				aventure.setIsbnseries(seriesDao.recupererSeriesViaISBN(rs.getString("isbnserie")));
				ThemeDao themeDao = new ThemeDao();
				aventure.setCodeTheme(themeDao.recupererThemeViaCode(rs.getString("codetheme")));
				
				
				aventure.setNbParagraphe(rs.getInt("nbparagraphe"));
				aventure.setNvRequis(rs.getInt("nvrequis"));
				
				aventure.setDictionnaire(rs.getBoolean("dictionnaire"));


				listeaventures.add(aventure);

			}
			afficherAventure(listeaventures);
			rs.close();
			return listeaventures;
		}
		
		//Methode pour afficher les Aventures avec la methode toString
		public void afficherAventure(ArrayList <Aventure> listeAventures){
			for(Aventure avt : listeAventures){
				System.out.println(avt.toString());
			}
		}


	/**
	 * Methodes pour recuperer un aventure
	 * @param isbn
	 * @return
	 * @throws DaoException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public Aventure recupererAventureViaIsbnAventure(String isbn) throws DaoException, SQLException, ClassNotFoundException{
		String sql = "SELECT * FROM avt_aventure WHERE isbnaventure = ?;";

		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ps.setString(1, isbn);
		ResultSet rs = ps.executeQuery();
		rs.next();

		Aventure aventure = new Aventure();

		aventure.setIdaventure(rs.getInt("idaventure"));

		aventure.setNom(rs.getString("nom"));
		aventure.setAuteur(rs.getString("auteur"));
		aventure.setIsbnAventure(rs.getString("isbnaventure"));
		aventure.setClasseRequise(rs.getString("classerequise"));
		aventure.setSynopsis(rs.getString("synopsis"));
		aventure.setVersion(rs.getString("version"));
		aventure.setIsbnseries(rs.getString("isbnserie"));

		SeriesDao seriesDao = new SeriesDao();
		aventure.setIsbnseries(seriesDao.recupererSeriesViaISBN(rs.getString("isbnserie")));
		ThemeDao themeDao = new ThemeDao();
		aventure.setCodeTheme(themeDao.recupererThemeViaCode(rs.getString("codetheme")));

		aventure.setNbParagraphe(rs.getInt("nbparagraphe"));
		aventure.setNvRequis(rs.getInt("nvrequis"));

		aventure.setDictionnaire(rs.getBoolean("dictionnaire"));

		return aventure;
	}
}	
