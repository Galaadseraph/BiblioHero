package bibliohero;

import java.sql.SQLException;

import bibliohero.dao.request.avt_.ActionDao;

import bibliohero.dao.request.avt_.ParagrapheDao;
import bibliohero.dao.request.pers_.EquipementDao;
import bibliohero.exceptions.DaoException;

public class Main {
	public static void main(String[] args){
		
	
		ParagrapheDao paraf = new ParagrapheDao();
		EquipementDao equip = new EquipementDao();
		ActionDao act = new ActionDao();
		
		try{
		act.recupererAction();
		equip.recupererEquipement();
		
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
