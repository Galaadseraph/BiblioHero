package bibliohero;

import java.sql.SQLException;

import bibliohero.bin.data.Equipement;
import bibliohero.dao.request.EquipeDao;
import bibliohero.dao.request.EquipementDao;
import bibliohero.dao.request.PersonnageDao;
import bibliohero.dao.request.TypeEquipementDao;
import bibliohero.exceptions.DaoException;
import bibliohero.model.TypeEquipement;

public class Main {
	public static void main(String[] args){
		
		PersonnageDao personnageDAO = new PersonnageDao();
		EquipementDao equip = new EquipementDao();
		TypeEquipementDao typeEquipement = new TypeEquipementDao();
		EquipeDao equipe = new EquipeDao();
		
		try{
		//personnageDAO.recupererPersonnage();
		equipe.recupererEquipe();
		typeEquipement.recupererTypeEquipement();
		
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
