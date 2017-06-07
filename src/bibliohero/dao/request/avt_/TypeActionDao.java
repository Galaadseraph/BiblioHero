package bibliohero.dao.request.avt_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.avt_.TypeAction;

public class TypeActionDao {

	//Methode pour recuperer les TypeActions
			public ArrayList <TypeAction> recupererTypeAction() throws DaoException, SQLException, ClassNotFoundException{
				String sql = "SELECT * FROM avt_typeaction;";
				ArrayList<TypeAction> listeTypeAction = new ArrayList();
				
				PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				
				while(rs.next()){
				TypeAction typeAction = new TypeAction();
				
				typeAction.setIdTypeAction(rs.getInt("idtypeaction"));
				typeAction.setCodeAction(rs.getString("codeaction"));
				typeAction.setNom(rs.getString("nom"));
				
				
				listeTypeAction.add(typeAction);	
				}
				return listeTypeAction;
			}
			
			public String recupererTypeActionViaCode(String codeTypeAction) throws SQLException, DaoException, ClassNotFoundException{
				String sql = "SELECT nom FROM avt_typeaction WHERE avt_typeaction.codeaction = ?;";
				
				PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
				ps.setString(1, codeTypeAction);
				ResultSet rs = ps.executeQuery();
				
				if(rs.next()){
					return rs.getString(1);
				}
				else{
					return null;
				}
			}
	
}
