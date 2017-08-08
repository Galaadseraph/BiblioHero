package bibliohero.service;

import bibliohero.dao.request.pers_.PersonnageDao;
import bibliohero.exceptions.DaoException;
import bibliohero.model.pers_.Personnage;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by jiolle.cdi04 on 08/06/2017.
 */
public class SrvGame {

    // Méthodes de classes statiques appelées par le moteur d'aventure
    // TODO : les méthodes *.dao devraient être statiques -> à modifier dans Dao + tous les appels

    /**
     *
     * @return
     */
    public static ArrayList<Personnage> getCharacterList()
    {
        ArrayList<Personnage> charList = new ArrayList<>();

        // Instantiation de la classe DAO (Nécessaire car pas static)
        PersonnageDao personnageDao = new PersonnageDao();

        try {
            // Récupération de la liste des personnages
            charList = personnageDao.recupererPersonnage();
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return charList;
    }
}
