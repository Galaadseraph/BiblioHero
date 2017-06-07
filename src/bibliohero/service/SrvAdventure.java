package bibliohero.service;

import bibliohero.dao.request.pers_.PersonnageDao;

import bibliohero.controller.AdventureEngineObj.AventureObj;
import bibliohero.controller.AdventureEngineObj.PJoueurObj;
import bibliohero.controller.AdventureEngineObj.ParagrapheObj;
import bibliohero.dao.request.avt_.AventureDao;
import bibliohero.dao.request.avt_.ParagrapheDao;
import bibliohero.dao.request.pers_.InventaireDao;
import bibliohero.dao.request.pers_.PJPCTemporaireDao;
import bibliohero.dao.request.pers_.PersonnageDao;
import bibliohero.model.avt_.Action;
import bibliohero.model.avt_.Aventure;
import bibliohero.model.avt_.Paragraphe;
import bibliohero.model.pers_.Inventaire;
import bibliohero.model.pers_.PJPCTemporaire;
import bibliohero.model.pers_.Personnage;

import java.util.ArrayList;

/**
 * Created by jiolle.cdi04 on 01/06/2017.
 */
public class SrvAdventure {

    // Méthodes de classes statiques appelées par le moteur d'aventure

    /**
     * Objet Joueur : Requêtes DAO + Construction des objets
     * @param nomPersonnage
     * @return
     */
    /*public static PJoueurObj getPlayer(String nomPersonnage)
    {
        // TODO : Vérifier si la table pers_pjpctempo est POPULE (déjà réalisé lors de la création du person en BDD)
        // Si c'est le cas, on charge la table pers_pjpctempo et on la stocke dans PJoueurObj
        // Sinon, on la POPULE dans un premier temps

        // TODO 1 : Requête DAO : Récupération du personnage d'après son nom
        Personnage personnage =  PersonnageDao.recupererPersonnageViaNom(nomPersonnage);

        // Création de l'objet personnage joueur à partir du personnage en base
        PJoueurObj pjoueur = (PJoueurObj) personnage;

        // TODO 2 : Requête DAO : Récupération des attributs variables du joueur (d'après son nom)
        PJPCTemporaire persoTmp =  PJPCTemporaireDao.recupererPjpcTemporaireViaNom(nomPersonnage);
        //
        pjoueur.setPerso_tmp(persoTmp);

        // TODO 3 : Requête DAO : Récupération de la liste des inventaires du joueur (d'après son nom)
        ArrayList<Inventaire> listeInventaire = InventaireDao.recupererListeInventaireViaNom(nomPersonnage);
        //
        pjoueur.setListeInventaire(listeInventaire);

        // On retourne l'objet Joueur
        return pjoueur;

    }*/

    /**
     * Objet Aventure : Requêtes DAO + Contruction des objets
     * @param isbnAdventure
     * @return
     */
    /*public static AventureObj getAdventure(String isbnAdventure)
    {

        // TODO 1 : Requête DAO : Récupération de l'aventure d'après son identifiant "isbn"
        Aventure aventure =  AventureDao.recupererAventureViaNom(isbnAdventure);

        // Création de l'objet aventure à partir de l'aventure en base
        AventureObj aventureObj = (AventureObj) aventure;

        // TODO 2 : Requête DAO : Récupération de la liste des paragraphes de l'aventure (d'après l'identifiant du paragraphe)
        ArrayList<ParagrapheObj> listeParagraphe = ParagrapheDao.recupererListeParagrapheViaId(isbnAdventure);
        // Association de la liste de paragraphes à l'aventure
        aventureObj.setParagrapheList(listeParagraphe);

        // TODO 3 : Requête DAO : Récupération de la liste des actions pour chaque paragraphe de la liste des paragraphes
        for (ParagrapheObj paragraphe : listeParagraphe)
        {
            // Récupération de la liste des actions pour le paragraphe en cours
            ArrayList<Action> listeAction = ParagrapheDao.recupererListeActionViaId(paragraphe.getIdParagraphe());
            // Association de la liste d'actions au paragraphe en cours
            paragraphe.setActionList(listeAction);
        }

        // Renvoie de l'objet aventure complet (Aventure + Liste des paragraphes associés + Liste des actions associées à chaque paragraphe.
        return aventureObj;
    }*/

