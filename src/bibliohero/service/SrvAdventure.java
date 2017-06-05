package bibliohero.service;

//import bibliohero.dao.request.pers_.PersonnageDao;

import bibliohero.controller.AdventureEngineObj.AventureObj;
import bibliohero.controller.AdventureEngineObj.PJoueurObj;
import bibliohero.controller.AdventureEngineObj.ParagrapheObj;
import bibliohero.dao.request.avt_.AventureDao;
import bibliohero.dao.request.avt_.ParagrapheDao;
import bibliohero.dao.request.pers_.InventaireDao;
import bibliohero.dao.request.pers_.PJPCTemporaireDao;
import bibliohero.dao.request.pers_.PersonnageDao;
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
     * Requêtes DAO + Contruction des objets (Joueur)
     * @param nomPersonnage
     * @return
     */
    public static PJoueurObj loadPlayer(String nomPersonnage)
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
     * Requêtes DAO + Contruction des objets (Aventure)
     * @param isbnAdventure
     * @return
     */
    public static AventureObj loadAdventure(String isbnAdventure)
    {

        // TODO 1 : Requête DAO : Récupération de l'aventure d'après son identifiant "isbn"
        Aventure aventure =  AventureDao.recupererAventureViaNom(isbnAdventure);

        // Création de l'objet aventure à partir de l'aventure en base
        AventureObj aventureObj = (AventureObj) aventure;

        // TODO 2 : Requête DAO : Récupération de la liste des paragraphes de l'aventure (d'après l'identifiant du paragraphe)
        ArrayList<ParagrapheObj> listeParagraphe = ParagrapheDao.recupererListeParagrapheViaId(isbnAdventure);
        //
        aventureObj.setParagrapheList(listeParagraphe);

        // TODO 3 : Requête DAO : Récupération de la liste des actions pour chaque paragraphe de la liste des paragraphes
        // TODO : utiliser une boucle for

        return aventureObj;
    }


}
