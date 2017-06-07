package bibliohero.dao.jdbc.mysql;
import java.sql.*;

public class MainDAOmysql {
	
	public static void main(String [] args){
		
		ParagrapheDAOmysql test = new ParagrapheDAOmysql();
		
		test.recupererTexte();
  }  
}
