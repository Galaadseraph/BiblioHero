package bibliohero.dao.jdbc.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import bibliohero.exceptions.DaoException;

public class ConnectionDAOsqlite {
	
	private static Connection connection;
	/*private static final ConnectionDAOsqlite instance = new ConnectionDAOsqlite();
	
	
	public static void ConnectionDAOsqlite(){
		
		try{
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:biblioheros.sqlite");
			System.out.println("Connexion � la base de donn�es r�ussie! ");
		}
		
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException ee){
			ee.printStackTrace();
		}
	}
	*/
	public static Connection getConnection() throws DaoException, SQLException, ClassNotFoundException{
		if (connection == null) {
			
				Class.forName("org.sqlite.JDBC");
				connection = DriverManager.getConnection("jdbc:sqlite:biblioheros.sqlite");
				System.out.println("Connexion � la base de donn�es r�ussie! ");
		}
        return connection;
    }
}