    //region Test

    /**
     * Objet Joueur : Requêtes DAO + Construction des objets
     * Chargement du jeu d'essai Manuellement pour TEST (Bypass DAO Access)
     * @param nomPersonnage
     * @return
     */
    public static PJoueurObj getPlayerTest(String nomPersonnage)
    {
        // TODO : Vérifier si la table pers_pjpctempo est POPULE (déjà réalisé lors de la création du person en BDD)
        // Si c'est le cas, on charge la table pers_pjpctempo et on la stocke dans PJoueurObj
        // Sinon, on la POPULE dans un premier temps

        // TODO 1 : Requête DAO : Récupération du personnage d'après son nom
        Personnage personnage =  PersonnageDao.recupererPersonnageViaNom(nomPersonnage);

        // Création de l'objet personnage joueur à partir du personnage en base
        PJoueurObj pjoueur = (PJoueurObj) personnage;

        // TODO 2 : Requête DAO : Récupération des attributs variables du joueur (d'après son nom)
        PJPCTemporaire persoTmp =  PJPCTemporaireDao.recupererPjpcTemporaireViaNom(nomPersonnage);
        //
        pjoueur.setPerso_tmp(persoTmp);

        // TODO 3 : Requête DAO : Récupération de la liste des inventaires du joueur (d'après son nom)
        ArrayList<Inventaire> listeInventaire = InventaireDao.recupererListeInventaireViaNom(nomPersonnage);
        //
        pjoueur.setListeInventaire(listeInventaire);

        // On retourne l'objet Joueur
        return pjoueur;

    }

    /**
     * Objet Aventure : Requêtes DAO + Contruction des objets
     * Chargement du jeu d'essai Manuellement pour TEST (Bypass DAO Access)
     * @param isbnAdventure
     * @return
     */
    public static AventureObj getAdventureTest(String isbnAdventure)
    {

        // TODO 1 : Requête DAO : Récupération de l'aventure d'après son identifiant "isbn"
        Aventure aventure =  new Aventure();
        aventure.setAuteur();
        aventure.setClasseRequise();
        aventure.setCodeTheme();
        aventure.setDictionnaire();
        aventure.setIdaventure();
        aventure.setIsbnAventure();
        aventure.setIsbnseries();
        aventure.setNbParagraphe();
        aventure.setNom();
        aventure.setNvRequis();
        aventure.setSynopsis();
        aventure.setVersion();

        // Création de l'objet aventure à partir de l'aventure en base
        AventureObj aventureObj = (AventureObj) aventure;

        // TODO 2 : Requête DAO : Récupération de la liste des paragraphes de l'aventure (d'après l'identifiant du paragraphe)
        ArrayList<ParagrapheObj> listeParagraphe = ParagrapheDao.recupererListeParagrapheViaId(isbnAdventure);
        // Association de la liste de paragraphes à l'aventure
        aventureObj.setParagrapheList(listeParagraphe);

        // TODO 3 : Requête DAO : Récupération de la liste des actions pour chaque paragraphe de la liste des paragraphes
        for (ParagrapheObj paragraphe : listeParagraphe)
        {
            // Récupération de la liste des actions pour le paragraphe en cours
            ArrayList<Action> listeAction = ParagrapheDao.recupererListeActionViaId(paragraphe.getIdParagraphe());
            // Association de la liste d'actions au paragraphe en cours
            paragraphe.setActionList(listeAction);
        }

        // Renvoie de l'objet aventure complet (Aventure + Liste des paragraphes associés + Liste des actions associées à chaque paragraphe.
        return aventureObj;
    }

    //endregion

}
