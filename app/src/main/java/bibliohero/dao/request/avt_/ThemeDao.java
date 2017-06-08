package bibliohero.dao.request.avt_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.avt_.Theme;

public class ThemeDao {

		//Methode pour recuperer les themes
		public ArrayList <Theme> recupererTheme() throws DaoException, SQLException, ClassNotFoundException{
			String sql = "Select * from avt_theme;";
			ArrayList<Theme> listeTheme = new ArrayList();
			
			PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()){
			Theme theme = new Theme();
			
			theme.setIdTheme(rs.getInt("idtheme"));
			theme.setNomtheme(rs.getString("nomtheme"));
			theme.setCodetheme(rs.getString("codetheme"));
			
			listeTheme.add(theme);	
			}
			return listeTheme;
		}
		
		public String recupererThemeViaCode(String codeTheme) throws SQLException, DaoException, ClassNotFoundException{
			String sql = "SELECT nomtheme FROM avt_theme WHERE avt_theme.codetheme = ?;";
			
			PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
			ps.setString(1, codeTheme);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				return rs.getString(1);
			}
			else{
				return null;
			}
		}
}
