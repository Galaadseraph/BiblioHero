package bibliohero.dao.jdbc.mysql;
import java.sql.*;

public class MainDAO {
	
	public static void main(String [] args){
		
		ParagrapheDAO test = new ParagrapheDAO();
		
		test.recupererTexte();
  }  
}
