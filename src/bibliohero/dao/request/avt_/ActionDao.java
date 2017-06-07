kage bibliohero.dao.request.avt_;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bibliohero.dao.jdbc.sqlite.ConnectionDAOsqlite;
import bibliohero.exceptions.DaoException;
import bibliohero.model.avt_.Action;

public class ActionDao {

	//Methodes pour recuperer un Action
	public ArrayList <Action> recupererAction() throws DaoException, SQLException, ClassNotFoundException{
		String sql = "SELECT * FROM avt_action;";
		ArrayList<Action> listeActions = new ArrayList();

		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		

		while(rs.next()){
			Action action = new Action();
			
			action.setIdAction(rs.getInt("idaction"));
			action.setDescription(rs.getString("description"));
			action.setEffet(rs.getString("effet"));
			action.setCodeCombat(rs.getString("codecombat"));
			
			
			TypeActionDao typeActionDao = new TypeActionDao();
			action.setCodeAction(typeActionDao.recupererTypeActionViaCode(rs.getString("codetypeaction")));
			action.setParagrapheSuite(rs.getInt("paragraphesuite"));

			listeActions.add(action);

		}
		afficherAction(listeActions);
		rs.close();
		return listeActions;
	}
	
	//Methode pour afficher les Actions avec la methode toString
	public void afficherAction(ArrayList <Action> listeActions){
		for(Action action : listeActions){
			System.out.println(action.toString());
		}
	}
	
	//Methode pour recuperer les actions d'un paragraphe
	public ArrayList<Action> recupererActionViaIdParagraphe(int idParagraphe) throws ClassNotFoundException, SQLException, DaoException{
		
		String sql = "SELECT * FROM avt_action WHERE idaction IN (SELECT idaction FROM avt_paragrapheaction WHERE idparagraphe = ?);";
		ArrayList<Action> listeActions = new ArrayList();

		PreparedStatement ps = ConnectionDAOsqlite.getConnection().prepareStatement(sql);
		ps.setInt(1, idParagraphe);
		ResultSet rs = ps.executeQuery();
		

		while(rs.next()){
			Action action = new Action();
			
			action.setIdAction(rs.getInt("idaction"));
			action.setDescription(rs.getString("description"));
			action.setEffet(rs.getString("effet"));
			action.setCodeCombat(rs.getString("codecombat"));
			
			
			TypeActionDao typeActionDao = new TypeActionDao();
			action.setCodeAction(typeActionDao.recupererTypeActionViaCode(rs.getString("codetypeaction")));
			action.setParagrapheSuite(rs.getInt("paragraphesuite"));

			listeActions.add(action);

		}
		afficherAction(listeActions);
		rs.close();
		return listeActions;
	}
		
}