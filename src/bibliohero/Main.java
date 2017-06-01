package bibliohero;

import java.sql.SQLException;


import bibliohero.dao.request.avt_.AventureDao;

import bibliohero.exceptions.DaoException;

public class Main {
	public static void main(String[] args){
		
		AventureDao aventureDao = new AventureDao();
		
		try{
		//personnageDAO.recupererPersonnage();
		
		aventureDao.recupereraventure();
		
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
