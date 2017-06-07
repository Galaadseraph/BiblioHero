package bibliohero.dao.request.avt_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.avt_.Des;

public class DesDao {

		
	//Methodes pour recuperer un Des
		public ArrayList <Des> recupererDes() throws DaoException, SQLException, ClassNotFoundException{
			String sql = "SELECT * FROM avt_des;";
			ArrayList <Des> listeDes = new ArrayList();

			PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			

			while(rs.next()){
				Des des = new Des();
				
				des.setIdDes(rs.getInt("iddes"));
				des.setNbDeFaces(rs.getInt("nombredefaces"));
				des.setNom(rs.getString("nom"));
			

				listeDes.add(des);

			}
			afficherDes(listeDes);
			rs.close();
			return listeDes;
		}
		
		//Methode pour afficher les Dess avec la methode toString
		public void afficherDes(ArrayList <Des> listeDes){
			for(Des des : listeDes){
				System.out.println(des.toString());
			}
		}
		
}
