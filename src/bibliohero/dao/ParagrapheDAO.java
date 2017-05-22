package bibliohero.dao;

import java.sql.*;
import java.util.ArrayList;

public class ParagrapheDAO {
	
	private ConnectionDAO dao = ConnectionDAO.getConnectionDAO();
	
	
	public void recupererTexte(){
		
		try{
			Connection connection = dao.getConnection();
			Statement state = connection.createStatement();
			
			String requete = "Select aventure.nom, paragraphe.texte, actions.description from aventure"; 
			requete +=" inner join paragraphe on aventure.idaventure = paragraphe.idaventure";
			requete +=" inner join paragrapheaction on paragraphe.idparagraphe = paragrapheaction.idparagraphe"; 
			requete +=" inner join actions on paragrapheaction.idaction = actions.idaction";
			requete +=" inner join typeaction on actions.idtypeaction = typeaction.idtypeaction";
			
			ResultSet result = state.executeQuery(requete);
			ResultSetMetaData resultMeta= result.getMetaData();
			
			
			System.out.println("******************");
			for (int i =1; i<=resultMeta.getColumnCount();i++){
				System.out.println(resultMeta.getColumnName(i).toUpperCase());
			}
			System.out.println("*************");
			while(result.next()){
				for (int i =1; i<=resultMeta.getColumnCount();i++){
					System.out.println(result.getObject(i).toString()+  " || ");
				}
				System.out.println("____");
			}
			result.close();
			state.close();
		 }catch (Exception e){	    
			 e.printStackTrace();
		 } 		
		
	}
}