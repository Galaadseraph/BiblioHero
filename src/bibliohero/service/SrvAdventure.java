package bibliohero.service;

import bibliohero.dao.request.avt_.ActionDao;
import bibliohero.dao.request.pers_.PersonnageDao;

import bibliohero.controller.AdventureEngineObj.AventureObj;
import bibliohero.controller.AdventureEngineObj.PJoueurObj;
import bibliohero.controller.AdventureEngineObj.ParagrapheObj;
import bibliohero.dao.request.avt_.AventureDao;
import bibliohero.dao.request.avt_.ParagrapheDao;
import bibliohero.dao.request.pers_.InventaireDao;
import bibliohero.dao.request.pers_.PJPCTemporaireDao;
import bibliohero.dao.request.pers_.PersonnageDao;
import bibliohero.exceptions.DaoException;
import bibliohero.model.avt_.Action;
import bibliohero.model.avt_.Aventure;
import bibliohero.model.avt_.Paragraphe;
import bibliohero.model.pers_.Inventaire;
import bibliohero.model.pers_.PJPCTemporaire;
import bibliohero.model.pers_.Personnage;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Classe service appelée par le moteur d'aventure pour récupérer/envoyer des données de/vers la BDD
 * Created by jiolle.cdi04 on 01/06/2017.
 */
public class SrvAdventure {

    // Méthodes de classes statiques appelées par le moteur d'aventure
    // TODO : les méthodes *.dao devraient être statiques -> à modifier dans Dao + tous les appels

