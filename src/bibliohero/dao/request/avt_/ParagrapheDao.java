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
			public ArrayList <Paragraphe> recupererParagraphe() throws DaoException, SQLException, ClassNotFoundException{
				String sql = "SELECT * FROM avt_paragraphe;";
				ArrayList<Paragraphe> listeParagraphes = new ArrayList();

				PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				

				while(rs.next()){
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
			public void afficherParagraphe(ArrayList <Paragraphe> listeParagraphes){
				for(Paragraphe paragraphe : listeParagraphes){
					System.out.println(paragraphe.toString());
				}
			}
	
}
