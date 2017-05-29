package bibliohero.dao.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDAOmysql {
    private static ConnectionDAOmysql instanceConnection;
    private static Connection connection;
    
    /**
    * m�thode pour se connecter � la base de donn�es 
    */
    private ConnectionDAOmysql() {
    	
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        }
        
        try {
            String url = "jdbc:mysql://10.2.6.31:3306/biblio";
            String utilisateur = "root";
            String motDePasse = "root";
            connection = DriverManager.getConnection(url, utilisateur , motDePasse);
            System.out.println("Connexion effective");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static ConnectionDAOmysql getConnectionDAO(){
    	if(instanceConnection == null){
    		instanceConnection = new ConnectionDAOmysql();
    	}
        return instanceConnection;
    }

	public Connection getConnection() {
		
		return connection;
	}
        
}