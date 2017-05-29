package bibliohero.dao.jdbc.sqlite;

import java.sql.*;

public class JavaSQLite {
	
	private Statement etat = null;
	
	public static void main(String[] args){
		
		//creertable();
		ajouterPersonnage("Francois", "Insectos", "paladin", 250);
		
	}
	
	//Methode pour creer une table
	public static void creertable(){
		Connection connexion = null;
		Statement stat = null;
		System.out.println("Connexion r�ussie");
		
		try{
			
			Class.forName("org.sqlite.JDBC");
			connexion = DriverManager.getConnection("jdbc:sqlite:bibliohero.db");
			
			stat = connexion.createStatement();
			
			String commandeSQL = "CREATE TABLE PERSONNAGE" + 
								 "(ID 		INTEGER 	PRIMARY KEY 	AUTOINCREMENT, " +
								 "NOM 		TEXT	NOT NULL, " +
								 "RACE 		TEXT 	NOT NULL, " +
								 "CLASSE 	TEXT 	NOT NULL, " +
								 "EXPERIENCE INT 	NOT NULL);";
			stat.executeUpdate(commandeSQL);
			stat.close();
			connexion.close();
		}
		catch(Exception e){
			
			System.out.println("Cr�ation de la table impossible : " + e.getMessage());
		}
		
		System.out.println("La cr�ation de la table s'est effectu�e avec succ�s");
	}
	
	public static void ajouterPersonnage(String nom, String race, String classe, int experience){
		Connection connexion = null;
		Statement stat = null;
		System.out.println("Connexion r�ussie");
		
		try{
			
			Class.forName("org.sqlite.JDBC");
			connexion = DriverManager.getConnection("jdbc:sqlite:bibliohero.db");
			
			stat = connexion.createStatement();
			
			String commandeSQL;
			
			commandeSQL = "INSERT INTO PERSONNAGE (NOM, RACE, CLASSE, EXPERIENCE) " + 
			"VALUES ('" + nom + "', '" + race + "', '" + classe + "', " + experience + ");";
						   
		stat.executeUpdate(commandeSQL);
		stat.close();
		connexion.close();
					
		}catch(Exception e){
			
		}
	}
}