    /**
     * Objet Joueur (Personnage Joueur) : Requêtes DAO + Construction des objets
     * @param nomPersonnage
     * @return
     */
    public static PJoueurObj getPlayer(String nomPersonnage)
    {
        // TODO : Vérifier si la table pers_pjpctempo est POPULE (déjà réalisé lors de la création du person en BDD)
        // Si c'est le cas, on charge la table pers_pjpctempo et on la stocke dans PJoueurObj
        // Sinon, on la POPULE dans un premier temps

        // TODO 1 : Requête DAO : Récupération du personnage d'après son nom
        PersonnageDao personnageDao = new PersonnageDao();

        Personnage personnage = null;
        try {
            personnage = personnageDao.recupererPersonnageViaNomPersonnage(nomPersonnage);
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Création de l'objet personnage joueur à partir du personnage en base
        PJoueurObj pjoueur = new PJoueurObj(personnage);

        // TODO 2 : Requête DAO : Récupération des attributs variables du joueur (d'après son nom)
        PJPCTemporaireDao pJPCTemporaireDao = new PJPCTemporaireDao();

        PJPCTemporaire persoTmp = null;
        try {
            persoTmp = pJPCTemporaireDao.recupererPJPCTempoViaNomPersonnage(nomPersonnage);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (DaoException e) {
            e.printStackTrace();
        }
        // Association de Perso_Tmp à l'objet Personnage
        pjoueur.setPerso_tmp(persoTmp);

        // TODO 3 : Requête DAO : Récupération de la liste des inventaires du joueur (d'après son nom)
        InventaireDao inventaireDao = new InventaireDao();

        ArrayList<Inventaire> listeInventaire = null;
        try {
            listeInventaire = inventaireDao.recupererListeInventaireViaNomPersonnage(nomPersonnage);
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Association de la liste des inventaires à l'objet Personnage
        pjoueur.setListeInventaire(listeInventaire);

        // On retourne l'objet Joueur (Personnage) avec les attributs temporaires et sa liste d'inventaires
        return pjoueur;

    }

    /**
     * Objet Aventure : Requêtes DAO + Contruction des objets
     * @param isbnAdventure
     * @return
     */
    public static AventureObj getAdventure(String isbnAdventure)
    {

        // TODO 1 : Requête DAO : Récupération de l'aventure d'après son identifiant "isbn"
        AventureDao aventureDao = new AventureDao();

        Aventure aventure = null;
        try {
            aventure = aventureDao.recupererAventureViaIsbnAventure(isbnAdventure);
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Création de l'objet aventure à partir de l'aventure en base
        AventureObj aventureObj = new AventureObj(aventure);

        // TODO 2 : Requête DAO : Récupération de la liste des paragraphes de l'aventure (d'après l'identifiant du paragraphe)
        ParagrapheDao paragrapheDao = new ParagrapheDao();

        ArrayList<ParagrapheObj> listeParagraphe = null;
        try {
            // Récupération de la liste de paragraphe
            ArrayList<Paragraphe> listeParagrapheTmp;
            listeParagrapheTmp = paragrapheDao.recupererListeParagrapheViaIsbnAventure(isbnAdventure);
            // Cast Paragraphe -> ParagrapheObj (pour chaque paragraphe
            for (Paragraphe paragrapheTmp : listeParagrapheTmp)
            {
                listeParagraphe.add(new ParagrapheObj(paragrapheTmp));
            }
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Association de la liste de paragraphes à l'aventure
        aventureObj.setParagrapheList(listeParagraphe);

        // TODO 3 : Requête DAO : Récupération de la liste des actions pour chaque paragraphe de la liste des paragraphes
        ActionDao actionDao = new ActionDao();

        ArrayList<Action> listeAction = null;

        // Pour chaque paragraphe
        for (ParagrapheObj paragrapheObj : listeParagraphe)
        {
            // Récupération de la liste des actions (pour le paragraphe en cours)
            try {
                listeAction = actionDao.recupererListeActionViaIdParagraphe(paragrapheObj.getParagraphe().getIdParagraphe());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (DaoException e) {
                e.printStackTrace();
            }
            // Association de la liste d'actions au paragraphe en cours
            paragrapheObj.setActionList(listeAction);
        }

        // Renvoie de l'objet aventure complet (Aventure + Liste des paragraphes associés + Liste des actions associées à chaque paragraphe.
        return aventureObj;
    }

    //region Test

    /**
     * Objet Joueur : Requêtes DAO + Construction des objets
     * Chargement du jeu d'essai Manuellement pour TEST (Bypass DAO Access)
     * NE PAS UTILISER : INCOMPLET
     * @param nomPersonnage
     * @return
     */
    public static PJoueurObj getPlayerTest(String nomPersonnage)
    {

        PJoueurObj pJoueurObj = new PJoueurObj();

        return pJoueurObj;

    }

    /**
     * Objet Aventure : Requêtes DAO + Contruction des objets ()
     * Chargement du jeu d'essai Manuellement pour TEST (Bypass DAO Access)
     * NE PAS UTILISER : INCOMPLET
     * @param isbnAdventure
     * @return
     */
    public static AventureObj getAdventureTest(String isbnAdventure)
    {

        // TODO 1 : Requête DAO : Récupération de l'aventure d'après son identifiant "isbn"
        Aventure aventure =  new Aventure();
        aventure.setIdaventure(1);

        aventure.setNom("le coeur du chaos");
        aventure.setAuteur("Cyril Guillot");
        aventure.setVersion("1.00");
        aventure.setSynopsis("dans les années 70 80 un groupe terroriste dechaine les foules");
        aventure.setNbParagraphe(15);

        aventure.setCodeTheme("HST");

        aventure.setClasseRequise("aucune");
        aventure.setNvRequis(0);
        aventure.setDictionnaire(false);

        aventure.setIsbnAventure("1");
        aventure.setIsbnseries("ab4");

        // Création de l'objet aventure à partir de l'aventure en base
        AventureObj aventureObj = new AventureObj(aventure);

        // TODO 2 : Requête DAO : Récupération de la liste des paragraphes de l'aventure (d'après l'identifiant du paragraphe)
        ParagrapheDao paragrapheDao = new ParagrapheDao();

        ArrayList<ParagrapheObj> listeParagraphe = null;
        try {
            // Récupération de la liste de paragraphe
            ArrayList<Paragraphe> listeParagrapheTmp;
            listeParagrapheTmp = paragrapheDao.recupererListeParagrapheViaIsbnAventure(isbnAdventure);
            // Cast Paragraphe -> ParagrapheObj (pour chaque paragraphe
            for (Paragraphe paragrapheTmp : listeParagrapheTmp)
            {
                listeParagraphe.add(new ParagrapheObj(paragrapheTmp));
            }
        } catch (DaoException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // Association de la liste de paragraphes à l'aventure
        aventureObj.setParagrapheList(listeParagraphe);

        // TODO 3 : Requête DAO : Récupération de la liste des actions pour chaque paragraphe de la liste des paragraphes
        ActionDao actionDao = new ActionDao();

        ArrayList<Action> listeAction = null;

        // Pour chaque paragraphe
        for (ParagrapheObj paragrapheObj : listeParagraphe)
        {
            // Récupération de la liste des actions (pour le paragraphe en cours)
            try {
                listeAction = actionDao.recupererListeActionViaIdParagraphe(paragrapheObj.getParagraphe().getIdParagraphe());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (DaoException e) {
                e.printStackTrace();
            }
            // Association de la liste d'actions au paragraphe en cours
            paragrapheObj.setActionList(listeAction);
        }

        // Renvoie de l'objet aventure complet (Aventure + Liste des paragraphes associés + Liste des actions associées à chaque paragraphe.
        return aventureObj;
    }

    //endregion

}
