package bibliohero;

import java.sql.SQLException;


import bibliohero.dao.request.avt_.AventureDao;
import bibliohero.dao.request.avt_.EnnemiDao;
import bibliohero.exceptions.DaoException;

public class Main {
	public static void main(String[] args){
		
		AventureDao aventureDao = new AventureDao();
		EnnemiDao ennemiDao = new EnnemiDao();
		
		try{
		//personnageDAO.recupererPersonnage();
		ennemiDao.recupererEnnemi();
		
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
