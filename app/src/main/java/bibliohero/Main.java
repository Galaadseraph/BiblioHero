package bibliohero;

import java.sql.SQLException;

import bibliohero.dao.request.pers_.PersonnageDao;
import bibliohero.exceptions.DaoException;

public class Main {
	public static void main(String[] args){
		
		PersonnageDao personnageDAO = new PersonnageDao();
		
		try{
		personnageDAO.recupererPersonnage();
	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		catch(DaoException e){
			e.printStackTrace();
		}
	}
}
